package com.example.pnu_arena_mvp_10;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class frag_attention extends Fragment {
    private ArrayList<SearchItemData> itemData = new ArrayList<>();
    private ListView listView;
    private SearchAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_attention, container, false);

        listView = (ListView)view.findViewById(R.id.listview_attention);

        adapter = new SearchAdapter();

        //TypedArray resthumbs = getResources().obtainTypedArray(R.array.resthumb);

        //리스트 내용
        adapter.add_item(R.drawable.hamburger, R.drawable.ic_baseline_warning_24_red,
                R.drawable.ic_baseline_star_24, R.drawable.ic_baseline_star_24,
                "부산광역시 사하구 당리동","햄버거 전문점",
                "햄버거","4.7");

        adapter.add_item(R.drawable.avocado, R.drawable.ic_baseline_warning_24,
                R.drawable.ic_baseline_star_24, R.drawable.ic_baseline_star_24,
                "부산광역시 해운대구 우동","샌드위치 전문점",
                "샌드위치","4.5");

        adapter.add_item(R.drawable.bibimbab, R.drawable.ic_baseline_warning_24,
                R.drawable.ic_baseline_star_24, R.drawable.ic_baseline_star_24,
                "부산광역시 기장군 철마면","비빔밥 전문점",
                "비빔밥","5.0");

        adapter.add_item(R.drawable.donut, R.drawable.ic_baseline_warning_24,
                R.drawable.ic_baseline_star_24, R.drawable.ic_baseline_star_24,
                "부산광역시 북구 만덕동","도넛 전문점",
                "도넛","4.9");

        adapter.add_item(R.drawable.noodle, R.drawable.ic_baseline_warning_24,
                R.drawable.ic_baseline_star_24, R.drawable.ic_baseline_star_24,
                "부산광역시 부산진구 가야동","국수 전문점",
                "국수","4.8");

        adapter.add_item(R.drawable.avocado, R.drawable.ic_baseline_warning_24_green,
                R.drawable.ic_baseline_star_24, R.drawable.ic_baseline_star_24,
                "부산광역시 영도구 동삼동","샌드위치 전문점",
                "샌드위치","4.9");


        listView.setAdapter(adapter);

        return view;

    }
}
