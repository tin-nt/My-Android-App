package com.example.deeplink;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.textView);
        Uri uri = getIntent().getData();
        if( uri != null){
            List<String> parameters = uri.getPathSegments();
            String param = parameters.get(parameters.size() - 1);
            textView.setText(param);
        }
        //myapp://example.com
    }
}