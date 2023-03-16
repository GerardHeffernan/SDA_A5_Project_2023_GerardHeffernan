package com.example.sda_a5_project_2023_gerardheffernan;

import android.app.MediaRouteButton;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Battle extends AppCompatActivity {
    ImageButton Angel, Demon, Psychic, Ifrit, Shiva, Terra ;
    boolean angelSelected, demonSelected, psychicSelected, ifritSelected, shivaSelected, terraSelected;


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


        Button attackButton;
        Button resetButton;

        Angel = (ImageButton) findViewById(R.id.Angel);
        //Angel.setVisibility(View.VISIBLE);

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


        // initialize button selection variables to false

        angelSelected = false;
        demonSelected = false;
        psychicSelected = false;
        ifritSelected = false;
        shivaSelected = false;
        terraSelected = false;

    }









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
                    if (!angelSelected) {
                        fighter.setText(getString(R.string.Angel));

                        angelSelected = true;
                        Angel.setVisibility(View.INVISIBLE);
                    }
                    break;
                case R.id.Demon:
                    if (!demonSelected) {
                        fighter.setText(getString(R.string.Demon));

                        demonSelected = true;
                        Demon.setVisibility(View.INVISIBLE);
                    }
                    break;
                case R.id.Psychic:

                    if (!psychicSelected) {
                        fighter.setText(getString(R.string.Psychic));

                        psychicSelected = true;
                        Psychic.setVisibility(View.INVISIBLE);
                    }
                    break;
                case R.id.Ifrit:

                    if (!ifritSelected) {
                        fighter.setText(getString(R.string.Ifrit));

                        ifritSelected = true;
                        Ifrit.setVisibility(View.INVISIBLE);
                    }
                    break;
                case R.id.Shiva:

                    if (!shivaSelected) {

                        shivaSelected = true;
                        Shiva.setVisibility(View.INVISIBLE);
                    }


                    break;
                case R.id.Terra:

                    if (!terraSelected) {
                        fighter.setText(getString(R.string.Terra));

                        terraSelected = true;
                        Terra.setVisibility(View.INVISIBLE);
                    }

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
                    Angel.setVisibility(View.VISIBLE);
                    Demon.setVisibility(View.VISIBLE);
                    Psychic.setVisibility(View.VISIBLE);
                    Ifrit.setVisibility(View.VISIBLE);
                    Shiva.setVisibility(View.VISIBLE);
                    Terra.setVisibility(View.VISIBLE);

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


        // list of available cases
        List<Integer> cases = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));


        @Override
        public void onClick(View v) {
            // count is the round, increment with each time fight button is pressed
            ++count;
            TextView cpu = (TextView) findViewById(R.id.computer);
            TextView player = (TextView) findViewById(R.id.user);
            TextView atext = (TextView) findViewById(R.id.angel_textView);
            TextView dtext = (TextView) findViewById(R.id.demon_textView);
            TextView ptext = (TextView) findViewById(R.id.psychic_textView);
            TextView itext = (TextView) findViewById(R.id.ifrit_textView);
            TextView stext = (TextView) findViewById(R.id.shiva_textView);
            TextView ttext = (TextView) findViewById(R.id.terra_textView);

            rounds.setText("Round " + count);


            // randomly pick one of the available cases
            int index = (int) (Math.random() * cases.size());
            int rand = cases.get(index);
            cases.remove(index); // remove the selected case from the list




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


                    cpuselection.setText(getString(R.string.Angel));
                    atext.setVisibility(View.VISIBLE);




                    switch ((String) fighters.getText())

                    {
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
                    cpuselection.setText(getString(R.string.Demon));
                    dtext.setVisibility(View.VISIBLE);





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

                    cpuselection.setText(getString(R.string.Psychic));
                    ptext.setVisibility(View.VISIBLE);




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

                    cpuselection.setText(getString(R.string.Ifrit));
                    itext.setVisibility(View.VISIBLE);



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

                    cpuselection.setText(getString(R.string.Shiva));
                    stext.setVisibility(View.VISIBLE);

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

                    cpuselection.setText(getString(R.string.Terra));
                    ttext.setVisibility(View.VISIBLE);


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
    }