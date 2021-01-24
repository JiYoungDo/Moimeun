
package com.carriedo.moimeun.src.Register.models;

import com.google.gson.annotations.SerializedName;


public class RegisterBody {

    @SerializedName("customer_birth")
    private String mCustomerBirth;
    @SerializedName("customer_email")
    private String mCustomerEmail;
    @SerializedName("customer_id")
    private String mCustomerId;
    @SerializedName("customer_level")
    private String mCustomerLevel;
    @SerializedName("customer_name")
    private String mCustomerName;
    @SerializedName("customer_password")
    private String mCustomerPassword;
    @SerializedName("customer_penalty_point")
    private String mCustomerPenaltyPoint;

    public RegisterBody(String mCustomerBirth, String mCustomerEmail, String mCustomerId, String mCustomerLevel, String mCustomerName,String mCustomerPassword, String mCustomerPenaltyPoint) {
        this.mCustomerBirth = mCustomerBirth;
        this.mCustomerEmail = mCustomerEmail;
        this.mCustomerId = mCustomerId;
        this.mCustomerLevel = mCustomerLevel;
        this.mCustomerName = mCustomerName;
        this.mCustomerPassword = mCustomerPassword;
        this.mCustomerPenaltyPoint = mCustomerPenaltyPoint;

    }

}
