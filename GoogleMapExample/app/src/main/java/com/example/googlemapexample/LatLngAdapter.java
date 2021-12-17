package com.example.googlemapexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.List;

public class LatLngAdapter extends ArrayAdapter implements AdapterView.OnItemClickListener {

    private Context context;
    private List latlnglist;

    class ViewHolder {
        public TextView name, latlng;
    }

    public LatLngAdapter(Context context, ArrayList<LatLngList> latlnglist) {
        super(context, 0, latlnglist);
        this.context = context;
        this.latlnglist = latlnglist;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final ViewHolder latlnglistView;

        if (convertView==null) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            convertView = layoutInflater.inflate(R.layout.activity_sub, parent, false);
        }

        latlnglistView = new ViewHolder();
        latlnglistView.name = convertView.findViewById(R.id.name);
        latlnglistView.latlng = convertView.findViewById(R.id.latlng);

        return convertView;
    }
}
