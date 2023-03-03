package com.example.roomdatabaseexample;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DisplayActivity extends AppCompatActivity {

    private UserDao mUserDao;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private ArrayList<User> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        arrayList = new ArrayList<>();

        UserDatabase database = Room.databaseBuilder(getApplicationContext(), UserDatabase.class, "ice_cream")
                .fallbackToDestructiveMigration() // 스키마(database) 버전 변경 가능
                .allowMainThreadQueries() // Main Thread에서 DB에 IO(Input / Output)를 가능하게 함
                .build();

        mUserDao = database.userDao();  // 인터페이스 객체 할당

        Intent receive_intent = getIntent();
        String strName = receive_intent.getStringExtra("name");
        String strAge = receive_intent.getStringExtra("age");
        String strPhoneNumber = receive_intent.getStringExtra("phone");

        User user = new User(); // 객체 인스턴스 생성
        user.setName(strName);
        user.setAge(strAge);
        user.setPhonNumber(strPhoneNumber);
        mUserDao.setInsertUser(user);

        List<User> userList = mUserDao.getUserAll();
        // 데이터 조회
        arrayList.clear();
        for (int i = 0; i < userList.size(); i++) {
            User user1 = new User(userList.get(i).getId(), userList.get(i).getName(), userList.get(i).getAge(), userList.get(i).getPhonNumber());
            arrayList.add(user);

        }

//        adapter = new CustomAdapter(arrayList, this);
//        recyclerView.setAdapter(adapter);

    }
}
/*
private UserDao mUserDao;

UserDatabase database = Room.databaseBuilder(getApplicationContext(), UserDatabase.class, "ice_cream")
                .fallbackToDestructiveMigration() // 스키마(database) 버전 변경 가능
                .allowMainThreadQueries() // Main Thread에서 DB에 IO(Input / Output)를 가능하게 함
                .build();

        mUserDao = database.userDao();  // 인터페이스 객체 할당

        // 데이터 삽입
//        User user = new User(); // 객체 인스턴스 생성
//        user.setName("문별이");
//        user.setAge("30");
//        user.setPhonNumber("01012345678");
//        mUserDao.setInsertUser(user);

        List<User> userList = mUserDao.getUserAll();
        // 데이터 조회
        for (int i = 0; i < userList.size(); i++) {
            Log.d("TEST", userList.get(i).getName() + "\n"
                    + userList.get(i).getAge() + "\n"
                    + userList.get(i).getPhonNumber() + "\n");
        }

        // 데이터 수정
//        User user2 = new User(); // 객체 인스턴스 생성
//        user2.setId(1);
//        user2.setName("김용선");
//        user2.setAge("31");
//        user2.setPhonNumber("01019910221");
//        mUserDao.setInsertUser(user2);

        // 데이터 삭제
        User user3 = new User();
        user3.setId(2);
        mUserDao.setDeleteUser(user3);
 */