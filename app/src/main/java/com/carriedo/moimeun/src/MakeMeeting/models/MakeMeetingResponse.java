
package com.carriedo.moimeun.src.MakeMeeting.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class MakeMeetingResponse {

    @Expose
    private int code;
    @Expose
    private Boolean isSuccess;
    @Expose
    private String message;
    @Expose
    private MoimInfo moimInfo;

    public int getCode() {
        return code;
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

        @SerializedName("moim_leader")
        private String moimLeader;
        @SerializedName("moim_link")
        private String moimLink;
        @SerializedName("moim_money")
        private int moimMoney;
        @SerializedName("moim_name")
        private String moimName;
        @SerializedName("moim_place")
        private String moimPlace;
        @SerializedName("moim_pwd")
        private String moimPwd;
        @SerializedName("moim_repeat")
        private String moimRepeat;
        @SerializedName("moim_size")
        private Boolean moimSize;

        public String getMoimLeader() {
            return moimLeader;
        }

        public String getMoimLink() {
            return moimLink;
        }

        public int getMoimMoney() {
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

        public String getMoimRepeat() {
            return moimRepeat;
        }

        public Boolean getMoimSize() {
            return moimSize;
        }

    }


}
