package com.example.oldnavigationdrawer.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;


public class TestBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "TestBroadcastReceiver";


    @Override
    public void onReceive(Context context, Intent intent) {
        //Show notice la da connection hay airplane mode da thay doi
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Action: ").append(intent.getAction()).append("\n");
        stringBuilder.append("URI: ").append(intent.toUri(Intent.URI_INTENT_SCHEME)).append("\n");
        String log = stringBuilder.toString();
        Log.d(TAG, log);
        Toast.makeText(context, log, Toast.LENGTH_LONG).show();
    }
}
