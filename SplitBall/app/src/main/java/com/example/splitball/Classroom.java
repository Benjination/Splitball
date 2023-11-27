package com.example.splitball;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Classroom extends AppCompatActivity {

    long[] score = new long[1];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classroom);

        score[0] = 0;

        Button pause = findViewById(R.id.pause);
        ImageView paperball, airplane, star, kunai;
        paperball = findViewById(R.id.paperball);
        airplane = findViewById(R.id.airplane);
        star = findViewById(R.id.star);
        kunai = findViewById(R.id.kunai);



        int lives = 3;
        int[]  ammoNum = new int[4];
        ammoNum[0] = 0;  //paperball
        ammoNum[1] = 1;  //airplane
        ammoNum[2] = 2;  //star
        ammoNum[3] = 3;  //kunai


        TextView scoreView = findViewById(R.id.score);
        scoreView.setText("SCORE: " + score[0]);
        TextView ammoPaper = findViewById(R.id.ammoNumP);
        ammoPaper.setText("X " + ammoNum[0]);
        TextView ammoAirplane = findViewById(R.id.ammoAirplane);
        ammoAirplane.setText("X " + ammoNum[1]);
        TextView ammoStar = findViewById(R.id.ammoStar);
        ammoStar.setText("X " + ammoNum[2]);
        TextView ammoKunai = findViewById(R.id.ammoKunai);
        ammoKunai.setText("X " + ammoNum[3]);

        pause.setOnClickListener(v ->{
            Intent intent = new Intent(Classroom.this, PauseScreen.class);
            startActivity(intent);
        });
        paperball.setOnClickListener(v ->{
           //trigger paperball firing animation
            if(ammoNum[0] != 0) {
                ammoNum[0]--;
                score[0] += 100;
                scoreView.setText("SCORE: " + score[0]);
                ammoPaper.setText("X " + ammoNum[0]);
            }
        });
        airplane.setOnClickListener(v ->{
            //trigger airplane firing animation
            if(ammoNum[1] != 0){
                ammoNum[1]--;
                score[0] += 150;
                scoreView.setText("SCORE: " + score[0]);
                ammoAirplane.setText("X " + ammoNum[1]);
            }
        });
        star.setOnClickListener(v ->{
            //trigger ninja star firing animation
            if(ammoNum[2] != 0) {
                ammoNum[2]--;
                score[0] += 200;
                scoreView.setText("SCORE: " + score[0]);
                ammoStar.setText("X " + ammoNum[2]);
            }
        });
        kunai.setOnClickListener(v ->{
            //trigger kunai firing animation
            if(ammoNum[3] != 0) {
                ammoNum[3]--;
                score[0] += 500;
                scoreView.setText("SCORE: " + score[0]);
                ammoKunai.setText("X " + ammoNum[3]);
            }
        });

        int[] objects = new int[2];
        objects[0] = 1; //balls
        objects[1] = 0; //bombs

        ImageView[] ball = new ImageView[22];
                ball[0]= findViewById(R.id.ball0);
                ball[1] = findViewById(R.id.ball1);
                ball[2] = findViewById(R.id.ball2);
                ball[3] = findViewById(R.id.ball3);

        for (int i = 0; i < 4; i++) {
            ball[i].setVisibility(View.INVISIBLE);
        }
        ball[0].setVisibility(View.VISIBLE);

        ball[0].setOnClickListener(v -> {
            if(objects[0] + objects[1] < 4)
            {
                Random random = new Random();
                int marginTop = random.nextInt(908 - 532 + 1) + 532; // Random margin top between 532 and 908
                int marginStart = random.nextInt(540 - 0 + 1);

                ViewGroup.MarginLayoutParams marginParams = (ViewGroup.MarginLayoutParams) ball[objects[0]].getLayoutParams();
                marginParams.setMargins(marginStart, marginTop, 0, 0);
                ball[objects[0]].requestLayout();
                int bombChance = random.nextInt(20 + 1);
                if(bombChance > 2)
                    ball[objects[0]].setVisibility(View.VISIBLE);
                else
                    //bomb[objects[1].setVisibility(View.VISIBLE);
                    System.out.println("Do Nothing");

                objects[0]++;
                score[0] += 50;
                scoreView.setText("SCORE: " + score[0]);

            }
            else
            {
                ball[0].setVisibility(View.INVISIBLE);
                score[0] += 50;
                scoreView.setText("SCORE: " + score[0]);
            }
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