package com.example.splitball;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class PauseScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pause_screen);

        Button backToMain = findViewById(R.id.backToMain);
        backToMain.setOnClickListener(v -> {
            Intent intent = new Intent(PauseScreen.this, MainMenu.class);
            startActivity(intent);
        });
        //settings, exit, resume, restart
        //Button restartButton = findViewById(R.id.restartButton);
        //Button exitButton = findViewById(R.id.exitButton);
        //Button resumeButton = findViewById(R.id.resumeButton);
    }
}