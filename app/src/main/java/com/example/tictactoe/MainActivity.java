package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }



        public void startgame_singlePlayer(View view) {
            Intent i = new Intent(this, GameActivity.class);
            startActivity(i);

        }

        public void startgame_single(View view) {
        Intent i = new Intent(this, SingleActivity.class);
        startActivity(i);

    }
}
