package com.example.bottomnavigationviewexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private Frag1 frag1;
    private Frag2 frag2;
    private Frag3 frag3;
    private Frag4 frag4;
    private Frag5 frag5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavi);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:
                        setFrag(0);
                        break;
                    case R.id.action_search:
                        setFrag(1);
                        break;
                    case R.id.action_add:
                        setFrag(2);
                        break;
                    case R.id.action_feed:
                        setFrag(3);
                        break;
                    case R.id.action_my:
                        setFrag(4);
                        break;
                }
                return true;
            }
        });
        frag1 = new Frag1();
        frag2 = new Frag2();
        frag3 = new Frag3();
        frag4 = new Frag4();
        frag5 = new Frag5();

        setFrag(0); //첫 프래그먼트 화면을 무엇으로 지정해줄 것인지 선택
    }

    //fragment 교체가 일어나는 실행문
    private void setFrag(int n) {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        switch (n) {
            case 0 :
                fragmentTransaction.replace(R.id.main_frame, frag1);
                fragmentTransaction.commit();
                break;

            case 1 :
                fragmentTransaction.replace(R.id.main_frame, frag2);
                fragmentTransaction.commit();
                break;

            case 2 :
                fragmentTransaction.replace(R.id.main_frame, frag3);
                fragmentTransaction.commit();
                break;

            case 3 :
                fragmentTransaction.replace(R.id.main_frame, frag4);
                fragmentTransaction.commit();
                break;

            case 4 :
                fragmentTransaction.replace(R.id.main_frame, frag5);
                fragmentTransaction.commit();
                break;
        }
    }
}