package com.religion76.autoservicedemo;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.religion76.common.ComponentFragment;
import java.util.ServiceLoader;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment();
    }

    private void loadFragment(){
        long start = System.currentTimeMillis();
        ServiceLoader<ComponentFragment> loader = ServiceLoader.load(ComponentFragment.class);
        for (ComponentFragment fragment : loader) {
            Log.d(TAG, "load " + fragment.getClass().getSimpleName());
        }

        Log.d(TAG, "service load cost: " + (System.currentTimeMillis() - start));
    }
}
