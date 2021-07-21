package com.carriedo.moimeun.src.MeetingFragment;

import com.carriedo.moimeun.src.MakeMeetingActivity.models.MakeMeetingResponse;
import com.carriedo.moimeun.src.MeetingFragment.interfaces.MeetingListActivityView;
import com.carriedo.moimeun.src.MeetingFragment.interfaces.MeetingListRetrofitInterface;
import com.carriedo.moimeun.src.MeetingFragment.models.UserMeettingResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.carriedo.moimeun.ApplicationClass.getRetrofit;

public class MeetingListService {

    private final MeetingListActivityView meetingListActivityView;

    public MeetingListService(MeetingListActivityView meetingListActivityView) {
        this.meetingListActivityView = meetingListActivityView;
    }



    void getMeetingList(String customer_id) {
        final MeetingListRetrofitInterface meetingListRetrofitInterface = getRetrofit().create(MeetingListRetrofitInterface.class);
        meetingListRetrofitInterface.UserMeetingGetTest(customer_id).enqueue(new Callback<UserMeettingResponse>() {

            // 비동기 호출 - 비동기 오류 주의 코드
            @Override
            public void onResponse(Call<UserMeettingResponse> call, Response<UserMeettingResponse> response) {
                // 성공시
                final UserMeettingResponse userMeettingResponse = response.body();
                if (userMeettingResponse == null) {
                    meetingListActivityView.MeetingListFailure("통신 성공, null 값");
                    return;
                }

                meetingListActivityView.MeetingListSuccess(userMeettingResponse);
            }

            // API 통신이 실패했을 시
            @Override
            public void onFailure(Call<UserMeettingResponse> call, Throwable t) {
                meetingListActivityView.MeetingListFailure("통신 실패");
            }
        });
    }

    void getMoimInfo(String moim_link) {
        final MeetingListRetrofitInterface meetingListRetrofitInterface = getRetrofit().create(MeetingListRetrofitInterface.class);
        meetingListRetrofitInterface.MeetingInfoGetTest(moim_link).enqueue(new Callback<MakeMeetingResponse>() {

            // 비동기 호출 - 비동기 오류 주의 코드
            @Override
            public void onResponse(Call<MakeMeetingResponse> call, Response<MakeMeetingResponse> response) {
                // 성공시
                final MakeMeetingResponse makeMeetingResponse = response.body();
                if (makeMeetingResponse == null) {
                    meetingListActivityView.GetMoimInfoFailure("통신 성공, null 값");
                    return;
                }

                meetingListActivityView.GetMoimInfoSuccess(makeMeetingResponse);
            }

            // API 통신이 실패했을 시
            @Override
            public void onFailure(Call<MakeMeetingResponse> call, Throwable t) {
                meetingListActivityView.GetMoimInfoFailure("통신 실패");
            }
        });
    }

}
