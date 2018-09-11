package com.noisyz.states.modules.details;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bindlibrary.generated.StateViewBinder;
import com.noisyz.states.R;
import com.noisyz.states.data.State;

/**
 * Created by TESSARACT2 on 11.09.2018.
 */

public class DetailsFragment extends Fragment {

    public static DetailsFragment newInstance(@NonNull State state) {
        DetailsFragment fragment = new DetailsFragment();
        Bundle args = new Bundle();
        args.putSerializable(DetailsActivity.EXTRA_STATE, state);
        fragment.setArguments(args);
        return fragment;
    }

    public DetailsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.state_details, null);
        State state = (State) getArguments().getSerializable(DetailsActivity.EXTRA_STATE);
        new StateViewBinder(state).registerView(view).bindUI();
        return view;
    }

}
