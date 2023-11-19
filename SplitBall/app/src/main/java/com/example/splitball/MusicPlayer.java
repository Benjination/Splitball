package com.example.splitball;

import android.content.Context;
import android.media.MediaPlayer;

public class MusicPlayer {
    private static MediaPlayer mediaPlayer;

    public static void play(Context context, int resId) {
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        mediaPlayer = MediaPlayer.create(context, resId);
        mediaPlayer.start();
    }

    public static void stop() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}