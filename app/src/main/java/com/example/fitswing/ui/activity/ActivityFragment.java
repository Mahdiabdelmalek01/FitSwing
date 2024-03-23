package com.example.fitswing.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitswing.databinding.FragmentActivityBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ActivityFragment extends Fragment {

private FragmentActivityBinding binding;
    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        ActivityViewModel activityViewModel =
                new ViewModelProvider(this).get(ActivityViewModel.class);

    binding = FragmentActivityBinding.inflate(inflater, container, false);
    View root = binding.getRoot();
        FloatingActionButton addBtn = binding.fab;
    addBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getActivity(), add_activity.class);
            startActivity(intent);
        }
    });
        RecyclerView recView = binding.recycleView;
        recView.setLayoutManager(new LinearLayoutManager(getActivity()));
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://fitswing-6ea90-default-rtdb.europe-west1.firebasedatabase.app/");
        String userid = user.getUid();
        DatabaseReference myRef = database.getReference("users").child(userid).child("challenges");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<activity> activities = new ArrayList<activity>();
                for (DataSnapshot datasnapshot : snapshot.getChildren()) {
                    activity challenge = new activity(datasnapshot.child("name").getValue(String.class),datasnapshot.child("calories").getValue(String.class),datasnapshot.child("completed").getValue(Boolean.class),datasnapshot.child("description").getValue(String.class),datasnapshot.child("date").getValue(String.class),datasnapshot.getKey());
                    if (challenge != null) {
                        activities.add(challenge);
                    }
                }
                recView.setAdapter(new MyAdapter(getContext(),activities));
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return root;
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}