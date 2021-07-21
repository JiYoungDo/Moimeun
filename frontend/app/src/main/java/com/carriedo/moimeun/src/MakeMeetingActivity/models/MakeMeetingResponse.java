
package com.carriedo.moimeun.src.MakeMeetingActivity.models;

import com.google.gson.annotations.SerializedName;


public class MakeMeetingResponse {

    @SerializedName("code")
    private int code;
    @SerializedName("count")
    private int count;
    @SerializedName("isSuccess")
    private Boolean isSuccess;
    @SerializedName("message")
    private String message;
    @SerializedName("moimInfo")
    private MoimInfo moimInfo;

    public int getCode() {
        return code;
    }

    public int getCount() {
        return count;
    }

    public Boolean getIsSuccess() {
        return isSuccess;
    }

    public String getMessage() {
        return message;
    }

    public MoimInfo getMoimInfo() {
        return moimInfo;
    }

    public class MoimInfo {

        @SerializedName("moim_endDate")
        private String moimEndDate;
        @SerializedName("moim_isRepeat")
        private Boolean moimIsRepeat;
        @SerializedName("moim_leader")
        private String moimLeader;
        @SerializedName("moim_link")
        private String moimLink;
        @SerializedName("moim_money")
        private Long moimMoney;
        @SerializedName("moim_name")
        private String moimName;
        @SerializedName("moim_place")
        private String moimPlace;
        @SerializedName("moim_pwd")
        private String moimPwd;
        @SerializedName("moim_size")
        private Boolean moimSize;
        @SerializedName("moim_startDate")
        private String moimStartDate;

        public String getMoimEndDate() {
            return moimEndDate;
        }

        public Boolean getMoimIsRepeat() {
            return moimIsRepeat;
        }

        public String getMoimLeader() {
            return moimLeader;
        }

        public String getMoimLink() {
            return moimLink;
        }

        public Long getMoimMoney() {
            return moimMoney;
        }

        public String getMoimName() {
            return moimName;
        }

        public String getMoimPlace() {
            return moimPlace;
        }

        public String getMoimPwd() {
            return moimPwd;
        }

        public Boolean getMoimSize() {
            return moimSize;
        }

        public String getMoimStartDate() {
            return moimStartDate;
        }


    }


}
