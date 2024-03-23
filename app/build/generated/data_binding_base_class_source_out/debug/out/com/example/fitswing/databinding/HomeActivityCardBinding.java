// Generated by view binder compiler. Do not edit!
package com.example.fitswing.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.fitswing.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class HomeActivityCardBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final TextView descriptionTextView1;

  @NonNull
  public final TextView titleTextView1;

  private HomeActivityCardBinding(@NonNull CardView rootView,
      @NonNull TextView descriptionTextView1, @NonNull TextView titleTextView1) {
    this.rootView = rootView;
    this.descriptionTextView1 = descriptionTextView1;
    this.titleTextView1 = titleTextView1;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static HomeActivityCardBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static HomeActivityCardBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.home_activity_card, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static HomeActivityCardBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.descriptionTextView1;
      TextView descriptionTextView1 = ViewBindings.findChildViewById(rootView, id);
      if (descriptionTextView1 == null) {
        break missingId;
      }

      id = R.id.titleTextView1;
      TextView titleTextView1 = ViewBindings.findChildViewById(rootView, id);
      if (titleTextView1 == null) {
        break missingId;
      }

      return new HomeActivityCardBinding((CardView) rootView, descriptionTextView1, titleTextView1);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}