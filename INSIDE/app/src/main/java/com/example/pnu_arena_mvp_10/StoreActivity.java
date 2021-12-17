package com.example.pnu_arena_mvp_10;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class StoreActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        TextView textView = (TextView)findViewById(R.id.content_page);

        /*Intent intent = getIntent();
        String text = intent.getExtras().getString("inside");
        textView.setText(text);*/
    }
}
