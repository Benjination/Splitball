package com.example.splitball;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainMenu extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        //MusicPlayer musicPlayer = new MusicPlayer();

        // Play music
        //musicPlayer.play(this, R.raw.dancemusic);

        // Stop music
        //Add if mute = 1
        //musicPlayer.stop();

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