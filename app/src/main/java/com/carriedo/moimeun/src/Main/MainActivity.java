package com.carriedo.moimeun.src.Main;

import androidx.annotation.NonNull;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.carriedo.moimeun.BaseActivity;
import com.carriedo.moimeun.R;
import com.carriedo.moimeun.src.CalendarFragment.CalendarFragment;
import com.carriedo.moimeun.src.MakeMeeting.MakeMeetingActivity;
import com.carriedo.moimeun.src.MeetingFragment.MettingFragment;
import com.carriedo.moimeun.src.MyPageFragment.MypageFragment;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends BaseActivity {

    FloatingActionButton floatingActionButton;
    BottomNavigationView bottomNavigationView;

    MettingFragment mettingFragment;
    CalendarFragment calendarFragment;
    MypageFragment mypageFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //fab
        floatingActionButton = findViewById(R.id.main_fb);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MakeMeetingActivity.class);
                startActivity(intent);
                finish();
            }
        });


        //bnv
        bottomNavigationView = findViewById(R.id.main_bnv);


        // fragment
        mettingFragment = new MettingFragment();
        calendarFragment = new CalendarFragment();
        mypageFragment = new MypageFragment();

        // 처음에 띄어줄 뷰 세팅
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_fl, mettingFragment).commitAllowingStateLoss();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.main_menu_my_meeting:
                    {
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.main_fl, mettingFragment).commitAllowingStateLoss();
                        floatingActionButton.setVisibility(View.VISIBLE);
                        return true;
                    }
                    case R.id.main_menu_my_calendar:
                    {
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.main_fl, calendarFragment).commitAllowingStateLoss();

                        floatingActionButton.setVisibility(View.GONE);
                        return true;
                    }
                    case R.id.main_menu_my_mypage:
                    {
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.main_fl, mypageFragment).commitAllowingStateLoss();
                        floatingActionButton.setVisibility(View.GONE);
                        return true;
                    }
                    default:
                        return false;
                }
            }
        });
    }

    public void onChangeFragment(int index){}
    {
//        if(index == 7)
//        {
//            // 7번일 때는 changeprofile로
//            getSupportFragmentManager().beginTransaction().replace(R.id.activity_a_fl,changeFragment).commitAllowingStateLoss();
//            1)  Activity 클래스의 getFragmentManager() 함수를 사용하여 FragmentManager 에 대한 참조를 획득한 다음
//            2) FragmentManager 의 beginTransaction() 함수를 호출하여 FragmentTransaction 을 시작합니다.
//            3) 그런 다음 FragmentTransaction 의 add() 함수를 이용하여 Fragment 를 Activity 의 ViewGroup(FrameLayout)에 추가
//            4) Fragment와 관련된 모든 작업이 완료되면 FragmentTransaction의 commit() 함수를 호출하여 Fragment와 관련된 작업이 완료되었음을 알려줍니다.
//        }

    }


}
