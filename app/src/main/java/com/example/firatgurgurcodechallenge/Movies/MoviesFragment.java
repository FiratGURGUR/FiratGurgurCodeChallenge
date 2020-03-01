package com.example.firatgurgurcodechallenge.Movies;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.example.firatgurgurcodechallenge.APIGeneral.APIClass;
import com.example.firatgurgurcodechallenge.CustomItemClickListener;
import com.example.firatgurgurcodechallenge.Detail.MovieDetail;
import com.example.firatgurgurcodechallenge.Movies.NowPlaying.NowPlayingAdapter;
import com.example.firatgurgurcodechallenge.Movies.Popular.PopularAdapter;
import com.example.firatgurgurcodechallenge.Movies.TopRated.TopRatedMoviesAdapter;
import com.example.firatgurgurcodechallenge.R;
import com.example.firatgurgurcodechallenge.Statics;
import com.github.rubensousa.gravitysnaphelper.GravityPagerSnapHelper;

import java.util.ArrayList;
import java.util.List;

public class MoviesFragment extends Fragment {
    ConstraintLayout mainLayout;
    //TOPRATED
    RecyclerView recyclerViewTopRated;
    TopRatedMoviesAdapter topRatedMoviesAdapter;
    List<MovieModel> topRatedList;
    //nowPLAYING
    RecyclerView recyclerViewNowPlaying;
    NowPlayingAdapter nowPlayingMoviesAdapter;
    List<MovieModel> nowPlayingList;
    //popular
    RecyclerView recyclerViewPopular;
    PopularAdapter popularAdapter;
    List<MovieModel> popularList;

    Context context;
    APIClass apiClass;

