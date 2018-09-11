package com.noisyz.states.modules.list;

import com.noisyz.mvvmbase.view.ItemView;
import com.noisyz.mvvmbase.viewmodel.impl.single.abs.BaseItemViewModelImpl;
import com.noisyz.states.data.State;
import com.noisyz.states.data.StatesResponse;
import com.noisyz.states.net.ApiService;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.functions.Function;

/**
 * Created by TESSARACT2 on 11.09.2018.
 */

public class StatesViewModel extends BaseItemViewModelImpl<List<State>> {
    public StatesViewModel(ItemView<List<State>> listItemView) {
        super(listItemView);
    }

    @Override
    protected Single<List<State>> initRequest() {
        return ApiService.getInstance()
                .getStatesApi()
                .getStates()
                .map(new Function<StatesResponse, List<State>>() {
                    @Override
                    public List<State> apply(StatesResponse statesResponse) throws Exception {
                        return statesResponse.getStates();
                    }
                });
    }
}
