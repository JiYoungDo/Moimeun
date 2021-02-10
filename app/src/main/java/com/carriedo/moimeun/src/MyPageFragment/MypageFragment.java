package com.carriedo.moimeun.src.MyPageFragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.carriedo.moimeun.R;
import com.carriedo.moimeun.src.Main.MainActivity;
import com.carriedo.moimeun.src.MyPageFragment.interfaces.MypageActivityView;
import com.carriedo.moimeun.src.Register.models.IdCheckResponse;

import static android.content.Context.MODE_PRIVATE;
import static com.carriedo.moimeun.ApplicationClass.TAG;
import static com.carriedo.moimeun.ApplicationClass.sSharedPreferences;

public class MypageFragment extends Fragment implements MypageActivityView {

    ViewGroup viewGroup;
    MainActivity mainActivity;

    TextView profile_name_tv;
    TextView profile_id_tv;
    ImageView profile_level_iv;

    TextView total_meeting_count_tv;
    TextView total_meeting_late_count_tv;


    // sharedpreference에서 읽어 올 아이디를 담을 값
    String user_id;


    MypageService mypageService = new MypageService(this);

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) getActivity();

        // sharedpreference 에 저장되어 있는
        sSharedPreferences = context.getSharedPreferences(TAG,MODE_PRIVATE);
       user_id = sSharedPreferences.getString("user_id","");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mainActivity =null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_mypage, container, false);
        profile_name_tv = viewGroup.findViewById(R.id.mypage_tv_profile_name);
        profile_id_tv = viewGroup.findViewById(R.id.mypage_tv_id);
        profile_level_iv = viewGroup.findViewById(R.id.mypage_iv_level);

        total_meeting_count_tv = viewGroup.findViewById(R.id.mypage_fm_tv_total_meeting_count_num);
        total_meeting_late_count_tv = viewGroup.findViewById(R.id.mypage_fm_tv_total_meeting_late_count_num);

        tryGetMypageInfo(user_id);

        return viewGroup;
    }


    private void tryGetMypageInfo(String user_id)
    {
        mypageService.getMypage(user_id);
    }


    @Override
    public void MypageSuccess(IdCheckResponse idCheckResponse) {

        profile_name_tv.setText(idCheckResponse.getCustomerInfo().getmCustomerName());
        profile_id_tv.setText(idCheckResponse.getCustomerInfo().getmCustomerId());

        int level = idCheckResponse.getCustomerInfo().getmCustomerLevel();
        Log.d("출력 확인", Integer.toString(level)); // 형변환 (int to string)

        if(level ==1) {
            profile_level_iv.setImageDrawable(getResources().getDrawable(R.drawable.lv_iron));
        }else if(level ==2) {
            profile_level_iv.setImageDrawable(getResources().getDrawable(R.drawable.lv_bronze));
        }else if(level ==3) {
            profile_level_iv.setImageDrawable(getResources().getDrawable(R.drawable.lv_silver));
        }else if(level ==4) {
            profile_level_iv.setImageDrawable(getResources().getDrawable(R.drawable.lv_gold));
        }else if(level ==5) {
            profile_level_iv.setImageDrawable(getResources().getDrawable(R.drawable.lv_platinum));
        }else {
            profile_level_iv.setImageDrawable(getResources().getDrawable(R.drawable.lv_dia));
        }

        // [!] 누적 필요
        total_meeting_count_tv.setText("3");

        int late_count = idCheckResponse.getCustomerInfo().getmCustomerPenalty();
        Log.d("출력 확인", Integer.toString(late_count));
        String late_count_str =Integer.toString(late_count);
        total_meeting_late_count_tv.setText(late_count_str);
    }

    @Override
    public void MypageFailure(String message) {
        Log.d("통신 실패",message);
    }


}
