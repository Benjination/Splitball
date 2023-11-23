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

        Button resume = findViewById(R.id.resume);
        resume.setOnClickListener(v ->{
            Intent intent = new Intent(PauseScreen.this, Classroom.class);
            startActivity(intent);
        });

        Button backToMain = findViewById(R.id.backToMain);
        backToMain.setOnClickListener(v -> {
            Intent intent = new Intent(PauseScreen.this, MainMenu.class);
            startActivity(intent);
        });

        Button exit = findViewById(R.id.exit);
        exit.setOnClickListener(v -> {
            Intent intent = new Intent(PauseScreen.this, MainMenu.class);
            startActivity(intent);
        });

        Button settings = findViewById(R.id.settings);
        settings.setOnClickListener(v-> {
            Intent intent = new Intent(PauseScreen.this, Settings.class);
            startActivity(intent);
        });

        Button restart = findViewById(R.id.restart);
        restart.setOnClickListener(v-> {
            Intent intent = new Intent(PauseScreen.this,Classroom.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });
    }
}