package com.example.firatgurgurcodechallenge.Tv.TvPopular;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.firatgurgurcodechallenge.APIGeneral.URLList;
import com.example.firatgurgurcodechallenge.CustomItemClickListener;
import com.example.firatgurgurcodechallenge.Movies.MovieModel;
import com.example.firatgurgurcodechallenge.R;
import com.example.firatgurgurcodechallenge.Tv.TvModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TvPopularAdapter extends RecyclerView.Adapter<TvPopularAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView cover_photo;
        public TextView movie_name;
        public TextView movie_vote_average;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cover_photo = itemView.findViewById(R.id.imageView4);
            movie_name = itemView.findViewById(R.id.textView12);
            movie_vote_average = itemView.findViewById(R.id.textView11);

        }
    }

    private List<TvModel> popular_list;
    private Context context;
    CustomItemClickListener listener;


    public TvPopularAdapter(List<TvModel> popular_list, Context context, CustomItemClickListener listener) {
        this.popular_list = popular_list;
        this.context = context;
        this.listener = listener;

    }

    @NonNull
    @Override
    public TvPopularAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View vr = LayoutInflater.from(parent.getContext()).inflate(R.layout.tv_popular_item, parent, false);
        final TvPopularAdapter.ViewHolder view_holder = new TvPopularAdapter.ViewHolder(vr);


        vr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(view, view_holder.getPosition());
            }
        });

        return view_holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final TvPopularAdapter.ViewHolder holder, final int position) {


        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.film_poster_placeholder);
        requestOptions.error(R.drawable.film_poster_placeholder);

        Glide.with(context)
                .setDefaultRequestOptions(requestOptions)
                .load(URLList.IMAGE_BASE_URL + popular_list.get(position).getBackdrop_path())
                .into(holder.cover_photo);


        holder.movie_name.setText(popular_list.get(position).getName());
        holder.movie_vote_average.setText(String.valueOf(popular_list.get(position).getVote_average()));

    }

    @Override
    public int getItemCount() {
        return popular_list.size();
    }

}

