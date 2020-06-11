package com.jenson.common.mvvm;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.appbar.MaterialToolbar;
import com.jenson.common.R;
import com.jenson.common.event.PageControlEvent;
import com.jenson.common.event.StateViewEvent;
import com.jenson.common.mvvm.view.IBaseView;
import com.jenson.common.mvvm.viewmodel.BaseViewModel;
import com.jenson.common.util.DialogUtils;
import com.jenson.common.widget.StateView;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;

/**
 * author: CDJenson
 * date: 2020/5/6 15:47
 * version: 1.0
 * description: One-sentence description
 */
public abstract class BaseActivity<V extends ViewDataBinding, VM extends BaseViewModel> extends AppCompatActivity implements IBaseView {

    protected V mBinding;
    protected VM mViewModel;
    protected DataBindingConfig mDataBindingConfig;
    private LifecycleEventObserver mLifecycleEventObserver;
    private MaterialToolbar mToolbar;
    private StateView mStateView;
    private AlertDialog mProgressBarDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_root);
        initRootView();
        initViewDataBinding();
        initUiEvent();
        initData();
    }

    private void initRootView() {
        //设置toolbar
        if (enableToolbar()) {
            ViewStub viewStubToolBar = findViewById(R.id.view_stub_toolbar);
            viewStubToolBar.setLayoutResource(onBindToolbar());
            View view = viewStubToolBar.inflate();
            mToolbar = view.findViewById(R.id.toolbar);
            if (mToolbar != null) {
                setSupportActionBar(mToolbar);
                initToolbar(mToolbar);
                //toolbar直接设置title要在setSupportActionBar之前才能生效，而其他相关actionbar功能则要在setSupportActionBar之后
                if (mToolbar.getTitle() != null) {
                    Objects.requireNonNull(getSupportActionBar()).setTitle(mToolbar.getTitle());
                }
            }
        }

        //替换 android.R.id.content
        ViewGroup contentView = findViewById(android.R.id.content);
        mStateView = findViewById(R.id.view_state);
        ViewGroup contentWrap = (ViewGroup) mStateView.getView(StateView.VIEW_STATE_CONTENT);
        View content = LayoutInflater.from(this).inflate(onBindContentView(), contentWrap, false);
        contentWrap.setId(android.R.id.content);
        contentView.setId(View.NO_ID);
        contentWrap.removeAllViews();
        contentWrap.addView(content);
    }

    private void initViewDataBinding() {
        mBinding = DataBindingUtil.setContentView(this, onBindContentView());
        mViewModel = createViewModel();
        mDataBindingConfig = initDataBindingConfig();
        if (mBinding != null && mDataBindingConfig != null) {
            mBinding.setVariable(mDataBindingConfig.getVariableId(), mViewModel);

            SparseArray bindingParams = mDataBindingConfig.getBindingParams();
            for (int i = 0; i < bindingParams.size(); i++) {
                mBinding.setVariable(bindingParams.keyAt(i), bindingParams.valueAt(i));
            }
        }
        mLifecycleEventObserver = mViewModel.onBindLifecycleEventObserver();
        if (mLifecycleEventObserver != null) {
            getLifecycle().addObserver(mLifecycleEventObserver);
        }
    }

    private void initUiEvent() {
        subscribeStateView();
        subscribePageControl();
        subscribeUi();
    }

    //多状态视图控制
    private void subscribeStateView() {
        StateViewEvent stateViewEvent = mViewModel.getStateViewEvent();
        if (enableStateView() && stateViewEvent != null) {
            stateViewEvent.viewState.observe(this, integer -> mStateView.setViewState(integer));
            mStateView.setOnRetryListener(this::initData);
        }
    }

    //一些页面交互控制
    private void subscribePageControl() {
        PageControlEvent pageControlEvent = mViewModel.getPageControlEvent();
        if (pageControlEvent != null) {
            pageControlEvent.startActivity.observe(this, params -> {
                Class<?> clz = (Class<?>) params.get(BaseViewModel.ParameterField.CLASS);
                Bundle bundle = (Bundle) params.get(BaseViewModel.ParameterField.BUNDLE);
                startActivity(clz, bundle);
            });

            pageControlEvent.finishActivity.observe(this, v -> finish());

            pageControlEvent.onBackPressed.observe(this, v -> onBackPressed());

            pageControlEvent.showProgressBarDialog.observe(this, message -> {
                mProgressBarDialog = DialogUtils.showProgressDialog(this, message, false, null);
            });

            pageControlEvent.hideProgressBarDialog.observe(this, v -> {
                if (mProgressBarDialog != null && mProgressBarDialog.isShowing())
                    mProgressBarDialog.dismiss();
            });
        }
    }

    protected void initToolbar(MaterialToolbar toolbar) {
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        DrawableCompat.setTint(Objects.requireNonNull(toolbar.getNavigationIcon()), Color.WHITE);
        //需要设置在setSupportActionBar之后，否则不生效
        mToolbar.setNavigationOnClickListener(v -> onBackPressed());
    }

    protected int onBindToolbar() {
        return R.layout.common_toolbar;
    }

    protected boolean enableToolbar() {
        return true;
    }

    protected boolean enableStateView() {
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mLifecycleEventObserver != null) getLifecycle().removeObserver(mLifecycleEventObserver);
        if (mBinding != null) mBinding.unbind();
        if (mProgressBarDialog != null && mProgressBarDialog.isShowing()) {
            mProgressBarDialog.dismiss();
        }
    }

    private VM createViewModel() {
        Class modelClass;
        //读取泛参数
        Type type = getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            modelClass = (Class) ((ParameterizedType) type).getActualTypeArguments()[1];
        } else {
            modelClass = BaseViewModel.class;
        }
        ViewModelProvider vp = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()));
        return (VM) vp.get(modelClass.getName(), modelClass);
    }

    protected void startActivity(Class<?> clz, Bundle bundle) {
        Intent intent = new Intent(this, clz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }
}
