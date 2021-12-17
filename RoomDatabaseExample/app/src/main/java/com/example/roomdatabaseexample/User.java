package com.example.roomdatabaseexample;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    private int id = 0; // 하나의 사용자에 대한 고유 ID 값

    private String name;
    private String age;
    private String phonNumber;

    public User(int id, String name, String age, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phonNumber = phoneNumber;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhonNumber() {
        return phonNumber;
    }

    public void setPhonNumber(String phonNumber) {
        this.phonNumber = phonNumber;
    }
}
