package com.example.firatgurgurcodechallenge.Detail;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.firatgurgurcodechallenge.APIGeneral.APIClass;
import com.example.firatgurgurcodechallenge.APIGeneral.URLList;
import com.example.firatgurgurcodechallenge.CustomItemClickListener;
import com.example.firatgurgurcodechallenge.Detail.CastAndCrew.CastCrewAdapter;
import com.example.firatgurgurcodechallenge.Detail.CastAndCrew.CastCrewList;
import com.example.firatgurgurcodechallenge.Detail.CastAndCrew.CastCrewModel;
import com.example.firatgurgurcodechallenge.Detail.CastAndCrew.CastModel;
import com.example.firatgurgurcodechallenge.Detail.CastAndCrew.CrewModel;
import com.example.firatgurgurcodechallenge.Movies.MModel;
import com.example.firatgurgurcodechallenge.R;
import com.example.firatgurgurcodechallenge.Statics;

import com.example.firatgurgurcodechallenge.Tv.TTModel;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.ArrayList;
import java.util.List;

public class TvDetail extends AppCompatActivity {
    RecyclerView recyclerView;
    CastCrewAdapter castCrewAdapter;
    List<CastCrewList> castCrewModelList;
    AppBarLayout appBarLayout;
    CollapsingToolbarLayout collapsingToolbarLayout;

    public static int tv_id = -1;
    Context context;
    APIClass apiClass;
    public String movieName = "";
    ImageView posterImage, backImage;
    TextView movie_name, movie_overview, movie_genres, movie_vote_avg;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Statics.setTransparetStatusBar(TvDetail.this);
        setContentView(R.layout.activity_tv_detail);

        context = this;
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        recyclerView = findViewById(R.id.crew_rcycler);
        castCrewModelList = new ArrayList<>();

        appBarLayout = findViewById(R.id.appbar);
        collapsingToolbarLayout = findViewById(R.id.collapsingToolbar);

        loadDetail();
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            tv_id = bundle.getInt("tv_id");
            Log.i("frt", "id : " + tv_id);
        }


        loadCrew();

        new Thread(new Runnable() {
            @Override
            public void run() {
                getMovieDetail(tv_id);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                getCastCrewPeople(tv_id);
            }
        }).start();

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {


                if (Math.abs(verticalOffset) - appBarLayout.getTotalScrollRange() == 0) {
                    //  Collapsed
                    appBarLayout.setBackgroundColor(getColor(R.color.textview_back));
                    collapsingToolbarLayout.setTitle(movieName);
                    collapsingToolbarLayout.setCollapsedTitleTextColor(getColor(R.color.tab_menu_item_color));
                    toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.tab_menu_item_color), PorterDuff.Mode.SRC_ATOP);

                } else {
                    collapsingToolbarLayout.setTitle(" ");
                    toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);

                }
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.movie_detail_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.share:
                Toast.makeText(this, "Paylaş", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void loadCrew() {

        castCrewAdapter = new CastCrewAdapter(castCrewModelList, TvDetail.this, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(castCrewAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }


    public void getMovieDetail(int id) {
        apiClass = new APIClass();
        apiClass.getTvDetail(handler, id);
    }

    public void getCastCrewPeople(int id) {
        apiClass = new APIClass();
        apiClass.getTVCastAndCrew(handler, id);
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what) {
                case 0:
                    break;
                case 1:
                    final TTModel model = (TTModel) msg.obj;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            loadContent(model);
                        }
                    });
                    break;
                case 3:
                    //Filmin cast ve crew kadrosu
                    CastCrewModel sum = (CastCrewModel) msg.obj;
                    List<CastModel> casts = sum.getCastModels();
                    List<CrewModel> crews = sum.getCrewModels();
                    for (int i = 0; i < casts.size(); i++) {
                        castCrewModelList.add(new CastCrewList(casts.get(i).getId(), casts.get(i).getName(), casts.get(i).getProfile_path(), ""));
                    }
                    for (int i = 0; i < crews.size(); i++) {
                        castCrewModelList.add(new CastCrewList(crews.get(i).getId(), crews.get(i).getName(), crews.get(i).getProfile_path(), crews.get(i).getJob()));
                    }
                    castCrewAdapter.notifyDataSetChanged();
                    break;
            }
        }
    };


    public void loadDetail() {
        posterImage = findViewById(R.id.poster);
        backImage = findViewById(R.id.back_image);
        movie_name = findViewById(R.id.moview_name);
        movie_overview = findViewById(R.id.overviewTv);
        movie_genres = findViewById(R.id.genres);
        movie_vote_avg = findViewById(R.id.vote_avarage);
    }


    public void loadContent(TTModel model) {
        movieName = model.getName();
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.film_poster_placeholder);
        requestOptions.error(R.drawable.film_poster_placeholder);

        Glide.with(context)
                .setDefaultRequestOptions(requestOptions)
                .load(URLList.IMAGE_BASE_URL + model.getBackdropPath()).into(backImage);

        Glide.with(context)
                .setDefaultRequestOptions(requestOptions)
                .load(URLList.IMAGE_BASE_URL + model.getPosterPath())
                .into(posterImage);

        movie_name.setText(model.getName());
        movie_overview.setText(model.getOverview());
        movie_vote_avg.setText(String.valueOf(model.getVoteAverage()));

        List<TTModel.Genre> genres = model.getGenres();
        for (int i = 0; i < model.getGenres().size(); i++) {
            movie_genres.append(genres.get(i).getName());
            if (i != genres.size() - 1) {
                movie_genres.append(", ");
            }
        }


    }

}
