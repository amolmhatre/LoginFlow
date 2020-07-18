package com.amol.testlogin.controller;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by amolmhatre on 7/7/20
 */

public class ProductController  {
    private static Retrofit getRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://nirvaacls.com/bombill_pages/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }

    public static RequestInterface getRequestInterface(){
        RequestInterface requestInterface = getRetrofit().create(RequestInterface.class);
        return requestInterface;
    }
}
