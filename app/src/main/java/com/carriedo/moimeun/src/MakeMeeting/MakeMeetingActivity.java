package com.carriedo.moimeun.src.MakeMeeting;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.carriedo.moimeun.R;
import com.carriedo.moimeun.src.Main.MainActivity;
import com.carriedo.moimeun.src.MakeMeeting.interfaces.MakeMeetingActivityView;
import com.carriedo.moimeun.src.MakeMeeting.models.MakeMeetingResponse;
import com.carriedo.moimeun.src.Register.RegisterActivity;

import java.util.Calendar;

import static com.carriedo.moimeun.ApplicationClass.TAG;
import static com.carriedo.moimeun.ApplicationClass.sSharedPreferences;

public class MakeMeetingActivity extends AppCompatActivity  implements MakeMeetingActivityView {

    MakeMeetingService makeMeetingService = new MakeMeetingService(this);

    ImageView back_btn;
    EditText moim_name_et;
    EditText moim_pw_et;
    TextView moim_start_date_tv;
    DatePicker moim_start_date_dp;
    TextView moim_end_date_tv;
    DatePicker moim_end_date_dp;
    TextView moim_is_repeat_tv;
    RadioGroup moim_s_b_r_grp;
    RadioButton moim_small_rbtn;
    RadioButton moim_big_rbtn;
    Calendar calendar;
    TextView moim_is_late_money_on_tv;
    EditText moim_late_money_tv;

    TextView moim_is_location_on_tv;
    TextView moim_make_link_tv;


    TextView moim_make_tv;


