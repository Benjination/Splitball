package com.example.splitball;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LeaderboardG extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboardg);

        // Read the CSV file from the raw folder
        InputStream inputStream = getResources().openRawResource(R.raw.leaderboardg);
        List<String> userValue = new ArrayList<>();
        List<Integer> highScores = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            String csvLine;
            int lineCount = 0;
            while ((csvLine = reader.readLine()) != null && lineCount < 10) {
                String[] row = csvLine.split(",");
                userValue.add(row[0]);
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


            TextView user1 = findViewById(R.id.user1);
            TextView user2 = findViewById(R.id.user2);
            TextView user3 = findViewById(R.id.user3);
            TextView user4 = findViewById(R.id.user4);
            TextView user5 = findViewById(R.id.user5);
            TextView user6 = findViewById(R.id.user6);
            TextView user7 = findViewById(R.id.user7);
            TextView user8 = findViewById(R.id.user8);
            TextView user9 = findViewById(R.id.user9);
            TextView user10 = findViewById(R.id.user10);
            user1.setText("1. " + userValue.get(0) + ": " + highScores.get(0));
            user2.setText("2. " + userValue.get(1) + ": " + highScores.get(1));
            user3.setText("3. " + userValue.get(2) + ": " + highScores.get(2));
            user4.setText("4. " + userValue.get(3) + ": " + highScores.get(3));
            user5.setText("5. " + userValue.get(4) + ": " + highScores.get(4));
            user6.setText("6. " + userValue.get(5) + ": " + highScores.get(5));
            user7.setText("7. " + userValue.get(6) + ": " + highScores.get(6));
            user8.setText("8. " + userValue.get(7) + ": " + highScores.get(7));
            user9.setText("9. " + userValue.get(8) + ": " + highScores.get(8));
            user10.setText("10. " + userValue.get(9) + ": " + highScores.get(9));




            Button backToMain = findViewById(R.id.backToMain);
            backToMain.setOnClickListener(v -> {
                Intent intent = new Intent(LeaderboardG.this, MainMenu.class);
                startActivity(intent);
            });
            Button local = findViewById(R.id.local);
            local.setOnClickListener(v -> {
                Intent intent = new Intent(LeaderboardG.this, Leaderboard.class);
                startActivity(intent);
            });
            Button friends = findViewById(R.id.friends);
            friends.setOnClickListener(v -> {
                Intent intent = new Intent(LeaderboardG.this, LeaderboardF.class);
                startActivity(intent);
            });
        }
    }
}