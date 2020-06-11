package com.jenson.common.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewStub;
import android.widget.RelativeLayout;

import androidx.annotation.IntDef;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.core.widget.ContentLoadingProgressBar;

import com.jenson.common.R;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * author: CDJenson
 * date: 2020/5/9 9:17
 * version: 1.0
 * description: One-sentence description
 */
public class StateView extends RelativeLayout {

    public static final int VIEW_STATE_UNKNOWN = -1;

    public static final int VIEW_STATE_CONTENT = 0;

    public static final int VIEW_STATE_ERROR = 1;

    public static final int VIEW_STATE_EMPTY = 2;

    public static final int VIEW_STATE_LOADING = 3;

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({VIEW_STATE_UNKNOWN, VIEW_STATE_CONTENT, VIEW_STATE_ERROR, VIEW_STATE_EMPTY, VIEW_STATE_LOADING})
    @interface ViewState {}

    private RelativeLayout mViewContent;
    private ViewStub mViewStubEmpty;
    private ViewStub mViewStubError;
    private ViewStub mViewStubLoading;

    private View mViewEmpty;
    private View mViewError;
    private View mViewLoading;

    private int preViewState = VIEW_STATE_CONTENT;
    private AnimatorProvider mAnimatorProvider = new FadeScaleAnimatorProvider();
    private onRetryListener mOnRetryListener;
    private Animator preAnimator;

    public StateView(Context context) {
        super(context);
        init();
    }

    public StateView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public StateView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public StateView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_state, this);
        mViewContent = findViewById(R.id.view_stub_content);
        mViewStubEmpty = findViewById(R.id.view_stub_empty);
        mViewStubError = findViewById(R.id.view_stub_error);
        mViewStubLoading = findViewById(R.id.view_stub_loading);
    }

    public void setAnimatorProvider(AnimatorProvider animatorProvider) {
        mAnimatorProvider = animatorProvider;
    }

    public void setOnRetryListener(onRetryListener onRetryListener) {
        mOnRetryListener = onRetryListener;
    }

    public View getView(@ViewState int viewState) {
        switch (viewState) {
            case VIEW_STATE_UNKNOWN:
            case VIEW_STATE_CONTENT:
                return mViewContent;
            case VIEW_STATE_ERROR:
                return mViewError;
            case VIEW_STATE_EMPTY:
                return mViewEmpty;
            case VIEW_STATE_LOADING:
                return mViewLoading;
            default:
                return getView(VIEW_STATE_UNKNOWN);
        }
    }

    public void setViewState(@ViewState int viewState) {
        if(preViewState == viewState) return;
        showOrHideView(getView(preViewState),GONE);
        preViewState = viewState;

        switch (viewState) {
            case VIEW_STATE_UNKNOWN:
            case VIEW_STATE_CONTENT:
                showContentView();
                break;
            case VIEW_STATE_ERROR:
                showErrorView();
                break;
            case VIEW_STATE_EMPTY:
                showEmptyView();
                break;
            case VIEW_STATE_LOADING:
                showLoadingView();
                break;
            default:
                setViewState(VIEW_STATE_UNKNOWN);
                break;
        }
    }

    private void showContentView() {
        showOrHideView(mViewContent, VISIBLE);
    }

    private void showErrorView() {
        if (mViewError == null) {
            mViewError = mViewStubError.inflate();
            mViewError.setVisibility(INVISIBLE);
            mViewError.setOnClickListener(v -> {
                if (mOnRetryListener != null) mOnRetryListener.onRetry();
            });
        }
        showOrHideView(mViewError, VISIBLE);
    }

    private void showEmptyView() {
        if (mViewEmpty == null) {
            mViewEmpty = mViewStubEmpty.inflate();
            mViewEmpty.setVisibility(INVISIBLE);
            mViewEmpty.setOnClickListener(v -> {
                if (mOnRetryListener != null) mOnRetryListener.onRetry();
            });
        }
        showOrHideView(mViewEmpty, VISIBLE);
    }

    private void showLoadingView() {
        if (mViewLoading == null) {
            mViewLoading = mViewStubLoading.inflate();
            mViewLoading.setVisibility(INVISIBLE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                ((ContentLoadingProgressBar) mViewLoading).getIndeterminateDrawable().setColorFilter(new BlendModeColorFilter(ContextCompat.getColor(getContext(), R.color.cc_cang), BlendMode.MULTIPLY));
            } else {
                ((ContentLoadingProgressBar) mViewLoading).getIndeterminateDrawable().setColorFilter(ContextCompat.getColor(getContext(), R.color.cc_cang), PorterDuff.Mode.MULTIPLY);
            }
        }
        showOrHideView(mViewLoading, VISIBLE);
    }

    private void showOrHideView(View view, int visibility) {
        if (view == null || view.getVisibility() == visibility) {
            return;
        }
        if (mAnimatorProvider == null) {
            view.setVisibility(visibility);
            return;
        }
        if(preAnimator != null){
            preAnimator.cancel();
        }

        Animator animator = visibility == VISIBLE ? mAnimatorProvider.showAnimation(view) : mAnimatorProvider.hideAnimation(view);
        if (animator == null) {
            view.setVisibility(visibility);
            return;
        }
        animator.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                view.setVisibility(VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                view.setVisibility(visibility);
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                super.onAnimationCancel(animation);
                view.setVisibility(visibility);
            }
        });
        animator.start();
        preAnimator = animator;
    }


    public interface onRetryListener {
        void onRetry();
    }

    public interface AnimatorProvider {

        Animator showAnimation(View view);

        Animator hideAnimation(View view);
    }

    public static class FadeScaleAnimatorProvider implements AnimatorProvider {

        @Override
        public Animator showAnimation(View view) {
            AnimatorSet set = new AnimatorSet();
            set.playTogether(
                    ObjectAnimator.ofFloat(view, "alpha", 0f, 1f),
                    ObjectAnimator.ofFloat(view, "scaleX", 0.1f, 1f),
                    ObjectAnimator.ofFloat(view, "scaleY", 0.1f, 1f)
            );
            return set;
        }

        @Override
        public Animator hideAnimation(View view) {
            AnimatorSet set = new AnimatorSet();
            set.playTogether(
                    ObjectAnimator.ofFloat(view, "alpha", 1f, 0f),
                    ObjectAnimator.ofFloat(view, "scaleX", 1f, 0.1f),
                    ObjectAnimator.ofFloat(view, "scaleY", 1f, 0.1f)
            );
            return set;
        }
    }
}
