package com.quintus.labs.autoslider.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.quintus.labs.autoslider.R;

import java.util.List;

/**
 * Created by QUINTUSLABS on 13/04/2018.
 */

public class SliderAdapter extends PagerAdapter {
    private Context context;
    private List<Integer> icon;
    private List<String> iconName;

    public SliderAdapter(Context context, List<Integer> icon, List<String> iconName) {
        this.context = context;
        this.icon = icon;
        this.iconName = iconName;
    }

    @Override
    public int getCount() {
        return icon.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_slider, null);

        TextView textView = view.findViewById(R.id.textView);
        ImageView imageView = view.findViewById(R.id.imageview);

        textView.setText(iconName.get(position));
        imageView.setBackgroundResource(icon.get(position));

        ViewPager viewPager = (ViewPager) container;
        viewPager.addView(view, 0);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ViewPager viewPager = (ViewPager) container;
        View view = (View) object;
        viewPager.removeView(view);
    }
}
