package com.example.listview.adapter;

import com.example.listview.R;
import com.example.listview.ui.activity.Animations;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class AnimationCategoryAdapter extends BaseAdapter {

    private final LayoutInflater mInflater;
    private final Animations[] mAnimationArray;

    public AnimationCategoryAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        mAnimationArray = Animations.values();
    }

    @Override
    public int getCount() {
        return mAnimationArray.length;
    }

    @Override
    public Animations getItem(int position) {
        return mAnimationArray[position];
    }

    @Override
    public long getItemId(int thePosition) {
        return thePosition;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView resultView;

        if (convertView == null) {
            resultView = (TextView) mInflater.inflate(R.layout.row_item, null);
        } else {
            resultView = (TextView) convertView;
        }

        Animations item = getItem(position);
        resultView.setText(item.toString());

        return resultView;
    }
}
