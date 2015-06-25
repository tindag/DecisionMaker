package com.example.tinsaye.decisionmaker;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;



public class CoinToss extends ActionBarActivity {

    private Button mainMenu;
    private ImageView coin;
    private Button flip;
    private TextView ans;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cointoss);
        mainMenu = (Button) findViewById(R.id.mainMenu);
        flip = (Button) findViewById(R.id.flip);
        ans = (TextView) findViewById(R.id.textAns2);
        mainMenu.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    mainMenu.setBackgroundColor(Color.BLACK);

                } else if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    mainMenu.setBackgroundColor(Color.GRAY);
                }
                return false;
            }

        });
        flip.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    flip.setBackgroundColor(Color.BLACK);

                } else if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    flip.setBackgroundColor(Color.GRAY);
                }
                return false;
            }

        });
        mainMenu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                mainMenuOnClick();
            }
        });
        coin = (ImageView) findViewById(R.id.coin1);
        coin.setImageResource(R.drawable.coin1);
        flip.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                flipOnClick();
            }
        });
        handler = new Handler();
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_coin_toss, menu);
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

    public void mainMenuOnClick()
    {
        Intent answer = new Intent(CoinToss.this, Welcome.class);
        startActivity(answer);
    }

    public void flipOnClick()
    {
        ans.setText(" ");
        new Thread(new Task()).start();
    }

    class Task implements Runnable {
        private float pos = 0;
        private int i = 0;
        public void run() {
            for (i = 0; i <= 10; i++) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        coin.setRotationX(pos);
                        if (i % 2 != 0)
                        {
                            coin.setImageResource(R.drawable.coin2);
                        }
                        else {
                            coin.setImageResource(R.drawable.coin1);
                        }
                    }
                });
                try {
                    Thread.sleep(75);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                pos = pos + 30;
            }
            handler.post(new Runnable() {
                @Override
                public void run() {
                    Random rand = new Random();
                    int choice = rand.nextInt(2);
                    if (choice == 1)
                    {
                        coin.setRotationX(0);
                        coin.setImageResource(R.drawable.coin2);
                        ans.setText("It's Tails");
                    }
                    else
                    {
                        coin.setRotationX(0);
                        ans.setText("It's Heads");
                    }
                }
            });

        }

    }

}
