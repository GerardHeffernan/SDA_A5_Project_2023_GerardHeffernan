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
import android.widget.Toast;

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


    boolean angelUsed = false;
    boolean demonUsed = false;
    boolean psychicUsed = false;
    boolean ifritUsed = false;
    boolean shivaUsed = false;
    boolean terraUsed = false;

    boolean fighterUsed = false;
    ImageButton Angel, Demon, Psychic, Ifrit, Shiva, Terra;
    ImageView playerCard;
    boolean angelSelected, demonSelected, psychicSelected, ifritSelected, shivaSelected, terraSelected;
    int battleTheme = R.raw.orchestra;
    TextView fighters;
    private MediaPlayer battleMusic;
    private int count = 0;
    private int aiWins = 0;
    private int playerWins = 0;
    private boolean fighterSelected = false;

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
        TextView rounds = findViewById(R.id.Round);
        rounds.setText("Round");


        Button attackButton;
        Button resetButton;

        Angel = findViewById(R.id.Angel);
        //Angel.setVisibility(View.VISIBLE);

        Demon = findViewById(R.id.Demon);

        Psychic = findViewById(R.id.Psychic);

        Ifrit = findViewById(R.id.Ifrit);

        Shiva = findViewById(R.id.Shiva);

        Terra = findViewById(R.id.Terra);

        attackButton = findViewById(R.id.attackButton);


        Battle.MyClick myClickListener = new Battle.MyClick();
        Battle.FightClick fightListener = new Battle.FightClick();

        Angel.setOnClickListener(myClickListener);
        Demon.setOnClickListener(myClickListener);
        Psychic.setOnClickListener(myClickListener);
        Ifrit.setOnClickListener(myClickListener);
        Shiva.setOnClickListener(myClickListener);
        Terra.setOnClickListener(myClickListener);

        attackButton.setOnClickListener(fightListener);


        // initialize button selection variables to false

        angelSelected = false;
        demonSelected = false;
        psychicSelected = false;
        ifritSelected = false;
        shivaSelected = false;
        terraSelected = false;

    }

    private class MyClick implements View.OnClickListener {

        TextView cpu = findViewById(R.id.computer);
        TextView player = findViewById(R.id.user);
        TextView atext = findViewById(R.id.angel_textView);
        TextView dtext = findViewById(R.id.demon_textView);
        TextView ptext = findViewById(R.id.psychic_textView);
        TextView itext = findViewById(R.id.ifrit_textView);
        TextView stext = findViewById(R.id.shiva_textView);
        TextView ttext = findViewById(R.id.terra_textView);
        ImageView playerCard = findViewById(R.id.imageView4);
        ImageButton aiCard = findViewById(R.id.aiCard);


        public void onClick(View v) {

            TextView fighters = findViewById(R.id.PlayerCardUsed);
            TextView rounds = findViewById(R.id.Round);
            TextView cpu = findViewById(R.id.computer);
            TextView player = findViewById(R.id.user);
            // depending on image button chosen, populate textview descritpion
            TextView atext = findViewById(R.id.angel_textView);
            TextView dtext = findViewById(R.id.demon_textView);
            TextView ptext = findViewById(R.id.psychic_textView);
            TextView itext = findViewById(R.id.ifrit_textView);
            TextView stext = findViewById(R.id.shiva_textView);
            TextView ttext = findViewById(R.id.terra_textView);

            switch (v.getId()) {
                case R.id.Angel:
                    if (!angelSelected) {
                        fighters.setText(getString(R.string.Angel));
                        playerCard.setImageResource(R.drawable.angel_new);
                        angelSelected = true;
                        Angel.setVisibility(View.INVISIBLE);
                    }
                    break;
                case R.id.Demon:
                    if (!demonSelected) {
                        fighters.setText(getString(R.string.Demon));
                        playerCard.setImageResource(R.drawable.deamon_woman);
                        demonSelected = true;
                        Demon.setVisibility(View.INVISIBLE);
                    }
                    break;
                case R.id.Psychic:
                    if (!psychicSelected) {
                        fighters.setText(getString(R.string.Psychic));
                        playerCard.setImageResource(R.drawable.psychic);
                        psychicSelected = true;
                        Psychic.setVisibility(View.INVISIBLE);
                    }
                    break;
                case R.id.Ifrit:
                    if (!ifritSelected) {
                        fighters.setText(getString(R.string.Ifrit));
                        playerCard.setImageResource(R.drawable.ifrit);
                        ifritSelected = true;
                        Ifrit.setVisibility(View.INVISIBLE);
                    }
                    break;
                case R.id.Shiva:
                    if (!shivaSelected) {
                        fighters.setText(getString(R.string.Shiva));
                        playerCard.setImageResource(R.drawable.snow_woman);
                        shivaSelected = true;
                        Shiva.setVisibility(View.INVISIBLE);
                    }
                    break;
                case R.id.Terra:
                    if (!terraSelected) {
                        fighters.setText(getString(R.string.Terra));
                        playerCard.setImageResource(R.drawable.leaf);
                        terraSelected = true;
                        Terra.setVisibility(View.INVISIBLE);
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
                case "Ifrit":
                    if (ifritUsed) {
                        fighterUsed = true;
                    } else {
                        ifritUsed = true;
                    }
                    break;
                case "Shiva":
                    if (shivaUsed) {
                        fighterUsed = true;
                    } else {
                        shivaUsed = true;
                    }
                    break;
                case "Terra":
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