package com.example.sda_a5_project_2023_gerardheffernan;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Thia ia the battle activity where a user plays against an AI.
 */

public class Battle extends AppCompatActivity {

    // variables to keep track of whether certain fighters have been selected or not
    boolean angelUsed = false;
    boolean demonUsed = false;
    boolean psychicUsed = false;
    boolean ifritUsed = false;
    boolean shivaUsed = false;
    boolean terraUsed = false;


    // variables to reference the ImageButton views for each fighter
    ImageButton Angel, Demon, Psychic, Ifrit, Shiva, Terra;
    // variables to keep track of which fighter has been selected
    boolean angelSelected, demonSelected, psychicSelected, ifritSelected, shivaSelected, terraSelected;
    // variable to store the id of the background music for the battle
    int battleTheme = R.raw.orchestra;
    // variables to control the background music


    private MediaPlayer battleMusic;
    // variables to keep track of the number of rounds won by the AI and the player
    private int count = 0;
    private int aiWins = 0;
    private int playerWins = 0;

    // variable to keep track of whether a fighter has been selected or not
    private boolean fighterSelected = false;

    // This method is called when the activity is created
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // Set the layout of the activity to battle.xml
        setContentView(R.layout.battle);
       // Hide the title bar
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
       // Load and start playing the background music for the battle
        battleMusic = MediaPlayer.create(this, battleTheme);
        battleMusic.setLooping(true);
        battleMusic.start();
       // Initialize variables to reference various UI elements
        TextView rounds = findViewById(R.id.Round);
        rounds.setText("Round");
        Button attackButton;
        Angel = findViewById(R.id.Angel);
        Demon = findViewById(R.id.Demon);
        Psychic = findViewById(R.id.Psychic);
        Ifrit = findViewById(R.id.Ifrit);
        Shiva = findViewById(R.id.Shiva);
        Terra = findViewById(R.id.Terra);
        attackButton = findViewById(R.id.attackButton);

       // Create instances of the MyClick and FightClick classes
        Battle.MyClick myClickListener = new Battle.MyClick();
        Battle.FightClick fightListener = new Battle.FightClick();

       // Set the onClickListener for each ImageButton view to myClickListener
        Angel.setOnClickListener(myClickListener);
        Demon.setOnClickListener(myClickListener);
        Psychic.setOnClickListener(myClickListener);
        Ifrit.setOnClickListener(myClickListener);
        Shiva.setOnClickListener(myClickListener);
        Terra.setOnClickListener(myClickListener);

       // Set the onClickListener for the attack button to fightListener
        attackButton.setOnClickListener(fightListener);


