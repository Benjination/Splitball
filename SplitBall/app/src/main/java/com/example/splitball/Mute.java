package com.example.splitball;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Mute extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mute);

        Button backToMain = findViewById(R.id.backToMain);

        backToMain.setOnClickListener(v -> {
            Intent intent = new Intent(Mute.this, MainMenu.class);
            startActivity(intent);
        });
    }
}