package com.example.firatgurgurcodechallenge.Tv;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.example.firatgurgurcodechallenge.APIGeneral.APIClass;
import com.example.firatgurgurcodechallenge.CustomItemClickListener;
import com.example.firatgurgurcodechallenge.Detail.MovieDetail;
import com.example.firatgurgurcodechallenge.Detail.TvDetail;
import com.example.firatgurgurcodechallenge.R;
import com.example.firatgurgurcodechallenge.StartSnapHelper;
import com.example.firatgurgurcodechallenge.Statics;
import com.example.firatgurgurcodechallenge.Tv.TvPopular.TvPopularAdapter;
import com.example.firatgurgurcodechallenge.Tv.TvTop.TvTopAdapter;

import java.util.ArrayList;
import java.util.List;

public class Tvfragment extends Fragment {

    NestedScrollView mScrollView;
    //top list
    RecyclerView recyclerViewTv;
    TvTopAdapter tVAdapter;
    List<TvModel> tVList;

    //popular tv
    RecyclerView recyclerViewPopularTv;
    TvPopularAdapter popularTVAdapter;
    List<TvModel> popularTVList;

    Context context;
    APIClass apiClass;

    public int popularPage = 1;
    public int topRatedPage = 1;


    private boolean loading = true;
    int pastVisiblesItems, visibleItemCount, totalItemCount;

