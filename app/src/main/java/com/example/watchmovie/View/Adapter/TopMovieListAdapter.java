package com.example.watchmovie.View.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.watchmovie.R;
import com.example.watchmovie.Service.Model.Result;

import java.util.List;

public class TopMovieListAdapter extends RecyclerView.Adapter<TopMovieListAdapter.myViewHolder> {


    private Context mCtx;
    private List<Result> mList;

    public TopMovieListAdapter(Context mCtx, List<Result> mList) {
        this.mCtx = mCtx;
        this.mList = mList;
    }



    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mCtx).inflate(R.layout.movie_single_row, parent, false);

        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        holder.title.setText(mList.get(position).getTitle());
        holder.rating.setText(String.valueOf(mList.get(position).getVoteAverage()));
        holder.releaseDate.setText(mList.get(position).getReleaseDate());
        Glide.with(mCtx).load("https://image.tmdb.org/t/p/original"+mList.get(position).getPosterPath()).into(holder.mImageView);

    }

    @Override
    public int getItemCount() {

        if(this.mList!=null){
            return mList.size();
        }
        else
            return 0;

    }






    public class myViewHolder extends RecyclerView.ViewHolder{

        ImageView mImageView;
        TextView title, rating, releaseDate;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            rating = itemView.findViewById(R.id.rating);
            releaseDate = itemView.findViewById(R.id.release_date);
            mImageView = itemView.findViewById(R.id.movie_poster);

        }
    }




}
