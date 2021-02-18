package com.carriedo.moimeun.src.MeetingFragment.interfaces;

import com.carriedo.moimeun.src.MakeMeeting.models.MakeMeetingResponse;
import com.carriedo.moimeun.src.MeetingFragment.models.UserMeettingResponse;


public interface MeetingListActivityView {

    void MeetingListSuccess(UserMeettingResponse userMeettingResponse);
    void MeetingListFailure(String message);

    void GetMoimInfoSuccess(MakeMeetingResponse makeMeetingResponse);
    void GetMoimInfoFailure(String message);

}
