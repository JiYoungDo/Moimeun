
package com.carriedo.moimeun.src.MakeMeetingActivity.models;

import com.google.gson.annotations.SerializedName;

public class MakeMeetingBody {

    @SerializedName("moim_endDate")
    private String moimEndDate;
    @SerializedName("moim_isRepeat")
    private Boolean moimIsRepeat;
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

    public Boolean getMoimSize() {
        return moimSize;
    }

    public String getMoimStartDate() {
        return moimStartDate;
    }

    public MakeMeetingBody(String moimEndDate, Boolean moimIsRepeat, String moimLeader, String moimLink,
                           int moimMoney, String moimName, String moimPlace, String moimPwd, Boolean moimSize, String moimStartDate) {
        this.moimEndDate = moimEndDate;
        this.moimIsRepeat = moimIsRepeat;
        this.moimLeader = moimLeader;
        this.moimLink = moimLink;
        this.moimMoney = moimMoney;
        this.moimName = moimName;
        this.moimPlace = moimPlace;
        this.moimPwd = moimPwd;
        this.moimSize = moimSize;
        this.moimStartDate = moimStartDate;
    }
}
