package com.carriedo.moimeun.src.MyPageFragment.interfaces;

import com.carriedo.moimeun.src.Register.models.IdCheckResponse;
import com.carriedo.moimeun.src.Register.models.RegisterBody;
import com.carriedo.moimeun.src.Register.models.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MypageRetrofitInterface {

    @GET("/customer/{customer_id}")
    Call<IdCheckResponse> MyPageGetTest(
            @Path("customer_id") String customer_id);

}
