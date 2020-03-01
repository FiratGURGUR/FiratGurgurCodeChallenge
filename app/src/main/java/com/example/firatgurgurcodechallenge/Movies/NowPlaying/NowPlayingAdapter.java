package com.example.firatgurgurcodechallenge.Movies.NowPlaying;

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

import java.util.List;

public class NowPlayingAdapter extends RecyclerView.Adapter<NowPlayingAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView cover_photo;
        public TextView movie_name;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cover_photo = itemView.findViewById(R.id.imageView4);
            movie_name = itemView.findViewById(R.id.textView8);

        }
    }

    private List<MovieModel> now_playing_list;
    private Context context;
    CustomItemClickListener listener;


    public NowPlayingAdapter(List<MovieModel> now_playing_list, Context context, CustomItemClickListener listener) {
        this.now_playing_list = now_playing_list;
        this.context = context;
        this.listener = listener;

    }

    @NonNull
    @Override
    public NowPlayingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View vr = LayoutInflater.from(parent.getContext()).inflate(R.layout.now_playing_item, parent, false);
        final NowPlayingAdapter.ViewHolder view_holder = new NowPlayingAdapter.ViewHolder(vr);


        vr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(view, view_holder.getPosition());
            }
        });

        return view_holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final NowPlayingAdapter.ViewHolder holder, final int position) {

        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.film_poster_placeholder);
        requestOptions.error(R.drawable.film_poster_placeholder);

        Glide.with(context)
                .setDefaultRequestOptions(requestOptions)
                .load(URLList.IMAGE_BASE_URL + now_playing_list.get(position).getPoster_path())
                .into(holder.cover_photo);

        holder.movie_name.setText(now_playing_list.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return now_playing_list.size();
    }

}

