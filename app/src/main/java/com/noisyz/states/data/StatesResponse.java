package com.noisyz.states.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by TESSARACT2 on 11.09.2018.
 */

public class StatesResponse {

    @SerializedName("RestResponse")
    private Response restResponse;

    public List<State> getStates() {
        return restResponse.getResult();
    }

    private static class Response {
        private List<State> result;

        public List<State> getResult() {
            return result;
        }
    }
}
