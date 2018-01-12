package com.purebook.purebook_android.base;

import android.app.Activity;
import android.support.v4.app.Fragment;

/**
 * Fragment基类
 * @author chrischen
 */

public abstract class BaseFragment extends Fragment {
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    public void onStart() {
        super.onStart();
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
    }

}
