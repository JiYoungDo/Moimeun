package com.carriedo.moimeun.src.Register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.carriedo.moimeun.BaseActivity;
import com.carriedo.moimeun.R;
import com.carriedo.moimeun.src.Register.interfaces.RegisterActivityView;
import com.carriedo.moimeun.src.Splash.SplashActivity;

public class RegisterActivity extends BaseActivity implements RegisterActivityView {

    final RegisterService registerService = new RegisterService(this);

    // res/layout
    ImageView back_btn;
    EditText id_et;
    TextView id_check_tv;
    TextView id_confirm_msg_tv;
    EditText pw_et;
    EditText pw_confirm_et;
    TextView pw_confirm_msg_tv;
    EditText birthday_et;
    TextView birthday_msg_tv;
    EditText email_et;
    TextView email_confirm_tv;
    TextView register_tv;

    // 알람 메세지 값
    String pw_alert_msg, birth_alert_msg, id_alert_msg_ok, id_alert_msg_not_ok, empty_msg;

    // 사용자 입력 값들
    String user_id, user_pw, user_pw_confirm, user_birth, user_email;

    // boolean
    boolean Is_Id_Ok = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // 알람 메세지 String  값에서 가져 와 놓기
        pw_alert_msg = getResources().getString(R.string.pw_msg);
        birth_alert_msg = getResources().getString(R.string.birth_msg);
        id_alert_msg_ok = getResources().getString(R.string.id_msg_ok);
        id_alert_msg_not_ok = getResources().getString(R.string.id_msg_not_ok);
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

                // 클릭 배경 전환
                id_check_tv.setBackground(getResources().getDrawable(R.drawable.darkgreen_bg_line));
                id_check_tv.setBackground(getResources().getDrawable(R.drawable.white_line_fill_darkgreen));

                // 사용자가 입력한 아이디 값 가져오기
                user_id = id_et.getText().toString();


                if(user_id.equals(""))
                {
                    id_confirm_msg_tv.setText(empty_msg);
                }
                else
                {
                    tryIdCheck(user_id);
                }

            }
        });



        pw_et= findViewById(R.id.register_et_pw);
        pw_confirm_et = findViewById(R.id.register_et_pw_confirm);
        pw_confirm_msg_tv = findViewById(R.id.register_tv_pw_confirm_msg);
        pw_confirm_msg_tv.setText("");

        birthday_et = findViewById(R.id.register_et_birthday);
        birthday_msg_tv = findViewById(R.id.register_tv_birthday_confirm_msg);
        birthday_msg_tv.setText("");

        email_et = findViewById(R.id.register_et_email);
        email_confirm_tv =findViewById(R.id.register_tv_email_confirm_btn);

        register_tv = findViewById(R.id.register_tv_register);

    }

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

    }

    // tryPostRegister 실패시(null 값이거나, 통신 실패)
    @Override
    public void RegisterFailure(String message) {

    }

    // tryIdCheck 성공시
    @Override
    public void IdCheckSuccess(String message) {

        Log.d("아이디 중복 검사 성공", message);

        if(message.equals("성공")) {
            id_alert_msg_ok = getResources().getString(R.string.id_msg_ok);
            id_confirm_msg_tv.setText(id_alert_msg_ok);
            Is_Id_Ok = true;
        }else
        {
            id_alert_msg_not_ok = getResources().getString(R.string.id_msg_not_ok);
            id_confirm_msg_tv.setText(id_alert_msg_not_ok);
        }
    }

    // tryIdCheck 실패시 (null 값이거나, 통신 실패)
    @Override
    public void IdCheckFailure(String message) {

        Log.d("아이디 중복 검사 실패", message);
    }
}