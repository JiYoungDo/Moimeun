package com.carriedo.moimeun.src.MeetingFragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.carriedo.moimeun.R;
import com.carriedo.moimeun.src.MainActivity.MainActivity;
import com.carriedo.moimeun.src.MakeMeetingActivity.models.MakeMeetingResponse;
import com.carriedo.moimeun.src.MeetingFragment.interfaces.MeetingListActivityView;
import com.carriedo.moimeun.src.MeetingFragment.models.UserMeettingResponse;

import java.util.ArrayList;

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
    ArrayList meeting_link_list;

    MeetingListService meetingListService = new MeetingListService(this);


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


        TryGetMeetingList(str_user_id);

        meeting_list = new ArrayList<>();

        // [!] Dummy - meeting_list에 받아온 값을 넣어햐 함.
        // meeting_list 에서 값을 받아오는건 모임들 링크
        // 모임들의 정보는 해당 링크를 get 하여 얻어와야 한다.
        // MeetingItem meetingItem = new MeetingItem("소융과 모여라","87");
        //  MeetingItem meetingItem_1 = new MeetingItem("모이믄 앱 런칭 모임","8");

        // meeting_list.add(meetingItem);
        // meeting_list.add(meetingItem_1);


        // 어댑터
        meetingAdapter = new MeetingAdapter(meeting_list);
        meeting_recyclerview.setAdapter(meetingAdapter);
        meetingAdapter.setOnItemClickListener(new MeetingAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {

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

        meeting_link_list = userMeettingResponse.getResult();

        int size;

        if (meeting_link_list == null) { size = 0; }
        else {size = meeting_link_list.size();}

        for(int i = 0; i < size; i++)
        {
            Log.d("미팅 링크",meeting_link_list.get(i).toString());
            TryGetMoimInfo(meeting_link_list.get(i).toString());
        }


    }

    @Override
    public void MeetingListFailure(String message) {
        Log.d("MeetingListFailure", message);
    }

    @Override
    public void GetMoimInfoSuccess(MakeMeetingResponse makeMeetingResponse) {

        MeetingItem meetingItem = new MeetingItem(makeMeetingResponse.getMoimInfo().getMoimName().toString(),"50");
        meeting_list.add(meetingItem);

        meetingAdapter.notifyDataSetChanged();

    }

    @Override
    public void GetMoimInfoFailure(String message) {
        Log.d("GetMoimInfoFailure", message);
    }
}
