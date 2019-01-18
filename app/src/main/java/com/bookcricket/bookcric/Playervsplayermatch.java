package com.bookcricket.bookcric;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Playervsplayermatch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playervsplayermatch);

        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        final String usr1 = bundle.getString("name1");
        final String usr2 = bundle.getString("name2");

        TextView Username1 = findViewById(R.id.player1_name);
        Username1.setText(usr1);

        TextView Username2 = findViewById(R.id.player2_name);
        Username2.setText(usr2);

        final Random rand = new Random();
        final TextView player1_value = findViewById(R.id.player1_score);
        final TextView player2_value = findViewById(R.id.player2_score);
        final int[] player1_score = {0};
        final int[] player2_score = {0};
        final boolean[] player1_out = {false};
        final boolean[] player2_out = {false};
        final TextView match_resu = findViewById(R.id.matchresult);
        final TextView ball_score = findViewById(R.id.thisball_score);

        Button Play1match = findViewById(R.id.play1ball);
        Play1match.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( player1_out[0] == false ){
                    int player1_ball = rand.nextInt(4);
                    player1_ball = player1_ball * 2;
                    ball_score.setText(String.valueOf(player1_ball));
                    if (player1_ball == 0) {
                        Toast.makeText(getBaseContext(), "OUT!!!", Toast.LENGTH_SHORT).show();
                        player1_out[0] = true;
                    } else {
                        player1_score[0] = player1_score[0] + player1_ball;
                        player1_value.setText(String.valueOf(player1_score[0]));
                    }
                }
            }
        });

        Button Play2match = findViewById(R.id.play2ball);
        Play2match.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if ( (player2_score[0] < player1_score[0]) && ( player2_out[0] == false ) ){
                    int player2_ball = rand.nextInt(4);
                    //Log.d("player_ball=", String.valueOf(player_ball));
                    player2_ball = player2_ball * 2;
                    ball_score.setText(String.valueOf(player2_ball));
                    if (player2_ball == 0) {
                        Toast.makeText(getBaseContext(), "OUT!!!", Toast.LENGTH_SHORT).show();
                        player2_out[0] = true;
                        if (player2_score[0] < player1_score[0]) {
                            match_resu.setText(usr1 + " won the match!\nClick here to Continue...");
                        } else {
                            match_resu.setText("Match ended in a tie!\nClick here to Continue...");
                        }
                    } else {
                        player2_score[0] = player2_score[0] + player2_ball;
                        player2_value.setText(String.valueOf(player2_score[0]));
                        if (player2_score[0] >= player1_score[0]) {
                            match_resu.setText(usr2 + " won the match!\nClick here to Continue...");
                        }
                    }
                }
            }
        });

        match_resu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Playervsplayermatch.this, Home.class);
                startActivity(intent);
            }
        });

        ImageButton Help = findViewById(R.id.imageButton);
        Help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Playervsplayermatch.this);
                builder.setMessage("Player-1 will play first and sets Player-2 a target score.\n\n" +
                        "Player-1 and 2 should click on FLIP PAGE (P1) and FLIP PAGE (P2) buttons respectively to play.\n\n" +
                        "The points/runs that you score every ball will get displayed at the top of the screen.\n\n" +
                        "Player is considered OUT if the score is 0 in that ball.\n\n" +
                        "You stop playing if you are OUT (applies to both players or if Player-2 reaches the target.")
                        .setCancelable(false)
                        .setPositiveButton("Close", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //do things
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

    }
}
