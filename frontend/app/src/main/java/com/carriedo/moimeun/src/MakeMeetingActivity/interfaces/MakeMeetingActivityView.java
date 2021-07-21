package com.carriedo.moimeun.src.MakeMeetingActivity.interfaces;

import com.carriedo.moimeun.src.MakeMeetingActivity.models.MakeMeetingResponse;

public interface MakeMeetingActivityView {

    void MakeMeetingSuccess(MakeMeetingResponse makeMeetingResponse);
    void MakeMeetingFailure(String message);

}
