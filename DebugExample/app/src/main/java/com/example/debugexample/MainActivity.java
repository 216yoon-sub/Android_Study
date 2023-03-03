package com.example.debugexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String MAMAMOO = "Where Are We Now";
        Log.e("MainActivity : ",MAMAMOO);
        //마마무가 7주년에 낸 곡
        int a = 7;
        //로그를 찍어봤다.
        Log.e("MainActivity", String.valueOf(a));
    }
}