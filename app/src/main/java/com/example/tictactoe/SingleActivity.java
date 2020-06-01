package com.example.tictactoe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class SingleActivity extends AppCompatActivity {

    int gameState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);

        gameState=1 ;

    }



    public void GameBoardClick(View view){
        ImageView selectedImage=(ImageView)view;

        int selectedBlock=0;
        switch (selectedImage.getId()){
            case R.id.imageView0:selectedBlock=1; break;
            case R.id.imageView1:selectedBlock=2; break;
            case R.id.imageView2:selectedBlock=3; break;

            case R.id.imageView3:selectedBlock=4; break;
            case R.id.imageView4:selectedBlock=5; break;
            case R.id.imageView5:selectedBlock=6; break;

            case R.id.imageView6:selectedBlock=6; break;
            case R.id.imageView7:selectedBlock=7; break;
            case R.id.imageView8:selectedBlock=8; break;
        }

        PlayGame (selectedBlock,selectedImage);
    }

    int activePlayer=1;
    ArrayList<Integer> player1=new ArrayList<Integer>();
    ArrayList<Integer> player2=new ArrayList<Integer>();
    private void PlayGame(int selectedBlock, ImageView selectedImage) {
        if (gameState==1){
            if (activePlayer==1){
                selectedImage.setImageResource(R.drawable.croses);
                player1.add(selectedBlock);
                activePlayer=2;
                Autoplay();

            }else if (activePlayer==2){
                selectedImage.setImageResource(R.drawable.circle1);
                player2.add(selectedBlock);
                activePlayer=1;
            }

            selectedImage.setEnabled(false);
            checkWinner();
        }
    }

    private void Autoplay() {
        ArrayList<Integer> emptyblocks=new ArrayList<Integer>();

        for(int i=1;i<9;i++){
            if(!(player1.contains(i) || player2.contains(i))){
                emptyblocks.add(i);
            }
        }

        if(emptyblocks.size()==0){
            checkWinner();
            if(gameState==1){
                AlertDialog.Builder b = new AlertDialog.Builder(this,android.R.style.Theme_Material_Dialog_Alert);
                showAlert("!!DRAW!!");

            }
            gameState=3;

        }else{
            Random r = new Random();
            int randomIndex=r.nextInt(emptyblocks.size());
            int selectedBlock=emptyblocks.get(randomIndex);

            ImageView selectedImage=(ImageView)  findViewById(R.id.imageView0);
            switch (selectedBlock){

                case 1: selectedImage=(ImageView) findViewById(R.id.imageView0); break;
                case 2: selectedImage=(ImageView) findViewById(R.id.imageView1); break;
                case 3: selectedImage=(ImageView) findViewById(R.id.imageView2); break;


                case 4: selectedImage=(ImageView) findViewById(R.id.imageView3); break;
                case 5: selectedImage=(ImageView) findViewById(R.id.imageView4); break;
                case 6: selectedImage=(ImageView) findViewById(R.id.imageView5); break;


                case 7: selectedImage=(ImageView) findViewById(R.id.imageView6); break;
                case 8: selectedImage=(ImageView) findViewById(R.id.imageView7); break;
                case 9: selectedImage=(ImageView) findViewById(R.id.imageView8); break;


            }

            PlayGame(selectedBlock,selectedImage);
        }
    }

    private void showAlert(String Title) {
        AlertDialog.Builder b = new AlertDialog.Builder(this,R.style.TransparentDialog);
        b.setTitle(Title)
                .setMessage("Start a new Game ??")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,int which ){
                        ResetGame();
                    }
                })
                .setNegativeButton("Menu", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i=new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(i);
                        finish();
                    }
                })

                .show();


    }

    void ResetGame(){
        gameState=1;
        activePlayer=1;
        player1.clear();
        player2.clear();

        ImageView iv;
        iv=(ImageView) findViewById(R.id.imageView0); iv.setImageResource(0); iv.setEnabled(true);
        iv=(ImageView) findViewById(R.id.imageView1); iv.setImageResource(0); iv.setEnabled(true);
        iv=(ImageView) findViewById(R.id.imageView2); iv.setImageResource(0); iv.setEnabled(true);

        iv=(ImageView) findViewById(R.id.imageView3); iv.setImageResource(0); iv.setEnabled(true);
        iv=(ImageView) findViewById(R.id.imageView4); iv.setImageResource(0); iv.setEnabled(true);
        iv=(ImageView) findViewById(R.id.imageView5); iv.setImageResource(0); iv.setEnabled(true);


        iv=(ImageView) findViewById(R.id.imageView6); iv.setImageResource(0); iv.setEnabled(true);
        iv=(ImageView) findViewById(R.id.imageView7); iv.setImageResource(0); iv.setEnabled(true);
        iv=(ImageView) findViewById(R.id.imageView8); iv.setImageResource(0); iv.setEnabled(true);



    }

    private void checkWinner() {
        int winner=0;

        if(player1.contains(1)&&player1.contains(2)&&player1.contains(3)){winner=1;}
        if(player1.contains(4)&&player1.contains(5)&&player1.contains(6)){winner=1;}
        if(player1.contains(7)&&player1.contains(8)&&player1.contains(9)){winner=1;}

        if(player1.contains(1)&&player1.contains(4)&&player1.contains(7)){winner=1;}
        if(player1.contains(2)&&player1.contains(5)&&player1.contains(8)){winner=1;}
        if(player1.contains(3)&&player1.contains(6)&&player1.contains(9)){winner=1;}

        if(player1.contains(1)&&player1.contains(5)&&player1.contains(9)){winner=1;}
        if(player1.contains(3)&&player1.contains(5)&&player1.contains(7)){winner=1;}



        if(player2.contains(1)&&player2.contains(2)&&player2.contains(3)){winner=2;}
        if(player2.contains(4)&&player2.contains(5)&&player2.contains(6)){winner=2;}
        if(player2.contains(7)&&player2.contains(8)&&player2.contains(9)){winner=2;}

        if(player2.contains(1)&&player2.contains(4)&&player2.contains(7)){winner=2;}
        if(player2.contains(2)&&player2.contains(5)&&player2.contains(8)){winner=2;}
        if(player2.contains(3)&&player2.contains(6)&&player2.contains(9)){winner=2;}

        if(player2.contains(1)&&player2.contains(5)&&player2.contains(9)){winner=2;}
        if(player2.contains(3)&&player2.contains(5)&&player2.contains(7)){winner=2;}


        if(winner!=0&& gameState==1){
            if(winner==1){
                showAlert("You WIN the Game!!");

            }else if (winner==2)

            {
                showAlert("Computer is the winner!!");

            }

            gameState=2;
        }

    }
}
