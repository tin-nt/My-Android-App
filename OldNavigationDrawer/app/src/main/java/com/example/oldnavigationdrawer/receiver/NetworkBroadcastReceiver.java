package com.example.oldnavigationdrawer.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;



public class NetworkBroadcastReceiver  extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())){
            Toast.makeText(context, "Connectivity changed", Toast.LENGTH_SHORT).show();
        }
    }
}
