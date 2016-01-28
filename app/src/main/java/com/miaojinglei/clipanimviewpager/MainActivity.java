package com.miaojinglei.clipanimviewpager;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.miaojinglei.clipanimviewpager.customView.ClipViewPager;
import com.miaojinglei.clipanimviewpager.customView.ColorAnimationView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.colorView)
    ColorAnimationView colorView;
    @Bind(R.id.viewPager)
    ClipViewPager viewPager;
    @Bind(R.id.pagerContainer)
    FrameLayout pagerContainer;
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    private int[] colors = {R.color.light_green, R.color.light_blue, R.color.light_yellow, R.color.light_orange, R.color.orange, R.color.light_red};
    private int[] bgs = {R.drawable.kapian1, R.drawable.kapian2, R.drawable.kapian3, R.drawable.kapian4, R.drawable.kapian5, R.drawable.kapian6};
    private LayoutInflater inflater;
    private int imageSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
            window.setNavigationBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initViews();
        setEvents();
    }

    private void initViews() {
        setSupportActionBar(toolbar);
        imageSize = ClipViewPager.getPagerWidth(this);
        inflater = LayoutInflater.from(this);
        pagerContainer.setVisibility(View.VISIBLE);
        //缓存所有数据
        viewPager.setOffscreenPageLimit(bgs.length);
        viewPager.setAdapter(new ViewPagerAdapter());
        colorView.setmViewPager(viewPager, bgs.length);
    }

    private void setEvents() {
        //当ViewPager滚动时背景色渐变
        colorView.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    class ViewPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return colors.length;
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            View view = inflater.inflate(R.layout.adapter_pager, null);
            RelativeLayout cardLayout = ViewHolder.get(view, R.id.cardLayout);
            cardLayout.setBackgroundResource(bgs[position % bgs.length]);
            RelativeLayout imageLayout = ViewHolder.get(view, R.id.imageLayout);
            ViewGroup.LayoutParams imgParams = imageLayout.getLayoutParams();
            imgParams.width = imageSize;
            imgParams.height = imageSize;
            imageLayout.setLayoutParams(imgParams);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

    }
}
