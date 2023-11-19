package com.example.splitball;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class LanguagesSP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_languages_sp);


        Button english = findViewById(R.id.Ingles);

        english.setOnClickListener(v -> {
            Intent intent = new Intent(LanguagesSP.this, MainMenu.class);
            startActivity(intent);
        });
        Button spanish = findViewById(R.id.Espanol);

        spanish.setOnClickListener(v -> {
            Intent intent = new Intent(LanguagesSP.this, MainMenuSP.class);
            startActivity(intent);
        });
        Button backToMain = findViewById(R.id.MenuSP);

        backToMain.setOnClickListener(v -> {
            Intent intent = new Intent(LanguagesSP.this, MainMenuSP.class);
            startActivity(intent);
        });
    }
}