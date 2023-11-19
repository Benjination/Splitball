package com.example.splitball;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Languages extends AppCompatActivity {


    //Language options will be saved to user as 0 for English, 1 for Spanish
    //As more languages are added, they will be given values 2,3,4...

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_languages);

        Button english = findViewById(R.id.English);

        english.setOnClickListener(v -> {
            Intent intent = new Intent(Languages.this, MainMenu.class);
            startActivity(intent);
        });
        Button spanish = findViewById(R.id.Spanish);

        spanish.setOnClickListener(v -> {
            Intent intent = new Intent(Languages.this, MainMenuSP.class);
            startActivity(intent);
        });
        Button backToMain = findViewById(R.id.English);

        backToMain.setOnClickListener(v -> {
            Intent intent = new Intent(Languages.this, MainMenu.class);
            startActivity(intent);
        });
    }


}