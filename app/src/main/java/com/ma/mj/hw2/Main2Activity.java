package com.ma.mj.hw2;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;

import static com.ma.mj.hw2.R.id.button14;

public class Main2Activity extends AppCompatActivity {
    Button b1, b2;
    Chronometer ch;
    DatePicker dp;
    TimePicker tp;
    GridLayout glinput, glcon;
    FrameLayout fl;
    EditText e1, e2, e3;
    TextView t1, t2, t3, t4, t5;
    Switch s;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b1 = (Button) findViewById(R.id.button14);
        b2 = (Button) findViewById(R.id.button13);
        e1 = (EditText) findViewById(R.id.editText6);
        e2 = (EditText) findViewById(R.id.editText5);
        e3 = (EditText) findViewById(R.id.editText4);
        dp = (DatePicker) findViewById(R.id.datePicker3);
        tp = (TimePicker) findViewById(R.id.timePicker2);
        t1 = (TextView) findViewById(R.id.textView18);
        t2 = (TextView) findViewById(R.id.textView20);
        t3 = (TextView) findViewById(R.id.textView26);
        t4 = (TextView) findViewById(R.id.textView23);
        t5 = (TextView) findViewById(R.id.textView24);
        s = (Switch) findViewById(R.id.switch3);
        ch = (Chronometer)findViewById(R.id.chronometer5);
        glinput = (GridLayout)findViewById(R.id.gin);
        glcon = (GridLayout)findViewById(R.id.gout);
        fl = (FrameLayout)findViewById(R.id.frl);


        s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ch.setBase(SystemClock.elapsedRealtime());
                    ch.setVisibility(View.VISIBLE);
                    ch.start();
                    fl.setVisibility(View.VISIBLE);
                    dp.setVisibility(View.VISIBLE);
                    b2.setVisibility(View.VISIBLE);
                    b2.setEnabled(true);
                    b1.setVisibility(View.VISIBLE);
                    back();
                    gogo();

                } else {
                    ch.setBase(SystemClock.elapsedRealtime());
                    fl.setVisibility(View.INVISIBLE);
                    dp.setVisibility(View.INVISIBLE);
                    tp.setVisibility(View.INVISIBLE);
                    glcon.setVisibility(View.INVISIBLE);
                    glinput.setVisibility(View.INVISIBLE);
                    b1.setVisibility(View.INVISIBLE);
                    b2.setVisibility(View.INVISIBLE);
                    ch.setVisibility(View.INVISIBLE);
                }
            }

            void back() {
                b1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (tp.getVisibility() == View.VISIBLE) {
                            tp.setVisibility(View.INVISIBLE);
                            dp.setVisibility(View.VISIBLE);
                            b1.setEnabled(false);
                        } else if (glinput.getVisibility() == View.VISIBLE) {
                            glinput.setVisibility(View.INVISIBLE);
                            tp.setVisibility(View.VISIBLE);
                        } else if (glcon.getVisibility() == View.VISIBLE) {
                            glcon.setVisibility(View.INVISIBLE);
                            glinput.setVisibility(View.VISIBLE);
                            ch.start();
                            b2.setEnabled(true);
                        }
                    }
                });
            }

            void gogo() {
                b2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (dp.getVisibility() == View.VISIBLE) {
                            dp.setVisibility(View.INVISIBLE);
                            tp.setVisibility(View.VISIBLE);
                            b1.setEnabled(true);
                        } else if (tp.getVisibility() == View.VISIBLE) {
                            tp.setVisibility(View.INVISIBLE);
                            glinput.setVisibility(View.VISIBLE);
                        } else if (glinput.getVisibility() == View.VISIBLE) {
                            glinput.setVisibility(View.INVISIBLE);
                            glcon.setVisibility(View.VISIBLE);
                            ch.stop();
                            b2.setEnabled(false);
                            String adult = e1.getText().toString();
                            String teenager = e2.getText().toString();
                            String children = e3.getText().toString();

                            if(adult.getBytes().length == 0){
                                adult = "0";
                            }
                            if (teenager.getBytes().length == 0){
                                teenager ="0";
                            }
                            if (children.getBytes().length == 0){
                                children ="0";
                            }

                            t1.setText(dp.getYear() + "년 " + dp.getMonth() + "월 " + dp.getDayOfMonth() + "일");
                            t2.setText(tp.getCurrentHour() + "시 " + tp.getCurrentMinute() + "분");
                            t3.setText(adult+ "명");
                            t4.setText(teenager + "명");
                            t5.setText(children + "명");
                        }
                    }
                });
            }
        });
    }
}