package com.carriedo.moimeun.src.LoginActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.carriedo.moimeun.BaseActivity;
import com.carriedo.moimeun.R;
import com.carriedo.moimeun.src.LoginActivity.interfaces.LoginActivityView;
import com.carriedo.moimeun.src.LoginActivity.models.LoginResponse;
import com.carriedo.moimeun.src.MainActivity.MainActivity;
import com.carriedo.moimeun.src.SplashActivity.SplashActivity;

import static com.carriedo.moimeun.ApplicationClass.TAG;
import static com.carriedo.moimeun.ApplicationClass.sSharedPreferences;


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

        // 자동 로그인 처리하기
        // sharedPreferences에 아무런 정보도 없으므로 값을 저장할 키들을 생성한다.
        // getString의 첫 번째 인자는 저장될 키, 두 번째 인자는 값이다.
        // 처음에는 값이 없어서 키값은 원하는 것으로 하고, 값을 null을 준다.
        String login_auto_id, login_auto_pw;
        sSharedPreferences = getSharedPreferences(TAG,MODE_PRIVATE);
        login_auto_id = sSharedPreferences.getString("user_id","null");
        login_auto_pw = sSharedPreferences.getString("user_pw","null");

        if(!login_auto_id.equals("null")  && !login_auto_pw.equals("null"))
        {
            Toast.makeText(LoginActivity.this, login_auto_id+ "님 자동로그인 입니다.",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }


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
    public void LoginSuccess(LoginResponse loginResponse) {
        hideProgressDialog();

        String id = loginResponse.getCustomerInfo().getCustomerId();
        String pw = loginResponse.getCustomerInfo().getCustomerPassword();


        // 로그인 성공시 액션
        Toast.makeText(this,"로그인 성공",Toast.LENGTH_SHORT).show();
        // sharedPreference에 저장
        sSharedPreferences = getSharedPreferences(TAG,MODE_PRIVATE);
        SharedPreferences.Editor editor = sSharedPreferences.edit();
        editor.putString("user_id",id);
        editor.putString("user_pw",pw);
        editor.commit();

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
