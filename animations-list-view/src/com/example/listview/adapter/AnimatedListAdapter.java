package com.example.listview.adapter;

import com.example.listview.R;
import com.example.listview.animation.AnimationFactory;
import com.example.listview.ui.activity.Animations;

import android.content.Context;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AnimatedListAdapter extends BaseAdapter {

    private final LayoutInflater inflater;
    private final List<String> itemList;
    private int displayWidth;
    private int prevPosition;
    private Animations animation;

    public AnimatedListAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        itemList = new ArrayList<String>();
        displayWidth = getDisplayWidth(context);

        addDummyData();
    }

    private void addDummyData() {
        for (int i = 0; i < 50; i++) {
            itemList.add("Item title " + i);
        }
    }

    public void setAnimation(Animations animation) {
        this.animation = animation;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public String getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int thePosition) {
        return thePosition;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView resultView;

        if (convertView == null) {
            resultView = (TextView) inflater.inflate(R.layout.row_item, null);
        } else {
            resultView = (TextView) convertView;
        }

        String item = getItem(position);
        resultView.setText(item);

        animateView(position, resultView);

        prevPosition = position;
        return resultView;
    }

    private void animateView(int position, TextView resultView) {
        switch (animation) {
            case CARDS:
                AnimationFactory.doCards(resultView, position, prevPosition);
                break;
            case CURL:
                AnimationFactory.doCurl(resultView, position, prevPosition, displayWidth);
                break;
            case FADE:
                AnimationFactory.doFade(resultView);
                break;
            case FLIP:
                AnimationFactory.doFlip(resultView, position, prevPosition);
                break;
            case FLY:
                AnimationFactory.doFly(resultView, position, prevPosition);
                break;
            case GROW:
                AnimationFactory.doGrow(resultView);
                break;
            case REVERSE_FLY:
                AnimationFactory.doReverseFly(resultView, position, prevPosition);
                break;
            case TWIRL:
                AnimationFactory.doTwirl(resultView, position, prevPosition);
                break;
            case ZIPPER:
                AnimationFactory.doZipper(resultView, position, displayWidth);
                break;
            case WAVE:
                AnimationFactory.doWave(resultView, displayWidth);
                break;
        }
    }

    public int getDisplayWidth(Context context) {
        final Display display = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE))
                .getDefaultDisplay();
        return display.getWidth();
    }
}