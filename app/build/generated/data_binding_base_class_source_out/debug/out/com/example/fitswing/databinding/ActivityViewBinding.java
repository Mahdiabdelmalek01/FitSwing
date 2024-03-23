// Generated by view binder compiler. Do not edit!
package com.example.fitswing.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.fitswing.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityViewBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView activityTitle;

  @NonNull
  public final TextView caloriesBurned;

  @NonNull
  public final CheckBox completedCheckbox;

  @NonNull
  public final ImageView editBtn;

  private ActivityViewBinding(@NonNull ConstraintLayout rootView, @NonNull TextView activityTitle,
      @NonNull TextView caloriesBurned, @NonNull CheckBox completedCheckbox,
      @NonNull ImageView editBtn) {
    this.rootView = rootView;
    this.activityTitle = activityTitle;
    this.caloriesBurned = caloriesBurned;
    this.completedCheckbox = completedCheckbox;
    this.editBtn = editBtn;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityViewBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityViewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_view, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityViewBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.activityTitle;
      TextView activityTitle = ViewBindings.findChildViewById(rootView, id);
      if (activityTitle == null) {
        break missingId;
      }

      id = R.id.caloriesBurned;
      TextView caloriesBurned = ViewBindings.findChildViewById(rootView, id);
      if (caloriesBurned == null) {
        break missingId;
      }

      id = R.id.completedCheckbox;
      CheckBox completedCheckbox = ViewBindings.findChildViewById(rootView, id);
      if (completedCheckbox == null) {
        break missingId;
      }

      id = R.id.editBtn;
      ImageView editBtn = ViewBindings.findChildViewById(rootView, id);
      if (editBtn == null) {
        break missingId;
      }

      return new ActivityViewBinding((ConstraintLayout) rootView, activityTitle, caloriesBurned,
          completedCheckbox, editBtn);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
