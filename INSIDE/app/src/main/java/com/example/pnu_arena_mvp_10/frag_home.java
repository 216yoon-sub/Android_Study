package com.example.pnu_arena_mvp_10;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.icu.util.ULocale;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Locale;

public class frag_home extends Fragment {
    private ArrayList<SearchItemData> itemData = new ArrayList<>();
    private ListView listView;
    private SearchAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_home, container, false);

        listView = (ListView)view.findViewById(R.id.listview);

        adapter = new SearchAdapter();

        //TypedArray resthumbs = getResources().obtainTypedArray(R.array.resthumb);

        //리스트 내용
        adapter.add_item(R.drawable.pizza, R.drawable.ic_baseline_warning_24_red,
                R.drawable.ic_baseline_star_24, R.drawable.ic_baseline_star_border_24,
                "부산광역시 금정구 장전동","피자 전문점",
                "피자","4.5");

        adapter.add_item(R.drawable.bibimbab, R.drawable.ic_baseline_warning_24,
                R.drawable.ic_baseline_star_24, R.drawable.ic_baseline_star_border_24,
                "부산광역시 금정구 부곡동","비빔밥 전문점",
                "비빔밥","5.0");

        adapter.add_item(R.drawable.chicken, R.drawable.ic_baseline_warning_24_green,
                R.drawable.ic_baseline_star_24, R.drawable.ic_baseline_star_border_24,
                "부산광역시 사상구 괘법동","치킨 전문점",
                "치킨","3.8");

        adapter.add_item(R.drawable.curry, R.drawable.ic_baseline_warning_24_red,
                R.drawable.ic_baseline_star_24, R.drawable.ic_baseline_star_border_24,
                "부산광역시 기장군 기장읍","카레 전문점",
                "카레","3.6");

        adapter.add_item(R.drawable.donut, R.drawable.ic_baseline_warning_24,
                R.drawable.ic_baseline_star_24, R.drawable.ic_baseline_star_border_24,
                "부산광역시 사하구 괴정동","도넛 전문점",
                "도넛","4.3");

        adapter.add_item(R.drawable.hamburger, R.drawable.ic_baseline_warning_24_red,
                R.drawable.ic_baseline_star_24, R.drawable.ic_baseline_star_24,
                "부산광역시 사하구 당리동","햄버거 전문점",
                "햄버거","4.7");

        adapter.add_item(R.drawable.hotdog, R.drawable.ic_baseline_warning_24,
                R.drawable.ic_baseline_star_24, R.drawable.ic_baseline_star_border_24,
                "부산광역시 강서구 죽동","핫도그 전문점",
                "핫도그","3.9");

        adapter.add_item(R.drawable.junkfood, R.drawable.ic_baseline_warning_24_green,
                R.drawable.ic_baseline_star_24, R.drawable.ic_baseline_star_border_24,
                "부산광역시 해운대구 반여동","패스트푸드 전문점",
                "패스트푸드","3.7");

        adapter.add_item(R.drawable.noodle, R.drawable.ic_baseline_warning_24_green,
                R.drawable.ic_baseline_star_24, R.drawable.ic_baseline_star_border_24,
                "부산광역시 북구 덕천동","국수 전문점",
                "국수","4.1");

        adapter.add_item(R.drawable.avocado, R.drawable.ic_baseline_warning_24,
                R.drawable.ic_baseline_star_24, R.drawable.ic_baseline_star_24,
                "부산광역시 해운대구 우동","샌드위치 전문점",
                "샌드위치","4.5");

        adapter.add_item(R.drawable.pizza, R.drawable.ic_baseline_warning_24_red,
                R.drawable.ic_baseline_star_24, R.drawable.ic_baseline_star_border_24,
                "부산광역시 기장군 일광면","피자 전문점",
                "피자","4.3");

        adapter.add_item(R.drawable.bibimbab, R.drawable.ic_baseline_warning_24,
                R.drawable.ic_baseline_star_24, R.drawable.ic_baseline_star_24,
                "부산광역시 기장군 철마면","비빔밥 전문점",
                "비빔밥","5.0");

        adapter.add_item(R.drawable.chicken, R.drawable.ic_baseline_warning_24_green,
                R.drawable.ic_baseline_star_24, R.drawable.ic_baseline_star_border_24,
                "부산광역시 기장군 장안읍","치킨 전문점",
                "치킨","3.5");

        adapter.add_item(R.drawable.curry, R.drawable.ic_baseline_warning_24,
                R.drawable.ic_baseline_star_24, R.drawable.ic_baseline_star_border_24,
                "부산광역시 수영구 망미동","카레 전문점",
                "카레","4.1");

        adapter.add_item(R.drawable.donut, R.drawable.ic_baseline_warning_24,
                R.drawable.ic_baseline_star_24, R.drawable.ic_baseline_star_24,
                "부산광역시 북구 만덕동","도넛 전문점",
                "도넛","4.9");

        adapter.add_item(R.drawable.hamburger, R.drawable.ic_baseline_warning_24_red,
                R.drawable.ic_baseline_star_24, R.drawable.ic_baseline_star_border_24,
                "부산광역시 강서구 강동동","햄버거 전문점",
                "햄버거","4.8");

        adapter.add_item(R.drawable.hotdog, R.drawable.ic_baseline_warning_24,
                R.drawable.ic_baseline_star_24, R.drawable.ic_baseline_star_border_24,
                "부산광역시 수영구 수영동","핫도그 전문점",
                "핫도그","3.5");

        adapter.add_item(R.drawable.junkfood, R.drawable.ic_baseline_warning_24_red,
                R.drawable.ic_baseline_star_24, R.drawable.ic_baseline_star_border_24,
                "부산광역시 기장군 정관읍","패스트푸드 전문점",
                "패스트푸드","3.7");

        adapter.add_item(R.drawable.noodle, R.drawable.ic_baseline_warning_24,
                R.drawable.ic_baseline_star_24, R.drawable.ic_baseline_star_24,
                "부산광역시 부산진구 가야동","국수 전문점",
                "국수","4.8");

        adapter.add_item(R.drawable.avocado, R.drawable.ic_baseline_warning_24_green,
                R.drawable.ic_baseline_star_24, R.drawable.ic_baseline_star_24,
                "부산광역시 영도구 동삼동","샌드위치 전문점",
                "샌드위치","4.9");


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), StoreActivity.class);
                startActivity(intent);
            }
        });

        listView.setAdapter(adapter);

        return view;

    }
}
