package com.example.pnu_arena_mvp_10;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class frag_map extends Fragment implements OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener {
    private View view;
    private FragmentManager fragmentManager; //Fragment Manager
    private MapFragment mapFragment; //지도 fragment
    private MapView googlemap = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_map, container, false);

        googlemap = (MapView)view.findViewById(R.id.GoogleMap);
        googlemap.onCreate(savedInstanceState);
        googlemap.getMapAsync(this);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        googlemap.onStart();

    }

    @Override
    public void onStop() {
        super.onStop();
        googlemap.onStop();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        googlemap.onSaveInstanceState(outState);
    }

    @Override
    public void onResume() {
        super.onResume();
        googlemap.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        googlemap.onLowMemory();
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        LatLng center = new LatLng(35.229695236124925, 129.0882936406705);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.title("피자 전문점");
        markerOptions.snippet("피자");
        markerOptions.position(center);
        googleMap.addMarker(markerOptions);

        LatLng store1 = new LatLng(35.23112453519780, 129.08231692683924);
        MarkerOptions markerOptions1 = new MarkerOptions();
        markerOptions1.title("비빔밥 전문점");
        markerOptions1.snippet("비빔밥");
        markerOptions1.position(store1);
        googleMap.addMarker(markerOptions1);

        LatLng store2 = new LatLng(35.23112453519780, 129.08231692683924);
        MarkerOptions markerOptions2 = new MarkerOptions();
        markerOptions2.title("치킨 전문점");
        markerOptions2.snippet("치킨");
        markerOptions2.position(store2);
        googleMap.addMarker(markerOptions2);

        LatLng store3 = new LatLng(35.23112453519780, 129.08231692683924);
        MarkerOptions markerOptions3 = new MarkerOptions();
        markerOptions3.title("카레 전문점");
        markerOptions3.snippet("카레");
        markerOptions3.position(store3);
        googleMap.addMarker(markerOptions3);

        LatLng store4 = new LatLng(35.23112453519780, 129.08231692683924);
        MarkerOptions markerOptions4 = new MarkerOptions();
        markerOptions4.title("도넛 전문점");
        markerOptions4.snippet("도넛");
        markerOptions4.position(store4);
        googleMap.addMarker(markerOptions4);

        LatLng store5 = new LatLng(35.23372648720138, 129.08518227807141);
        MarkerOptions markerOptions5 = new MarkerOptions();
        markerOptions5.title("비빔밥 전문점");
        markerOptions5.snippet("비빔밥");
        markerOptions5.position(store5);
        googleMap.addMarker(markerOptions5);

        LatLng store6 = new LatLng(35.2310623785027, 129.0847531246095);
        MarkerOptions markerOptions6 = new MarkerOptions();
        markerOptions6.title("햄버거 전문점");
        markerOptions6.snippet("햄버거");
        markerOptions6.position(store6);
        googleMap.addMarker(markerOptions6);

        LatLng store7 = new LatLng(35.22980040174112, 129.0840450213973);
        MarkerOptions markerOptions7 = new MarkerOptions();
        markerOptions7.title("핫도그 전문점");
        markerOptions7.snippet("핫도그");
        markerOptions7.position(store7);
        googleMap.addMarker(markerOptions7);

        LatLng store8 = new LatLng(35.230641721763284, 129.08586892361055);
        MarkerOptions markerOptions8 = new MarkerOptions();
        markerOptions8.title("패스트푸드 전문점");
        markerOptions8.snippet("패스트푸드");
        markerOptions8.position(store1);
        googleMap.addMarker(markerOptions8);

        LatLng store9 = new LatLng(35.23225422741964, 129.08591183895675);
        MarkerOptions markerOptions9 = new MarkerOptions();
        markerOptions9.title("국수 전문점");
        markerOptions9.snippet("국수");
        markerOptions9.position(store9);
        googleMap.addMarker(markerOptions9);

        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(center, 15));
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }

    @Override
    public void onInfoWindowClick(@NonNull Marker marker) {

    }
}
