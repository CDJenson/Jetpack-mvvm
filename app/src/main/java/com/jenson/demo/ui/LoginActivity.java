package com.jenson.demo.ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.library.baseAdapters.BR;

import com.google.android.material.appbar.MaterialToolbar;
import com.jenson.common.binding.command.BindingCommand;
import com.jenson.common.binding.command.BindingResponseCommand;
import com.jenson.common.mvvm.BaseActivity;
import com.jenson.common.mvvm.DataBindingConfig;
import com.jenson.demo.R;
import com.jenson.demo.databinding.ActivityLoginBinding;
import com.jenson.demo.viewmodel.LoginViewModel;


/**
 *  author: CDJenson
 *  date: 2020/5/20 17:51
 *	version: 1.0
 *  description: One-sentence description
 */
public class LoginActivity extends BaseActivity<ActivityLoginBinding, LoginViewModel> {

    @Override
    protected void initToolbar(MaterialToolbar toolbar) {
        toolbar.setTitle("登录");
    }

    @Override
    public int onBindContentView() {
        return R.layout.activity_login;
    }

    @Override
    public DataBindingConfig initDataBindingConfig() {
        return new DataBindingConfig(BR.viewModel).addBindingParam(BR.clickProxy,new ClickProxy());
    }

    @Override
    public void subscribeUi() {

    }

    @Override
    public void initData() {

    }

    @Override
    public boolean enableStateView() {
        return false;
    }

    public class ClickProxy{

        public void onTextChangedOfUserName(CharSequence s, int start, int before, int count){
            if(!TextUtils.isEmpty(s) && !TextUtils.isEmpty(mBinding.tilUsername.getError())){
                mBinding.tilUsername.setError(null);
            }
        }

        public void onTextChangedOfPassword(CharSequence s, int start, int before, int count){
            if(!TextUtils.isEmpty(s) && !TextUtils.isEmpty(mBinding.tilPassword.getError())){
                mBinding.tilPassword.setError(null);
            }
        }

        public BindingCommand onClickLogin = new BindingCommand(()->mViewModel.login(), () -> {
            boolean result = true;
            if(TextUtils.isEmpty(mBinding.etUsername.getText())){
                mBinding.tilUsername.setError("用户名不能为空");
                result = false;
            }
            if(TextUtils.isEmpty(mBinding.etPassword.getText())){
                mBinding.tilPassword.setError("密码不能为空");
                result = false;
            }
            return result;
        });

        public BindingResponseCommand onLongClickLogin = new BindingResponseCommand<View, Boolean>(view -> {
            Toast.makeText(getApplication(), "Boom Boom Boom", Toast.LENGTH_SHORT).show();
            return true;
        });
    }
}
