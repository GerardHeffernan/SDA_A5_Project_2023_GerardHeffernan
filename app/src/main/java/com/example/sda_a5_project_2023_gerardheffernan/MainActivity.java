package com.example.sda_a5_project_2023_gerardheffernan;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer intro;
    int introTheme = R.raw.intro_song;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intro = MediaPlayer.create(this,introTheme);
        intro.setLooping(true);
        intro.start();


        VideoView videoView = findViewById(R.id.videoView);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.nebula;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        VideoView videoView2 = findViewById(R.id.videoView2);
        String videoPath2 = "android.resource://" + getPackageName() + "/" + R.raw.snow_girl;
        Uri uri2 = Uri.parse(videoPath2);
        videoView2.setVideoURI(uri2);

        VideoView videoView3 = findViewById(R.id.videoView3);
        String videoPath3 = "android.resource://" + getPackageName() + "/" + R.raw.fw;
        Uri uri3 = Uri.parse(videoPath3);
        videoView3.setVideoURI(uri3);

        videoView.setOnPreparedListener(mediaPlayer -> mediaPlayer.setLooping(true));
        videoView.start();

        videoView2.setOnPreparedListener(mediaPlayer -> mediaPlayer.setLooping(true));
        videoView2.start();

        videoView3.setOnPreparedListener(mediaPlayer -> mediaPlayer.setLooping(true));
        videoView3.start();


    }
}