       // Initialize all of the fighter selection variables to false
        angelSelected = false;
        demonSelected = false;
        psychicSelected = false;
        ifritSelected = false;
        shivaSelected = false;
        terraSelected = false;


    }

    // This is the MyClick class, which implements the OnClickListener interface
    private class MyClick implements View.OnClickListener {

// Variable to reference the ImageView for the player's selected fighter
        ImageView playerCard = findViewById(R.id.imageView4);


        // This method is called when a fighter is clicked
        public void onClick(View v) {

            // Variable to reference the TextView for the fighter that the player has selected
            TextView fighters = findViewById(R.id.PlayerCardUsed);

            // Determine which fighter was clicked based on the id of the view
            switch (v.getId()) {
                case R.id.Angel:
                    if (!angelSelected) {
                        fighters.setText(getString(R.string.Angel));
                        playerCard.setImageResource(R.drawable.angel_new);

                    }
                    break;
                case R.id.Demon:
                    if (!demonSelected) {
                        fighters.setText(getString(R.string.Demon));
                        playerCard.setImageResource(R.drawable.deamon_woman);
                        demonSelected = true;
                    }
                    break;
                case R.id.Psychic:
                    if (!psychicSelected) {
                        fighters.setText(getString(R.string.Psychic));
                        playerCard.setImageResource(R.drawable.psychic);
                        psychicSelected = true;
                    }
                    break;
                case R.id.Ifrit:
                    if (!ifritSelected) {
                        fighters.setText(getString(R.string.Fire));
                        playerCard.setImageResource(R.drawable.ifrit);
                        ifritSelected = true;
                    }
                    break;
                case R.id.Shiva:
                    if (!shivaSelected) {
                        fighters.setText(getString(R.string.Ice));
                        playerCard.setImageResource(R.drawable.snow_woman);
                        shivaSelected = true;
                    }
                    break;
                case R.id.Terra:
                    if (!terraSelected) {
                        fighters.setText(getString(R.string.Earth));
                        playerCard.setImageResource(R.drawable.leaf);
                        terraSelected = true;

                    }
                    break;
                case R.id.attackButton:
                    if (fighters.getText().toString().equals("")) {
                        Toast.makeText(getApplicationContext(), "Please select a fighter before attacking", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (fighterSelected) {
                        Toast.makeText(getApplicationContext(), "You cannot use the same fighter twice", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    fighterSelected = true;
            }
        }
    }
    private class FightClick implements View.OnClickListener {
        TextView fighters = findViewById(R.id.PlayerCardUsed);
        TextView rounds = findViewById(R.id.Round);
        ImageButton cpuAnimon = findViewById(R.id.aiCard);
        TextView cpuselection = findViewById(R.id.AICard);

        // list of available cases
        List<Integer> cases = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        // flags to keep track of whether a fighter has been used
        @Override
        public void onClick(View v) {
            // check if fighters TextView is empty
            if (fighters.getText().toString().isEmpty()) {
                Toast.makeText(Battle.this, "Please select a fighter.", Toast.LENGTH_SHORT).show();
                return;
            }
            // check if the selected fighter has already been used
            String selectedFighter = fighters.getText().toString();
            boolean fighterUsed = false;
            switch (selectedFighter) {
                case "Angel":
                    if (angelUsed) {
                        fighterUsed = true;
                    } else {
                        angelUsed = true;
                    }
                    break;
                case "Demon":
                    if (demonUsed) {
                        fighterUsed = true;
                    } else {
                        demonUsed = true;
                    }
                    break;
                case "Psychic":
                    if (psychicUsed) {
                        fighterUsed = true;
                    } else {
                        psychicUsed = true;
                    }
                    break;
                case "Fire":
                    if (ifritUsed) {
                        fighterUsed = true;
                    } else {
                        ifritUsed = true;
                    }
                    break;
                case "Ice":
                    if (shivaUsed) {
                        fighterUsed = true;
                    } else {
                        shivaUsed = true;
                    }
                    break;
                case "Earth":
                    if (terraUsed) {
                        fighterUsed = true;
                    } else {
                        terraUsed = true;
                    }
                    break;
            }
            if (fighterUsed) {
                Toast.makeText(Battle.this, "This fighter has already been used.", Toast.LENGTH_SHORT).show();
                return;
            }
            // count is the round, increment with each time fight button is pressed
            ++count;
            TextView cpu = findViewById(R.id.computer);
            TextView player = findViewById(R.id.user);
            TextView atext = findViewById(R.id.angel_textView);
            TextView dtext = findViewById(R.id.demon_textView);
            TextView ptext = findViewById(R.id.psychic_textView);
            TextView itext = findViewById(R.id.ifrit_textView);
            TextView stext = findViewById(R.id.shiva_textView);
            TextView ttext = findViewById(R.id.terra_textView);
            rounds.setText("Round " + count);
            // check if cases list is empty
            if (cases.isEmpty()) {
                // refill cases list with original values
                cases.addAll(Arrays.asList(1, 2, 3, 4, 5, 6));
            }
            // randomly pick one of the available cases
            int index = (int) (Math.random() * cases.size());
            int rand = cases.get(index);
            cases.remove(index); // remove the selected case from the list
            switch (rand) {
                case 1:
                    cpuAnimon.setImageResource(R.drawable.angel_new);
                    cpuselection.setText(getString(R.string.Angel));
                    atext.setVisibility(View.VISIBLE);
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
                        case "Fire":
                            aiWins++;
                            playerWins++;
                            break;
                        case "Ice":
                            playerWins++;
                            aiWins++;
                            break;
                        case "Earth":
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
                        case "Fire":
                            aiWins++;
                            playerWins++;
                            break;
                        case "Ice":
                            playerWins++;
                            aiWins++;
                            break;
                        case "Earth":
                            playerWins++;
                            aiWins++;
                            break;
                    }
                    break;
                case 4:
                    cpuAnimon.setImageResource(R.drawable.flame);
                    cpuselection.setText(getString(R.string.Fire));
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
                        case "Fire":
                            aiWins++;
                            playerWins++;
                            break;
                        case "Ice":
                            playerWins++;
                            break;
                        case "Earth":
                            aiWins++;
                            break;
                    }
                    break;
                case 5:
                    cpuAnimon.setImageResource(R.drawable.snow_woman);
                    cpuselection.setText(getString(R.string.Ice));
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
                        case "Fire":
                            aiWins++;
                            break;
                        case "Ice":
                            playerWins++;
                            aiWins++;
                            break;
                        case "Earth":
                            playerWins++;
                            break;
                    }
                    break;
                case 6:
                    cpuAnimon.setImageResource(R.drawable.leaf);
                    cpuselection.setText(getString(R.string.Earth));
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
                        case "Fire":
                            playerWins++;
                            break;
                        case "Ice":
                            aiWins++;
                            break;
                        case "Earth":
                            aiWins++;
                            playerWins++;
                            break;
                    }
            }
            // display user and computer scores
            cpu.setText("Computer: " + aiWins);
            player.setText("Player: " + playerWins);
            // if 6 rounds have elapsed, determine the winner
            if (count == 6 && !fighters.getText().equals("")) {
                Intent intent = new Intent(Battle.this, BattleResult.class);
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