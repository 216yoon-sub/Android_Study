package com.example.customnaviexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import androidx.drawerlayout.widget.DrawerLayout;

public class NewActivity extends Activity {
    private DrawerLayout drawerLayout; //다른 Class에서 이 변수를 건드리지 못한다. (앞에 "private" 안 붙여도 자동으로 "private"으로 인식한다.)
    private View drawerView;
    private DrawerLayout drawerLayout2;
    private View drawerView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        drawerLayout2 = (DrawerLayout) findViewById(R.id.drawer_layout); //이 함수에서만 쓰는 변수이기 때문에 함수 안에 넣어준다.
        drawerView2 = (View) findViewById(R.id.drawer2);

        Button btn_02 = (Button) findViewById(R.id.btn_02);
        btn_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout2.openDrawer(drawerView2);
            }
        });

        Button btn_close2 = (Button) findViewById(R.id.btn_close2);
        btn_close2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout2.closeDrawers();
            }
        });
    }
}
