package com.example.roomdatabaseexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {
    private final ArrayList<User> arrayList;
    private final DisplayActivity disaplayActivity;

    public CustomAdapter(ArrayList<User> arrayList, DisplayActivity displayActivity){
        this.arrayList = arrayList;
        this.disaplayActivity = displayActivity;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.CustomViewHolder holder, int position) {
        holder.tvName.setText(arrayList.get(position).getName());
        holder.tvAge.setText(arrayList.get(position).getAge());
        holder.tvPhoneNumber.setText(arrayList.get(position).getPhonNumber());
    }

    @Override
    public int getItemCount() {
        return (arrayList != null ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{
        TextView tvName;
        TextView tvAge;
        TextView tvPhoneNumber;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tvName = itemView.findViewById(R.id.tv_name);
            this.tvAge = itemView.findViewById(R.id.tv_age);
            this.tvPhoneNumber = itemView.findViewById(R.id.tv_phoneNumber);
        }
    }
}
