package com.example.splitball;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

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



        int[] lives = new int[1];
        lives[0] = 3;
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

        ImageView[] ball = new ImageView[8];
            ball[0]= findViewById(R.id.ball0);
            ball[1] = findViewById(R.id.ball1);
            ball[2] = findViewById(R.id.ball2);
            ball[3] = findViewById(R.id.ball3);
            ball[4] = findViewById(R.id.ball4);
            ball[5] = findViewById(R.id.ball5);
            ball[6] = findViewById(R.id.ball6);
            ball[7] = findViewById(R.id.ball7);

        ImageView[] bomb = new ImageView[7];
            bomb[0] = findViewById(R.id.bomb0);
            bomb[1] = findViewById(R.id.bomb1);
            bomb[2] = findViewById(R.id.bomb2);
            bomb[3] = findViewById(R.id.bomb3);
            bomb[4] = findViewById(R.id.bomb4);
            bomb[5] = findViewById(R.id.bomb5);
            bomb[6] = findViewById(R.id.bomb6);


        for (int i = 0; i < 8; i++) {
            ball[i].setVisibility(View.INVISIBLE);
        }
        for (int j = 0; j < 7; j++) {
            bomb[j].setVisibility(View.INVISIBLE);
        }
        ball[0].setVisibility(View.VISIBLE);

        Random random = new Random();
        for (int i = 0; i < 8; i++)
        {
            final View currentBall = ball[i];
            ball[i].setOnClickListener(v -> {
                if (objects[0] < 8 && objects[1] < 7) {

                    int marginTop = random.nextInt(908 - 532 + 1) + 532; // Random margin top between 532 and 908
                    int marginStart = random.nextInt(540 - 0 + 1);
                    ViewGroup.MarginLayoutParams marginParams = (ViewGroup.MarginLayoutParams) currentBall.getLayoutParams();
                    marginParams.setMargins(marginStart, marginTop,0, 0);
                    int bombChance = random.nextInt(20);
                    if (bombChance > 1) {
                        float horizontal = random.nextInt(100);
                        horizontal /= 100;
                        float vertical = random.nextInt((59-20) + 20);
                        vertical /= 100;
                        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) currentBall.getLayoutParams();
                        params.horizontalBias = horizontal;
                        params.verticalBias = vertical;
                        currentBall.setLayoutParams(params);
                        //ball[objects[0]].requestLayout();
                        ball[objects[0]].setVisibility(View.VISIBLE);
                        objects[0]++;
                    } else {
                        //marginTop = random.nextInt(908 - 532 + 1) + 532;
                        //marginStart = random.nextInt(540 - 0 + 1);
                        //marginParams = (ViewGroup.MarginLayoutParams) bomb[objects[1]].getLayoutParams();
                        //marginParams.setMargins(marginStart, marginTop, 0, 0);
                        float horizontal = random.nextInt((59-20) + 20);
                        horizontal /= 100;
                        float vertical = random.nextInt(100);
                        vertical /= 100;
                        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) currentBall.getLayoutParams();
                        params.horizontalBias = horizontal;
                        params.verticalBias = vertical;
                        currentBall.setLayoutParams(params);

                        bomb[objects[1]].setVisibility(View.VISIBLE);
                        objects[1]++;
                    }
                    score[0] += 50;
                    scoreView.setText("SCORE: " + score[0]);
                } else {

                    currentBall.setVisibility(View.INVISIBLE);
                    score[0] += 50;
                    scoreView.setText("SCORE: " + score[0]);
                    objects[0]--;
                    if(objects[0] <= 1)
                    {
                        for (int j = 0; j < objects[1]; j++) {
                            score[0] += 100;
                        }
                        objects[0] = 1;
                        objects[1] = 0;
                        for (int k = 0; k < 8; k++) {
                            ball[k].setVisibility(View.INVISIBLE);
                        }
                        for (int j = 0; j < 7; j++) {
                            bomb[j].setVisibility(View.INVISIBLE);
                        }

                        ball[0].setVisibility(View.VISIBLE);
                    }
                    ball[0].setVisibility(View.VISIBLE);
                }
            });
        }
        for (int i = 0; i < 7; i++) {


            bomb[i].setOnClickListener(v -> {

                lives[0]--;
                switch (lives[0]) {
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
                        System.out.println("Lives should not be outside of the range 0-3. An error has occurred.");
                        break;
                }
                for (int k = 0; k < objects[0]; k++) {
                    score[0] -= 50;
                    if (score[0] < 0)
                        score[0] = 0;
                }
                for (int j = 0; j < objects[1]; j++) {
                    score[0] -= 100;
                    if (score[0] < 0)
                        score[0] = 0;
                }
                objects[0] = 1;
                objects[1] = 0;
                for (int k = 0; k < 8; k++) {
                    ball[k].setVisibility(View.INVISIBLE);
                }
                for (int j = 0; j < 7; j++) {
                    bomb[j].setVisibility(View.INVISIBLE);
                }

                ball[0].setVisibility(View.VISIBLE);
                if (objects[0] == 1)
                    ball[0].setVisibility(View.VISIBLE);
                ball[0].setVisibility(View.VISIBLE);
            });
        }
    }

}