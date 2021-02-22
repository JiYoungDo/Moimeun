package com.carriedo.moimeun.src.MeetingFragment.interfaces;


import com.carriedo.moimeun.src.MakeMeetingActivity.models.MakeMeetingResponse;
import com.carriedo.moimeun.src.MeetingFragment.models.UserMeettingResponse;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MeetingListRetrofitInterface {

    // 사용자가 참여한 모임의 링크를 조회하는 api
    @GET("/moims/{customer_id}")
    Call<UserMeettingResponse> UserMeetingGetTest(
            @Path("customer_id") String customer_id);


    // 모임의 링크로 모임의 정보를 조회하는 api
    @GET("/moim/{moim_link}")
    Call<MakeMeetingResponse> MeetingInfoGetTest(
            @Path("moim_link") String moim_link);

}
