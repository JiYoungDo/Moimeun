package com.carriedo.moimeun.src.LoginActivity.models;

import com.google.gson.annotations.SerializedName;

public class LoginBody {

    // 로그인 에 필요한 body
    @SerializedName("customer_id")
    private String customer_id;

    @SerializedName("customer_password")
    private String customer_password;

    public String getCustomer_id() {
        return customer_id;
    }

    public String getCustomer_password() {
        return customer_password;
    }

    public LoginBody(String customer_id, String customer_password) {
        this.customer_id = customer_id;
        this.customer_password = customer_password;
    }
}