    String str_leader, str_moim_name, str_moim_pw , str_start_date, str_end_date;
    int late_money;
    boolean is_small, is_repeat , is_late_money_checked;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_meeting);


        // 뒤로가기 버튼
        back_btn = findViewById(R.id.make_mt_iv_back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MakeMeetingActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // 모임 이름
        moim_name_et = findViewById(R.id.make_mt_et_name);
        // 모임 비밀 번호
        moim_pw_et = findViewById(R.id.make_mt_et_pw);

        // 모임 반복
        moim_is_repeat_tv = findViewById(R.id.make_mt_tv_is_repeat);
        moim_is_repeat_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!moim_is_repeat_tv.getText().toString().equals("반복 안함"))
                {
                    moim_is_repeat_tv.setBackground(getResources().getDrawable(R.drawable.all_dark_green_roung_bg));
                    moim_is_repeat_tv.setText(getResources().getString(R.string.repeat_not_ok));
                    moim_is_repeat_tv.setTextSize(14);
                    moim_is_repeat_tv.setTextColor(getResources().getColor(R.color.colorConceptWhite));

                    is_repeat = false;
                }
                else
                {
                    moim_is_repeat_tv.setBackground(getResources().getDrawable(R.drawable.darkgreen_line_bg));
                    moim_is_repeat_tv.setText(getResources().getString(R.string.repeat_ok));
                    moim_is_repeat_tv.setTextSize(16);
                    moim_is_repeat_tv.setTextColor(getResources().getColor(R.color.colorConceptDarkGreen));
                    is_repeat = true;
                }
            }
        });


        // RadioButton
        moim_s_b_r_grp = findViewById(R.id.make_mt_rg_sm_bm);
        moim_small_rbtn = findViewById(R.id.make_mt_rb_sm);
        moim_big_rbtn =findViewById(R.id.make_mt_rb_bm);

        moim_small_rbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                is_small = true;
            }
        });

        moim_big_rbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                is_small = false;
            }
        });


        // 벌금 여부
        moim_is_late_money_on_tv = findViewById(R.id.make_mt_et_late_money);
        moim_late_money_tv = findViewById(R.id.make_mt_et_late_money_real);

        moim_is_late_money_on_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(moim_is_late_money_on_tv.getText().toString().equals("지각비 기능 OFF"))
                {
                    moim_is_late_money_on_tv.setBackground(getResources().getDrawable(R.drawable.all_dark_green_roung_bg));
                    moim_is_late_money_on_tv.setText(getResources().getString(R.string.late_money_func_on));
                    moim_is_late_money_on_tv.setTextColor(getResources().getColor(R.color.colorConceptWhite));
                    moim_late_money_tv.setVisibility(View.VISIBLE);
                    moim_late_money_tv.setHint("지각비 입력");
                    is_late_money_checked = true;
                    is_repeat = false;
                }
                else
                {
                    moim_is_late_money_on_tv.setBackground(getResources().getDrawable(R.drawable.darkgreen_line_bg));
                    moim_is_late_money_on_tv.setText(getResources().getString(R.string.late_money_func_off));
                    moim_is_late_money_on_tv.setTextColor(getResources().getColor(R.color.colorConceptDarkGreen));
                    moim_late_money_tv.setVisibility(View.GONE);
                    is_late_money_checked = false;
                    is_repeat = true;
                }
            }
        });




        moim_start_date_tv = findViewById(R.id.make_mt_et_start_date);
        moim_start_date_dp = findViewById(R.id.make_mt_datepicker_start);

        moim_end_date_tv = findViewById(R.id.make_mt_et_end_date);
        moim_end_date_dp = findViewById(R.id.make_mt_datepicker_end);

        // 모임 시작일
        moim_start_date_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moim_start_date_dp.callOnClick();
                calendar = Calendar.getInstance();
                int year = calendar.get(calendar.YEAR);
                int month = calendar.get(calendar.MONTH);
                int dayOfMonth = calendar.get(calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(MakeMeetingActivity.this, listener_start, year, month, dayOfMonth);
                dialog.show();
            }
        });

        // 모임 종료일
        moim_end_date_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moim_end_date_dp.callOnClick();
                calendar = Calendar.getInstance();
                int year = calendar.get(calendar.YEAR);
                int month = calendar.get(calendar.MONTH);
                int dayOfMonth = calendar.get(calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(MakeMeetingActivity.this, listener_end, year, month, dayOfMonth);
                dialog.show();
            }
        });



        // 생성 버튼
        moim_make_tv = findViewById(R.id.make_mt_tv_create_meeting);
        moim_make_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // [!] 검증
                str_moim_name = moim_name_et.getText().toString();
                str_moim_pw = moim_pw_et.getText().toString();
                sSharedPreferences = getApplicationContext().getSharedPreferences(TAG,MODE_PRIVATE);
                str_leader = sSharedPreferences.getString("user_id","");
                Log.d("str_leader_값 확인",str_leader);

                if(is_late_money_checked) {
                    late_money = Integer.valueOf(moim_late_money_tv.getText().toString()); }
                else {
                    late_money = 0;
                }

                Log.d("값들 확인", str_end_date + late_money + str_moim_name + str_moim_pw+str_start_date );
                Log.d("값들 확인", Boolean.toString(is_repeat)+ Boolean.toString(is_small));
                TryMakeMeeting(str_end_date,is_repeat,str_leader,"temp",late_money,str_moim_name,"",str_moim_pw,is_small,str_start_date);
            }
        });

    }

    private DatePickerDialog.OnDateSetListener listener_start = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            int month_new = month+1;
            moim_start_date_tv.setText(year+"-"+month_new+"-"+dayOfMonth);
            str_start_date = year+"-"+month_new+"-"+dayOfMonth;
        }
    };

    private DatePickerDialog.OnDateSetListener listener_end = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            int month_new = month+1;
            moim_end_date_tv.setText(year+"-"+month_new+"-"+dayOfMonth);
            str_end_date = year+"-"+month_new+"-"+dayOfMonth;
        }
    };


    private void TryMakeMeeting(String moimEndDate, Boolean moimIsRepeat, String moimLeader, String moimLink, int moimMoney, String moimName, String moimPlace, String moimPwd, Boolean moimSize, String moimStartDate)
    {
        makeMeetingService.postMakeMeeting(moimEndDate,moimIsRepeat,moimLeader,moimLink,moimMoney,moimName,moimPlace,moimPwd,moimSize,moimStartDate);
    }

    @Override
    public void MakeMeetingSuccess(MakeMeetingResponse makeMeetingResponse) {
        int score = makeMeetingResponse.getCode();
        Toast.makeText(this,"모임 생성 성공 "+ makeMeetingResponse.getMessage() +" "+ Integer.toString(score), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void MakeMeetingFailure(String message) {
        Toast.makeText(this,"모임 생성 성공"+message, Toast.LENGTH_SHORT).show();
    }
}
