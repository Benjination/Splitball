package com.example.splitball;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MuteSP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mute_sp);

        Button backToMain = findViewById(R.id.backToMainSP);

        backToMain.setOnClickListener(v -> {
            Intent intent = new Intent(MuteSP.this, MainMenuSP.class);
            startActivity(intent);
        });
    }
}