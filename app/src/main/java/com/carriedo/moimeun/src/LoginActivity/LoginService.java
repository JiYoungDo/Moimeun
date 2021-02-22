package com.carriedo.moimeun.src.LoginActivity;

import com.carriedo.moimeun.src.LoginActivity.interfaces.LoginActivityView;
import com.carriedo.moimeun.src.LoginActivity.interfaces.LoginRetrofitInterface;
import com.carriedo.moimeun.src.LoginActivity.models.LoginBody;
import com.carriedo.moimeun.src.LoginActivity.models.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.carriedo.moimeun.ApplicationClass.getRetrofit;

public class LoginService {
    private final LoginActivityView loginActivityView;

    public LoginService(LoginActivityView loginActivityView) {
        this.loginActivityView = loginActivityView;
    }

    //서버 통신
    void postLogin(String id, String pw) {
        final LoginRetrofitInterface loginRetrofitInterface = getRetrofit().create(LoginRetrofitInterface.class);
        loginRetrofitInterface.LoginTest(new LoginBody(id,pw)).enqueue(new Callback<LoginResponse>() {

            // 비동기 호출 - 비동기 오류 주의 코드


            //  API 통신이 성공 했을 시
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                final LoginResponse loginResponse = response.body();
                if (loginResponse.getIsSuccess() == false) {
                    loginActivityView.LoginFailure(loginResponse.getCode(), loginResponse.getMessage());
                    return;
                }

                loginActivityView.LoginSuccess(loginResponse);
            }

            // API 통신이 실패 했을 시
            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                loginActivityView.LoginFailure(0, "no message");
            }
        });
    }

}
