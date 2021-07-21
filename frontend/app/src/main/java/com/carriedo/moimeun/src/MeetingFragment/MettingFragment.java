package com.carriedo.moimeun.src.MeetingFragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.carriedo.moimeun.R;
import com.carriedo.moimeun.src.DetailMeetingActivity.DetailMeetingActivity;
import com.carriedo.moimeun.src.MainActivity.MainActivity;
import com.carriedo.moimeun.src.MakeMeetingActivity.models.MakeMeetingResponse;
import com.carriedo.moimeun.src.MeetingFragment.interfaces.MeetingListActivityView;
import com.carriedo.moimeun.src.MeetingFragment.models.UserMeettingResponse;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;
import static com.carriedo.moimeun.ApplicationClass.TAG;
import static com.carriedo.moimeun.ApplicationClass.sSharedPreferences;

public class MettingFragment extends Fragment implements MeetingListActivityView {

    ViewGroup viewGroup;
    MainActivity mainActivity;

    private MeetingAdapter meetingAdapter;
    RecyclerView meeting_recyclerview;
    ArrayList meeting_list;

    String str_user_id;

    MeetingListService meetingListService = new MeetingListService(this);

    EditText moim_link_et;
    EditText moim_link_pw_et;
    TextView moim_join_btn_tv;



    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) getActivity();

        // sharedpreference 에 저장되어 있는
        sSharedPreferences = context.getSharedPreferences(TAG,MODE_PRIVATE);
        str_user_id = sSharedPreferences.getString("user_id","");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mainActivity =null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_meeting, container, false);

        meeting_recyclerview = viewGroup.findViewById(R.id.meeting_fm_rv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mainActivity,LinearLayoutManager.VERTICAL,false);
        meeting_recyclerview.setLayoutManager(linearLayoutManager);

        moim_link_et = viewGroup.findViewById(R.id.meeting_fm_tv_join_meeting);
        moim_join_btn_tv = viewGroup.findViewById(R.id.meeting_fm_btn_join_meeting);
        moim_link_pw_et = viewGroup.findViewById(R.id.meeting_fm_tv_join_meeting_pw);


        Log.d("미팅 프래그먼트", str_user_id);
        TryGetMeetingList(str_user_id);

        meeting_list = new ArrayList<String>();

        // 어댑터
        meetingAdapter = new MeetingAdapter(meeting_list);
        meeting_recyclerview.setAdapter(meetingAdapter);
        meetingAdapter.setOnItemClickListener(new MeetingAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                // 해당 모임 조회
                Intent intent = new Intent(getContext(), DetailMeetingActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
        meetingAdapter.notifyDataSetChanged();

        return viewGroup;
    }


    private void TryGetMeetingList(String user_id)
    {
        meetingListService.getMeetingList(user_id);
    }

    private void TryGetMoimInfo(String moim_link)
    {
        meetingListService.getMoimInfo(moim_link);
    }



    @Override
    public void MeetingListSuccess(UserMeettingResponse userMeettingResponse) {

        int count = userMeettingResponse.getCount();
        Log.d("111_count", String.valueOf(count));

        for(int i = 0; i < count; i++ )
        {
            String temp_link = (String) userMeettingResponse.getResult().get(i);
            TryGetMoimInfo(temp_link);
        }

    }

    @Override
    public void MeetingListFailure(String message) {
        Log.d("MeetingListFailure", message);
    }

    @Override
    public void GetMoimInfoSuccess(MakeMeetingResponse makeMeetingResponse) {

        // [!] meetingResponse.get Count API 아직 안 나옴.
        MeetingItem meetingItem = new MeetingItem(makeMeetingResponse.getMoimInfo().getMoimName(), String.valueOf(makeMeetingResponse.getCount()));
        meeting_list.add(meetingItem);

        meetingAdapter.notifyDataSetChanged();

    }

    @Override
    public void GetMoimInfoFailure(String message) {
        Log.d("GetMoimInfoFailure", message);
    }
}
