
package com.carriedo.moimeun.src.Register.models;

import com.google.gson.annotations.SerializedName;

public class RegisterResponse {

    @SerializedName("code")
    private Long code;
    @SerializedName("customerInfo")
    private CustomerInfo customerInfo;
    @SerializedName("isSuccess")
    private Boolean isSuccess;
    @SerializedName("message")
    private String message;

    public Long getCode() {
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
        private String customerBirth;
        @SerializedName("customer_email")
        private String customerEmail;
        @SerializedName("customer_id")
        private String customerId;
        @SerializedName("customer_level")
        private Long customerLevel;
        @SerializedName("customer_name")
        private String customerName;
        @SerializedName("customer_password")
        private String customerPassword;
        @SerializedName("customer_penalty_point")
        private Long customerPenaltyPoint;

        public String getCustomerBirth() {
            return customerBirth;
        }

        public String getCustomerEmail() {
            return customerEmail;
        }

        public String getCustomerId() {
            return customerId;
        }

        public Long getCustomerLevel() {
            return customerLevel;
        }

        public String getCustomerName() {
            return customerName;
        }

        public String getCustomerPassword() {
            return customerPassword;
        }

        public Long getCustomerPenaltyPoint() {
            return customerPenaltyPoint;
        }



    }
}
