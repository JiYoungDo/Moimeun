package com.carriedo.moimeun.src.MeetingFragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.carriedo.moimeun.R;
import com.carriedo.moimeun.src.Main.MainActivity;

import java.util.ArrayList;

public class MettingFragment extends Fragment {

    ViewGroup viewGroup;
    MainActivity mainActivity;

    private MeetingAdapter meetingAdapter;
    RecyclerView meeting_recyclerview;
    ArrayList meeting_list;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) getActivity();
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

        meeting_list = new ArrayList<>();

        // Dummy
        MeetingItem meetingItem = new MeetingItem("소융과 모여라","87");
        MeetingItem meetingItem_1 = new MeetingItem("모이믄 앱 런칭 모임","8");

        meeting_list.add(meetingItem);
        meeting_list.add(meetingItem_1);


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
}