    public int popularPage = 1;
    public int topRatedPage = 1;
    public int nowPlayingPage = 1;
    ImageView loadingPlaceholder;
    TextView sectionTopRated, sectionNowPlaying, sectionPopular;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movies, container, false);

        context = getActivity();
        mainLayout = view.findViewById(R.id.mainLayout);
        recyclerViewTopRated = view.findViewById(R.id.top_rated_recycler);
        recyclerViewNowPlaying = view.findViewById(R.id.now_playing_recycler);
        recyclerViewPopular = view.findViewById(R.id.popular_recycler);
        topRatedList = new ArrayList<>();
        nowPlayingList = new ArrayList<>();
        popularList = new ArrayList<>();

        loadTopRated();
        loadNowPlaying();
        loadPopular();
        loadingPlaceholder = view.findViewById(R.id.imageView6);


        sectionTopRated = view.findViewById(R.id.textView5);
        sectionNowPlaying = view.findViewById(R.id.textView6);
        sectionPopular = view.findViewById(R.id.textView7);

        if (Statics.isConnected(getContext())) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    moviewGetPopular(popularPage);
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    moviewGetTopRated(topRatedPage);
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    moviewGetNowPlaying(nowPlayingPage);
                }
            }).start();
        } else {
            Toast.makeText(context, getString(R.string.no_internet), Toast.LENGTH_LONG).show();
        }


        recyclerViewPopular.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                LinearLayoutManager layoutManager = LinearLayoutManager.class.cast(recyclerView.getLayoutManager());
                int totalItemCount = layoutManager.getItemCount();
                int lastVisible = layoutManager.findLastVisibleItemPosition();


                boolean endHasBeenReached = lastVisible + 5 >= totalItemCount;
                if (totalItemCount > 0 && endHasBeenReached) {
                    //you have reached to the bottom of your recycler view
                    popularPage = popularPage + 1;
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            moviewGetPopular(popularPage);
                        }
                    }).start();
                }
            }
        });

        recyclerViewTopRated.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                LinearLayoutManager layoutManager = LinearLayoutManager.class.cast(recyclerView.getLayoutManager());
                int totalItemCount = layoutManager.getItemCount();
                int lastVisible = layoutManager.findLastVisibleItemPosition();

                boolean endHasBeenReached = lastVisible + 5 >= totalItemCount;
                if (totalItemCount > 0 && endHasBeenReached) {
                    //you have reached to the bottom of your recycler view
                    topRatedPage = topRatedPage + 1;
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            moviewGetTopRated(topRatedPage);
                        }
                    }).start();
                }
            }
        });

        recyclerViewNowPlaying.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                LinearLayoutManager layoutManager = LinearLayoutManager.class.cast(recyclerView.getLayoutManager());
                int totalItemCount = layoutManager.getItemCount();
                int lastVisible = layoutManager.findLastVisibleItemPosition();

                boolean endHasBeenReached = lastVisible + 5 >= totalItemCount;
                if (totalItemCount > 0 && endHasBeenReached) {
                    //you have reached to the bottom of your recycler view
                    nowPlayingPage = nowPlayingPage + 1;
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            moviewGetNowPlaying(nowPlayingPage);
                        }
                    }).start();
                }
            }
        });

        return view;
    }

    public void loadTopRated() {
        topRatedMoviesAdapter = new TopRatedMoviesAdapter(topRatedList, getActivity(), new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {

                if (Statics.isConnected(getContext())) {
                    ImageView imageStart = (ImageView) v.findViewById(R.id.imageView3);
                    Intent openDetail = new Intent(getActivity(), MovieDetail.class);
                    String transitionName = "backPoster";
                    ViewCompat.setTransitionName(imageStart, transitionName);
                    ActivityOptionsCompat options = ActivityOptionsCompat.
                            makeSceneTransitionAnimation(getActivity(), imageStart, transitionName);
                    openDetail.putExtra("movie_id", topRatedList.get(position).getId());
                    startActivity(openDetail, options.toBundle());
                } else {
                    Toast.makeText(context, getString(R.string.no_internet), Toast.LENGTH_LONG).show();
                }


            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerViewTopRated.setLayoutManager(linearLayoutManager);
        SnapHelper snapHelper = new GravityPagerSnapHelper(Gravity.START);
        snapHelper.attachToRecyclerView(recyclerViewTopRated);
        recyclerViewTopRated.setHasFixedSize(true);
        recyclerViewTopRated.setAdapter(topRatedMoviesAdapter);
        recyclerViewTopRated.setItemAnimator(new DefaultItemAnimator());
    }


    public void loadNowPlaying() {


        nowPlayingMoviesAdapter = new NowPlayingAdapter(nowPlayingList, getActivity(), new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {


                if (Statics.isConnected(getContext())) {
                    ImageView imageStart = (ImageView) v.findViewById(R.id.imageView4);
                    Intent openDetail = new Intent(getActivity(), MovieDetail.class);
                    String transitionName = "posterImageTransition";
                    ViewCompat.setTransitionName(imageStart, transitionName);
                    ActivityOptionsCompat options = ActivityOptionsCompat.
                            makeSceneTransitionAnimation(getActivity(), imageStart, transitionName);
                    openDetail.putExtra("movie_id", nowPlayingList.get(position).getId());
                    startActivity(openDetail, options.toBundle());
                } else {
                    Toast.makeText(context, getString(R.string.no_internet), Toast.LENGTH_LONG).show();
                }


            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerViewNowPlaying.setLayoutManager(linearLayoutManager);
        recyclerViewNowPlaying.setHasFixedSize(true);
        recyclerViewNowPlaying.setAdapter(nowPlayingMoviesAdapter);
        recyclerViewNowPlaying.setItemAnimator(new DefaultItemAnimator());
    }


    public void loadPopular() {

        popularAdapter = new PopularAdapter(popularList, getActivity(), new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {

                if (Statics.isConnected(getContext())) {
                    ImageView imageStart = (ImageView) v.findViewById(R.id.imageView4);
                    Intent openDetail = new Intent(getActivity(), MovieDetail.class);
                    String transitionName = "posterImageTransition";
                    ViewCompat.setTransitionName(imageStart, transitionName);
                    ActivityOptionsCompat options = ActivityOptionsCompat.
                            makeSceneTransitionAnimation(getActivity(), imageStart, transitionName);
                    openDetail.putExtra("movie_id", popularList.get(position).getId());
                    startActivity(openDetail, options.toBundle());
                } else {
                    Toast.makeText(context, getString(R.string.no_internet), Toast.LENGTH_LONG).show();
                }


            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerViewPopular.setLayoutManager(linearLayoutManager);
        recyclerViewPopular.setHasFixedSize(true);
        recyclerViewPopular.setAdapter(popularAdapter);
        recyclerViewPopular.setItemAnimator(new DefaultItemAnimator());
    }


    public void moviewGetPopular(int page) {
        apiClass = new APIClass();
        apiClass.getPopularMovies(handler, page);

    }

    public void moviewGetTopRated(int page) {
        apiClass = new APIClass();
        apiClass.getTopRatedMovies(handler, page);
    }

    public void moviewGetNowPlaying(int page) {
        apiClass = new APIClass();
        apiClass.getNowPlayingMovies(handler, page);
    }


    Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what) {
                case 0:
                    break;
                case 1:
                    popularList.addAll((ArrayList<MovieModel>) msg.obj);
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            doldurPopular();
                        }
                    });

                    break;
                case 2:
                    topRatedList.addAll((ArrayList<MovieModel>) msg.obj);
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            doldurTopRared();
                        }
                    });
                    break;
                case 3:
                    nowPlayingList.addAll((ArrayList<MovieModel>) msg.obj);
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            doldurNowPlaying();
                        }
                    });
                    break;
            }
        }
    };


    public void doldurPopular() {
        popularAdapter.notifyDataSetChanged();
        sectionPopular.setVisibility(View.VISIBLE);
        recyclerViewPopular.setVisibility(View.VISIBLE);
        loadingPlaceholder.setVisibility(View.INVISIBLE);
    }

    public void doldurTopRared() {
        topRatedMoviesAdapter.notifyDataSetChanged();
        sectionTopRated.setVisibility(View.VISIBLE);
        recyclerViewTopRated.setVisibility(View.VISIBLE);
        loadingPlaceholder.setVisibility(View.INVISIBLE);
    }

    public void doldurNowPlaying() {
        nowPlayingMoviesAdapter.notifyDataSetChanged();
        sectionNowPlaying.setVisibility(View.VISIBLE);
        recyclerViewNowPlaying.setVisibility(View.VISIBLE);
        loadingPlaceholder.setVisibility(View.INVISIBLE);
    }
}