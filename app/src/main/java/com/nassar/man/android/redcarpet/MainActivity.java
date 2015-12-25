//This code was written by the servant of God,
//and no one except him could understand/read how it was done.

package com.nassar.man.android.redcarpet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().add(R.id.container, new MainMovieFragment()).commit();
        }
    }
}