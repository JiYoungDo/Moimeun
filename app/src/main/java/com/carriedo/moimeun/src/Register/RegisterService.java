package com.carriedo.moimeun.src.Register;

import com.carriedo.moimeun.src.Register.interfaces.RegisterActivityView;
import com.carriedo.moimeun.src.Register.interfaces.RegisterRetrofitInterface;
import com.carriedo.moimeun.src.Register.models.IdCheckResponse;
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

    //서버 통신
    void postRegister(String mCustomerBirth, String mCustomerEmail, String mCustomerId, String mCustomerLevel, String mCustomerName,String mCustomerPassword, String mCustomerPenaltyPoint, Double mLatitude, Double mLogditude, String profile_img) {
        final RegisterRetrofitInterface registerRetrofitInterface = getRetrofit().create(RegisterRetrofitInterface.class);
        registerRetrofitInterface.RegisterTest(new RegisterBody(mCustomerBirth, mCustomerEmail,mCustomerId, mCustomerLevel,mCustomerName, mCustomerPassword,mCustomerPenaltyPoint,mLatitude,mLogditude,profile_img)).enqueue(new Callback<RegisterResponse>() {

            // 비동기 호출 - 비동기 오류 주의 코드
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                // 성공시
                final RegisterResponse registerResponse = response.body();
                if (registerResponse == null) {
                    mRegisterActivityView.RegisterFailure("통신 성공, null 값");
                    return;
                }

                mRegisterActivityView.RegisterSuccess(registerResponse.getMessage());
            }

            // API 통신이 실패했을 시
            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                mRegisterActivityView.RegisterFailure("통신 실패");
            }
        });
    }


    void getIdCheck(String id) {
        final RegisterRetrofitInterface registerRetrofitInterface = getRetrofit().create(RegisterRetrofitInterface.class);
        registerRetrofitInterface.IdCheckTest(id).enqueue(new Callback<IdCheckResponse>() {

            // 비동기 호출 - 비동기 오류 주의 코드
            @Override
            public void onResponse(Call<IdCheckResponse> call, Response<IdCheckResponse> response) {
                // 성공시
                final IdCheckResponse idCheckResponse = response.body();
                if (idCheckResponse == null) {
                    mRegisterActivityView.IdCheckFailure("통신 성공, null 값");
                    return;
                }

                mRegisterActivityView.IdCheckSuccess(idCheckResponse.getMessage());
            }

            // API 통신이 실패했을 시
            @Override
            public void onFailure(Call<IdCheckResponse> call, Throwable t) {
                mRegisterActivityView.IdCheckFailure("통신 실패");
            }
        });
    }




}
