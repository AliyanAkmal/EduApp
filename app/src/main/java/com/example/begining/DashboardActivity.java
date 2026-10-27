package com.example.begining;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        ImageView imgHeaderAvatar = findViewById(R.id.imgHeaderAvatar);
        MaterialCardView cardCourses = findViewById(R.id.cardCourses);
        MaterialCardView cardAssignments = findViewById(R.id.cardAssignments);
        MaterialCardView cardGrades = findViewById(R.id.cardGrades);
        MaterialCardView cardSchedule = findViewById(R.id.cardSchedule);
        MaterialCardView cardNotifications = findViewById(R.id.cardNotifications);
        MaterialCardView cardProfile = findViewById(R.id.cardProfile);

        imgHeaderAvatar.setOnClickListener(v -> openProfile());
        cardProfile.setOnClickListener(v -> openProfile());

        cardCourses.setOnClickListener(v -> showModuleToast(getString(R.string.module_courses)));
        cardAssignments.setOnClickListener(v -> showModuleToast(getString(R.string.module_assignments)));
        cardGrades.setOnClickListener(v -> showModuleToast(getString(R.string.module_grades)));
        cardSchedule.setOnClickListener(v -> showModuleToast(getString(R.string.module_schedule)));
        cardNotifications.setOnClickListener(v -> showModuleToast(getString(R.string.module_notifications)));
    }

    private void openProfile() {
        Intent intent = new Intent(DashboardActivity.this, ProfileActivity.class);
        startActivity(intent);
    }

    private void showModuleToast(String moduleName) {
        Toast.makeText(this, "Opening " + moduleName + "...", Toast.LENGTH_SHORT).show();
    }
}
