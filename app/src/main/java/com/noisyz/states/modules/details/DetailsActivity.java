package com.noisyz.states.modules.details;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.noisyz.mvvmbase.ui.activity.abs.ContainerWithToolbarActivity;
import com.noisyz.states.data.State;

/**
 * Created by TESSARACT2 on 11.09.2018.
 */

public class DetailsActivity extends ContainerWithToolbarActivity {

    public static final String EXTRA_STATE = "EXTRA_STATE";

    public static void show(Context context, @NonNull State state) {
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(EXTRA_STATE, state);
        context.startActivity(intent);
    }

    @Override
    protected Fragment initFragment() {
        return DetailsFragment.newInstance(getState());
    }

    @Override
    public String getActivityTitle() {
        State state = getState();
        return state.getName() + ", " + state.getCountry() + ", " + state.getAbbr();
    }

    private State getState() {
        Bundle extras = getIntent().getExtras();
        return extras.containsKey(EXTRA_STATE) ? (State) extras.getSerializable(EXTRA_STATE) : new State();
    }
}
