package com.example.googlemapexample;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.FragmentManager;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

import java.nio.BufferUnderflowException;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private FragmentManager fragmentManager;
    private MapFragment mapFragment;
    private static final int REQUEST_CODE = 216;
    Button btn_univ;
    Button btn_high;
    Button btn_mid1;
    Button btn_mid2;
    Button btn_ele1;
    Button btn_ele2;
    Button btn_zoomin;
    Button btn_zoomout;
    Button btn_search;
    GoogleMap googleMap;
    LocationManager locationManager;
    float FIRST_ZOOM = 16;
    float NOW_ZOOM = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        fragmentManager = getFragmentManager();
        mapFragment = (MapFragment) fragmentManager.findFragmentById(R.id.googleMap);
        mapFragment.getMapAsync(this);

        btn_univ = (Button) findViewById(R.id.btn_univ);
        btn_high = (Button) findViewById(R.id.btn_high);
        btn_mid1 = (Button) findViewById(R.id.btn_mid1);
        btn_mid2 = (Button) findViewById(R.id.btn_mid2);
        btn_ele1 = (Button) findViewById(R.id.btn_ele1);
        btn_ele2 = (Button) findViewById(R.id.btn_ele2);

        btn_zoomin = (Button) findViewById(R.id.btn_zoomin);
        btn_zoomout = (Button) findViewById(R.id.btn_zoomout);
        btn_search = (Button) findViewById(R.id.btn_search);

        btn_univ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                changeLocation(35.23114039736819, 129.08236856216604);
            }
        });
        btn_high.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                changeLocation(35.31880386203575, 129.23660803279242);
            }
        });
        btn_mid1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                changeLocation(35.533036315264006, 129.30020786759152);
            }
        });
        btn_mid2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                changeLocation(35.33799671378591, 129.162093009914);
            }
        });
        btn_ele1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                changeLocation(37.44585520254803, 129.17621104065512);
            }
        });
        btn_ele2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                changeLocation(35.52592685561498, 129.3170752559568);
            }
        });


        btn_zoomin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (NOW_ZOOM == 0) {
                    NOW_ZOOM = FIRST_ZOOM + 1;
                } else {
                    NOW_ZOOM = NOW_ZOOM + 1;
                }
                googleMap.animateCamera(CameraUpdateFactory.zoomTo(NOW_ZOOM), 2000, null);
            }
        });
        btn_zoomout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (NOW_ZOOM == 0) {
                    NOW_ZOOM = FIRST_ZOOM - 1;
                } else {
                    NOW_ZOOM = NOW_ZOOM - 1;
                }
                googleMap.animateCamera(CameraUpdateFactory.zoomTo(NOW_ZOOM), 2000, null);
            }
        });
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

    }

    public void changeLocation(@NonNull double latitude, double longitude) {
        /*if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0f, new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {
                LatLng update = new LatLng(latitude, longitude);
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(update, NOW_ZOOM));
            }
        });*/
        LatLng update = new LatLng(latitude, longitude);
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLng(update);
        googleMap.moveCamera(cameraUpdate);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        LatLng location = new LatLng(35.23114039736819, 129.08236856216604); //부산대학교 제6공학관
        MarkerOptions markerOptions1 = new MarkerOptions();
        markerOptions1.title("부산대학교 제6공학관");
        markerOptions1.snippet("컴퓨터공학관");
        markerOptions1.position(location);
        googleMap.addMarker(markerOptions1);

        LatLng high = new LatLng(35.31880386203575, 129.23660803279242); //부산장안고등학교
        MarkerOptions markerOptions2 = new MarkerOptions();
        markerOptions2.title("부산장안고등학교");
        markerOptions2.snippet("입학/졸업한 고등학교");
        markerOptions2.position(high);
        googleMap.addMarker(markerOptions2);

        LatLng mid1 = new LatLng(35.533036315264006, 129.30020786759152); //울산서여자중학교
        MarkerOptions markerOptions3 = new MarkerOptions();
        markerOptions3.title("울산서여자중학교");
        markerOptions3.snippet("입학한 중학교");
        markerOptions3.position(mid1);
        googleMap.addMarker(markerOptions3);

        LatLng mid2 = new LatLng(35.33799671378591, 129.162093009914); //모전중학교
        MarkerOptions markerOptions4 = new MarkerOptions();
        markerOptions4.title("모전중학교");
        markerOptions4.snippet("졸업한 중학교");
        markerOptions4.position(mid2);
        googleMap.addMarker(markerOptions4);

        LatLng ele1 = new LatLng(37.44585520254803, 129.17621104065512); //정라초등학교
        MarkerOptions markerOptions5 = new MarkerOptions();
        markerOptions5.title("정라초등학교");
        markerOptions5.snippet("입학한 초등학교");
        markerOptions5.position(ele1);
        googleMap.addMarker(markerOptions5);

        LatLng ele2 = new LatLng(35.52592685561498, 129.3170752559568); //수암초등학교
        MarkerOptions markerOptions6 = new MarkerOptions();
        markerOptions6.title("수암초등학교");
        markerOptions6.snippet("졸업한 초등학교");
        markerOptions6.position(ele2);
        googleMap.addMarker(markerOptions6);


        //googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 16));
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location, FIRST_ZOOM));

        //googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        //googleMap.setMapType(GoogleMap.MAP_TYPE_NONE);
        //googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        //googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            Toast.makeText(getApplicationContext(), "수신 성공", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "수신 실패", Toast.LENGTH_SHORT).show();
        }

        if(requestCode == REQUEST_CODE){
            Double result1 = data.getDoubleExtra("comeback1", 0);
            Double result2 = data.getDoubleExtra("comeback2", 0);
            changeLocation(result1, result2);
        }
    }
}