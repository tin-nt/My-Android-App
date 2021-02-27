package com.example.oldnavigationdrawer.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.oldnavigationdrawer.R;

public class SecondActivity extends Activity {

    Button buttonFirstActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        buttonFirstActivity = (Button) findViewById(R.id.switch_back);
        buttonFirstActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, ActivityLifeCircleActivity.class);
                startActivity(intent);
            }
        });
        Log.d("AAA", "Second Activity || onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("AAA", "Second Activity || onStart()");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("AAA", "Second Activity || onRestart()");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("AAA", "Second Activity || onResume()");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("AAA", "Second Activity || onPause()");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("AAA", "Second Activity || onStop()");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("AAA", "Second Activity || onDestroy()");

    }
}