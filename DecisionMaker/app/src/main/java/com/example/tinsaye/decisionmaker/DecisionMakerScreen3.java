package com.example.tinsaye.decisionmaker;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;



public class DecisionMakerScreen3 extends ActionBarActivity {

    private Handler handler;
    private TextView textDot1;
    private int clock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        textDot1 = (TextView)findViewById(R.id.textDot1);
        handler = new Handler();
        Timer time = new Timer();
        clock = 0;
        time.schedule(new TimerTask() {
            @Override
            public void run() {
                if (clock == 3) {
                    cancel();
                    finish();
                    changeScreen();
                } else {
                    updateScreen(clock);
                }
            }
        }, 1000, 1000);
        time.purge();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_activity_loading, menu);
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

    public void updateScreen(int i) {
        if (i == 0)
        {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    textDot1.setText(" .");
                }
            });
        }
        else if (i == 1)
        {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    textDot1.setText(" . .");
                }
            });
        }
        else
        {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    textDot1.setText(" . . .");
                }
            });
        }
        clock++;
    }
    public void changeScreen()
    {
        String s = getIntent().getStringExtra("Decision");
        Intent answer = new Intent(DecisionMakerScreen3.this, DecisionMakerScreen2.class)
                .putExtra("Decision", s);
        startActivity(answer);
    }


}
