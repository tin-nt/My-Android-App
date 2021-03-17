package com.example.oldnavigationdrawer.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.oldnavigationdrawer.R;

public class SimpleLoginTestCaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_login_test_case);
        Button buttonLogin = (Button) findViewById(R.id.button_login);
        EditText editTextUsername = (EditText) findViewById(R.id.edittext_login_username);
        EditText editTextPassword = (EditText) findViewById(R.id.edittext_password_username);

        // yeu cau viet 1 malicious app de goi vao welcome
        buttonLogin.setOnClickListener(v -> {
            String username = editTextUsername.getText().toString();
            String password = editTextPassword.getText().toString();
            if(!username.equals("admin") || !password.equals("admin")){
                Toast.makeText(this, "Unauthorized", Toast.LENGTH_SHORT).show();
            }
            else{
                Intent intent = new Intent(this, WelcomeActivity.class);
                startActivity(intent);
            }
        });
    }
}