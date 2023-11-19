package com.example.splitball;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainMenuSP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu_sp);

        Button settings = findViewById(R.id.ajustes);

        settings.setOnClickListener(v -> {
            Intent intent = new Intent(MainMenuSP.this, SettingsSP.class);
            startActivity(intent);
        });
        Button classroom = findViewById(R.id.classroomSP);

        classroom.setOnClickListener(v -> {
            Intent intent = new Intent(MainMenuSP.this, Classroom.class);
            startActivity(intent);
        });
        Button leaderboard = findViewById(R.id.leaderboardSP);

        leaderboard.setOnClickListener(v -> {
            Intent intent = new Intent(MainMenuSP.this, LeaderboardSP.class);
            startActivity(intent);
        });
        Button connectToSocial = findViewById(R.id.connectToSocialSP);

        connectToSocial.setOnClickListener(v -> {
            Intent intent = new Intent(MainMenuSP.this, SocialSP.class);
            startActivity(intent);
        });
    }
}