package com.example.tinsaye.decisionmaker;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class DecisionMakerScreen extends ActionBarActivity {

    private TextView textNum;
    private EditText editD;
    private DecisionMakerCode base;
    private Button decide;
    private Button mainMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        base = new DecisionMakerCode();
        editD = (EditText)findViewById(R.id.editD);
        editD.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    saveOnClick(v);
                    handled = true;
                }
                return handled;
            }
        });
        editD.setHintTextColor(Color.BLACK);
        textNum = (TextView)findViewById(R.id.textNum);
        textNum.setText(Integer.toString(base.getSize()));
        decide = (Button) findViewById(R.id.decide);
        decide.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    decide.setBackgroundColor(Color.BLACK);

                } else if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    decide.setBackgroundColor(Color.GRAY);
                }
                return false;
            }

        });

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
    }


 //   @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }

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

    public void saveOnClick(View v)
    {
        String input = editD.getText().toString();
        base.storeDecision(input);
        textNum.setText(Integer.toString(base.getSize()));
        editD.getText().clear();
        hide_keyboard(this);
    }

    public void decideOnClick(View v)
    {
        if (base.getSize() > 0)
        {
            String value = base.chooseDecision(base.getSize());
            Intent answer = new Intent(DecisionMakerScreen.this, DecisionMakerScreen3.class)
                    .putExtra("Decision", value);
            startActivity(answer);

        }
    }

    public void mainMenuOnClick(View v)
    {
        Intent answer = new Intent(DecisionMakerScreen.this, Welcome.class);
        startActivity(answer);
    }

    public static void hide_keyboard(Activity activity) {
        InputMethodManager inputMethodManager;
        inputMethodManager = (InputMethodManager) activity
            .getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = activity.getCurrentFocus();
        if(view == null) {
            view = new View(activity);
        }
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

}
