package com.example.ashwin.gridlinearswitchdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by ashwin on 2/12/17.
 */

public class LinearAdapter extends RecyclerView.Adapter<LinearAdapter.LinearViewHolder> {

    Context mContext;
    List<Movie> mMoviesList;

    public LinearAdapter(Context context, List<Movie> moviesList) {
        mContext = context;
        mMoviesList = moviesList;
    }

    public class LinearViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextView;

        public LinearViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.linearImageView);
            mTextView = (TextView) itemView.findViewById(R.id.linearTitleTextView);
        }
    }

    @Override
    public LinearViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_linear_item, parent, false);

        return new LinearViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(LinearViewHolder holder, int position) {
        Movie movie = mMoviesList.get(position);

        Glide.with(mContext)
                .load(movie.getImage())
                .into(holder.mImageView);

        (holder.mTextView).setText(movie.getName());
    }

    @Override
    public int getItemCount() {
        return mMoviesList.size();
    }
}
