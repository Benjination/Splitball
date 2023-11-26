package com.example.splitball;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Classroom extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classroom);

        Button pause = findViewById(R.id.pause);

        int ammoNumP =0, ammoNumA=1, ammoNumS=2, ammoNumK=3, lives=3;
        double highScore = 0;

        TextView ammoPaper = findViewById(R.id.ammoNumP);
        ammoPaper.setText("X " + ammoNumP);
        TextView ammoAirplane = findViewById(R.id.ammoAirplane);
        ammoAirplane.setText("X " + ammoNumA);
        TextView ammoStar = findViewById(R.id.ammoStar);
        ammoStar.setText("X " + ammoNumS);
        TextView ammoKunai = findViewById(R.id.ammoKunai);
        ammoKunai.setText("X " + ammoNumK);

        pause.setOnClickListener(v ->{
            Intent intent = new Intent(Classroom.this, PauseScreen.class);
            startActivity(intent);
        });




    }
    public void BombIsPressed(int lives) {
        // Lives will need to be reduced by one inside the button click that activates function. lives--;
        switch (lives) {
            case 2:
                ImageView heart3 = findViewById(R.id.heart3);
                heart3.setVisibility(View.INVISIBLE);
                break;
            case 1:
                ImageView heart2 = findViewById(R.id.heart2);
                heart2.setVisibility(View.INVISIBLE);
                break;
            case 0:
                ImageView heart1 = findViewById(R.id.heart1);
                heart1.setVisibility(View.INVISIBLE);
                //if (playerLosesGameConditionMet) {
                Intent intent = new Intent(Classroom.this, GameOver.class);
                startActivity(intent);
                // Finish the current activity to prevent going back to the game
                //finish();
                break;
            default:
                System.out.println("Lives should not be outside of the range 0-3. An error has occured.");
                break;
        }

    }
}