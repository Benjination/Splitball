package com.example.splitball;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class SettingsSP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_sp);

        Button languages = findViewById(R.id.languagesSP);

        languages.setOnClickListener(v -> {
            Intent intent = new Intent(SettingsSP.this, LanguagesSP.class);
            startActivity(intent);
        });
        Button muteUnmute = findViewById(R.id.muteUnmuteSP);

        muteUnmute.setOnClickListener(v -> {
            Intent intent = new Intent(SettingsSP.this, MuteSP.class);
            startActivity(intent);
        });
        Button sfx = findViewById(R.id.sfxVolumeSP);

        sfx.setOnClickListener(v -> {
            Intent intent = new Intent(SettingsSP.this, SFXSP.class);
            startActivity(intent);
        });
        Button music = findViewById(R.id.musicVolumeSP);

        music.setOnClickListener(v -> {
            Intent intent = new Intent(SettingsSP.this, MusicSP.class);
            startActivity(intent);
        });
    }
}