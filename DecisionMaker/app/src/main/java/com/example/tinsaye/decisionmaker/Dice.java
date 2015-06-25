package com.example.tinsaye.decisionmaker;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;


public class Dice extends ActionBarActivity {

    private Button mainMenu;
    private Button spin;
    private ImageView imageDice;
    private RotateAnimation rotate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);
        mainMenu = (Button) findViewById(R.id.mainMenu);
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

        mainMenu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                mainMenuOnClick();
            }
        });

        spin = (Button) findViewById(R.id.spin);
        spin.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    spin.setBackgroundColor(Color.BLACK);

                } else if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    spin.setBackgroundColor(Color.GRAY);
                }
                return false;
            }

        });

        spin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                spinOnClick();
            }
        });

        imageDice = (ImageView) findViewById(R.id.imageDice);
        imageDice.setImageResource(R.drawable.aleaa1);
    }



//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_dice, menu);
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
        Intent answer = new Intent(Dice.this, Welcome.class);
        startActivity(answer);
    }

    public void spinOnClick()
    {
        rotate = new RotateAnimation(0f, 900f, imageDice.getWidth() / 2, imageDice.getHeight() / 2);
        rotate.setInterpolator(new LinearInterpolator());
        rotate.setRepeatCount(Animation.ABSOLUTE);
        rotate.setDuration(2000);
        imageDice.startAnimation(rotate);
    }
}
