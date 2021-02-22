package com.carriedo.moimeun.src.MyPageFragment.interfaces;

import com.carriedo.moimeun.src.RegisterActivity.models.IdCheckResponse;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MypageRetrofitInterface {

    @GET("/customer/{customer_id}")
    Call<IdCheckResponse> MyPageGetTest(
            @Path("customer_id") String customer_id);


    @DELETE("/customer/{customer_id}")
    Call<IdCheckResponse> MyPageDeleteTest(
            @Path("customer_id") String customer_id);


}
