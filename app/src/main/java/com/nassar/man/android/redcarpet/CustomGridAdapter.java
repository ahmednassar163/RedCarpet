//This code was written by the servant of God,
//and no one except him could understand/read how it was done.

package com.nassar.man.android.redcarpet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nassar.man.android.redcarpet.extras.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Andy on 12/2/2015.
 */
public class CustomGridAdapter extends BaseAdapter {

    private Context mContext;
    private final LayoutInflater mInflater;

    private final Movie mLock = new Movie();

    private List<Movie> mObjects;


    public CustomGridAdapter(Context context, List<Movie> objects) {
        mContext = context;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mObjects = objects;
    }

    public Context getContext() {
        return mContext;
    }

    public void add(Movie object) {
        synchronized (mLock) {
            mObjects.add(object);
        }
        notifyDataSetChanged();
    }

    public void clear() {
        synchronized (mLock) {
            mObjects.clear();
        }
        notifyDataSetChanged();
    }

    public void setData(List<Movie> data) {
        clear();
        for (Movie movie : data) {
            add(movie);
        }
    }

    @Override
    public int getCount() {
        return mObjects.size();
    }

    @Override
    public Movie getItem(int position) {
        return mObjects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder viewHolder;

        if (view == null) {
            view = mInflater.inflate(R.layout.grid_item_movie_display, parent, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }

        final Movie movie = getItem(position);

        String image_url = "http://image.tmdb.org/t/p/w185" + movie.getImage();

        viewHolder = (ViewHolder) view.getTag();

        Picasso.with(getContext())
                .load(image_url)
                .error(R.drawable.ic_no_poster_error)
                .into(viewHolder.moviePoster);
        viewHolder.movieTitle.setText(movie.getTitle());

        return view;
    }

    public static class ViewHolder {
        public final ImageView moviePoster;
        public final TextView movieTitle;

        public ViewHolder(View view) {
            movieTitle = (TextView) view.findViewById(R.id.grid_movie_title);
            moviePoster = (ImageView) view.findViewById(R.id.grid_movie_image);
        }
    }
}