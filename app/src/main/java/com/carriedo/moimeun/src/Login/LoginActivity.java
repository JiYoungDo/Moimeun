package com.carriedo.moimeun.src.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.carriedo.moimeun.BaseActivity;
import com.carriedo.moimeun.R;
import com.carriedo.moimeun.src.Login.interfaces.LoginActivityView;
import com.carriedo.moimeun.src.Main.MainActivity;
import com.carriedo.moimeun.src.Splash.SplashActivity;

public class LoginActivity extends BaseActivity implements LoginActivityView {

    LoginService loginService = new LoginService(this);

    ImageView back_btn;
    EditText id_et;
    EditText pw_et;
    TextView login_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // 뒤로가기
        back_btn = findViewById(R.id.login_iv_back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SplashActivity.class);
                startActivity(intent);
                finish();
            }
        });

        id_et = findViewById(R.id.login_et_id);
        pw_et = findViewById(R.id.login_et_pw);
        login_btn = findViewById(R.id.login_tv_login);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_id, user_pw;
                user_id = id_et.getText().toString();
                user_pw = pw_et.getText().toString();

                // 사용자가 id, pw 값을 입력 했을 때
                if(!user_id.equals("") && !user_pw.equals(""))
                {
                    tryLogin(user_id, user_pw);
                }
                else
                    Toast.makeText(LoginActivity.this,"입력 되지 않은 값이 있습니다.",Toast.LENGTH_SHORT).show();

            }
        });



    }

    private void tryLogin(String id, String pw)
    {
        showProgressDialog();
        loginService.postLogin(id,pw);
    }

    @Override
    public void LoginSuccess(int code) {
        hideProgressDialog();

        // 로그인 성공시 액션
        Toast.makeText(this,"로그인 성공",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }


    // 코드 구문하여 처리리
   @Override
    public void LoginFailure(int code, String message) {
        hideProgressDialog();

        // 로그인 실패시 액션
        Toast.makeText(this,"로그인 실패: "+message,Toast.LENGTH_SHORT).show();
    }
}
