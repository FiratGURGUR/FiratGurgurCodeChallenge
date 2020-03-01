package com.example.firatgurgurcodechallenge.Profile;

        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;

        import androidx.fragment.app.Fragment;

        import com.bumptech.glide.Glide;
        import com.bumptech.glide.request.RequestOptions;
        import com.example.firatgurgurcodechallenge.R;

public class ProfileFragment extends Fragment {
    ImageView app_image;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        app_image = view.findViewById(R.id.imageView2);

        Glide.with(getActivity())
                .load(R.drawable.profile_icon)
                .into(app_image);

        return view;
    }
}