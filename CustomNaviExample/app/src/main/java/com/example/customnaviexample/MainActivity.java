package com.example.customnaviexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout; //다른 Class에서 이 변수를 건드리지 못한다. (앞에 "private" 안 붙여도 자동으로 "private"으로 인식한다.)
    private View drawerView;
    private DrawerLayout drawerLayout2;
    private View drawerView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout); //이 함수에서만 쓰는 변수이기 때문에 함수 안에 넣어준다.
        drawerView = (View)findViewById(R.id.drawer);

        Button btn_open = (Button)findViewById(R.id.btn_01);
        btn_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(drawerView);
            }
        });

        Button btn_close = (Button)findViewById(R.id.btn_close);
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawers();
            }
        });

        drawerLayout.setDrawerListener(listener);
        drawerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        drawerLayout2 = (DrawerLayout)findViewById(R.id.drawer_layout); //이 함수에서만 쓰는 변수이기 때문에 함수 안에 넣어준다.
        drawerView2 = (View)findViewById(R.id.drawer2);

        Button btn_02 = (Button)findViewById(R.id.btn_02);
        btn_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout2.openDrawer(drawerView2);
            }
        });

        Button btn_close2 = (Button)findViewById(R.id.btn_close2);
        btn_close2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout2.closeDrawers();
            }
        });

        drawerLayout2.setDrawerListener(listener2);
        drawerView2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
    }

    DrawerLayout.DrawerListener listener = new DrawerLayout.DrawerListener() {
        @Override
        public void onDrawerSlide(View drawerView, float slideOffset) {

        }

        @Override
        public void onDrawerOpened(View drawerView) {

        }

        @Override
        public void onDrawerClosed(View drawerView) {

        }

        @Override
        public void onDrawerStateChanged(int newState) {

        }
    };

    DrawerLayout.DrawerListener listener2 = new DrawerLayout.DrawerListener() {
        @Override
        public void onDrawerSlide(View drawerView, float slideOffset) {

        }

        @Override
        public void onDrawerOpened(View drawerView) {

        }

        @Override
        public void onDrawerClosed(View drawerView) {

        }

        @Override
        public void onDrawerStateChanged(int newState) {

        }
    };

    /**DrawerLayout.DrawerListener listener = new DrawerLayout.DrawerListener() {
        @Override
        public void onDrawerSlide(@NonNull @org.jetbrains.annotations.NotNull View drawerView, float slideOffset) {

        } //안드로이드 허용 애너테이션으로 바꿔주면 된다.

        @Override
        public void onDrawerOpened(@NonNull @org.jetbrains.annotations.NotNull View drawerView) {

        }

        @Override
        public void onDrawerClosed(@NonNull @org.jetbrains.annotations.NotNull View drawerView) {

        }

        @Override
        public void onDrawerStateChanged(int newState) {

        }
    };**/
}