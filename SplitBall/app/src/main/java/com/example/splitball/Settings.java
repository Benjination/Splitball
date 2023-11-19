package com.example.splitball;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Settings extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Button languages = findViewById(R.id.languages);

        languages.setOnClickListener(v -> {
            Intent intent = new Intent(Settings.this, Languages.class);
            startActivity(intent);
        });
        Button muteUnmute = findViewById(R.id.muteUnmute);

        muteUnmute.setOnClickListener(v -> {
            Intent intent = new Intent(Settings.this, Mute.class);
            startActivity(intent);
        });
        Button sfx = findViewById(R.id.sfxVolume);

        sfx.setOnClickListener(v -> {
            Intent intent = new Intent(Settings.this, SFX.class);
            startActivity(intent);
        });
        Button music = findViewById(R.id.musicVolume);

        music.setOnClickListener(v -> {
            Intent intent = new Intent(Settings.this, Music.class);
            startActivity(intent);
        });
        Button backToMain = findViewById(R.id.backToMain);
        backToMain.setOnClickListener(v -> {
            Intent intent = new Intent(Settings.this, MainMenu.class);
            startActivity(intent);
        });
    }
}