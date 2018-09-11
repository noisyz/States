package com.noisyz.states.net;

import com.noisyz.states.data.StatesResponse;

import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * Created by TESSARACT2 on 11.09.2018.
 */

public interface StatesApi {

    @GET("state/get/USA/all")
    Single<StatesResponse> getStates();

}
