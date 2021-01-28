package com.carriedo.moimeun.src.Main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.carriedo.moimeun.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MeetingAdapter meetingAdapter;
    RecyclerView meeting_recyclerview;
    ArrayList meeting_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        meeting_recyclerview = findViewById(R.id.main_rv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
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
    }
}
