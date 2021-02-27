package com.example.oldnavigationdrawer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.oldnavigationdrawer.R;

public class ActivityLifeCircleActivity extends AppCompatActivity {

    Button buttonSecond;

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("AAA", "First Activity || onRestart()");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("AAA", "First Activity || onStart()");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("AAA", "First Activity || onResume()");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("AAA", "First Activity || onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("AAA", "First Activity || onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("AAA", "First Activity || onDestroy()");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_circle);

        buttonSecond = (Button) findViewById(R.id.switch_second_activity);
        buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityLifeCircleActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
        Log.d("AAA", "First Activity || onCreate()");
    }

}