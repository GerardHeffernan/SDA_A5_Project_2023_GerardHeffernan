package com.example.sda_a5_project_2023_gerardheffernan;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import static com.example.sda_a5_project_2023_gerardheffernan.R.string.Angel;
import static com.example.sda_a5_project_2023_gerardheffernan.R.string.Demon;
import static com.example.sda_a5_project_2023_gerardheffernan.R.string.Psychic;
import static com.example.sda_a5_project_2023_gerardheffernan.R.string.Ifrit;
import static com.example.sda_a5_project_2023_gerardheffernan.R.string.Shiva;
import static com.example.sda_a5_project_2023_gerardheffernan.R.string.Terra;

public class Battle extends AppCompatActivity {

    private MediaPlayer battleMusic;
    int battleTheme = R.raw.orchestra;

    private int count  = 0;
    private int aiWins = 0;
    private int playerWins = 0;

    private class MyClick implements View.OnClickListener {
        public void onClick(View v) {
            TextView fighter = (TextView) findViewById(R.id.PlayerCardUsed);
            TextView rounds = (TextView) findViewById(R.id.Round);
            TextView cpu = (TextView) findViewById(R.id.computer);
            TextView player = (TextView) findViewById(R.id.user);
            // depending on image button chosen, populate textview descritpion
            switch(v.getId()){
                case R.id.Angel:
                    fighter.setText(getResources().getString(Angel));
                    break;
                case R.id.Demon:
                    fighter.setText(getResources().getString(Demon));
                    break;
                case R.id.Psychic:
                    fighter.setText(getResources().getString(Psychic));
                    break;
                case R.id.Ifrit:
                    fighter.setText(getResources().getString(Ifrit));
                    break;
                case R.id.Shiva:
                    fighter.setText(getResources().getString(Shiva));
                    break;
                case R.id.Terra:
                    fighter.setText(getResources().getString(Terra));
                    break;
                case R.id.resetButton:
                    // whenever reset is clicked, reset round and score data
                    fighter.setText("");
                    count = 0;
                    playerWins = 0;
                    aiWins = 0;
                    rounds.setText("Round");
                    cpu.setText("Computer " + Integer.toString(aiWins));
                    player.setText("Player " + Integer.toString(playerWins));
                    break;
                case R.id.attackButton:
                    if (fighter.getText().equals("")){
                        fighter.setText("\n *Choose a character first");
                    }
            }
        }
    }

    // fight button actions
    private class FightClick implements View.OnClickListener {
        TextView fighters = (TextView) findViewById(R.id.PlayerCardUsed);
        TextView rounds = (TextView) findViewById(R.id.Round);
        ImageButton cpuAnimon = (ImageButton) findViewById(R.id.aiCard);
        TextView cpuselection = (TextView) findViewById(R.id.AICard);

