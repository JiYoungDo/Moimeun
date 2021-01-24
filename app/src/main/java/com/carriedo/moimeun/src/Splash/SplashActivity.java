package com.carriedo.moimeun.src.Splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.carriedo.moimeun.R;
import com.carriedo.moimeun.src.Login.LoginActivity;
import com.carriedo.moimeun.src.Main.MainActivity;
import com.carriedo.moimeun.src.Register.RegisterActivity;

public class SplashActivity extends AppCompatActivity {

    TextView login_btn;
    TextView register_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        login_btn = findViewById(R.id.login_tv_login);
        register_btn = findViewById(R.id.login_tv_register);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SplashActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
