package com.example.roomdatabaseexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Insert;
import androidx.room.Room;

import android.content.Intent;
import android.media.ExifInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText etName;
    private EditText etAge;
    private EditText etPhoneNumber;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. 변수 초기화
        etName = findViewById(R.id.et_name);
        etAge = findViewById(R.id.et_age);
        etPhoneNumber = findViewById(R.id.et_phonenumber);
        button = findViewById(R.id.button);

        // 2. Button Click 시 EditText 정보를 DisplayActivity로 이동시킨다
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 2-1. EditText 내용을 String으로 변환
                String strName = etName.getText().toString();
                String strAge = etAge.getText().toString();
                String strPhoneNumber = etPhoneNumber.getText().toString();

                // 2-2. String으로 변환한 내용을 DisplayActivity를 생성한 후, 이동시키키
                Intent intent = new Intent(getApplicationContext(), DisplayActivity.class);
                intent.putExtra("name", strName);
                intent.putExtra("age", strAge);
                intent.putExtra("phone", strPhoneNumber);

                startActivity(intent);
            }
        });
    }
}