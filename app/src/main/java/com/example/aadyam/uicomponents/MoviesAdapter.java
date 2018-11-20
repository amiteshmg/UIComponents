package com.example.aadyam.uicomponents;

import android.content.Context;

import android.support.v7.widget.PopupMenu;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import android.view.MenuInflater;
import android.view.MenuItem;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import android.widget.Toast;

import com.bumptech.glide.Glide;
import java.util.List;

/**
 * Created by Ravi Tamada on 18/05/16.
 */
public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    private Context mContext;
    private List<Movie> moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView moviename,movie_description;
        public ImageView poster;

        public MyViewHolder(View view) {
            super(view);
            moviename = (TextView) view.findViewById(R.id.movie_edit);
            movie_description = (TextView) view.findViewById(R.id.description_edit);
            poster=(ImageView)view.findViewById(R.id.poster_imageview);




        }
    }


    public MoviesAdapter(Context mContext, List<Movie> moviesList) {
        this.mContext = mContext;
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        //used for loading data into each entry

        Movie movie = moviesList.get(position);
        holder.moviename.setText(movie.getName());
        holder.movie_description.setText("Category:"+movie.getDescription() );

        // loading album cover using Glide library
        Glide.with(mContext).load(movie.getPoster()).into(holder.poster);


    }



    @Override
    public int getItemCount()
    {
        return moviesList.size();
    }

}
