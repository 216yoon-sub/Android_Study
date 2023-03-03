package com.example.fragmentapplicationexample;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment2 extends Fragment {

    private EditText et;
    private WebView wv;
    private Button bt;

    public Fragment2() {

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment1, container, false);

        et = v.findViewById(R.id.et);
        wv = v.findViewById(R.id.wv);
        bt = v.findViewById(R.id.bt);

        WebSettings webSettings = wv.getSettings();

        //자바 스크립트를 사용할 수 있도록 한다.
        webSettings.setJavaScriptEnabled(true);


        et.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    //bt의 onClick을 실행
                    bt.callOnClick();

                    //키보드 숨기기
                    InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(),0);
                    return true;
                }
                return false;
            }
        });

        return v;
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
}
