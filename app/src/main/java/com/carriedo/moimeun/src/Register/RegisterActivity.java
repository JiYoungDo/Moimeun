package com.carriedo.moimeun.src.Register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.carriedo.moimeun.R;
import com.carriedo.moimeun.src.Splash.SplashActivity;

public class RegisterActivity extends AppCompatActivity {

    ImageView back_btn;
    EditText id_et;
    TextView id_check_tv;
    EditText pw_et;
    EditText pw_confirm_et;
    TextView pw_confirm_msg_tv;
    EditText birthday_et;
    TextView birthday_msg_tv;
    EditText email_et;
    TextView email_confirm_tv;
    TextView register_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

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
}
