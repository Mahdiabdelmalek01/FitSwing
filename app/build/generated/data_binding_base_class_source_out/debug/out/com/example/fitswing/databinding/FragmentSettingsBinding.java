// Generated by view binder compiler. Do not edit!
package com.example.fitswing.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.fitswing.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentSettingsBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button button;

  @NonNull
  public final CardView cardView;

  @NonNull
  public final Switch darkModeSwitch;

  @NonNull
  public final TextView darkModeTextView;

  @NonNull
  public final Switch notificationSwitch;

  @NonNull
  public final TextView notificationTextView;

  @NonNull
  public final TextView settingsTextView;

  @NonNull
  public final TextView settingsTextView2;

  @NonNull
  public final TextView settingsTitleTextView;

  @NonNull
  public final CardView userName;

  @NonNull
  public final ImageView userPhotoImageView;

  @NonNull
  public final TextView userTextView2;

  @NonNull
  public final TextView usernameTextView;

  private FragmentSettingsBinding(@NonNull ConstraintLayout rootView, @NonNull Button button,
      @NonNull CardView cardView, @NonNull Switch darkModeSwitch,
      @NonNull TextView darkModeTextView, @NonNull Switch notificationSwitch,
      @NonNull TextView notificationTextView, @NonNull TextView settingsTextView,
      @NonNull TextView settingsTextView2, @NonNull TextView settingsTitleTextView,
      @NonNull CardView userName, @NonNull ImageView userPhotoImageView,
      @NonNull TextView userTextView2, @NonNull TextView usernameTextView) {
    this.rootView = rootView;
    this.button = button;
    this.cardView = cardView;
    this.darkModeSwitch = darkModeSwitch;
    this.darkModeTextView = darkModeTextView;
    this.notificationSwitch = notificationSwitch;
    this.notificationTextView = notificationTextView;
    this.settingsTextView = settingsTextView;
    this.settingsTextView2 = settingsTextView2;
    this.settingsTitleTextView = settingsTitleTextView;
    this.userName = userName;
    this.userPhotoImageView = userPhotoImageView;
    this.userTextView2 = userTextView2;
    this.usernameTextView = usernameTextView;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentSettingsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentSettingsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_settings, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentSettingsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button;
      Button button = ViewBindings.findChildViewById(rootView, id);
      if (button == null) {
        break missingId;
      }

      id = R.id.cardView;
      CardView cardView = ViewBindings.findChildViewById(rootView, id);
      if (cardView == null) {
        break missingId;
      }

      id = R.id.darkModeSwitch;
      Switch darkModeSwitch = ViewBindings.findChildViewById(rootView, id);
      if (darkModeSwitch == null) {
        break missingId;
      }

      id = R.id.darkModeTextView;
      TextView darkModeTextView = ViewBindings.findChildViewById(rootView, id);
      if (darkModeTextView == null) {
        break missingId;
      }

      id = R.id.notificationSwitch;
      Switch notificationSwitch = ViewBindings.findChildViewById(rootView, id);
      if (notificationSwitch == null) {
        break missingId;
      }

      id = R.id.notificationTextView;
      TextView notificationTextView = ViewBindings.findChildViewById(rootView, id);
      if (notificationTextView == null) {
        break missingId;
      }

      id = R.id.settingsTextView;
      TextView settingsTextView = ViewBindings.findChildViewById(rootView, id);
      if (settingsTextView == null) {
        break missingId;
      }

      id = R.id.settingsTextView2;
      TextView settingsTextView2 = ViewBindings.findChildViewById(rootView, id);
      if (settingsTextView2 == null) {
        break missingId;
      }

      id = R.id.settingsTitleTextView;
      TextView settingsTitleTextView = ViewBindings.findChildViewById(rootView, id);
      if (settingsTitleTextView == null) {
        break missingId;
      }

      id = R.id.user_name;
      CardView userName = ViewBindings.findChildViewById(rootView, id);
      if (userName == null) {
        break missingId;
      }

      id = R.id.userPhotoImageView;
      ImageView userPhotoImageView = ViewBindings.findChildViewById(rootView, id);
      if (userPhotoImageView == null) {
        break missingId;
      }

      id = R.id.userTextView2;
      TextView userTextView2 = ViewBindings.findChildViewById(rootView, id);
      if (userTextView2 == null) {
        break missingId;
      }

      id = R.id.usernameTextView;
      TextView usernameTextView = ViewBindings.findChildViewById(rootView, id);
      if (usernameTextView == null) {
        break missingId;
      }

      return new FragmentSettingsBinding((ConstraintLayout) rootView, button, cardView,
          darkModeSwitch, darkModeTextView, notificationSwitch, notificationTextView,
          settingsTextView, settingsTextView2, settingsTitleTextView, userName, userPhotoImageView,
          userTextView2, usernameTextView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
