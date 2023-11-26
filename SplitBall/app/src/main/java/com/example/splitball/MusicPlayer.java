package com.example.splitball;

import android.content.Context;
import android.media.MediaPlayer;

import androidx.appcompat.app.AppCompatActivity;

public class MusicPlayer extends AppCompatActivity {
    private static MediaPlayer mediaPlayer;

    public void play(Context context, int resId) {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        mediaPlayer = MediaPlayer.create(context, resId);
        mediaPlayer.start();
    }

    public static void stop() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
        mediaPlayer.release();
        mediaPlayer = null;
    }
}