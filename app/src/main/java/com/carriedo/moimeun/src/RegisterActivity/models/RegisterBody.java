
package com.carriedo.moimeun.src.RegisterActivity.models;

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

    @SerializedName("customer_latitude")
    private Double mCustomerLatitude;
    @SerializedName("customer_longitude")
    private Double mCustomerLongitude;

    @SerializedName("customer_profile")
    private String mCustomerProfile;

    public RegisterBody(String mCustomerBirth, String mCustomerEmail, String mCustomerId,
                        String mCustomerLevel, String mCustomerName,String mCustomerPassword, String mCustomerPenaltyPoint,
                        Double mCustomerLatitude, Double mCustomerLongitude, String mCustomerProfile ) {
        this.mCustomerBirth = mCustomerBirth;
        this.mCustomerEmail = mCustomerEmail;
        this.mCustomerId = mCustomerId;
        this.mCustomerLevel = mCustomerLevel;
        this.mCustomerName = mCustomerName;
        this.mCustomerPassword = mCustomerPassword;
        this.mCustomerPenaltyPoint = mCustomerPenaltyPoint;

        this.mCustomerLatitude = mCustomerLatitude;
        this.mCustomerLongitude = mCustomerLongitude;
        this.mCustomerProfile = mCustomerProfile;
    }

}
