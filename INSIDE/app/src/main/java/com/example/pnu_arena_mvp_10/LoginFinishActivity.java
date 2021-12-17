package com.example.pnu_arena_mvp_10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.LogoutResponseCallback;

public class LoginFinishActivity extends AppCompatActivity {

    private String strNick, strProfileImg, strBd, strEmail;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_finish);

        Intent intent = getIntent();
        strNick = intent.getStringExtra("name");
        strEmail = intent.getStringExtra("Email");
        strProfileImg = intent.getStringExtra("profileImg");
        strBd = intent.getStringExtra("birthday");

        TextView tv_nick = findViewById(R.id.tv_id);
        TextView tv_email = findViewById(R.id.tv_email);
        TextView tv_bd = findViewById(R.id.tv_bd);
        ImageView iv_profile = findViewById(R.id.iv_profile);
        Button btn_go_mypage = findViewById(R.id.btn_go_mypage);

        // 닉네임 세팅
        tv_nick.setText(strNick);

        // 이메일 세팅
        tv_email.setText(strEmail);

        // 생일 세팅
        tv_bd.setText(strBd);

        // 프로필 이미지 사진 세팅
        Glide.with(this).load(strProfileImg).into(iv_profile);

        btn_go_mypage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btn_logout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserManagement.getInstance().requestLogout(new LogoutResponseCallback() {
                    @Override
                    public void onCompleteLogout() {
                        // 로그아웃 성공 시 수행하는 지점
                        finish(); // 현재 액티비티 종료
                    }
                });
            }
        });
    }
}