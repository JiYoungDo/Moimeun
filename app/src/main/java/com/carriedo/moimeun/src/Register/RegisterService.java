package com.carriedo.moimeun.src.Register;

import com.carriedo.moimeun.src.Register.interfaces.RegisterActivityView;
import com.carriedo.moimeun.src.Register.interfaces.RegisterRetrofitInterface;
import com.carriedo.moimeun.src.Register.models.RegisterBody;
import com.carriedo.moimeun.src.Register.models.RegisterResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.carriedo.moimeun.ApplicationClass.getRetrofit;

public class RegisterService {
    private final RegisterActivityView mRegisterActivityView;

    public RegisterService(RegisterActivityView mRegisterActivityView) {
        this.mRegisterActivityView = mRegisterActivityView;
    }

    // 진짜 서버 통신이 들어가는 부분

    void getTest(String mCustomerBirth, String mCustomerEmail, String mCustomerId, String mCustomerLevel, String mCustomerName,String mCustomerPassword, String mCustomerPenaltyPoint) {
        final RegisterRetrofitInterface registerRetrofitInterface = getRetrofit().create(RegisterRetrofitInterface.class);
        registerRetrofitInterface.RegisterTest(new RegisterBody(mCustomerBirth, mCustomerEmail,mCustomerId, mCustomerLevel,mCustomerName, mCustomerPassword,mCustomerPenaltyPoint)).enqueue(new Callback<RegisterResponse>() {

            // 필요할 때 복붙해서 쓰세요요 - 비동기 호출 (물 흐르듯 위에서 아래로 흐르지 않음) - 비동기 오류를 겪을 수도 있다.
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                // 성공시
                final RegisterResponse registerResponse = response.body();
                if (registerResponse == null) {
                    // 이게 어디로 갈까? mainactivtiy에 있는 validateFailure로 간다.
                    mRegisterActivityView.RegisterFailure(registerResponse.getMessage());
                    return;
                }

                mRegisterActivityView.RegisterSuccess(registerResponse.getMessage());
            }

            // API 통신이 실패했을 시
            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                mRegisterActivityView.RegisterFailure(null);
            }
        });
    }
}
