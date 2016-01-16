//This code was written by the servant of God,
//and no one except him could understand/read how it was done :D

package com.nassar.man.android.redcarpet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.nassar.man.android.redcarpet.extras.Movie;

public class MainActivity extends AppCompatActivity implements MainMovieFragment.Callback {

    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.movie_detail_container) != null) {
            mTwoPane = true;
            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.movie_detail_container, new DetailMovieFragment(),
                                DetailMovieFragment.TAG)
                        .commit();
            }
        } else {
            getSupportFragmentManager().beginTransaction().add(R.id.container, new MainMovieFragment()).commit();
            mTwoPane = false;
        }
    }

    @Override
    public void onItemSelected(Movie movie) {
        if (mTwoPane) {
            Bundle arguments = new Bundle();
            arguments.putParcelable(DetailMovieFragment.DETAIL_MOVIE, movie);

            DetailMovieFragment fragment = new DetailMovieFragment();
            fragment.setArguments(arguments);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.movie_detail_container, fragment, DetailMovieFragment.TAG)
                    .commit();
        } else {
            Intent intent = new Intent(this, DetailActivity.class)
                    .putExtra(DetailMovieFragment.DETAIL_MOVIE, movie);
            startActivity(intent);
        }
    }
}