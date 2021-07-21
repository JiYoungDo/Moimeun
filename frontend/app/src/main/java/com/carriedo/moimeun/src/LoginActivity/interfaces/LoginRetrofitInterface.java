package com.carriedo.moimeun.src.LoginActivity.interfaces;

import com.carriedo.moimeun.src.LoginActivity.models.LoginBody;
import com.carriedo.moimeun.src.LoginActivity.models.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginRetrofitInterface {

    @POST("/login")
    Call<LoginResponse> LoginTest(@Body LoginBody params);

}
