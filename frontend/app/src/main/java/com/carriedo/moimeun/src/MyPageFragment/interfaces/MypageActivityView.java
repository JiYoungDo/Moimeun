package com.carriedo.moimeun.src.MyPageFragment.interfaces;

import com.carriedo.moimeun.src.RegisterActivity.models.IdCheckResponse;

public interface MypageActivityView {

    void MypageSuccess(IdCheckResponse idCheckResponse);
    void MypageFailure(String message);

    void UserDeleteSuccess(IdCheckResponse idCheckResponse);
    void UserDeleteFailure(String message);

}
