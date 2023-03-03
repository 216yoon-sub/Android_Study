package com.example.comebackexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity2 extends AppCompatActivity {
    private EditText et_comeback2;
    private Button btn_close2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub2);

        et_comeback2 = findViewById(R.id.et_comeback2);
        btn_close2 = findViewById(R.id.btn_close2);

        btn_close2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("comeback2", et_comeback2.getText().toString()); // 입력폼에 적은 값 담아주기
                setResult(RESULT_OK, intent); // 결과 값 설정
                finish(); // 현재 액티비티 종료
            }
        });


    }
}
