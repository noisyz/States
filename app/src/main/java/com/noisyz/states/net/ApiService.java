package com.noisyz.states.net;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit.Builder;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {

    private static final String STATES_API_URL = "http://services.groupkt.com/";

    private static ApiService instance;
    private StatesApi statesApi;

    public static ApiService getInstance() {
        if (instance == null) {
            instance = new ApiService();
        }
        return instance;
    }

    public static ApiService newInstance() {
        return new ApiService();
    }

    public static void release() {
        instance = null;
    }

    private ApiService() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(Level.BODY);

        this.statesApi = new Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(STATES_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder()
                        .readTimeout(5, TimeUnit.SECONDS)
                        .writeTimeout(5, TimeUnit.SECONDS)
                        .connectTimeout(5, TimeUnit.SECONDS)
                        .addInterceptor(interceptor)
                        .build())
                .build()
                .create(StatesApi.class);


    }

    public StatesApi getStatesApi() {
        return statesApi;
    }
}
