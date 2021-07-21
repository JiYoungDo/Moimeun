package com.carriedo.moimeun.src.MyPageFragment;

import com.carriedo.moimeun.src.MyPageFragment.interfaces.MypageActivityView;
import com.carriedo.moimeun.src.MyPageFragment.interfaces.MypageRetrofitInterface;
import com.carriedo.moimeun.src.RegisterActivity.models.IdCheckResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.carriedo.moimeun.ApplicationClass.getRetrofit;

public class MypageService {

    private final MypageActivityView mypageActivityView;

    public MypageService(MypageActivityView mypageActivityView) {
        this.mypageActivityView = mypageActivityView;
    }

    void getMypage(String customer_id) {
        final MypageRetrofitInterface mypageRetrofitInterface = getRetrofit().create(MypageRetrofitInterface.class);
        mypageRetrofitInterface.MyPageGetTest(customer_id).enqueue(new Callback<IdCheckResponse>() {

            // 비동기 호출 - 비동기 오류 주의 코드
            @Override
            public void onResponse(Call<IdCheckResponse> call, Response<IdCheckResponse> response) {
                // 성공시
                final IdCheckResponse idCheckResponse = response.body();
                if (idCheckResponse == null) {
                    mypageActivityView.MypageFailure("통신 성공, null 값");
                    return;
                }

                mypageActivityView.MypageSuccess(idCheckResponse);
            }

            // API 통신이 실패했을 시
            @Override
            public void onFailure(Call<IdCheckResponse> call, Throwable t) {
                mypageActivityView.MypageFailure("통신 실패");
            }
        });
    }

    void deleteMypage(String customer_id) {
        final MypageRetrofitInterface mypageRetrofitInterface = getRetrofit().create(MypageRetrofitInterface.class);
        mypageRetrofitInterface.MyPageDeleteTest(customer_id).enqueue(new Callback<IdCheckResponse>() {

            // 비동기 호출 - 비동기 오류 주의 코드
            @Override
            public void onResponse(Call<IdCheckResponse> call, Response<IdCheckResponse> response) {
                // 성공시
                final IdCheckResponse idCheckResponse = response.body();
                if (idCheckResponse == null) {
                    mypageActivityView.UserDeleteFailure("통신 성공, null 값");
                    return;
                }

                mypageActivityView.UserDeleteSuccess(idCheckResponse);
            }

            // API 통신이 실패했을 시
            @Override
            public void onFailure(Call<IdCheckResponse> call, Throwable t) {
                mypageActivityView.UserDeleteFailure("통신 실패");
            }
        });
    }
}
