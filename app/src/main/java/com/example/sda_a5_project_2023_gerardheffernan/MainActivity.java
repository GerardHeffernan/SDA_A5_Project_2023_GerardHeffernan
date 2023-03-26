package com.example.sda_a5_project_2023_gerardheffernan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;
/*
Copyright [2023] [Gerard Heffernan]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

 */

/*
The game uses 6 different elements 3 fire, ice, earth, angel, demon and psychic.
You play against an ai and the first to 6 points wins.
The point system is explained below.
FIRE > EARTH
ICE > FIRE
EARTH > ICE
ANGEL > DEMON
DEMON > PSYCHIC
PSYCHIC > ANGEL
FIRE is level DEMON,PSYCHIC & ANGEL
ICE is level DEMON,PSYCHIC & ANGEL
EARTH is level DEMON,PSYCHIC & ANGEL


A strong element win scores 1 point.
Two elements that are level gains a point to the user and the AI.

The below main activity is the home screen of the app.
It is from here a the user can play a game and learn how to play the game.

 */

public class MainActivity extends AppCompatActivity {

    // MediaPlayer object to play intro song
    private MediaPlayer intro;
    int introTheme = R.raw.intro_song;

    private class MyClick implements View.OnClickListener {
        public void onClick(View v) {
            switch(v.getId()){
                // start Battle activity when button is clicked
                case R.id.button:
                    Intent intent = new Intent(MainActivity.this,Battle.class);
                    startActivity(intent);
                    // pause the intro song when starting the Battle activity
                    intro.pause();
                    break;
                // start HowToPlay activity when button is clicked
                case R.id.button2:

                    Intent intent2 = new Intent(MainActivity.this,HowToPlay.class);
                    startActivity(intent2);
            }
        }
    }

    // This method is called when the main activity is first created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Initialize and start the intro song
        intro = MediaPlayer.create(this,introTheme);
        intro.setLooping(true);
        intro.start();

        // Initialize and start the background videos
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

        // linking buttons with MyCLick class
        Button Battle, HowToPlay;

        Battle = findViewById(R.id.button);
        HowToPlay = findViewById(R.id.button2);

        MyClick myClickListener = new MainActivity.MyClick();

        Battle.setOnClickListener(myClickListener);
        HowToPlay.setOnClickListener(myClickListener);

    }

    // This method is called when the Main activity is resumed
    @Override
    public void onResume(){
        super.onResume();
        setContentView(R.layout.activity_main);



        // Initialize and start the background videos
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

        // linking buttons with MyCLick class
        Button Battle, HowToPlay;

        Battle = findViewById(R.id.button);
        HowToPlay = findViewById(R.id.button2);

        MyClick myClickListener = new MainActivity.MyClick();

        Battle.setOnClickListener(myClickListener);
        HowToPlay.setOnClickListener(myClickListener);

    }
}