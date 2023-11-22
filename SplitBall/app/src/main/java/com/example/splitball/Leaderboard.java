package com.example.splitball;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Leaderboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);

        // Read the CSV file from the raw folder
        InputStream inputStream = getResources().openRawResource(R.raw.leaderboardl);
        List<String> userValue = new ArrayList<String>();
        List<Integer> highScores = new ArrayList<Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String[] usernames = res.getStringArray(R.array.usernames);
        try {
            String csvLine;
            int lineCount = 0;
            while ((csvLine = reader.readLine()) != null && lineCount < 10) {
                String[] row = csvLine.split(",");
                userValue.add(row[0]);
                usernames[lineCount] = userValue.get(lineCount);
                highScores.add(Integer.parseInt(row[1]));
                lineCount++;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


            Button backToMain = findViewById(R.id.backToMain);
            backToMain.setOnClickListener(v -> {
                Intent intent = new Intent(Leaderboard.this, MainMenu.class);
                startActivity(intent);
            });
        }
    }
}