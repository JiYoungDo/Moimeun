package com.carriedo.moimeun.src.MyPageFragment.interfaces;

import com.carriedo.moimeun.src.Register.models.IdCheckResponse;

public interface MypageActivityView {

    void MypageSuccess(IdCheckResponse idCheckResponse);
    void MypageFailure(String message);

}
