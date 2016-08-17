package com.powernusa.andy.popmovies;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.powernusa.andy.popmovies.data.Result;

import java.util.List;

/**
 * Created by Andy on 8/17/2016.
 */
public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>{

    private Context mContext;
    private List<Result> mMoviesList;
    public static final String LOG_TAG = MoviesAdapter.class.getSimpleName();

    public MoviesAdapter(Context context, List<Result> movies){
        mContext = context;
        mMoviesList = movies;
    }
    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.list_item_movie,parent,false);

        MovieViewHolder viewHolder = new MovieViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        holder.mTitle.setText(mMoviesList.get(position).getTitle());
        //Log.d(LOG_TAG,">>>Title: " + mMoviesList.get(position).getTitle());
        holder.mDescription.setText(mMoviesList.get(position).getOverview());
        Log.d(LOG_TAG, ">>>>>Description: " + mMoviesList.get(position).getOverview());

    }

    @Override
    public int getItemCount() {
        Log.d(LOG_TAG,"Item count: " + mMoviesList.size());
        return mMoviesList.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder{
        TextView mTitle;
        TextView mSubtitle;
        TextView mDescription;

        public MovieViewHolder(View itemView) {
            super(itemView);
            //mTitle = (TextView) itemView.findViewById(R.id.title);
            mTitle = (TextView) itemView.findViewById(R.id.overview);
            mSubtitle = (TextView) itemView.findViewById(R.id.subtitle);
            mDescription = (TextView) itemView.findViewById(R.id.description);
        }
    }
}
