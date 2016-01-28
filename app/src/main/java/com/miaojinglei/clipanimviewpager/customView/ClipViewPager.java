package com.miaojinglei.clipanimviewpager.customView;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

import com.miaojinglei.clipanimviewpager.DisplayUtil;

/**
 * Created by HanHailong on 15/9/27.
 */
public class ClipViewPager extends ViewPager {

    public ClipViewPager(Context context) {
        super(context);
    }

    public ClipViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//
//        if (ev.getAction() == MotionEvent.ACTION_UP) {
//            View view = viewOfClickOnScreen(ev);
//            if (view != null) {
//                setCurrentItem(indexOfChild(view));
//            }
//        }
//
//        return super.dispatchTouchEvent(ev);
//    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        widthMeasureSpec = MeasureSpec.makeMeasureSpec(getPagerWidth(getContext())//这里设置两侧预显示的大小
                , MeasureSpec.getMode(widthMeasureSpec));
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public static int getPagerWidth(Context context){
        return  (int) ((DisplayUtil.getScreenWidth(context) - 2 * DisplayUtil.dip2px(context, 10)) / (3 - 2 * ScalePageTransformer.MIN_SCALE));
    }

    /**
     * @param ev
     * @return
     */
//    private View viewOfClickOnScreen(MotionEvent ev) {
//        int childCount = getChildCount();
//        int[] location = new int[2];
//        for (int i = 0; i < childCount; i++) {
//            View v = getChildAt(i);
//            v.getLocationOnScreen(location);
//            int minX = location[0];
//            int minY = getTop();
//
//            int maxX = location[0] + v.getWidth();
//            int maxY = getBottom();
//
//            float x = ev.getX();
//            float y = ev.getY();
//
//            if ((x > minX && x < maxX) && (y > minY && y < maxY)) {
//                return v;
//            }
//        }
//        return null;
//    }
}
