package com.ma.mj.hw2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main3Activity extends AppCompatActivity {
    Button b1, b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.papapapap);
    }
    public void noMyClick(View v){
        if (v.getId() == R.id.button6){
            Intent intent  = new Intent(Main3Activity.this, MainActivity.class);
            startActivity(intent);
        }
        else if(v.getId() == R.id.button7){
            Intent intent  = new Intent(Main3Activity.this, Main2Activity.class);
            startActivity(intent);
        }
    }
}
