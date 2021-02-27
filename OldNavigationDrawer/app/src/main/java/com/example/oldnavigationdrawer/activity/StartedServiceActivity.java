package com.example.oldnavigationdrawer.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.oldnavigationdrawer.R;
import com.example.oldnavigationdrawer.service.StartedService;

public class StartedServiceActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_started_service);

        Button buttonStartService = (Button) findViewById(R.id.button_start_started_service);
        Button buttonStopService = (Button) findViewById(R.id.button_stop_started_service);

        buttonStartService.setOnClickListener(this);
        buttonStopService.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, StartedService.class);
        switch (v.getId()){
            case R.id.button_start_started_service:
                startService(intent);
                break;
            case R.id.button_stop_started_service:
                stopService(intent);
                break;
        }
    }
}