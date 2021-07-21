
package com.carriedo.moimeun.src.RegisterActivity.models;

import com.google.gson.annotations.SerializedName;

public class RegisterResponse {

    @SerializedName("code")
    private int  code;
    @SerializedName("customerInfo")
    private CustomerInfo customerInfo;
    @SerializedName("isSuccess")
    private Boolean isSuccess;
    @SerializedName("message")
    private String message;

    public int getCode() {
        return code;
    }

    public CustomerInfo getCustomerInfo() {
        return customerInfo;
    }

    public Boolean getIsSuccess() {
        return isSuccess;
    }

    public String getMessage() {
        return message;
    }

    public class CustomerInfo {


        @SerializedName("customer_birth")
        private String mCustomerBirth;
        @SerializedName("customer_email")
        private String mCustomerEmail;
        @SerializedName("customer_id")
        private String mCustomerId;
        @SerializedName("customer_latitude")
        private Double mCustomerLatitude;
        @SerializedName("customer_level")
        private int mCustomerLevel;
        @SerializedName("customer_longitude")
        private Double mCustomerLongitude;
        @SerializedName("customer_name")
        private String mCustomerName;
        @SerializedName("customer_password")
        private String mCustomerPassword;
        @SerializedName("customer_penalty")
        private int mCustomerPenalty;
        @SerializedName("customer_profile")
        private String mCustomerProfile;

        public String getmCustomerBirth() {
            return mCustomerBirth;
        }

        public String getmCustomerEmail() {
            return mCustomerEmail;
        }

        public String getmCustomerId() {
            return mCustomerId;
        }

        public Double getmCustomerLatitude() {
            return mCustomerLatitude;
        }

        public int getmCustomerLevel() {
            return mCustomerLevel;
        }

        public Double getmCustomerLongitude() {
            return mCustomerLongitude;
        }

        public String getmCustomerName() {
            return mCustomerName;
        }

        public String getmCustomerPassword() {
            return mCustomerPassword;
        }

        public int getmCustomerPenalty() {
            return mCustomerPenalty;
        }

        public String getmCustomerProfile() {
            return mCustomerProfile;
        }
    }
}
