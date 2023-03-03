package com.example.pnu_arena_mvp_10;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SearchAdapter extends BaseAdapter implements Filterable {

    private ArrayList<SearchItemData> listview_data = new ArrayList<>();
    private ArrayList<SearchItemData> filteredItemList = listview_data;
    RecyclerView.ViewHolder viewHolder;
    Filter listFilter;

    @Override
    public int getCount() {
        return filteredItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return filteredItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Context context = parent.getContext();
        final int pos = position;

        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.frag_search_items, parent, false);
        }

        TextView location = (TextView)convertView.findViewById(R.id.location);
        TextView name = (TextView)convertView.findViewById(R.id.name);
        TextView kind = (TextView)convertView.findViewById(R.id.kind);
        TextView starpoint = (TextView)convertView.findViewById(R.id.starpoint);
        ImageView mainimg = (ImageView)convertView.findViewById(R.id.mainimg);
        ImageView warning = (ImageView)convertView.findViewById(R.id.warning);
        ImageView starpointimg = (ImageView)convertView.findViewById(R.id.starimg);
        ImageView myfav = (ImageView)convertView.findViewById(R.id.myfav);

        SearchItemData itemData = (SearchItemData) getItem(position);

        location.setText(itemData.getLocation());
        name.setText(itemData.getName());
        kind.setText(itemData.getKind());
        starpoint.setText(itemData.getStarpoint());
        mainimg.setImageResource(itemData.getMainimg());
        warning.setImageResource(itemData.getWarning());
        starpointimg.setImageResource(itemData.getStarpointimg());
        myfav.setImageResource(itemData.getMyfav());

        mainimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, name.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }

    public void add_item(int mainimg, int warning, int starpointimg, int myfav,
                         String location, String name, String kind, String starpoint){
        SearchItemData m_item = new SearchItemData();

        m_item.setLocation(location);
        m_item.setKind(kind);
        m_item.setName(name);
        m_item.setStarpoint(starpoint);
        m_item.setMainimg(mainimg);
        m_item.setWarning(warning);
        m_item.setStarpointimg(starpointimg);
        m_item.setMyfav(myfav);

        listview_data.add(m_item);
    }

    @Override
    public Filter getFilter() {
        if(listFilter == null){
            listFilter = new ListFilter();
        }

        return listFilter;
    }

    private class ListFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();

            if(constraint==null || constraint.length()==0){
                results.values = listview_data;
                results.count = listview_data.size();
            } else {
                ArrayList<SearchItemData> itemData = new ArrayList<SearchItemData>();

                for (SearchItemData item : listview_data) {
                    if(item.getName().toUpperCase().contains(constraint.toString().toUpperCase())||
                    item.getKind().toUpperCase().contains(constraint.toString().toUpperCase())||
                    item.getLocation().toUpperCase().contains(constraint.toString().toUpperCase())||
                    item.getStarpoint().toUpperCase().contains(constraint.toString().toUpperCase()))
                    {
                        itemData.add(item);
                    }
                }

                results.values = itemData;
                results.count = itemData.size();
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            //update listview by filtered data list
            filteredItemList = (ArrayList<SearchItemData>) results.values;

            //notify
            if(results.count>0){
                notifyDataSetChanged();
            } else {
                notifyDataSetInvalidated();
            }
        }
    }
}
