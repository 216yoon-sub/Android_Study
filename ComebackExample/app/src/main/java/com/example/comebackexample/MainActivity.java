package com.example.comebackexample;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tv_comeback;
    private Button btn_go;

    //private static final int REQUEST_CODE = 216; // 상수 값을 선언 *상수(항상 같은 수 + 변하지않을 수)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_comeback = findViewById(R.id.tv_comeback);
        btn_go = findViewById(R.id.btn_go);

        //launcher 선언 (ActivityResultLauncher 선언)
        ActivityResultLauncher<Intent> launcher = registerForActivityResult (
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == RESULT_OK) {
                        Toast.makeText(getApplicationContext(), "수신 성공",Toast.LENGTH_SHORT).show();
                        String resultText = result.getData().getStringExtra("comeback");
                        tv_comeback.setText(resultText);
                    } else {
                        Toast.makeText(getApplicationContext(), "수신 실패",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        );

        btn_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 2. laucher로 intent launch
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                launcher.launch(intent);
            }
        });

    }
}