package com.example.splitball;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainMenu extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        MediaPlayer musicPlayer = MediaPlayer.create(MainMenu.this, R.raw.dancemusic);
        musicPlayer.start();


        Button settings = findViewById(R.id.settings);

        settings.setOnClickListener(v -> {
            Intent intent = new Intent(MainMenu.this, Settings.class);
            startActivity(intent);
        });

        Button classroom = findViewById(R.id.classroom);
        classroom.setOnClickListener(v -> {
            Intent intent = new Intent(MainMenu.this, Classroom.class);
            startActivity(intent);
        });

        Button leaderboard = findViewById(R.id.leaderboard);
        leaderboard.setOnClickListener(v -> {
            Intent intent = new Intent(MainMenu.this, Leaderboard.class);
            startActivity(intent);
        });

        Button social = findViewById(R.id.social);
        social.setOnClickListener(v -> {
            Intent intent = new Intent(MainMenu.this, Social.class);
            startActivity(intent);
        });
    }
}