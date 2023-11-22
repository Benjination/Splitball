package com.example.splitball;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Classroom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classroom);

        Button pause = findViewById(R.id.pause);

        pause.setOnClickListener(v ->{
                Intent intent = new Intent(Classroom.this, PauseScreen.class);
                startActivity(intent);
            });
    }
}