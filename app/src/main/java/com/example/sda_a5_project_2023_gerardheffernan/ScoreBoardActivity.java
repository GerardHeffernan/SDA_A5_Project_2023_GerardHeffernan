package com.example.sda_a5_project_2023_gerardheffernan;


import static android.content.Intent.getIntent;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ScoreBoardActivity extends AppCompatActivity {

    private DatabaseReference userResults;
    TextView User, Result;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.score_board);



            User = (TextView) findViewById(R.id.textView8);
            Result = (TextView) findViewById(R.id.textView9);


            String st1 = getIntent().getStringExtra("st1");
            String result = getIntent().getStringExtra("result");

            User.setText(st1);
            Result.setText(result);
            userResults = FirebaseDatabase.getInstance().getReference().child("user_results");
            updateScoreboard(st1, result);

        }

      /*
      public class ScoreBoardActivity extends AppCompatActivity {

    private DatabaseReference userResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_board);

        TextView User, Result;

        User = findViewById(R.id.textView8);
        Result = findViewById(R.id.textView9);

        String st1 = getIntent().getStringExtra("st1");
        String result = getIntent().getStringExtra("result");

        User.setText(st1);
        Result.setText(result);

        // Update the user's result in the Firebase Realtime Database
        userResults = FirebaseDatabase.getInstance().getReference("users result/" + st1);
        userResults.setValue(result);

    }
}

2nd option

public class ScoreBoardActivity extends AppCompatActivity {

    private TextView userTextView, resultTextView;
    private DatabaseReference databaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_board);

        userTextView = findViewById(R.id.textView_user);
        resultTextView = findViewById(R.id.textView_result);

        String st1 = getIntent().getStringExtra("st1");
        String result = getIntent().getStringExtra("result");

        userTextView.setText(st1);
        resultTextView.setText(result);

        databaseRef = FirebaseDatabase.getInstance().getReference().child("user_results");
        updateScoreboard(st1, result);
    }

    private void updateScoreboard(String st1, String result) {
        // add new result to the database
        databaseRef.child(st1).setValue(result);

        // display the top 5 results on the scoreboard
        databaseRef.orderByValue().limitToLast(5).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                StringBuilder usersText = new StringBuilder();
                StringBuilder resultsText = new StringBuilder();
                for (DataSnapshot data : snapshot.getChildren()) {
                    usersText.insert(0, data.getKey() + "\n");
                    resultsText.insert(0, data.getValue() + "\n");
                }
                userTextView.setText(usersText.toString());
                resultTextView.setText(resultsText.toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d("Firebase Error", error.getMessage());
            }
        });
    }
}



       */

    private void updateScoreboard(String st1, String result) {




        User = (TextView) findViewById(R.id.textView8);
        Result = (TextView) findViewById(R.id.textView9);
        // add new result to the database
        userResults.child(st1).setValue(result);

        // display the top 5 results on the scoreboard
        userResults.orderByValue().limitToLast(5).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                StringBuilder usersText = new StringBuilder();
                StringBuilder resultsText = new StringBuilder();
                for (DataSnapshot data : snapshot.getChildren()) {
                    usersText.insert(0, data.getKey() + "\n");
                    resultsText.insert(0, data.getValue() + "\n");
                }
                User.setText(usersText.toString());
                Result.setText(resultsText.toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d("Firebase Error", error.getMessage());
            }
        });
    }
}

