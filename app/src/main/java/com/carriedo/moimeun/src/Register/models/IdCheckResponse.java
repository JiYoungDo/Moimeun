
package com.carriedo.moimeun.src.Register.models;


import com.google.gson.annotations.SerializedName;

public class IdCheckResponse {

    @SerializedName("code")
    private Long mCode;
    @SerializedName("customerInfo")
    private CustomerInfo mCustomerInfo;
    @SerializedName("isSuccess")
    private Boolean mIsSuccess;
    @SerializedName("message")
    private String mMessage;

    public Long getCode() {
        return mCode;
    }
    public CustomerInfo getCustomerInfo() {
        return mCustomerInfo;
    }
    public Boolean getIsSuccess() {
        return mIsSuccess;
    }
    public String getMessage() {
        return mMessage;
    }


    public class CustomerInfo {

        @SerializedName("customer_birth")
        private String mCustomerBirth;
        @SerializedName("customer_email")
        private String mCustomerEmail;
        @SerializedName("customer_id")
        private String mCustomerId;
        @SerializedName("customer_level")
        private Long mCustomerLevel;
        @SerializedName("customer_name")
        private String mCustomerName;
        @SerializedName("customer_password")
        private String mCustomerPassword;
        @SerializedName("customer_penalty_point")
        private Long mCustomerPenaltyPoint;

        public String getCustomerBirth() {
            return mCustomerBirth;
        }

        public String getCustomerEmail() {
            return mCustomerEmail;
        }

        public String getCustomerId() {
            return mCustomerId;
        }

        public Long getCustomerLevel() {
            return mCustomerLevel;
        }

        public String getCustomerName() {
            return mCustomerName;
        }

        public String getCustomerPassword() {
            return mCustomerPassword;
        }

        public Long getCustomerPenaltyPoint() {
            return mCustomerPenaltyPoint;
        }

    }

}
