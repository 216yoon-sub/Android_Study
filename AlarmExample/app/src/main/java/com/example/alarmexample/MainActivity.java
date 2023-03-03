package com.example.alarmexample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    public AlarmManager am;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Button btnOnce = (Button)findViewById(R.id.btn_once);
        Button btnCancel = (Button)findViewById(R.id.btn_cancel);

        btnOnce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AlarmReceiver.class);
                intent.putExtra("tag", "one time");
                PendingIntent sender = PendingIntent.getBroadcast(MainActivity.this, 0, intent, 0);

                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                calendar.add(Calendar.SECOND, 5);

                am.set(AlarmManager.RTC, calendar.getTimeInMillis(), sender);
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AlarmReceiver.class);
                PendingIntent sender = PendingIntent.getBroadcast(MainActivity.this, 0, intent, 0);
                am.cancel(sender);
            }
        });
    }
}