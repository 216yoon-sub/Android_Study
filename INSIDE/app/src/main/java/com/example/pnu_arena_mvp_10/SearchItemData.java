package com.example.pnu_arena_mvp_10;

import android.graphics.drawable.Drawable;

public class SearchItemData {
    public String location;
    public String name;
    public String kind;
    public String starpoint;
    public int mainimg;
    public int warning;
    public int starpointimg;
    public int myfav;

    public String getLocation() {
        return location;
    }
    public String getName() {
        return name;
    }
    public String getKind() {
        return kind;
    }
    public String getStarpoint() {
        return starpoint;
    }
    public int getMainimg() {
        return mainimg;
    }
    public int getWarning() {
        return warning;
    }
    public int getStarpointimg() {
        return starpointimg;
    }
    public int getMyfav() {
        return myfav;
    }

    public void setLocation(String location){
        this.location = location;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setKind(String kind){
        this.kind = kind;
    }
    public void setStarpoint(String starpoint){
        this.starpoint = starpoint;
    }
    public void setMainimg(int mainimg){
        this.mainimg = mainimg;
    }
    public void setWarning(int warning){
        this.warning = warning;
    }
    public void setStarpointimg(int starpointimg){
        this.starpointimg = starpointimg;
    }
    public void setMyfav(int myfav){
        this.myfav = myfav;
    }
}
