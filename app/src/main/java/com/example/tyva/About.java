package com.example.tyva;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.IOException;

public class About extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    Button btn_stop, btn_pause;
    ImageButton btn_play;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        mediaPlayer = MediaPlayer.create(this, R.raw.gimn);

        btn_play = findViewById(R.id.play_btn);
        btn_pause = findViewById(R.id.pause_btn);
        btn_stop = findViewById(R.id.stop_btn);
    }

    public void play(View view){
        mediaPlayer.start();
        //btn_play.setVisibility(View.);
        btn_stop.setEnabled(true);
        btn_pause.setEnabled(true);
    }
    public void pause(View view){
        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }

       // btn_play.setEnabled(true);
    }
    public void stop(View view){
        if(mediaPlayer.isPlaying()){
            stopPlay();
        }
    }
    private void stopPlay(){
        mediaPlayer.stop();
        btn_play.setEnabled(true);
        try{
            mediaPlayer.prepare();
            mediaPlayer.seekTo(0);
        } catch (IOException e){
            Toast.makeText(this,"Error!", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        if(mediaPlayer.isPlaying()){
            stopPlay();
        }
    }
    @Override
    public void onPause(){
        super.onPause();
        if(mediaPlayer.isPlaying()){
            stopPlay();
        }
    }
}