package com.example.listview.ui.activity;

import com.example.listview.adapter.AnimatedListAdapter;

import android.app.ListActivity;
import android.os.Bundle;

public class AnimatedListActivity extends ListActivity {

    public static final String EXTRAS_ANIMATION_INDEX = "EXTRAS_ANIMATION_INDEX";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int index = getAnimationIndex();
        Animations animation = Animations.values()[index];
        initView(animation);
    }

    private void initView(Animations animation) {
        getActionBar().setTitle(animation.toString());
        AnimatedListAdapter adapter = new AnimatedListAdapter(this);
        adapter.setAnimation(animation);
		getListView().setAdapter(adapter);
    }

    public int getAnimationIndex() {
        return getIntent().getIntExtra(EXTRAS_ANIMATION_INDEX, 0);
    }
}
