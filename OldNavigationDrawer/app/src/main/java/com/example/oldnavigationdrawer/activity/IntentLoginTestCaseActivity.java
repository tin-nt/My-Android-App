package com.example.oldnavigationdrawer.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.oldnavigationdrawer.R;

public class IntentLoginTestCaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_login_test_case);
        EditText editTextUsername = (EditText) findViewById(R.id.edit_text_intent_login_username);
        EditText editTextPassword = (EditText) findViewById(R.id.edit_text_intent_login_password);
        Button buttonLogin = (Button) findViewById(R.id.button_intent_login_check);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("username",username);
                intent.putExtra("password",password);
                intent.setAction("com.example.oldnavigationdrawer.activity.IntentWelcomeActivity");
                intent.addCategory(Intent.CATEGORY_DEFAULT);
                startActivity(intent);
            }
        });
    }
}