
package com.carriedo.moimeun.src.MakeMeeting.models;

import com.google.gson.annotations.SerializedName;

public class MakeMeetingBody {

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

    public String getMoimRepeat() {
        return moimRepeat;
    }

    public Boolean getMoimSize() {
        return moimSize;
    }

    public MakeMeetingBody(String moimLeader, String moimLink, Long moimMoney, String moimName, String moimPlace, String moimPwd, String moimRepeat, Boolean moimSize) {
        this.moimLeader = moimLeader;
        this.moimLink = moimLink;
        this.moimMoney = moimMoney;
        this.moimName = moimName;
        this.moimPlace = moimPlace;
        this.moimPwd = moimPwd;
        this.moimRepeat = moimRepeat;
        this.moimSize = moimSize;
    }
}
