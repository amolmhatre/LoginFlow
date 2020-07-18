package com.amol.testlogin.controller;

import com.amol.testlogin.model.OrderModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by amolmhatre on 7/7/20
 */

public interface RequestInterface {
    @GET("vendor_get_orders.php?vendor_id=11")
    Call<List<OrderModel>> getProductJson();
}
