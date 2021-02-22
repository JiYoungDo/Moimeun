package com.carriedo.moimeun.src.LoginActivity.interfaces;

import com.carriedo.moimeun.src.LoginActivity.models.LoginResponse;

public interface LoginActivityView {

    void LoginSuccess(LoginResponse loginResponse);
    void LoginFailure(int code, String message);
}