        @Override
        public void onClick(View v) {
            // count is the round, increment with each time fight button is pressed
            ++count;
            TextView cpu = (TextView) findViewById(R.id.computer);
            TextView player = (TextView) findViewById(R.id.user);

            rounds.setText("Round " + count);

            // randomly pick one of the 6 characters
            int rand = (int) (Math.random() * 6 + 1);

             /*
            selection is based on the following criterion:
            1 is angel
            2 is
            3 is
            4 is
            5 is
            6 is
            */

            switch (rand) {
                case 1:
                    cpuAnimon.setImageResource(R.drawable.angel);
                    cpuselection.setText(getResources().getString(Angel));
                    switch ((String) fighters.getText()) {
                        case "Angel":
                            playerWins++;
                            aiWins++;
                            break;
                        case "Devil":
                            aiWins++;
                            break;
                        case "Psychic":
                            playerWins++;
                            break;
                        case "Ifrit":
                            aiWins++;
                            playerWins++;
                            break;
                        case "Shiva":
                            playerWins++;
                            aiWins++;
                            break;
                        case "Terra":
                            playerWins++;
                            aiWins++;
                            break;
                    }
                    break;
                case 2:
                    cpuAnimon.setImageResource(R.drawable.deamon_woman);
                    cpuselection.setText(getResources().getString(Demon));
                    switch ((String) fighters.getText()) {
                        case "Angel":
                            playerWins++;
                            break;
                        case "Devil":
                            aiWins++;
                            playerWins++;
                            break;
                        case "Psychic":
                            aiWins++;
                            break;
                        case "Ifrit":
                            aiWins++;
                            playerWins++;
                            break;
                        case "Shiva":
                            playerWins++;
                            aiWins++;
                            break;
                        case "Terra":
                            playerWins++;
                            aiWins++;
                            break;
                    }
                    break;
                case 3:
                    cpuAnimon.setImageResource(R.drawable.psychic);
                    cpuselection.setText(getResources().getString(Psychic));
                    switch ((String) fighters.getText()) {
                        case "Angel":
                            aiWins++;
                            break;
                        case "Devil":
                            playerWins++;
                            break;
                        case "Psychic":
                            aiWins++;
                            playerWins++;
                            break;
                        case "Ifrit":
                            aiWins++;
                            playerWins++;
                            break;
                        case "Shiva":
                            playerWins++;
                            aiWins++;
                            break;
                        case "Terra":
                            playerWins++;
                            aiWins++;
                            break;
                    }
                    break;
                case 4:
                    cpuAnimon.setImageResource(R.drawable.flame);
                    cpuselection.setText(getResources().getString(Ifrit));
                    switch ((String) fighters.getText()) {
                        case "Angel":
                            aiWins++;
                            playerWins++;
                            break;
                        case "Devil":
                            aiWins++;
                            playerWins++;
                            break;
                        case "Psychic":
                            aiWins++;
                            playerWins++;
                            break;
                        case "Ifrit":
                            aiWins++;
                            playerWins++;
                            break;
                        case "Shiva":
                            playerWins++;
                            break;
                        case "Terra":
                            aiWins++;
                            break;
                    }
                    break;
                case 5:
                    cpuAnimon.setImageResource(R.drawable.snow_woman);
                    cpuselection.setText(getResources().getString(Shiva));
                    switch ((String) fighters.getText()) {
                        case "Angel":
                            aiWins++;
                            playerWins++;
                            break;
                        case "Devil":
                            aiWins++;
                            playerWins++;
                            break;
                        case "Psychic":
                            aiWins++;
                            playerWins++;
                            break;
                        case "Ifrit":
                            aiWins++;
                            break;
                        case "Shiva":
                            playerWins++;
                            aiWins++;
                            break;
                        case "Terra":
                            playerWins++;
                            break;
                    }
                    break;
                case 6:
                    cpuAnimon.setImageResource(R.drawable.leaf);
                    cpuselection.setText(getResources().getString(Terra));
                    switch ((String) fighters.getText()) {
                        case "Angel":
                            aiWins++;
                            playerWins++;
                            break;
                        case "Devil":
                            aiWins++;
                            playerWins++;
                            break;
                        case "Psychic":
                            aiWins++;
                            playerWins++;
                            break;
                        case "Ifrit":
                            playerWins++;
                            break;
                        case "Shiva":
                            aiWins++;
                            break;
                        case "Terra":
                            aiWins++;
                            playerWins++;
                            break;
                    }
            }
            // display user and computer scores
            cpu.setText("Computer: " + Integer.toString(aiWins));
            player.setText("Player: " + Integer.toString(playerWins));

            // if 6 rounds have elapsed, determine the winner
            if (count == 6 && !fighters.getText().equals("")) {
                Intent intent = new Intent(Battle.this,BattleResult.class);
                battleMusic.pause();
                if (playerWins > aiWins) {
                    intent.putExtra("result", "win");

                } else if (playerWins < aiWins) {
                    intent.putExtra("result", "loss");
                } else if (playerWins == aiWins) {
                    intent.putExtra("result", "draw");
                }
                startActivity(intent);
                battleMusic.release();

            }
        }
    }
            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.battle);
                getSupportActionBar().setDisplayShowTitleEnabled(false);
                if (getSupportActionBar() != null) {
                    getSupportActionBar().hide();
                }



                battleMusic = MediaPlayer.create(this, battleTheme);
                battleMusic.setLooping(true);
                battleMusic.start();



            // linking various buttons to implementation classes
            TextView rounds = (TextView) findViewById(R.id.Round);
            rounds.setText("Round");

            ImageButton Angel, Demon, Psychic, Ifrit, Shiva, Terra ;
            Button attackButton;
            Button resetButton;

            Angel = (ImageButton) findViewById(R.id.Angel);
            Demon = (ImageButton) findViewById(R.id.Demon);
            Psychic = (ImageButton) findViewById(R.id.Psychic);
            Ifrit = (ImageButton) findViewById(R.id.Ifrit);
            Shiva = (ImageButton) findViewById(R.id.Shiva);
            Terra = (ImageButton) findViewById(R.id.Terra);
            attackButton = (Button) findViewById(R.id.attackButton);
            resetButton = (Button) findViewById(R.id.resetButton);

            Battle.MyClick myClickListener = new Battle.MyClick();
            Battle.FightClick fightListener = new Battle.FightClick();

            Angel.setOnClickListener(myClickListener);
            Demon.setOnClickListener(myClickListener);
            Psychic.setOnClickListener(myClickListener);
            Ifrit.setOnClickListener(myClickListener);
            Shiva.setOnClickListener(myClickListener);
            Terra.setOnClickListener(myClickListener);
            resetButton.setOnClickListener(myClickListener);
            attackButton.setOnClickListener(fightListener);
        }
    }