package com.example.fitswing;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;

import androidx.annotation.NonNull;

import com.example.fitswing.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.concurrent.CompletableFuture;

public class MyWidget extends AppWidgetProvider {
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }
    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager, int appWidgetId) {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://fitswing-6ea90-default-rtdb.europe-west1.firebasedatabase.app/");
        String userid = user.getUid();
        DatabaseReference myRef = database.getReference("users").child(userid).child("challenges");
        // Fetch challenges asynchronously from Firebase
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Process fetched data and update widget UI
                StringBuilder challenges = new StringBuilder();
                for (DataSnapshot challengeSnapshot : dataSnapshot.getChildren()) {
                    String activity = challengeSnapshot.child("activity").getValue(String.class);
                    String calories = challengeSnapshot.child("calories").getValue(String.class);
                    challenges.append("* ").append(activity).append(": ").append(calories).append("\n");
                }

                // Update widget UI with fetched challenges
                RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.my_widget);
                views.setTextViewText(R.id.txtWidget, challenges.toString());
                appWidgetManager.updateAppWidget(appWidgetId, views);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}