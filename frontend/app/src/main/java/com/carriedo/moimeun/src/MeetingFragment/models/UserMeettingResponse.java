package com.carriedo.moimeun.src.MeetingFragment.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class UserMeettingResponse {

    @SerializedName("results")
    private ArrayList results;

    @SerializedName("count")
    private int count;
    @SerializedName("isSuccess")
    private Boolean isSuccess;
    @SerializedName("message")
    private String message;
    @SerializedName("code")
    private int code;

    public ArrayList getResult() {
        return results;
    }

    public int getCount() {
        return count;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }
}
