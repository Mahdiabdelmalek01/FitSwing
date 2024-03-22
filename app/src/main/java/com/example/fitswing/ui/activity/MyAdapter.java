package com.example.fitswing.ui.activity;

import android.content.Context;
import android.view.ContentInfo;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitswing.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter <MyViewHolder> {

    Context context;
    List<activity> activities;

    public MyAdapter(Context context, List<activity> activities) {
        this.context = context;
        this.activities = activities;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.activity_name.setText(activities.get(position).getName());
        holder.activity_calories.setText(activities.get(position).getCalories());
        holder.completed.setChecked(activities.get(position).getCompleted());
    }

    @Override
    public int getItemCount() {
        return activities.size();
    }
}
