package com.example.musicplayerapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import me.relex.circleindicator.CircleIndicator3;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 mPager;
    private FragmentStateAdapter pagerAdapter;
    private int num_page = 6;
    private CircleIndicator3 mIndicator;

    ImageButton btn_play1;
    ImageButton btn_play2;
    ImageButton btn_play3;
    ImageButton btn_play4;
    ImageButton btn_play5;
    ImageButton btn_play6;
    ImageButton btn_go_newyork;
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
        btn_go_newyork = (ImageButton)findViewById(R.id.btn_go_newyork);
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
                if(mediaPlayer!=null && mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.iljido);
                mediaPlayer.start();
            }
        });
        btn_play2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer!=null && mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.windflowerjapan);
                mediaPlayer.start();
            }
        });
        btn_play3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer!=null && mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.fourbyfourever);
                mediaPlayer.start();
            }
        });
        btn_play4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer!=null && mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.newyork);
                mediaPlayer.start();
            }
        });
        btn_go_newyork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NewyorkActivity.class);
                startActivity(intent);
            }
        });
        btn_play5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer!=null && mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.rainyseason);
                mediaPlayer.start();
            }
        });
        btn_play6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer!=null && mediaPlayer.isPlaying()){
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

        mPager = findViewById(R.id.viewpager);
        pagerAdapter = new MyAdapter(this, num_page);
        mPager.setAdapter(pagerAdapter);
        mIndicator = findViewById(R.id.indicator);
        mIndicator.setViewPager(mPager);
        mIndicator.createIndicators(num_page, 0);

        mPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        mPager.setCurrentItem(1000);
        mPager.setOffscreenPageLimit(3);
        mPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                if (positionOffsetPixels==0){
                    mPager.setCurrentItem(position);
                }
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                mIndicator.animatePageSelected(position%num_page);
            }
        });

        final float pageMargin = getResources().getDimensionPixelOffset(R.dimen.pageMargin);
        final float pageOffset = getResources().getDimensionPixelOffset(R.dimen.offset);

        mPager.setPageTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float myOffset = position *-(2*pageOffset+pageMargin);
                if(mPager.getOrientation()==ViewPager2.ORIENTATION_HORIZONTAL){
                    if(ViewCompat.getLayoutDirection(mPager)==ViewCompat.LAYOUT_DIRECTION_RTL){
                        page.setTranslationX(-myOffset);
                    }else {
                        page.setTranslationX(myOffset);
                    }
                }else {
                    page.setTranslationY(myOffset);
                }
            }
        });
    }
}