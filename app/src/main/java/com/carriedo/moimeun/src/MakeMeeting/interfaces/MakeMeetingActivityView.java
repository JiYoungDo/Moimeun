package com.carriedo.moimeun.src.MakeMeeting.interfaces;

import com.carriedo.moimeun.src.Login.models.LoginResponse;
import com.carriedo.moimeun.src.MakeMeeting.models.MakeMeetingResponse;

public interface MakeMeetingActivityView {

    void MakeMeetingSuccess(MakeMeetingResponse makeMeetingResponse);
    void MakeMeetingFailure(int code, String message);

}
