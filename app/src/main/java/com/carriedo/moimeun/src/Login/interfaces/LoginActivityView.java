package com.carriedo.moimeun.src.Login.interfaces;

import com.carriedo.moimeun.src.Login.models.LoginResponse;

public interface LoginActivityView {

    void LoginSuccess(LoginResponse loginResponse);
    void LoginFailure(int code, String message);
}
