package com.example.firatgurgurcodechallenge;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Statics {

    public static Fragment ControlFragment = null;
    public static String ControlFragment_TagName = "";
    public static Fragment f;

    public static void setTransparetStatusBar(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
    }

    public static boolean isFragmentInBackstack(final FragmentManager fragmentManager, final String fragmentTagName) {
        for (int entry = 0; entry < fragmentManager.getBackStackEntryCount(); entry++) {
            if (fragmentTagName.equals(fragmentManager.getBackStackEntryAt(entry).getName())) {
                return true;
            }
        }
        return false;
    }

    public static void passOtherFragment(AppCompatActivity activity, Fragment fragment, String tag) {


        MainActivity.fragmentManager = activity.getSupportFragmentManager();
        FragmentManager manager = activity.getSupportFragmentManager();
        if (isFragmentInBackstack(manager, Statics.ControlFragment_TagName)) {
            manager.beginTransaction().remove(Statics.ControlFragment).commit();
        }
        open_fragment(activity, fragment, tag);

    }


    public static void open_fragment(AppCompatActivity activity, Fragment fragment, String tag) {
        if (f != null)
            f.onDestroy();
        f = fragment;
        FragmentManager manager = activity.getSupportFragmentManager();
        manager.beginTransaction()
                .replace(R.id.frame_main_container, fragment, tag)
                .addToBackStack(fragment.getTag())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();
        Statics.ControlFragment = fragment;
        Statics.ControlFragment_TagName = tag;
    }

    //pixelden dp ye dönüştürme işlemi
    public static int pxToDp(int px) {
        return (int) (px / Resources.getSystem().getDisplayMetrics().density);
    }

    //dp den px'e donusturme işlemi
    public static int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    public static boolean isConnected(Context context) {
        ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        boolean isConnected = false;
        if (networkInfo != null && (networkInfo.isConnected())) {
            isConnected = true;
        }
        return isConnected;
    }


}
