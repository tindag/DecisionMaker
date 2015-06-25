package com.example.tinsaye.decisionmaker;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;


public class Welcome extends ActionBarActivity {

    private Button randomPick;
    private Button coinToss;
    private Button dice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        randomPick = (Button) findViewById(R.id.randomPick);
        randomPick.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    randomPick.setBackgroundColor(Color.BLACK);

                } else if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    randomPick.setBackgroundColor(Color.GRAY);
                }
                return false;
            }

        });
        randomPick.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                randomPickOnClick();
            }
        });
        coinToss = (Button) findViewById(R.id.coinToss);
        coinToss.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    coinToss.setBackgroundColor(Color.BLACK);

                } else if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    coinToss.setBackgroundColor(Color.GRAY);
                }
                return false;
            }

        });
        coinToss.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                coinTossOnClick();
            }
        });
        dice = (Button) findViewById(R.id.dice);
        dice.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    dice.setBackgroundColor(Color.BLACK);

                } else if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    dice.setBackgroundColor(Color.GRAY);
                }
                return false;
            }

        });
        dice.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                diceOnClick();
            }
        });
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_welcome, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    public void randomPickOnClick()
    {
        Intent newScreen = new Intent(Welcome.this, DecisionMakerScreen.class);
        startActivity(newScreen);
    }

    public void coinTossOnClick()
    {
        Intent newScreen = new Intent(Welcome.this, CoinToss.class);
        startActivity(newScreen);
    }

    public void diceOnClick()
    {
        Intent newScreen = new Intent(Welcome.this, Dice.class);
        startActivity(newScreen);
    }
}
