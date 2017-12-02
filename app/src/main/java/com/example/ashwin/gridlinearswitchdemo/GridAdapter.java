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

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.GridViewHolder> {

    Context mContext;
    private List<Movie> mMoviesList;

    public GridAdapter(Context context, List<Movie> moviesList) {
        mContext = context;
        mMoviesList = moviesList;
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageView;
        private TextView mTextView;

        public GridViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.gridImageView);
            mTextView = (TextView) itemView.findViewById(R.id.gridTitleTextView);
        }
    }

    @Override
    public GridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_grid_item, parent, false);

        return new GridViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(GridViewHolder holder, int position) {
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
