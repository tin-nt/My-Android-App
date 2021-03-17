package com.example.oldnavigationdrawer.fragment;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.oldnavigationdrawer.R;
import com.example.oldnavigationdrawer.receiver.TestBroadcastReceiver;

import java.util.Objects;

public class BroadcastFragment extends Fragment {
    IntentFilter intentFilter;
    BroadcastReceiver broadcastReceiver;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        broadcastReceiver = new TestBroadcastReceiver();
        // check network
        intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        // check airplane mode
//        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);

        getActivity().registerReceiver(broadcastReceiver, intentFilter);
        return inflater.inflate(R.layout.fragment_broadcast, container, false);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getActivity().unregisterReceiver(broadcastReceiver);
    }
}
