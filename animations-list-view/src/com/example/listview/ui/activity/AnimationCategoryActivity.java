package com.example.listview.ui.activity;

import com.example.listview.adapter.AnimationCategoryAdapter;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

public class AnimationCategoryActivity extends ListActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        AnimationCategoryAdapter adapter = new AnimationCategoryAdapter(this);
		getListView().setAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int index, long l) {
        startAnimationActivity(index);
    }

    private void startAnimationActivity(int index) {
        Intent intent = new Intent(getApplicationContext(), AnimatedListActivity.class);
        intent.putExtra(AnimatedListActivity.EXTRAS_ANIMATION_INDEX, index);
        startActivity(intent);
    }
}
