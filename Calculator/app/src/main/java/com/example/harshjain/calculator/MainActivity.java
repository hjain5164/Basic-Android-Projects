package com.example.harshjain.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView fno, sno, res;
    String no1, no2;
    int a, b, c = 0, action;
    Double val1 = Double.NaN;
    Double val2;
    Button one, two, three, four, five, six, seven, eight, nine, zero, clear, answer, add, sub, mul, div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        zero = (Button) findViewById(R.id.zero);
        clear = (Button) findViewById(R.id.clear);
        add = (Button) findViewById(R.id.add);
        sub = (Button) findViewById(R.id.minus);
        mul = (Button) findViewById(R.id.multiply);
        div = (Button) findViewById(R.id.divide);
        answer = (Button) findViewById(R.id.result);
        fno = (TextView) findViewById(R.id.fno);
        //zero
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fno.setText(fno.getText().toString() + "0");
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fno.setText(fno.getText().toString() + "1");
            }
        });
        //two
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fno.setText(fno.getText().toString() + "2");
            }
        });
        //three
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fno.setText(fno.getText().toString() + "3");
            }
        });
        //additon operation
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                action = 1;
                //res.setText(c+"");
            }
        });
        answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                res.setText(String.valueOf(val1));
            }
        });

    }

    public void compute() {

        if (!Double.isNaN(val1)) {
            val2 = Double.parseDouble(fno.getText().toString());
            switch (action) {
                case 1:
                    val1 += val2;
                    break;
            }

        } else
            val1 = Double.parseDouble(fno.getText().toString());


    }
}