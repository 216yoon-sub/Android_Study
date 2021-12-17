package com.example.googlemapexample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.TaskStackBuilder;

import java.util.ArrayList;

public class SubActivity extends AppCompatActivity {

    private EditText et_lat;
    private EditText et_lng;
    private Button btn_back;

    ArrayList<LatLngList> actors;
    ListView sub_latlnglist;
    private static LatLngAdapter latLngAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        et_lat = findViewById(R.id.et_lat);
        et_lng = findViewById(R.id.et_lng);
        btn_back = findViewById(R.id.btn_back);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("comeback1", Double.parseDouble(et_lat.getText().toString()));
                intent.putExtra("comeback2", Double.parseDouble(et_lng.getText().toString()));
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        actors = new ArrayList<LatLngList>();
        actors.add(new LatLngList("부산대학교", "35.23114039736819, 129.08236856216604"));
        actors.add(new LatLngList("부산장안고등학교", "35.31880386203575, 129.23660803279242"));
        actors.add(new LatLngList("모전중학교", "35.533036315264006, 129.30020786759152"));
        actors.add(new LatLngList("서여자중학교", "35.33799671378591, 129.162093009914"));
        actors.add(new LatLngList("수암초등학교", "37.44585520254803, 129.17621104065512"));
        actors.add(new LatLngList("정라초등학교", "35.52592685561498, 129.3170752559568"));
        actors.add(new LatLngList("부산광역시청", "35.17997543308812, 129.07495481176633"));
        actors.add(new LatLngList("금정구청", "35.24312960301213, 129.09224257909577"));
        actors.add(new LatLngList("NC 백화점 부산대점", "35.23249057754544, 129.08426605595028"));
        actors.add(new LatLngList("삼척시청", "37.45015844609305, 129.16548714251095"));
        actors.add(new LatLngList("울산광역시청", "35.53968145343648, 129.31153579406623"));
        actors.add(new LatLngList("울산대공원", "35.531075257827496, 129.29376551180857"));
        actors.add(new LatLngList("삼척종합운동장", "37.456309612266516, 129.1735580864927"));

        sub_latlnglist = (ListView)findViewById(R.id.listview);
        sub_latlnglist.setAdapter(latLngAdapter);

    }
}
