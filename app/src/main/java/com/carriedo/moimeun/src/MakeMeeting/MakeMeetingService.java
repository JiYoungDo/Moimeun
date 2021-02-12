package com.carriedo.moimeun.src.MakeMeeting;

import android.util.Log;

import com.carriedo.moimeun.src.MakeMeeting.interfaces.MakeMeetingActivityView;
import com.carriedo.moimeun.src.MakeMeeting.interfaces.MakeMeetingRetrofitInterface;
import com.carriedo.moimeun.src.MakeMeeting.models.MakeMeetingBody;
import com.carriedo.moimeun.src.MakeMeeting.models.MakeMeetingResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.carriedo.moimeun.ApplicationClass.getRetrofit;

public class MakeMeetingService {

    private final MakeMeetingActivityView makeMeetingActivityView;

    public MakeMeetingService(MakeMeetingActivityView makeMeetingActivityView) {
        this.makeMeetingActivityView = makeMeetingActivityView;
    }

    //서버 통신
    void postMakeMeeting(String moimEndDate, Boolean moimIsRepeat, String moimLeader, String moimLink,
                         int moimMoney, String moimName, String moimPlace, String moimPwd, Boolean moimSize, String moimStartDate) {
        final MakeMeetingRetrofitInterface makeMeetingRetrofitInterface = getRetrofit().create(MakeMeetingRetrofitInterface.class);
        makeMeetingRetrofitInterface.MakeMeetingTest(new MakeMeetingBody( moimEndDate,  moimIsRepeat,  moimLeader,  moimLink,
         moimMoney,  moimName,  moimPlace,  moimPwd,  moimSize,  moimStartDate)).enqueue(new Callback<MakeMeetingResponse>() {

            // 비동기 호출 - 비동기 오류 주의 코드
            @Override
            public void onResponse(Call<MakeMeetingResponse> call, Response<MakeMeetingResponse> response) {
                // 성공시
                final MakeMeetingResponse makeMeetingResponse = response.body();
                if (makeMeetingResponse == null) {
                    makeMeetingActivityView.MakeMeetingFailure("null 값");
                    return;
                }

                makeMeetingActivityView.MakeMeetingSuccess(makeMeetingResponse);
            }

            // API 통신이 실패했을 시
            @Override
            public void onFailure(Call<MakeMeetingResponse> call, Throwable t) {
                makeMeetingActivityView.MakeMeetingFailure("통신 자체 실패");
            }
        });
    }



}
