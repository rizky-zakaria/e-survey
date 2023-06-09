package com.example.e_survey.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.e_survey.R;

public class viewPagerAdapter extends PagerAdapter {

    private Context context;

    public viewPagerAdapter(Context context) {
        this.context = context;
    }

    private LayoutInflater layoutInflater;

    private Integer[] images = {R.drawable.srf1, R.drawable.srf1, R.drawable.srf1};




    @Override

    public int getCount() {

        return images.length;

    }



    @Override

    public boolean isViewFromObject(View view, Object object) {

        return view == object;

    }



    @Override

    public Object instantiateItem(ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.custome_layout, null);

        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);

        imageView.setImageResource(images[position]);
//        imageView.setScaleType();



        ViewPager vp = (ViewPager) container;

        vp.addView(view, 0);

        return view;

    }



    @Override

    public void destroyItem(ViewGroup container, int position, Object object) {



        ViewPager vp = (ViewPager) container;

        View view = (View) object;

        vp.removeView(view);

    }

}
