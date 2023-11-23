package com.example.splitball;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class GameOver extends AppCompatActivity {
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameover);

        Button backToMain = findViewById(R.id.backToMain);
        backToMain.setOnClickListener(v -> {
            Intent intent = new Intent(GameOver.this, MainMenu.class);
            startActivity(intent);
        });

        Button exit = findViewById(R.id.exit);
        exit.setOnClickListener(v -> {
            Intent intent = new Intent(GameOver.this, MainMenu.class);
            startActivity(intent);
        });

        Button settings = findViewById(R.id.settings);
        settings.setOnClickListener(v-> {
            Intent intent = new Intent(GameOver.this, Settings.class);
            startActivity(intent);
        });

        Button restart = findViewById(R.id.restart);
        restart.setOnClickListener(v-> {
            Intent intent = new Intent(GameOver.this,Classroom.class);
            startActivity(intent);
        });

        Button leaderboard = findViewById(R.id.leaderboard);
        leaderboard.setOnClickListener(v-> {
            Intent intent = new Intent(GameOver.this, Leaderboard.class);
            startActivity(intent);
        });

        Button share = findViewById(R.id.share);
        share.setOnClickListener(v->{
            Intent intent = new Intent(GameOver.this, Social.class);
            startActivity(intent);
        });
    }
}