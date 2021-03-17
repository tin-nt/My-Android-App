package com.example.randomorg;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editNum1, editNum2;
        Button btnRandom;
        TextView txtView;
        editNum1 = (EditText) findViewById(R.id.minNum);
        editNum2 = (EditText) findViewById(R.id.maxNum);
        btnRandom = (Button) findViewById(R.id.buttonRandom);
        txtView = (TextView) findViewById(R.id.showNum);
        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string1 = editNum1.getText().toString().trim();
                String string2 = editNum2.getText().toString().trim();
                if(string1.isEmpty() || string2.isEmpty()){
                    Toast.makeText(MainActivity.this, "Input number pls!!!",Toast.LENGTH_LONG).show();
                }else{
                    int num1 = Integer.parseInt(string1);
                    int num2 = Integer.parseInt(string2);
                    if(Integer.compare(num1,num2) > 0){
                        Toast.makeText(MainActivity.this, "Min must not larger than Max", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    Random ranNum = new Random();
                    int number = ranNum.nextInt(num2 - num1 +1) + num1;
                    txtView.setText(String.valueOf(number));
                }
            }
        });
    }
}