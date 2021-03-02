package com.example.intentphishingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getBaseContext(), "username: "+this.getIntent().getStringExtra("username")
                +"\npassword: " + this.getIntent().getStringExtra("password"),
                Toast.LENGTH_LONG).show();
    }
}