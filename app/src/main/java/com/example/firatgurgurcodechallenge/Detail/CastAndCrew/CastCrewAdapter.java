package com.example.firatgurgurcodechallenge.Detail.CastAndCrew;

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
  import com.example.firatgurgurcodechallenge.R;

import java.util.List;

public class CastCrewAdapter extends RecyclerView.Adapter<CastCrewAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        public ImageView photo;
        public TextView name;
        public TextView job;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            photo = itemView.findViewById(R.id.imageView5);
            name = itemView.findViewById(R.id.textView);
            job = itemView.findViewById(R.id.textView13);

        }
    }

    private List<CastCrewList> cast_crew_list;
    private Context context;
    CustomItemClickListener listener;


    public CastCrewAdapter(List<CastCrewList> cast_crew_list, Context context, CustomItemClickListener listener){
        this.cast_crew_list = cast_crew_list;
        this.context = context;
        this.listener = listener;

    }

    @NonNull
    @Override
    public CastCrewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View vr = LayoutInflater.from(parent.getContext()).inflate(R.layout.cast_crew_item,parent,false);
        final CastCrewAdapter.ViewHolder view_holder = new CastCrewAdapter.ViewHolder(vr);


        vr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(view, view_holder.getPosition());
            }
        });

        return view_holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final CastCrewAdapter.ViewHolder holder, final int position) {


        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.placeholder_people);
        requestOptions.error(R.drawable.placeholder_people);

        Glide.with(context)
                .setDefaultRequestOptions(requestOptions)
                .load(URLList.IMAGE_BASE_URL + cast_crew_list.get(position).getPhoto()).into(holder.photo);

        holder.name.setText(cast_crew_list.get(position).getName());
        holder.job.setText(cast_crew_list.get(position).getJob());

    }

    @Override
    public int getItemCount() {
        return cast_crew_list.size();
    }

}

