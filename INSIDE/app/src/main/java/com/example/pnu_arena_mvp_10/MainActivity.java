package com.example.pnu_arena_mvp_10;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.security.MessageDigest;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private frag_map frag_map;
    private frag_home frag_home;
    private frag_search frag_search;
    private frag_attention frag_attention;
    private frag_mypage frag_mypage;
    //private frag_camera frag_camera;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getAppkeyHash();

        bottomNavigationView = findViewById(R.id.bottom_navi);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_map:
                        setFrag(5);
                        break;
                    case R.id.action_home:
                        setFrag(0);
                        break;
                    case R.id.action_search:
                        setFrag(1);
                        break;
                    case R.id.action_attention:
                        setFrag(2);
                        break;
                    case R.id.action_my:
                        setFrag(3);
                        break;
                    /*case R.id.action_camera:
                        setFrag(4);
                        break;*/
                }

                return true;
            }
        });
        frag_home = new frag_home();
        frag_search = new frag_search();
        frag_attention = new frag_attention();
        frag_mypage = new frag_mypage();
        //frag_camera = new frag_camera();
        frag_map = new frag_map();
        setFrag(5); // The first Fragment

    }

    //Fragment Change
    private void setFrag(int n) {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        switch (n) {
            case 0:
                fragmentTransaction.replace(R.id.main_frame, frag_home);
                fragmentTransaction.commit();
                break;
            case 1:
                fragmentTransaction.replace(R.id.main_frame, frag_search);
                fragmentTransaction.commit();
                break;
            case 2:
                fragmentTransaction.replace(R.id.main_frame, frag_attention);
                fragmentTransaction.commit();
                break;
            case 3:
                fragmentTransaction.replace(R.id.main_frame, frag_mypage);
                fragmentTransaction.commit();
                break;
            /*case 4:
                fragmentTransaction.replace(R.id.main_frame, frag_camera);
                fragmentTransaction.commit();
                break;*/
            case 5:
                fragmentTransaction.replace(R.id.main_frame, frag_map);
                fragmentTransaction.commit();
        }
    }

    //백버튼 두 번 누르면 종료
    private long backBtnTime = 0;

    @Override
    public void onBackPressed() {
        long curTime = System.currentTimeMillis();
        long gapTime = curTime - backBtnTime;

        if(0<=gapTime && 2000>=gapTime){
            super.onBackPressed();
        }
        else {
            backBtnTime = curTime;
            Toast.makeText(this, "한 번 더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show();
        }
    }

    // 카카오 로그인 시 필요한 해시키를 얻는 메소드
    private void getAppkeyHash(){
        try {
            PackageInfo info = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures){
                MessageDigest md;
                md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String something = new String(Base64.encode(md.digest(), 0));
                Log.e("Hash key", something);
            }
        }
        catch (Exception e){
            Log.e("name not found", e.toString());
        }
    }
}