package com.jenson.common.widget;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * author: CDJenson
 * date: 2020/6/19 17:00
 * version: 1.0
 * description: One-sentence description
 */
public class RecyclerViewItemDecoration extends RecyclerView.ItemDecoration {

    public static final int HORIZONTAL_DIV = 0;
    public static final int VERTICAL_DIV = 1;
    public static final int GRID_DIV = 2;

    private int mOrientation;
    private int mDividerWidth = 0;
    private Paint mPaint;
    private boolean mFirstLineVisible = false;//是否绘制第一个item的分割线

    private RecyclerViewItemDecoration(int orientation, int color, int dividerWidth, boolean firstLineVisible) {
        mOrientation = orientation;
        mDividerWidth = dividerWidth;
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(color);
        mPaint.setStyle(Paint.Style.FILL);
        mFirstLineVisible = firstLineVisible;
    }


    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        switch (mOrientation) {
            case HORIZONTAL_DIV:
                drawHorizontal(c, parent);
                break;
            case VERTICAL_DIV:
                drawVertical(c, parent);
                break;
            case GRID_DIV:
                drawGrid(c, parent);
                break;
            default:
                drawVertical(c, parent);
                break;
        }
    }


    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        int itemPosition = parent.getChildAdapterPosition(view);
        RecyclerView.Adapter mAdapter = parent.getAdapter();
        if (mAdapter != null) {
            int mChildCount = mAdapter.getItemCount();
            switch (mOrientation) {
                case HORIZONTAL_DIV:
                    if (!mFirstLineVisible && itemPosition == 0) {
                        return;
                    }
                    outRect.set(mDividerWidth, 0, 0, 0);
                    break;
                case VERTICAL_DIV:
                    if (!mFirstLineVisible && itemPosition == 0) {
                        return;
                    }
                    outRect.set(0, mDividerWidth, 0, 0);
                    break;
                case GRID_DIV:
                    /**
                     * 表格格局分割线
                     * <p>
                     *      1：当是第一个Item的时候，四周全部需要分割线
                     *      2：当是第一行Item的时候，需要额外添加顶部的分割线
                     *      3：当是第一列Item的时候，需要额外添加左侧的分割线
                     *      4：默认情况全部添加底部和右侧的分割线
                     * </p>
                     */
                    RecyclerView.LayoutManager mLayoutManager = parent.getLayoutManager();
                    if (mLayoutManager instanceof GridLayoutManager) {
                        GridLayoutManager mGridLayoutManager = (GridLayoutManager) mLayoutManager;
                        int mSpanCount = mGridLayoutManager.getSpanCount();
                        if (itemPosition == 0) {//1
                            outRect.set(mDividerWidth, mDividerWidth, mDividerWidth, mDividerWidth);
                        } else if ((itemPosition + 1) <= mSpanCount) {//2
                            outRect.set(0, mDividerWidth, mDividerWidth, mDividerWidth);
                        } else if (((itemPosition + mSpanCount) % mSpanCount) == 0) {//3
                            outRect.set(mDividerWidth, 0, mDividerWidth, mDividerWidth);
                        } else {//4
                            outRect.set(0, 0, mDividerWidth, mDividerWidth);
                        }
                    }
                    break;
                default:
                    //纵向布局分割线
                    if (itemPosition != (mChildCount - 1)) {
                        outRect.set(0, 0, 0, mDividerWidth);
                    }
                    break;
            }
        }
    }

    /**
     * 绘制横向列表分割线
     *
     * @param c      绘制容器
     * @param parent RecyclerView
     */
    private void drawHorizontal(Canvas c, RecyclerView parent) {
        int mChildCount = parent.getChildCount();
        for (int i = 0; i < mChildCount; i++) {
            View mChild = parent.getChildAt(i);
            drawLeft(c, mChild, parent);
        }
    }

    /**
     * 绘制纵向列表分割线
     *
     * @param c      绘制容器
     * @param parent RecyclerView
     */
    private void drawVertical(Canvas c, RecyclerView parent) {
        int mChildCount = parent.getChildCount();
        for (int i = 0; i < mChildCount; i++) {
            View mChild = parent.getChildAt(i);
            drawTop(c, mChild, parent);
        }
    }

    /**
     * 绘制表格类型分割线
     *
     * @param c      绘制容器
     * @param parent RecyclerView
     */
    private void drawGrid(Canvas c, RecyclerView parent) {
        int mChildCount = parent.getChildCount();
        for (int i = 0; i < mChildCount; i++) {
            View mChild = parent.getChildAt(i);
            RecyclerView.LayoutManager mLayoutManager = parent.getLayoutManager();
            if (mLayoutManager instanceof GridLayoutManager) {
                GridLayoutManager mGridLayoutManager = (GridLayoutManager) mLayoutManager;
                int mSpanCount = mGridLayoutManager.getSpanCount();
                if (i == 0) {
                    drawTop(c, mChild, parent);
                    drawLeft(c, mChild, parent);
                }
                if ((i + 1) <= mSpanCount) {
                    drawTop(c, mChild, parent);
                }
                if (((i + mSpanCount) % mSpanCount) == 0) {
                    drawLeft(c, mChild, parent);
                }
                drawRight(c, mChild, parent);
                drawBottom(c, mChild, parent);
            }
        }
    }

    /**
     * 绘制右边分割线
     *
     * @param c            绘制容器
     * @param mChild       对应ItemView
     * @param recyclerView RecyclerView
     */
    private void drawLeft(Canvas c, View mChild, RecyclerView recyclerView) {
        RecyclerView.LayoutParams mChildLayoutParams = (RecyclerView.LayoutParams) mChild.getLayoutParams();
        int left = mChild.getLeft() - mDividerWidth - mChildLayoutParams.leftMargin;
        int top = mChild.getTop() - mChildLayoutParams.topMargin;
        int right = mChild.getLeft() - mChildLayoutParams.leftMargin;
        int bottom;
        if (isGridLayoutManager(recyclerView)) {
            bottom = mChild.getBottom() + mChildLayoutParams.bottomMargin + mDividerWidth;
        } else {
            bottom = mChild.getBottom() + mChildLayoutParams.bottomMargin;
        }
        c.drawRect(left, top, right, bottom, mPaint);
    }

    /**
     * 绘制顶部分割线
     *
     * @param c            绘制容器
     * @param mChild       对应ItemView
     * @param recyclerView RecyclerView
     */
    private void drawTop(Canvas c, View mChild, RecyclerView recyclerView) {
        RecyclerView.LayoutParams mChildLayoutParams = (RecyclerView.LayoutParams) mChild.getLayoutParams();
        int left;
        int top = mChild.getTop() - mChildLayoutParams.topMargin - mDividerWidth;
        int right = mChild.getRight() + mChildLayoutParams.rightMargin;
        int bottom = mChild.getTop() - mChildLayoutParams.topMargin;
        if (isGridLayoutManager(recyclerView)) {
            left = mChild.getLeft() - mChildLayoutParams.leftMargin - mDividerWidth;
        } else {
            left = mChild.getLeft() - mChildLayoutParams.leftMargin;
        }
        c.drawRect(left, top, right, bottom, mPaint);
    }

    /**
     * 绘制右边分割线
     *
     * @param c            绘制容器
     * @param mChild       对应ItemView
     * @param recyclerView RecyclerView
     */
    private void drawRight(Canvas c, View mChild, RecyclerView recyclerView) {
        RecyclerView.LayoutParams mChildLayoutParams = (RecyclerView.LayoutParams) mChild.getLayoutParams();
        int left = mChild.getRight() + mChildLayoutParams.rightMargin;
        int top;
        int right = left + mDividerWidth;
        int bottom = mChild.getBottom() + mChildLayoutParams.bottomMargin;
        if (isGridLayoutManager(recyclerView)) {
            top = mChild.getTop() - mChildLayoutParams.topMargin - mDividerWidth;
        } else {
            top = mChild.getTop() - mChildLayoutParams.topMargin;
        }
        c.drawRect(left, top, right, bottom, mPaint);
    }

    /**
     * 绘制底部分割线
     *
     * @param c            绘制容器
     * @param mChild       对应ItemView
     * @param recyclerView RecyclerView
     */
    private void drawBottom(Canvas c, View mChild, RecyclerView recyclerView) {
        RecyclerView.LayoutParams mChildLayoutParams = (RecyclerView.LayoutParams) mChild.getLayoutParams();
        int left = mChild.getLeft() - mChildLayoutParams.leftMargin;
        int top = mChild.getBottom() + mChildLayoutParams.bottomMargin;
        int bottom = top + mDividerWidth;
        int right;
        if (isGridLayoutManager(recyclerView)) {
            right = mChild.getRight() + mChildLayoutParams.rightMargin + mDividerWidth;
        } else {
            right = mChild.getRight() + mChildLayoutParams.rightMargin;
        }
        c.drawRect(left, top, right, bottom, mPaint);
    }

    /**
     * 判断RecyclerView所加载LayoutManager是否为GridLayoutManager
     *
     * @param recyclerView RecyclerView
     * @return 是GridLayoutManager返回true，否则返回false
     */
    private boolean isGridLayoutManager(RecyclerView recyclerView) {
        RecyclerView.LayoutManager mLayoutManager = recyclerView.getLayoutManager();
        return (mLayoutManager instanceof GridLayoutManager);
    }

    public static class Builer {
        int orientation = VERTICAL_DIV;
        int color = Color.TRANSPARENT;
        int size = 2;
        boolean firstLineVisible = false;

        public Builer() {

        }

        public Builer setOrientation(int orientation) {
            if (orientation != HORIZONTAL_DIV && orientation != VERTICAL_DIV && orientation != GRID_DIV) {
                throw new IllegalArgumentException("ItemDecorationPowerful：分割线类型设置异常");
            } else {
                this.orientation = orientation;
            }
            return this;
        }

        public Builer setColor(int color) {
            this.color = color;
            return this;
        }

        public Builer setSize(int size) {
            this.size = size;
            return this;
        }

        public Builer setFirstLineVisible(boolean firstLineVisible) {
            this.firstLineVisible = firstLineVisible;
            return this;
        }

        public RecyclerViewItemDecoration create() {
            return new RecyclerViewItemDecoration(orientation, color, size, firstLineVisible);
        }
    }
}