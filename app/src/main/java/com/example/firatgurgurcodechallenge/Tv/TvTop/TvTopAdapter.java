package com.example.firatgurgurcodechallenge.Tv.TvTop;

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

import java.util.List;

public class TvTopAdapter extends RecyclerView.Adapter<TvTopAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView cover_photo;
        public TextView tv_name;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cover_photo = itemView.findViewById(R.id.imageView4);
            tv_name = itemView.findViewById(R.id.textView8);

        }
    }

    private List<TvModel> tv_list;
    private Context context;
    CustomItemClickListener listener;


    public TvTopAdapter(List<TvModel> tv_list, Context context, CustomItemClickListener listener) {
        this.tv_list = tv_list;
        this.context = context;
        this.listener = listener;

    }

    @NonNull
    @Override
    public TvTopAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View vr = LayoutInflater.from(parent.getContext()).inflate(R.layout.now_playing_item, parent, false);
        final TvTopAdapter.ViewHolder view_holder = new TvTopAdapter.ViewHolder(vr);


        vr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(view, view_holder.getPosition());
            }
        });

        return view_holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final TvTopAdapter.ViewHolder holder, final int position) {


        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.film_poster_placeholder);
        requestOptions.error(R.drawable.film_poster_placeholder);

        Glide.with(context)
                .setDefaultRequestOptions(requestOptions)
                .load(URLList.IMAGE_BASE_URL + tv_list.get(position).getPoster_path())
                .into(holder.cover_photo);

        holder.tv_name.setText(tv_list.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return tv_list.size();
    }

}

