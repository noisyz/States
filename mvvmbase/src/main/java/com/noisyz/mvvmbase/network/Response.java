package com.noisyz.mvvmbase.network;

import java.io.Serializable;

public class Response<T> implements Serializable {
    private String message;
    private T result;
    private boolean success;

    public boolean isSuccess() {
        return this.success;
    }

    public String getMessage() {
        return this.message;
    }

    public T getResult() {
        return this.result;
    }
}
