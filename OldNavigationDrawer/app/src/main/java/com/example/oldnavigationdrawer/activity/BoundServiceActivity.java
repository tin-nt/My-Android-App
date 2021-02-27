package com.example.oldnavigationdrawer.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.oldnavigationdrawer.R;
import com.example.oldnavigationdrawer.service.BoundService;
import com.example.oldnavigationdrawer.service.StartedService;

public class BoundServiceActivity extends AppCompatActivity implements View.OnClickListener {

    public boolean boundService = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bound_service);

        Button buttonStartService = (Button) findViewById(R.id.button_start_bound_service);
        Button buttonStopService = (Button) findViewById(R.id.button_stop_bound_service);
//        Intent intent = new Intent(BoundServiceActivity.this, BoundService.class);
        buttonStartService.setOnClickListener(this);
        buttonStopService.setOnClickListener(this);
    }

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            boundService = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            boundService = false;
        }
    };

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(BoundServiceActivity.this, BoundService.class);
        switch (v.getId()){
            case R.id.button_start_bound_service:
                bindService(intent,serviceConnection,BIND_AUTO_CREATE);
                break;
            case R.id.button_stop_bound_service:
                if(boundService){
                    unbindService(serviceConnection);
                    boundService = false;
                }
                break;
        }

    }
}