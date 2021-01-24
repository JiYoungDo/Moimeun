package com.carriedo.moimeun.src.Login.models;

import com.google.gson.annotations.SerializedName;

public class LoginBody {

    // 로그인 에 필요한 body
    @SerializedName("id")
    private String id;

    @SerializedName("password")
    private String password;
}
