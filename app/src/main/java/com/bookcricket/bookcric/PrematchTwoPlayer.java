package com.bookcricket.bookcric;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PrematchTwoPlayer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prematch_two_player);

        Button Playmatch2 = findViewById(R.id.play2);
        Playmatch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText p1_name_field = findViewById(R.id.player1name);
                final String p1_name = p1_name_field.getText().toString();
                EditText p2_name_field = findViewById(R.id.player2name);
                final String p2_name = p2_name_field.getText().toString();

                if (!p1_name.isEmpty() || !p2_name.isEmpty()) {
                    Intent intent = new Intent(PrematchTwoPlayer.this, Playervsplayermatch.class);

                    Bundle bundle = new Bundle();
                    bundle.putString("name1", p1_name);
                    bundle.putString("name2", p2_name);
                    intent.putExtras(bundle);

                    startActivity(intent);
                }
                else{
                    Toast.makeText(getBaseContext(), "Enter player names!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
