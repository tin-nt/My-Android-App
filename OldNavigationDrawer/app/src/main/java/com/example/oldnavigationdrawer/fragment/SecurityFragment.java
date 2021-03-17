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
import com.example.oldnavigationdrawer.activity.IntentLoginTestCaseActivity;
import com.example.oldnavigationdrawer.activity.SimpleLoginTestCaseActivity;

public class SecurityFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_security, container, false);
        Button buttonSimpleLogin = (Button) rootView.findViewById(R.id.button_simple_login_check);
        Button buttonIntentLogin = (Button) rootView.findViewById(R.id.button_intent_login_test_case);
        buttonSimpleLogin.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), SimpleLoginTestCaseActivity.class);
            startActivity(intent);
        });
        buttonIntentLogin.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), IntentLoginTestCaseActivity.class);
            startActivity(intent);
        });
        return rootView;
    }
}
