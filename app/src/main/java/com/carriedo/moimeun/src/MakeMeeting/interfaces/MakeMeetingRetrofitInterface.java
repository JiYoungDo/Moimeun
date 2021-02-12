package com.carriedo.moimeun.src.MakeMeeting.interfaces;

import com.carriedo.moimeun.src.MakeMeeting.models.MakeMeetingBody;
import com.carriedo.moimeun.src.MakeMeeting.models.MakeMeetingResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface MakeMeetingRetrofitInterface {

    @POST("/moim")
    Call<MakeMeetingResponse> MakeMeetingTest(@Body MakeMeetingBody params);

}
