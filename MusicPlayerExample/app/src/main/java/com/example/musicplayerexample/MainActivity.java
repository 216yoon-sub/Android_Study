package com.example.musicplayerexample;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    ImageButton btn_play1;
    ImageButton btn_play2;
    ImageButton btn_play3;
    ImageButton btn_play4;
    ImageButton btn_play5;
    ImageButton btn_play6;
    Button btn_stop;
    Button btn_pause;
    Button btn_random;

    MediaPlayer mediaPlayer;

    //액티비티가 종료될 때 이곳 실행
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_play1 = (ImageButton)findViewById(R.id.btn_play1);
        btn_play2 = (ImageButton)findViewById(R.id.btn_play2);
        btn_play3 = (ImageButton)findViewById(R.id.btn_play3);
        btn_play4 = (ImageButton)findViewById(R.id.btn_play4);
        btn_play5 = (ImageButton)findViewById(R.id.btn_play5);
        btn_play6 = (ImageButton)findViewById(R.id.btn_play6);
        btn_stop = (Button)findViewById(R.id.btn_stop);
        btn_pause = (Button)findViewById(R.id.btn_pause);
        btn_random = (Button)findViewById(R.id.btn_random);


        int playlist[] = new int[6];
        playlist[0] = R.raw.iljido;
        playlist[1] = R.raw.windflowerjapan;
        playlist[2] = R.raw.fourbyfourever;
        playlist[3] = R.raw.newyork;
        playlist[4] = R.raw.rainyseason;
        playlist[5] = R.raw.yesiam;

        //노래 버튼 눌렀을 때
        btn_play1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.iljido);
                mediaPlayer.start();
            }
        });
        btn_play2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.windflowerjapan);
                mediaPlayer.start();
            }
        });
        btn_play3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.fourbyfourever);
                mediaPlayer.start();
            }
        });
        btn_play4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.newyork);
                mediaPlayer.start();
            }
        });
        btn_play5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.rainyseason);
                mediaPlayer.start();
            }
        });
        btn_play6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.yesiam);
                mediaPlayer.start();
            }
        });

        //정지버튼 눌렀을 때
        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                }
            }
        });

        //일시정지 버튼 눌렀을 때
        btn_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                }else {
                    mediaPlayer.start();
                }
            }
        });

        //랜덤 버튼 눌렀을 때
        btn_random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                int random = (int) (Math.random()*6);
                mediaPlayer = MediaPlayer.create(MainActivity.this, playlist[random]);
                mediaPlayer.start();
            }
        });
    }
}