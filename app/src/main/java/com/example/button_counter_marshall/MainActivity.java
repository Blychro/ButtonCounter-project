package com.example.button_counter_marshall;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private TextView count;
    private int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        count = findViewById(R.id.textView);
        num = 0;

        count.setTextSize(35);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num -= 1;
                count.setText(num + "");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num += 1;
                count.setText(num + "");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = 0;
                count.setText(num + "");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num *= 2;
                count.setText(num + "");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num /= 2;
                count.setText(num + "");
            }
        });
    }

    @Override
    protected void onSaveInstanceState (Bundle outState) {
        super.onSaveInstanceState(outState);

        String value = count.getText().toString();
        int rNum = num;
        outState.putString("key", value);
        outState.putInt("key2", rNum);
    }

    @Override
    protected void onRestoreInstanceState (@NonNull Bundle savedInstanceSate) {
        super.onRestoreInstanceState(savedInstanceSate);

        String value = savedInstanceSate.getString("key");
        int value2 = savedInstanceSate.getInt("key2");

        num = value2;
        count.setText(value);
    }
}
