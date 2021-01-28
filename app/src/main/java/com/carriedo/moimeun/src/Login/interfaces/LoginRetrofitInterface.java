package com.carriedo.moimeun.src.Login.interfaces;

import com.carriedo.moimeun.src.Login.models.LoginBody;
import com.carriedo.moimeun.src.Login.models.LoginResponse;
import com.carriedo.moimeun.src.Register.models.RegisterBody;
import com.carriedo.moimeun.src.Register.models.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginRetrofitInterface {

    @POST("/login")
    Call<LoginResponse> LoginTest(@Body LoginBody params);

}
