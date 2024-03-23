package com.example.fitswing.ui.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.ContentInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitswing.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.activity_name.setText(activities.get(position).getName());
        holder.activity_calories.setText(activities.get(position).getCalories());
        holder.completed.setChecked(activities.get(position).getCompleted());
        String id = activities.get(position).getId();
        holder.completed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                FirebaseDatabase database = FirebaseDatabase.getInstance("https://fitswing-6ea90-default-rtdb.europe-west1.firebasedatabase.app/");
                String userid = user.getUid();
                DatabaseReference myRef = database.getReference("users").child(userid).child("challenges").child(id).child("completed");
                myRef.setValue(holder.completed.isChecked());

            }
        });
        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                FirebaseDatabase database = FirebaseDatabase.getInstance("https://fitswing-6ea90-default-rtdb.europe-west1.firebasedatabase.app/");
                String userid = user.getUid();
                DatabaseReference myRef = database.getReference("users").child(userid).child("challenges").child(id);
                myRef.removeValue();
            }
        });
    }

    @Override
    public int getItemCount() {
        return activities.size();
    }
}
