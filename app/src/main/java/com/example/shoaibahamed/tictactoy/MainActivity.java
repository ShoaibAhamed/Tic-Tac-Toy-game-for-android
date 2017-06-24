package com.example.shoaibahamed.tictactoy;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int CellID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void BuClick(View view ){

        Button buSelected = (Button) view;

        int cellID =0;
        switch((buSelected.getId())){

            case R.id.bu1:
                cellID=1;
                break;

            case R.id.bu2:
                cellID=2;
                break;

            case R.id.bu3:
                cellID=3;
                break;

            case R.id.bu4:
                cellID=4;
                break;

            case R.id.bu5:
                cellID=5;
                break;

            case R.id.bu6:
                cellID=6;
                break;

            case R.id.bu7:
                cellID=7;
                break;

            case R.id.bu8:
                cellID=8;
                break;

            case R.id.bu9:
                cellID=9;
                break;
        }
    PlayGame(CellID, buSelected);


    }

    int ActivePlayer= 1;   // 1 for the first player

ArrayList<Integer>Player1 = new ArrayList<>(); // for holding player one data

    ArrayList<Integer>Player2 = new ArrayList<>(); // for holding player two  data

    void PlayGame(int CellID, Button buSelected){


        Log.d( "Player:", String.valueOf(CellID));
//        Log.d("Button:", buSelected.getText().toString()); for debugging

        if (ActivePlayer==1){

            buSelected.setText("X");  // x will appear
            buSelected.setBackgroundColor(Color.RED);  // color will change to red
            Player1.add(CellID);
            ActivePlayer =2; // after that it will be the turn for the second player

            AutoPlay();
        }


        else if (ActivePlayer==2){

            buSelected.setText("O");  // O will appear
            buSelected.setBackgroundColor(Color.GREEN);  // color will change to green
            Player2.add(CellID);
            ActivePlayer =1; // after that it will be the turn for the second player

        }

         buSelected.setEnabled(false);

        checkWinner();

    }

    void checkWinner(){

        int winer =-1;

        // for row 1

        if (Player1.contains(1)&& Player1.contains(2)&& Player1.contains(3)) {

            winer = 1;
        }


        if (Player2.contains(1)&& Player2.contains(2)&& Player2.contains(3)) {

            winer = 2;
        }

        // for row 2

        if (Player1.contains(4)&& Player1.contains(5)&& Player1.contains(6)) {

            winer = 1;
        }


        if (Player2.contains(4)&& Player2.contains(5)&& Player2.contains(6)) {

            winer = 2;
        }

            // for row 3

            if (Player1.contains(7)&& Player1.contains(8)&& Player1.contains(9)) {

                winer = 1;
            }


            if (Player2.contains(7)&& Player2.contains(8)&& Player2.contains(9)) {

                winer = 2;
            }


            // for col 1

            if (Player1.contains(1)&& Player1.contains(4)&& Player1.contains(7)) {

                winer = 1;
            }


            if (Player2.contains(1)&& Player2.contains(4)&& Player2.contains(7)) {

                winer = 2;
        }

        // for col 2

        if (Player1.contains(2)&& Player1.contains(5)&& Player1.contains(8)) {

            winer = 1;
        }


        if (Player2.contains(2)&& Player2.contains(5)&& Player2.contains(8)) {

            winer = 2;
        }

        // for col 3

        if (Player1.contains(3)&& Player1.contains(6)&& Player1.contains(9)) {

            winer = 1;
        }


        if (Player2.contains(3)&& Player2.contains(6)&& Player2.contains(9)) {

            winer = 2;
        }

        if (winer !=-1){

            // we have winner

            if (winer==1){

                Toast.makeText(this,"yea! you've won the game ",Toast.LENGTH_LONG).show();
            }

            if (winer==2){

                Toast.makeText(this,"yea! you've lost the game ",Toast.LENGTH_LONG).show();
            }

        }

    }


    void AutoPlay(){

        ArrayList<Integer> EmptyCells= new ArrayList<Integer>(); //all unselected cells

        //device needs to find the emply cells

        for (int cellID =1; cellID<10; cellID++){

            if(!(Player1.contains(cellID) || Player2.contains(cellID) )) {

                EmptyCells.add(cellID);

            }


            }

        Random r = new Random();

        int RandomIndex= r.nextInt(EmptyCells.size()-0) + 0;

        int CellID= EmptyCells.get(RandomIndex);

        Button buSelected;

        switch(CellID){

            case 1:
               buSelected=(Button) findViewById(R.id.bu1);
                break;

            case 2:
                buSelected=(Button) findViewById(R.id.bu2);
                break;

            case 3:
                buSelected=(Button) findViewById(R.id.bu3);
                break;

            case 4:
                buSelected=(Button) findViewById(R.id.bu4);
                break;

            case 5:
                buSelected=(Button) findViewById(R.id.bu5);
                break;

            case 6:
                buSelected=(Button) findViewById(R.id.bu6);
                break;

            case 7:
                buSelected=(Button) findViewById(R.id.bu7);
                break;

            case 8:
                buSelected=(Button) findViewById(R.id.bu8);
                break;

            case 9:
                buSelected=(Button) findViewById(R.id.bu9);
                break;
            default:
            buSelected=(Button) findViewById(R.id.bu1);
            break;
        }
        PlayGame(CellID, buSelected);


    }
}
