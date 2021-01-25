package com.carriedo.moimeun.src.Register.interfaces;

import com.carriedo.moimeun.src.Register.models.IdCheckResponse;
import com.carriedo.moimeun.src.Register.models.RegisterBody;
import com.carriedo.moimeun.src.Register.models.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RegisterRetrofitInterface {

    @POST("/customer")
    Call<RegisterResponse> RegisterTest(@Body RegisterBody params);

    @GET("/customer/{customer_id}")
    Call<IdCheckResponse> IdCheckTest(
             @Path("customer_id") String customer_id);

}
