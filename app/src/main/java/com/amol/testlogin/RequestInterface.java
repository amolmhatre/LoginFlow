package com.amol.testlogin;

import com.amol.testlogin.model.ProductModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by amolmhatre on 7/7/20
 */

interface RequestInterface {
    @GET("vendor_get_products.php?vendor_id=11")
    Call<List<ProductModel>> getProductJson();
}
