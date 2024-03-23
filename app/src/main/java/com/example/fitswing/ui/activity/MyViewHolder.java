package com.example.fitswing.ui.activity;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitswing.R;

public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView activity_name,activity_calories;
    CheckBox completed;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        activity_name = itemView.findViewById(R.id.activityTitle);
        activity_calories = itemView.findViewById(R.id.caloriesBurned);
        completed = itemView.findViewById(R.id.completedCheckbox);
    }
}
