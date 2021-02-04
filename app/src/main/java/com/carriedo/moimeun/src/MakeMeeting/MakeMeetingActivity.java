package com.carriedo.moimeun.src.MakeMeeting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.carriedo.moimeun.R;
import com.carriedo.moimeun.src.Main.MainActivity;

public class MakeMeetingActivity extends AppCompatActivity {

    ImageView back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_meeting);


        back_btn = findViewById(R.id.make_mt_iv_back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MakeMeetingActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