    TextView sectionTv, sectionPopular;
    ImageView loadingPlaceholder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tv, container, false);
        context = getActivity();
        recyclerViewTv = view.findViewById(R.id.tv_recycler);
        recyclerViewPopularTv = view.findViewById(R.id.popular_tv_recycler);
        tVList = new ArrayList<>();
        popularTVList = new ArrayList<>();

        mScrollView = view.findViewById(R.id.nested);

        loadTv();
        recyclerViewPopularTv.setNestedScrollingEnabled(false);
        loadTvPopular();

        sectionTv = view.findViewById(R.id.textView5);
        sectionPopular = view.findViewById(R.id.textView7);
        loadingPlaceholder = view.findViewById(R.id.imageView7);


        if (Statics.isConnected(getContext())) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    tVGetTopRated(topRatedPage);
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    tVGetPopular(popularPage);
                }
            }).start();
        } else {
            Toast.makeText(context, getString(R.string.no_internet), Toast.LENGTH_LONG).show();
        }


        recyclerViewTv.addOnScrollListener(new RecyclerView.OnScrollListener() {
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
                            tVGetTopRated(topRatedPage);
                        }
                    }).start();
                }
            }
        });


        mScrollView.post(new Runnable() {
            @Override
            public void run() {
                ViewTreeObserver observer = mScrollView.getViewTreeObserver();
                observer.addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
                    @Override
                    public void onScrollChanged() {
                        View view = (View) mScrollView.getChildAt(mScrollView.getChildCount() - 1);

                        int diff = (view.getBottom() - (mScrollView.getHeight() + mScrollView
                                .getScrollY()));

                        if (diff == 0) {
                            LinearLayoutManager linearLayoutManagerFlw = LinearLayoutManager.class.cast(recyclerViewPopularTv.getLayoutManager());
                            visibleItemCount = linearLayoutManagerFlw.getChildCount();
                            totalItemCount = linearLayoutManagerFlw.getItemCount();
                            pastVisiblesItems = linearLayoutManagerFlw.findFirstVisibleItemPosition();
                            if (loading) {
                                if ((visibleItemCount + pastVisiblesItems) >= totalItemCount) {
                                    popularPage = popularPage + 1;
                                    loading = false;
                                    Log.v("firat", "Last Item Wow !");
                                    Log.i("firat", " visibleItemCount :  " + visibleItemCount);
                                    Log.i("firat", " totalItemCount :  " + totalItemCount);
                                    Log.i("firat", " pastVisiblesItems  :  " + pastVisiblesItems);
                                    Log.i("firat", " list size  :  " + popularTVList.size());

                                    new Thread(new Runnable() {
                                        @Override
                                        public void run() {
                                            tVGetPopular(popularPage);
                                        }
                                    }).start();
                                }
                            }
                        }
                    }
                });
            }
        });


        return view;
    }


    public void loadTv() {
        tVAdapter = new TvTopAdapter(tVList, getActivity(), new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {

                if (Statics.isConnected(getContext())) {
                    ImageView imageStart = (ImageView) v.findViewById(R.id.imageView4);
                    Intent openDetail = new Intent(getActivity(), TvDetail.class);
                    String transitionName = "posterImageTransition";
                    ViewCompat.setTransitionName(imageStart, transitionName);
                    ActivityOptionsCompat options = ActivityOptionsCompat.
                            makeSceneTransitionAnimation(getActivity(), imageStart, transitionName);
                    openDetail.putExtra("tv_id", tVList.get(position).getId());
                    startActivity(openDetail, options.toBundle());
                } else {
                    Toast.makeText(context, getString(R.string.no_internet), Toast.LENGTH_LONG).show();
                }


            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerViewTv.setLayoutManager(linearLayoutManager);

        //CUSTOM SNAPHELPER
        SnapHelper startSnapHelper = new StartSnapHelper();
        startSnapHelper.attachToRecyclerView(recyclerViewTv);

        recyclerViewTv.setHasFixedSize(true);
        recyclerViewTv.setAdapter(tVAdapter);
        recyclerViewTv.setItemAnimator(new DefaultItemAnimator());
    }

    LinearLayoutManager popularlinearLayoutManager;

    public void loadTvPopular() {

        popularTVAdapter = new TvPopularAdapter(popularTVList, getActivity(), new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {

                if (Statics.isConnected(getContext())) {
                    ImageView imageStart = (ImageView) v.findViewById(R.id.imageView4);
                    Intent openDetail = new Intent(getActivity(), TvDetail.class);
                    String transitionName = "backPoster";
                    ViewCompat.setTransitionName(imageStart, transitionName);
                    ActivityOptionsCompat options = ActivityOptionsCompat.
                            makeSceneTransitionAnimation(getActivity(), imageStart, transitionName);
                    openDetail.putExtra("tv_id", popularTVList.get(position).getId());
                    startActivity(openDetail, options.toBundle());
                } else {
                    Toast.makeText(context, getString(R.string.no_internet), Toast.LENGTH_LONG).show();
                }


            }
        });

        popularlinearLayoutManager = new LinearLayoutManager(getActivity());
        popularlinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewPopularTv.setLayoutManager(popularlinearLayoutManager);

        SnapHelper startSnapHelper = new StartSnapHelper();
        startSnapHelper.attachToRecyclerView(recyclerViewPopularTv);

        recyclerViewPopularTv.setHasFixedSize(true);
        recyclerViewPopularTv.setAdapter(popularTVAdapter);
        recyclerViewPopularTv.setItemAnimator(new DefaultItemAnimator());
    }

    public void tVGetTopRated(int page) {
        apiClass = new APIClass();
        apiClass.getTopRatedTv(handler, page);
    }

    public void tVGetPopular(int page) {
        apiClass = new APIClass();
        apiClass.getPopularTv(handler, page);
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what) {
                case 0:
                    break;
                case 1:
                    tVList.addAll((ArrayList<TvModel>) msg.obj);
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            doldurTopRared();
                        }
                    });
                    break;
                case 2:
                    popularTVList.addAll((ArrayList<TvModel>) msg.obj);
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            doldurPopular();
                        }
                    });
                    loading = true;
                    break;

            }
        }
    };


    public void doldurTopRared() {
        tVAdapter.notifyDataSetChanged();
        sectionTv.setVisibility(View.VISIBLE);
        recyclerViewTv.setVisibility(View.VISIBLE);
        loadingPlaceholder.setVisibility(View.INVISIBLE);
    }

    public void doldurPopular() {
        popularTVAdapter.notifyDataSetChanged();
        sectionPopular.setVisibility(View.VISIBLE);
        recyclerViewPopularTv.setVisibility(View.VISIBLE);
        loadingPlaceholder.setVisibility(View.INVISIBLE);
    }
}
