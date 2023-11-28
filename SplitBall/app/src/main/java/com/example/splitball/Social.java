package com.example.splitball;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

public class Social extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social);

        Button facebook = findViewById(R.id.facebook);
        facebook.setOnClickListener(v -> openLoginUrl("https://www.facebook.com/login"));

        Button x = findViewById(R.id.x);
        x.setOnClickListener(v -> openLoginUrl("https://www.x.com/login"));

        Button googleplay = findViewById(R.id.googleplay);
        googleplay.setOnClickListener(v -> openLoginUrl("https://accounts.google.com/InteractiveLogin"));

        Button email = findViewById(R.id.email);
        email.setOnClickListener(v -> openLoginUrl("https://accounts.google.com/InteractiveLogin"));

        Button backToMain = findViewById(R.id.backToMain);
        backToMain.setOnClickListener(v -> {
            Intent intent = new Intent(Social.this, MainMenu.class);
            startActivity(intent);
        });
    }

    private void openLoginUrl(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        if (intent != null && Intent.ACTION_VIEW.equals(intent.getAction())) {
            Uri data = intent.getData();
            if (data != null && data.toString().contains("yourappscheme://success_login")) {
                Intent gameIntent = new Intent(Social.this, Classroom.class);
                startActivity(gameIntent);
            }
        }
    }
}