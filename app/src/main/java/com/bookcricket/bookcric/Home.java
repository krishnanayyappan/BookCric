package com.bookcricket.bookcric;

import android.content.Intent;
import android.os.Build;
import android.os.Process;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        /*
        The button OnePlayer corresponds to the "PLAYER VS COM" in home GUI
        When clicked, app is navigated to PrematchOnePlayer activity
        */
        Button OnePlayer = findViewById(R.id.playervscom);
        OnePlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, PrematchOnePlayer.class);
                startActivity(intent);
            }
        });

        /*
        The button Multiplayer corresponds to the "PLAYER VS PLAYER" in home GUI
        When clicked, app is navigated to PrematchTwoPlayer activity
        */
        Button Multiplayer = findViewById(R.id.playervsplayer);
        Multiplayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, PrematchTwoPlayer.class);
                startActivity(intent);
            }
        });

        /*
        The button Howtoplay corresponds to the "HOW TO PLAY" in home GUI
        When clicked, app is navigated to Howtoplay activity
        */
        Button Howtoplay = findViewById(R.id.howplay);
        Howtoplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Howtoplay.class);
                startActivity(intent);
            }
        });

        /*
        The button ExitApp corresponds to the "EXIT FROM APP" in home GUI
        When clicked, app is closed/killed
        */
        Button ExitApp = findViewById(R.id.quitapp);
        ExitApp.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                finish();
//                moveTaskToBack(true);
//                finishAndRemoveTask();
                  System.exit(0);
//                finish();
                  Process.killProcess(Process.myPid());
            }
        });

    }
}
