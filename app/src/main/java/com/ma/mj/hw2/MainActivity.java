package com.ma.mj.hw2;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2,e3;
    Button b1, b2;
    TextView t1,t2;
    ImageView d1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Switch s1;
        Chronometer c1;
        DatePicker date;
        TimePicker time;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hwreal);
        init();
    }

    void init(){
        e1 = (EditText)findViewById(R.id.editText);
        e2 = (EditText)findViewById(R.id.editText2);
        e3 = (EditText)findViewById(R.id.editText3);
        b1 = (Button) findViewById(R.id.button9);
        b2 = (Button) findViewById(R.id.button10);
        t1 = (TextView) findViewById(R.id.textView6);
        t2 = (TextView) findViewById(R.id.textView8);
        d1 = (ImageView) findViewById(R.id.imageView);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String korean = e1.getText().toString();
                String mathmatics = e2.getText().toString();
                String english = e3.getText().toString();

                if (korean.getBytes().length == 0){
                    e1.setText("0");
                    korean = e1.getText().toString();
                }
                if (mathmatics.getBytes().length == 0){
                    e2.setText("0");
                    mathmatics = e2.getText().toString();
                }
                if (english.getBytes().length == 0){
                    e3.setText("0");
                    english = e3.getText().toString();
                }

                int total = Integer.parseInt(korean) + Integer.parseInt(mathmatics) + Integer.parseInt(english);
                int average = total / 3;

                t1.setText(total+"점");
                t2.setText(average+"점");

                if (average >= 90){
                    d1.setImageResource(R.drawable.aicon);
                }
                else if (average >= 80){
                    d1.setImageResource(R.drawable.bicon);
                }
                else if (average >= 70){
                    d1.setImageResource(R.drawable.cicon);
                }
                else if (average >= 60){
                    d1.setImageResource(R.drawable.dicon);
                }
                else{
                    d1.setImageResource(R.drawable.ficon);
                }
                d1.setVisibility(View.VISIBLE);
            }
        });

        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                e1.setText("");
                e2.setText("");
                e3.setText("");
                t1.setText("0점");
                t2.setText("0점");

                d1.setVisibility(View.INVISIBLE);

                Toast.makeText(getApplicationContext(),"초기화 되었습니다.",Toast.LENGTH_SHORT).show();
            }
        });
    }

}
