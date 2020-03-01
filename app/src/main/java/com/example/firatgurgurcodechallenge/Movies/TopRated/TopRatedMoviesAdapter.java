package com.example.firatgurgurcodechallenge.Movies.TopRated;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.firatgurgurcodechallenge.APIGeneral.URLList;
import com.example.firatgurgurcodechallenge.CustomItemClickListener;
import com.example.firatgurgurcodechallenge.Movies.MovieModel;
import com.example.firatgurgurcodechallenge.R;

import java.util.List;

public class TopRatedMoviesAdapter extends RecyclerView.Adapter<TopRatedMoviesAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView cover_photo;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cover_photo = itemView.findViewById(R.id.imageView3);

        }
    }

    private List<MovieModel> top_rated_list;
    private Context context;
    CustomItemClickListener listener;


    public TopRatedMoviesAdapter(List<MovieModel> top_rated_list, Context context, CustomItemClickListener listener) {
        this.top_rated_list = top_rated_list;
        this.context = context;
        this.listener = listener;

    }

    @NonNull
    @Override
    public TopRatedMoviesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View vr = LayoutInflater.from(parent.getContext()).inflate(R.layout.top_rated_movies_card_item, parent, false);
        final TopRatedMoviesAdapter.ViewHolder view_holder = new TopRatedMoviesAdapter.ViewHolder(vr);


        vr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(view, view_holder.getPosition());
            }
        });

        return view_holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final TopRatedMoviesAdapter.ViewHolder holder, final int position) {


        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.film_poster_placeholder);
        requestOptions.error(R.drawable.film_poster_placeholder);

        Glide.with(context)
                .setDefaultRequestOptions(requestOptions)
                .load(URLList.IMAGE_BASE_URL + top_rated_list.get(position).getBackdrop_path())
                .into(holder.cover_photo);


    }

    @Override
    public int getItemCount() {
        return top_rated_list.size();
    }

}
