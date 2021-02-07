package com.carriedo.moimeun.src.Register;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.carriedo.moimeun.BaseActivity;
import com.carriedo.moimeun.R;
import com.carriedo.moimeun.src.Register.interfaces.RegisterActivityView;
import com.carriedo.moimeun.src.Splash.SplashActivity;

import java.util.Calendar;

public class RegisterActivity extends BaseActivity implements RegisterActivityView {

    RegisterService registerService = new RegisterService(this);

    // res/layout
    ImageView back_btn;
    EditText id_et;
    TextView id_check_tv;
    TextView id_confirm_msg_tv;
    EditText pw_et;
    EditText pw_confirm_et;
    TextView pw_confirm_msg_tv;
    EditText name_et;
    TextView birthday_tv;
    EditText email_et;
    TextView email_confirm_tv;
    TextView register_tv;
    DatePicker datePicker;
    Calendar calendar;

    // 알람 메세지 값
    String pw_alert_msg, birth_alert_msg, id_alert_msg_ok, id_alert_msg_not_ok, empty_msg;

    // 사용자 입력 값들
    String user_id, user_pw, user_pw_confirm, user_birth, user_email , user_name;

    // boolean
    boolean Is_Id_Ok = false;
    boolean Is_Pw_Ok = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // 알람 메세지 String  값에서 가져 와 놓기
        pw_alert_msg = getResources().getString(R.string.pw_msg);
        birth_alert_msg = getResources().getString(R.string.birth_msg);
        empty_msg = getResources().getString(R.string.no_msg);


        // 뒤로가기
        back_btn = findViewById(R.id.register_iv_back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, SplashActivity.class);
                startActivity(intent);
                finish();
            }
        });


        id_et = findViewById(R.id.register_et_id);
        id_check_tv = findViewById(R.id.register_btn_id_check);
        id_confirm_msg_tv = findViewById(R.id.register_tv_id_confirm_msg);
        id_confirm_msg_tv.setText("");

        // 아이디 중복 체크
        id_check_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Is_Id_Ok = false;


                // 사용자가 입력한 아이디 값 가져오기
                user_id = id_et.getText().toString();
                // Log.d("user_id",user_id);


                if(user_id.equals(""))
                {
                    id_confirm_msg_tv.setText(empty_msg);
                }
                else
                {
                    Log.d("user_id",user_id);
                    tryIdCheck(user_id);
                }

            }
        });



        pw_et= findViewById(R.id.register_et_pw);
        pw_confirm_msg_tv = findViewById(R.id.register_tv_pw_confirm_msg);
        pw_confirm_msg_tv.setText("");

        pw_confirm_et = findViewById(R.id.register_et_pw_confirm);
        pw_confirm_et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                user_pw = pw_et.getText().toString();

                if(!pw_confirm_et.getText().toString().equals(user_pw))
                {
                    pw_confirm_msg_tv.setText(pw_alert_msg);
                }else
                {
                    pw_confirm_msg_tv.setText("");
                    Is_Pw_Ok = true;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(pw_et.getText().toString().equals(pw_confirm_et.getText().toString()))
                {
                    user_pw = pw_confirm_et.getText().toString();
                }
                else
                {
                    Is_Pw_Ok = false;
                }
            }
        });

        // 이름
        name_et = findViewById(R.id.register_et_name);


        // 생일 - 데이트 피커 - 현재 날짜
        birthday_tv = findViewById(R.id.register_tv_birthday);
        datePicker = findViewById(R.id.register_date_picker);

        birthday_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePicker.callOnClick();
                calendar = Calendar.getInstance();
                int year = calendar.get(calendar.YEAR);
                int month = calendar.get(calendar.MONTH);
                int dayOfMonth = calendar.get(calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(RegisterActivity.this, listener, year, month, dayOfMonth);
                dialog.show();
            }
        });



        // [!!!] 검증 절차 필요
        email_et = findViewById(R.id.register_et_email);
        email_confirm_tv =findViewById(R.id.register_tv_email_confirm_btn);



        register_tv = findViewById(R.id.register_tv_register);
        register_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Is_Id_Ok && Is_Pw_Ok)
                {
                    user_name = name_et.getText().toString();
                    tryPostRegister(user_birth,email_et.getText().toString(),user_id,"1",user_name,user_pw,"1");
                }
            }
        });

    }

    private DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            int month_new = month+1;
            birthday_tv.setText(year+"-"+month_new+"-"+dayOfMonth);
            user_birth = year+"-"+month_new+"-"+dayOfMonth;
        }
    };

    private void tryPostRegister(String mCustomerBirth, String mCustomerEmail, String mCustomerId, String mCustomerLevel, String mCustomerName,String mCustomerPassword, String mCustomerPenaltyPoint)
    {
        showProgressDialog();
        registerService.postRegister(mCustomerBirth,mCustomerEmail,mCustomerId,mCustomerLevel,mCustomerName,mCustomerPassword,mCustomerPenaltyPoint);
    }

    private void tryIdCheck(String id)
    {
        showProgressDialog();
        registerService.getIdCheck(id);
    }


    // tryPostRegister 성공시
    @Override
    public void RegisterSuccess(String message) {
        hideProgressDialog();
        Log.d("회원 가입 성공", message);
    }

    // tryPostRegister 실패시(null 값이거나, 통신 실패)
    @Override
    public void RegisterFailure(String message) {
        hideProgressDialog();
        Log.d("회원 가입 실패", message);
    }

    // tryIdCheck 성공시
    @Override
    public void IdCheckSuccess(String message) {
        hideProgressDialog();
        Log.d("아이디 중복 검사 성공", message);

        if(message.equals("성공")) {
            id_alert_msg_ok = getResources().getString(R.string.id_msg_ok);
            id_confirm_msg_tv.setText(id_alert_msg_not_ok);
        }else
        {
            id_alert_msg_not_ok = getResources().getString(R.string.id_msg_not_ok);
            id_confirm_msg_tv.setText(id_alert_msg_ok);
            Is_Id_Ok = true;
        }
    }

    // tryIdCheck 실패시 (null 값이거나, 통신 실패)
    @Override
    public void IdCheckFailure(String message) {
        hideProgressDialog();
        Log.d("아이디 중복 검사 실패", message);
    }
}
