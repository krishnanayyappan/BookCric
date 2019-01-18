package com.bookcricket.bookcric;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PrematchOnePlayer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prematch_one_player);

        /* The button Playmatch corresponds to the "PLAY" in the GUI
        *  User will enter his/her name and click PLAY. On click, app
        *  will navigated to the Playercommatch GUI*/
        Button Playmatch = findViewById(R.id.play1);
        Playmatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText p1_name_field = findViewById(R.id.playername);
                String p1_name = p1_name_field.getText().toString();
//                Log.d("p1_name =", p1_name);
                if (!p1_name.isEmpty()) {
                    Intent intent = new Intent(PrematchOnePlayer.this, Playercommatch.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("name", p1_name);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getBaseContext(), "Enter your name!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
