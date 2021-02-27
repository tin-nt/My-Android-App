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
import com.example.oldnavigationdrawer.activity.ContentProviderActivity;

public class ContentProviderFragment  extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_content_provider, container, false);
        Button button = (Button) rootView.findViewById(R.id.button_switch_activity_content_provider);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ContentProviderActivity.class);
                startActivity(intent);
            }
        });
        return rootView;
    }
}
