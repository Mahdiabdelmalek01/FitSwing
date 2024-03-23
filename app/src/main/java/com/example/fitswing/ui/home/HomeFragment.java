package com.example.fitswing.ui.home;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import android.widget.TextView;
import android.view.View;

import com.example.fitswing.R;
import com.example.fitswing.databinding.FragmentHomeBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;

public class HomeFragment extends Fragment {

private FragmentHomeBinding binding;
    TextView dateView,progressView,calories;
    LinearLayout layout;
    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

    binding = FragmentHomeBinding.inflate(inflater, container, false);
    View root = binding.getRoot();
    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, d MMMM yyyy");
    String currentDate = dateFormat.format(calendar.getTime());
    progressView = binding.textProgress;
    calories = binding.calorietxt;
    layout = binding.layoutA;
    TextView usertext = binding.usernameTextView;
         dateView = (TextView) root.findViewById(R.id.todayDate); // Assuming you have a TextView with id textView in your layout
        dateView.setText(currentDate);
        String userID = FirebaseAuth.getInstance().getCurrentUser().getUid();
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://fitswing-6ea90-default-rtdb.europe-west1.firebasedatabase.app/");
        DatabaseReference myRef = database.getReference("users").child(userID).child("username");

        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String username = snapshot.getValue(String.class);
                usertext.append(username);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        CircularProgressBar circularProgressBar = binding.circularProgressBar;
        DatabaseReference progressRef = database.getReference("users").child(userID).child("challenges");
        progressRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                long childrenCount = snapshot.getChildrenCount();
                float all = (float)childrenCount;
                float count = 0;
                long caloriesCount=0;
                for (DataSnapshot datasnapshot : snapshot.getChildren()) {
                    boolean value = datasnapshot.child("completed").getValue(Boolean.class);
                    if(value==true){
                        String calories = datasnapshot.child("calories").getValue(String.class);
                        caloriesCount+= Integer.parseInt(calories);
                        count++;
                    }
                    View cardview = getLayoutInflater().inflate(R.layout.home_activity_card, null);
                    TextView activity_name = cardview.findViewById(R.id.titleTextView1);
                    TextView description = cardview.findViewById(R.id.descriptionTextView1);
                    activity_name.setText(datasnapshot.child("name").getValue(String.class));
                    description.setText(datasnapshot.child("description").getValue(String.class));
                    layout.addView(cardview);
                }
                calories.setText(""+caloriesCount);
                if(count == 0 ) {
                    circularProgressBar.setProgress(0);
                    progressView.setText("0");
                    

                }
                else {

                    circularProgressBar.setProgress( (float)(count / all) * 100);
                    String formattedValue = String.format("%.1f", (count / all) * 100);
                    progressView.setText(formattedValue+"%");
                }
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

