package com.example.sda_a5_project_2023_gerardheffernan;

import static com.example.sda_a5_project_2023_gerardheffernan.R.string.draw;
import static com.example.sda_a5_project_2023_gerardheffernan.R.string.lost;
import static com.example.sda_a5_project_2023_gerardheffernan.R.string.win;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class BattleResult extends AppCompatActivity {

    EditText userNameEdit;
    Button playAgain, howToPlay, saveData, resetData;
    CheckBox checkBox;
    String uName;
    String userName;
    SharedPreferences sp;
    private MediaPlayer outro;
    int winTheme = R.raw.win_music;
    int lostTheme = R.raw.lost_music;
    int drawTheme = R.raw.piano_draw;

    private DatabaseReference userResults;


    private class MyClick implements View.OnClickListener {
        public void onClick(View v) {


            switch (v.getId()) {
                // start specified activity based on button pressed
                case R.id.playAgain:
                    Intent intent = new Intent(BattleResult.this, Battle.class);
                    startActivity(intent);
                    outro.pause();

                    break;
                case R.id.howToPlay:

                    Intent intent2 = new Intent(BattleResult.this, HowToPlay.class);
                    startActivity(intent2);
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.battle_result);
        getSupportActionBar().setDisplayShowTitleEnabled(false);



        playAgain = findViewById(R.id.playAgain);
        howToPlay = findViewById(R.id.howToPlay);

        BattleResult.MyClick myClickListener = new BattleResult.MyClick();
        playAgain.setOnClickListener(myClickListener);
        howToPlay.setOnClickListener(myClickListener);


        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        userNameEdit = findViewById(R.id.editname);


        saveData = findViewById(R.id.saveButton);
        resetData = findViewById(R.id.rData);
        checkBox = findViewById(R.id.checkBox);

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        String st1 = prefs.getString("N", "");
        userNameEdit.setText(st1);
        checkBox.setOnClickListener(v -> {

                    if (checkBox.isChecked()) {
                        //Save the UserId
                        uName = userNameEdit.getText().toString();

                        editor.putString("N", uName);

                        editor.commit();
                        Log.d("Test 1", "onClick: ");

                    } else {
                        editor.putString("I", "");
                        editor.putString("E", "");
                        editor.putString("B", "");
                        Log.d("Test 2", "onClick: ");

                    }
                }
        );
        resetData.setOnClickListener(v -> {
            Log.d("Test 3", "onClick: Cleared");
            userNameEdit.getText().clear();
            prefs.edit().clear().apply();
        });

        int playerWins = 0;
        // access data from intetn that was passed on to this activity
        String result = getIntent().getExtras().getString("result");
        TextView resultView = (TextView) findViewById(R.id.textView4);


        // store image view source as variable for manipulation based on outcome


        // if win, loss, or tie, execute the following instructions
        switch (result) {
            case "win":
                resultView.setText(getResources().getString(win));
                outro = MediaPlayer.create(this, winTheme);
                outro.setLooping(true);
                outro.start();

                break;
            case "loss":
                resultView.setText(getResources().getString(lost));
                outro = MediaPlayer.create(this, lostTheme);
                outro.setLooping(true);
                outro.start();

                break;
            case "draw":
                resultView.setText(getResources().getString(draw));
                outro = MediaPlayer.create(this, drawTheme);
                outro.setLooping(true);
                outro.start();

                break;
        }


        saveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // save data to firebase

                //FirebaseDatabase database = FirebaseDatabase.getInstance("https://sda-project-5-default-rtdb.europe-west1.firebasedatabase.app/");
                //DatabaseReference myRef = database.getReference().child("ABC");
                //myRef.setValue("try");

               FirebaseDatabase userResults = FirebaseDatabase.getInstance();
               DatabaseReference myRef = userResults.getReference("result");




               myRef.setValue(result);



               System.out.println("button pressed");
//                myRef.setValue("Hello, World!");
               // System.out.println("aaaaaa");
              //  userResults = FirebaseDatabase.getInstance().getReference().child("result");
                     //       userResults.child("result").child(result).setValue(result);

                        }
                    });

    }
}

