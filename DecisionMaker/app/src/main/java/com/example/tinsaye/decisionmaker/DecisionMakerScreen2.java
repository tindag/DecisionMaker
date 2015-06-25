package com.example.tinsaye.decisionmaker;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DecisionMakerScreen2 extends ActionBarActivity {

    private TextView textAns;
    private Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textAns = (TextView)findViewById(R.id.textAns);
        reset = (Button) findViewById(R.id.reset);
        reset.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    reset.setBackgroundColor(Color.BLACK);

                } else if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    reset.setBackgroundColor(Color.GRAY);
                }
                return false;
            }

        });
        reset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                resetOnClick();
            }
        });
        this.showDecision();
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_second, menu);
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

    public void showDecision()
    {
        String s = getIntent().getStringExtra("Decision");
        textAns.setText(s);
    }

    public void resetOnClick()
    {
        Intent reset = new Intent(DecisionMakerScreen2.this, DecisionMakerScreen.class);
        startActivity(reset);
    }
}
