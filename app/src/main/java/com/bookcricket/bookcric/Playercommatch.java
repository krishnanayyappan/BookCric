package com.bookcricket.bookcric;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Playercommatch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playercommatch);

        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        final String usr = bundle.getString("name");
        //Toast.makeText(getBaseContext(), "Player =" + usr, Toast.LENGTH_SHORT).show();

        TextView Username = findViewById(R.id.player_name);
        Username.setText(usr);

        Random r = new Random();
        final int com_innings = r.nextInt(50);

        TextView com_value = findViewById(R.id.com_score);
        com_value.setText(String.valueOf(com_innings));

        final int target = com_innings + 1;

        Toast.makeText(getBaseContext(), "Your target is " + target, Toast.LENGTH_SHORT).show();

        final TextView player_value = findViewById(R.id.player_score);
        final Random rand = new Random();
        final int[] player_score = {0};
        final boolean[] player_out = {false};
        final boolean[] match_over = {false};
        final TextView match_res = findViewById(R.id.matchresult);
        final TextView ball_score = findViewById(R.id.thisball_score);

        Button Playmatch = findViewById(R.id.playball);
        Playmatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( (player_score[0] < target) && ( player_out[0] == false ) ){
                    int player_ball = rand.nextInt(4);
                    Log.d("player_ball=", String.valueOf(player_ball));
                    player_ball = player_ball * 2;
                    ball_score.setText(String.valueOf(player_ball));
                    if (player_ball == 0) {
                        Toast.makeText(getBaseContext(), "OUT!!!", Toast.LENGTH_SHORT).show();
                        player_out[0] = true;
                        if (player_score[0] < com_innings) {
                            match_res.setText("Willie won the match!\nClick here to Continue...");
                        } else {
                            match_res.setText("Match ended in a tie!\nClick here to Continue...");
                        }
                    } else {
                        player_score[0] = player_score[0] + player_ball;
                        player_value.setText(String.valueOf(player_score[0]));
                        if (player_score[0] >= target) {
                            match_res.setText("You won the match!\nClick here to Continue...");
                        }
                    }
                }
            }
        });

         match_res.setOnClickListener(new View.OnClickListener() {
            @Override
              public void onClick(View v) {
                Intent intent = new Intent(Playercommatch.this, Home.class);
                startActivity(intent);
         }
        });

        ImageButton Help = findViewById(R.id.helpbutton);
        Help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Playercommatch.this);
                builder.setMessage("Willie will play first and set you a target score.\n\n" +
                        "Click on FLIP PAGE button to play.\n\n" +
                        "The points/runs that you score every ball will get displayed at the top of the screen.\n\n" +
                        "You are OUT of the game if your score is 0 in that ball.\n\n" +
                        "You stop playing if you reach the target or OUT.")
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
