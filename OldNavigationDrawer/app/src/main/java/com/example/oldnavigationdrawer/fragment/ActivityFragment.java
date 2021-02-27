package com.example.oldnavigationdrawer.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.oldnavigationdrawer.R;
import com.example.oldnavigationdrawer.activity.ActivityLifeCircleActivity;
import com.example.oldnavigationdrawer.activity.ExplicitIntentActivity;

public class ActivityFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_activity, container, false);
        Button buttonExplicitIntent = (Button) rootView.findViewById(R.id.button_explicit_intent);
        Button buttonImplicitIntent = (Button) rootView.findViewById(R.id.button_implicit_intent);
        Button buttonActivityLifeCircle = (Button) rootView.findViewById(R.id.button_activity_lifecircle);
        //explicit intent
        buttonExplicitIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ExplicitIntentActivity.class);
                startActivity(intent);
            }
        });
        //implicit intent
        buttonImplicitIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SENDTO);
                intent.putExtra("sms_body","This is Implicit Intent");
                intent.setData(Uri.parse("sms:0868840343"));
                startActivity(intent);
            }
        });

        buttonActivityLifeCircle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ActivityLifeCircleActivity.class);
                startActivity(intent);
            }
        });

        return rootView;
    }
}
