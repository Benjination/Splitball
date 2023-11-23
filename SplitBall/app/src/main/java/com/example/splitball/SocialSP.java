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
        setContentView(R.layout.activity_social_sp);

        Button facebooksp = findViewById(R.id.facebooksp);
        facebooksp.setOnClickListener(v -> {
            openSocialPage("https://www.facebook.com/login");
        });

        Button xsp = findViewById(R.id.xsp);
        xsp.setOnClickListener(v -> {
            openSocialPage("https://www.x.com/login");
        });

        Button googleplay = findViewById(R.id.googleplay);
        googleplay.setOnClickListener(v -> {
            openSocialPage("https://www.play.google.com");
        });

        Button email = findViewById(R.id.email);
        email.setOnClickListener(v -> {
            openSocialPage("https://www.accounts.google.com");
        });

    }
    private void openSocialPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
    }
}