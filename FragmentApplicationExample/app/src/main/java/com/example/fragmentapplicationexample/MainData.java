package com.example.fragmentapplicationexample;

public class MainData {
    private int iv_profile;
    private String search_history;

    public MainData(int iv_profile, String search_history) {
        this.iv_profile = iv_profile;
        this.search_history = search_history;
    }

    public int getIv_profile() {
        return iv_profile;
    }

    public void setIv_profile(int iv_profile) {
        this.iv_profile = iv_profile;
    }

    public String getSearch_history() {
        return search_history;
    }

    public void setSearch_history(String tv_name) {
        this.search_history = search_history;
    }
}
