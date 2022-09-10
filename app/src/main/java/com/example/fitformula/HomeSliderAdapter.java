package com.example.fitformula;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.smarteist.autoimageslider.SliderView;
import com.smarteist.autoimageslider.SliderViewAdapter;

public class HomeSliderAdapter extends SliderViewAdapter<HomeSliderAdapter.Holder> {

    int[] images;

    public HomeSliderAdapter(int[] images)
    {
        this.images = images;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_slider_items, parent, false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder viewHolder, int position) {
        viewHolder.iv_1.setImageResource(images[position]);
    }

    @Override
    public int getCount() {
        return images.length;
    }

    public class Holder extends SliderViewAdapter.ViewHolder {

        ImageView iv_1;

        public Holder(View itemView)
        {
            super(itemView);

            iv_1 = itemView.findViewById(R.id.iv_Home_Slider);
        }

    }
}
