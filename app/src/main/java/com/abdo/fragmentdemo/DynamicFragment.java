package com.abdo.fragmentdemo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DynamicFragment extends Fragment {

    private TextView counterTextView;
    private int counter = 0;
    public DynamicFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(savedInstanceState != null){
            counter = Integer.parseInt(savedInstanceState.getString("COUNTER"));
        }
        View view = inflater.inflate(R.layout.fragment_dynamic, container, false);
        counterTextView = view.findViewById(R.id.counter_text_view);
        counterTextView.setText(String.valueOf(counter));
        return view;
    }

    void setCounter(int counter){
        counterTextView.setText(String.valueOf(counter));
    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("COUNTER", counterTextView.getText().toString().trim());
    }
}