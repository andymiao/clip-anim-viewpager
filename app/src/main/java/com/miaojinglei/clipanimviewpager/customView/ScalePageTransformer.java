package com.miaojinglei.clipanimviewpager.customView;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by HanHailong on 15/9/27.
 */
public class ScalePageTransformer implements ViewPager.PageTransformer {

    public static final float MAX_SCALE = 1.0f;
    public static final float MIN_SCALE = 0.94f;
    private float lastPosition;

    @Override
    public void transformPage(View page, float position) {

        if (position < -1) {
            position = -1;
        } else if (position > 1) {
            position = 1;
        }

        float tempScale = position < 0 ? 1 + position : 1 - position;

        float slope = (MAX_SCALE - MIN_SCALE) / 1;
        //一个公式
        float scaleValue = MIN_SCALE + tempScale * slope;
        lastPosition = position;
        page.setScaleX(scaleValue);
        page.setScaleY(scaleValue);

    }
}
