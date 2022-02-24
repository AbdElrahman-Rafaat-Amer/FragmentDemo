package com.abdo.fragmentdemo;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements Communicator {

    private final String TAG = "FRAGMENT_B";
    private DynamicFragment fragmentB;
    FragmentManager manager = getSupportFragmentManager();
    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Log.i(TAG, "onCreate: Activity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            fragmentB = new DynamicFragment();
            transaction = manager.beginTransaction();
            transaction.setReorderingAllowed(true);
            transaction.add(R.id.fragmentb, fragmentB, TAG);
            transaction.commit();
        }else {
            fragmentB = (DynamicFragment) manager.findFragmentByTag(TAG);
        }
    }

    @Override
    public void respond(int counter) {
        fragmentB = (DynamicFragment) manager.findFragmentByTag(TAG);
        fragmentB.setCounter(counter);
    }

}