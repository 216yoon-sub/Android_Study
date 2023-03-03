package com.example.pnu_arena_mvp_10;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class frag_mypage extends Fragment {
    private View view;
    Button waiting;
    Button myreviews;
    Button myinformation;
    Button notice;
    Button customercenter;
    Button settings;
    Button login_register;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_mypage, container, false);

        waiting = (Button)view.findViewById(R.id.waiting);
        myreviews = (Button)view.findViewById(R.id.myreview);
        myinformation = (Button)view.findViewById(R.id.myinformation);
        notice = (Button)view.findViewById(R.id.notice);
        customercenter = (Button)view.findViewById(R.id.customercenter);
        settings = (Button)view.findViewById(R.id.settings);
        login_register = (Button)view.findViewById(R.id.login_register);

        waiting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CurrentWaiting.class);
                startActivity(intent);
            }
        });
        myreviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MyReviews.class);
                startActivity(intent);
            }
        });
        myinformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MyInformation.class);
                startActivity(intent);
            }
        });
        notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Notice.class);
                startActivity(intent);
            }
        });
        customercenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CustomerCenter.class);
                startActivity(intent);
            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Settings.class);
                startActivity(intent);
            }
        });
        login_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), KakaoLoginActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
