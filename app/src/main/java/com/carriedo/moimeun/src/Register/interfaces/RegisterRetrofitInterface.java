package com.carriedo.moimeun.src.Register.interfaces;

import com.carriedo.moimeun.src.Register.models.RegisterBody;
import com.carriedo.moimeun.src.Register.models.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RegisterRetrofitInterface {

    @POST("/customer")
    Call<RegisterResponse> RegisterTest(@Body RegisterBody params);

}
