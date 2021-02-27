package com.example.oldnavigationdrawer.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.oldnavigationdrawer.R;
import com.example.oldnavigationdrawer.activity.BoundServiceActivity;
import com.example.oldnavigationdrawer.activity.StartedServiceActivity;
import com.example.oldnavigationdrawer.service.BoundService;
import com.example.oldnavigationdrawer.service.StartedService;

public class ServiceFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView =inflater.inflate(R.layout.fragment_service, container, false);
        Button buttonStartedService = (Button) rootView.findViewById(R.id.button_started_service);
        Button buttonBoundService = (Button) rootView.findViewById(R.id.button_bound_service);

        buttonStartedService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), StartedServiceActivity.class);
                startActivity(intent);
            }
        });
        buttonBoundService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BoundServiceActivity.class);
                startActivity(intent);
            }
        });
        return rootView;
    }
}
