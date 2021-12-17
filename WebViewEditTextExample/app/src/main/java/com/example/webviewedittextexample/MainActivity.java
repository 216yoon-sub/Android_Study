package com.example.webviewedittextexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et;
    private WebView wv;
    private Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = findViewById(R.id.et);
        wv = findViewById(R.id.wv);
        bt = findViewById(R.id.bt);

        WebSettings webSettings = wv.getSettings();

        //자바 스크립트를 사용할 수 있도록 한다.
        webSettings.setJavaScriptEnabled(true);

        wv.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                Toast.makeText(MainActivity.this,"로딩 끝", Toast.LENGTH_SHORT).show();
            }
        });

        et.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    //bt의 onClick을 실행
                    bt.callOnClick();

                    //키보드 숨기기
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(),0);
                    return true;
                }
                return false;
            }
        });
    }

    public void onClick(View view) {
        String address = et.getText().toString();

        //http://를 넣지 않고 웹주소를 입력했을 경우 http://를 추가해준다.
        if (!address.startsWith("http://")) {
            address = "http://" + address;
        }

        //웹뷰 로드
        wv.loadUrl(address);
    }

    @Override
    public void onBackPressed() {
        if (wv.canGoBack()) {
            wv.goBack();
        }else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            //뒤로가기가 가능할 때 뒤로가기
            case R.id.action_back:
                if (wv.canGoBack()) {
                    wv.goBack();
                }
                return true;

            case R.id.action_forward:
                if (wv.canGoForward()) {
                    wv.goForward();
                }
                return true;

            case R.id.action_refresh:
                wv.reload();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}