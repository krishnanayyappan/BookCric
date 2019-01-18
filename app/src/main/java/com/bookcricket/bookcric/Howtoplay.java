package com.bookcricket.bookcric;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Gravity;
import android.widget.TextView;

import java.util.Random;

public class Howtoplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_howtoplay);

        final TextView tv = new TextView(this);
        tv.setGravity(Gravity.START);
        tv.setMovementMethod(new ScrollingMovementMethod());
        tv.setTextColor(Color.parseColor("#FF000000"));
        tv.setTextSize(16);
        tv.setText("* Book Cricket is a game that is usually played using a book that contains considerable number of pages in it.\n\n" +
                "* In this game, the unit digit of the even numbered pages will be taken as the runs (or points) scored in that ball (that is, 2, 4, 6 & 8). The player is OUT if it is a 0\n\n" +
                "* This app is a digitized form of the game.\n\n" +
                "* Willie is the mascot of this game\n\n" +
                "* This game can be played in two modes: 1.Single Player and 2.Two player\n\n" +
                "* In Single player mode, Willie will play first and will give the player a target. If the player reaches the target, player wins, else Willie wins the match\n\n" +
                "* In two player mode, Player-1 plays first and Player-2 takes the next turn. Whoever scores the highest is the winner.");
        setContentView(tv);
    }
}
