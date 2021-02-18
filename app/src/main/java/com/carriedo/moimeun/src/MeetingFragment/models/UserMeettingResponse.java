package com.carriedo.moimeun.src.MeetingFragment.models;

import com.carriedo.moimeun.src.MakeMeeting.models.MakeMeetingResponse;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class UserMeettingResponse {

    @SerializedName("result")
    private ArrayList result;
    @SerializedName("isSuccess")
    private Boolean isSuccess;
    @SerializedName("message")
    private String message;
    @SerializedName("code")
    private int code;

    public ArrayList getResult() {
        return result;
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
