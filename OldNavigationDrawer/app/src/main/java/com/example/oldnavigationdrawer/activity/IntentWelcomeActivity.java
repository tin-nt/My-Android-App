package com.example.oldnavigationdrawer.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.oldnavigationdrawer.R;

public class IntentWelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_welcome);
        TextView textViewUsername = (TextView) findViewById(R.id.textview_intent_welcome_username);
        TextView textViewPassword = (TextView) findViewById(R.id.textview_intent_welcome_password);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        textViewUsername.setText(username);

        String password = intent.getStringExtra("password");
        textViewPassword.setText(password);
    }
}