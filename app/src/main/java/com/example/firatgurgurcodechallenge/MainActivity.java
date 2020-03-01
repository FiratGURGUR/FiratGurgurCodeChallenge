package com.example.firatgurgurcodechallenge;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.firatgurgurcodechallenge.Movies.MoviesFragment;
import com.example.firatgurgurcodechallenge.Profile.ProfileFragment;
import com.example.firatgurgurcodechallenge.Tv.Tvfragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout ln_movies, ln_tv, ln_profile;
    ImageView ln_movies_img, ln_tv_img, ln_profile_img;
    TextView ln_movies_tv, ln_tv_tv, ln_profile_tv, section;
    View[] array;
    public static FragmentManager fragmentManager;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Statics.setTransparetStatusBar(MainActivity.this);
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.theme_color));

        setContentView(R.layout.activity_main);

        section = findViewById(R.id.section_tv);
        ln_movies = findViewById(R.id.menu_movies_item);
        ln_tv = findViewById(R.id.menu_tv_item);
        ln_profile = findViewById(R.id.menu_profile_item);

        array = new View[]{ln_movies, ln_tv, ln_profile};


        ln_movies.setOnClickListener(this);
        ln_tv.setOnClickListener(this);
        ln_profile.setOnClickListener(this);

        ln_movies_img = ln_movies.findViewById(R.id.imageView);
        ln_movies_tv = ln_movies.findViewById(R.id.textView3);
        ln_tv_img = ln_tv.findViewById(R.id.imageView);
        ln_tv_tv = ln_tv.findViewById(R.id.textView3);
        ln_profile_img = ln_profile.findViewById(R.id.imageView);
        ln_profile_tv = ln_profile.findViewById(R.id.textView3);


        ln_movies_img.setImageDrawable(getDrawable(R.drawable.ic_tab_movies));
        ln_movies_tv.setText(getString(R.string.tab_menu_1));
        ln_tv_img.setImageDrawable(getDrawable(R.drawable.ic_tab_tv));
        ln_tv_tv.setText(getString(R.string.tab_menu_2));
        ln_profile_img.setImageDrawable(getDrawable(R.drawable.ic_tab_profile));
        ln_profile_tv.setText(getString(R.string.tab_menu_3));


        ln_movies_img.setImageDrawable(getDrawable(R.drawable.ic_tab_movies_selected));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            ln_movies_tv.setTextColor(getColor(R.color.splash_center_color));
        }

        section.setText("Movies");
        Statics.passOtherFragment(MainActivity.this, new MoviesFragment(), "movies_fragment");


    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onClick(View v) {
        deactive_button(v.getId());
        switch (v.getId()) {
            case R.id.menu_movies_item:
                section.setText("Movies");

                Statics.passOtherFragment(MainActivity.this, new MoviesFragment(), "movies_fragment");
                break;
            case R.id.menu_tv_item:
                section.setText("Tv");
                Statics.passOtherFragment(MainActivity.this, new Tvfragment(), "tv_fragment");
                break;
            case R.id.menu_profile_item:
                section.setText("Profile");
                Statics.passOtherFragment(MainActivity.this, new ProfileFragment(), "profile_fragment");
                break;
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    public void deactive_button(int id) {
        for (View v : array) {
            if (v.getId() == id) {
                TextView tv = v.findViewById(R.id.textView3);
                ImageView imageView = v.findViewById(R.id.imageView);
                if (v.getId() == R.id.menu_movies_item) {
                    imageView.setImageDrawable(getDrawable(R.drawable.ic_tab_movies_selected));
                } else if (v.getId() == R.id.menu_tv_item) {
                    imageView.setImageDrawable(getDrawable(R.drawable.ic_tab_tv_selected));
                } else if (v.getId() == R.id.menu_profile_item) {
                    imageView.setImageDrawable(getDrawable(R.drawable.ic_tab_profile_selected));
                }

                tv.setTextColor(getColor(R.color.splash_center_color));
            } else {
                TextView tv = v.findViewById(R.id.textView3);
                ImageView imageView = v.findViewById(R.id.imageView);
                if (v.getId() == R.id.menu_movies_item) {
                    imageView.setImageDrawable(getDrawable(R.drawable.ic_tab_movies));
                } else if (v.getId() == R.id.menu_tv_item) {
                    imageView.setImageDrawable(getDrawable(R.drawable.ic_tab_tv));
                } else if (v.getId() == R.id.menu_profile_item) {
                    imageView.setImageDrawable(getDrawable(R.drawable.ic_tab_profile));
                }
                tv.setTextColor(getColor(R.color.tab_menu_item_color));
            }
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

        if (Statics.ControlFragment_TagName.equals("v")) {
            finish();
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                deactive_button(R.id.menu_movies_item);
            }
            Statics.passOtherFragment(MainActivity.this, new MoviesFragment(), "movies_fragment");
        }

    }


    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}
