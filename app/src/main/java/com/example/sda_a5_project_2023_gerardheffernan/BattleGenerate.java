package com.example.sda_a5_project_2023_gerardheffernan;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class BattleGenerate extends AppCompatActivity {


private class MyClick implements View.OnClickListener {
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.RandoBattle:
                Intent intent = new Intent(BattleGenerate.this,Battle.class);
                startActivity(intent);

                break;
        }
    }
}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.battle_generate);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.battletype);


        // creates random battle button and links it to MyClick class
        Button random;

        random = findViewById(R.id.RandoBattle);

        BattleGenerate.MyClick myClickListener = new BattleGenerate.MyClick();

        random.setOnClickListener(myClickListener);

    }
}
