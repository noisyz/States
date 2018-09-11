package com.noisyz.states.modules.list;

import android.view.View;

import com.bindlibrary.generated.state.adapter.StateBindAdapter;
import com.noisyz.bindlibrary.base.impl.adapter.RecyclerBindAdapter;
import com.noisyz.mvvmbase.ui.list.abs.ListItemFragment;
import com.noisyz.mvvmbase.viewmodel.impl.single.abs.BaseItemViewModelImpl;
import com.noisyz.states.R;
import com.noisyz.states.data.State;
import com.noisyz.states.modules.details.DetailsActivity;

import java.util.List;

/**
 * Created by TESSARACT2 on 11.09.2018.
 */

public class StatesListFragment extends ListItemFragment<State> {

    public static StatesListFragment newInstance() {
        return new StatesListFragment();
    }

    public StatesListFragment() {
    }

    @Override
    protected RecyclerBindAdapter<State> initItemsAdapter(List<State> list) {
        return new StateBindAdapter(list, R.layout.state_item);
    }

    @Override
    public BaseItemViewModelImpl<List<State>> initViewModel() {
        return new StatesViewModel(this);
    }

    @Override
    public void onItemClick(View convertView, int position, State state) {
        DetailsActivity.show(getContext(), state);
    }
}
