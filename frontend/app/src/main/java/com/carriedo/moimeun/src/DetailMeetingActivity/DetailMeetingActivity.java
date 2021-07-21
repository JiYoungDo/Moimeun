package com.carriedo.moimeun.src.DetailMeetingActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.carriedo.moimeun.R;
import com.carriedo.moimeun.src.MainActivity.MainActivity;

public class DetailMeetingActivity extends AppCompatActivity {

    ImageView open_drawer_iv;
    ImageView back_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_meeting);

        back_btn = findViewById(R.id.detail_meeting_iv_back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailMeetingActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        open_drawer_iv = findViewById(R.id.detail_meeting_iv_menu) ;
        open_drawer_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.detail_meeting_drawer) ;
                if (!drawer.isDrawerOpen(Gravity.RIGHT)) {
                    drawer.openDrawer(Gravity.RIGHT) ;
                }
                if (drawer.isDrawerOpen(Gravity.RIGHT)) {
                    drawer.closeDrawer(Gravity.RIGHT) ;
                }
            }
        });



    }

}