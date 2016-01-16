//This code was written by the servant of God,
//and no one except him could understand/read how it was done :D

package com.nassar.man.android.redcarpet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if (savedInstanceState == null) {
            Bundle arguments = new Bundle();
            arguments.putParcelable(DetailMovieFragment.DETAIL_MOVIE,
                    getIntent().getParcelableExtra(DetailMovieFragment.DETAIL_MOVIE));

            DetailMovieFragment fragment = new DetailMovieFragment();
            fragment.setArguments(arguments);

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.movie_detail_container, fragment)
                    .commit();
        }
    }
}
