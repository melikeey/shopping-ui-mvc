package com.melikeey.shoppingdemo.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.melikeey.shoppingdemo.R;
import com.melikeey.shoppingdemo.fragments.LoginFragment;
import com.melikeey.shoppingdemo.fragments.SharedPref;
import com.melikeey.shoppingdemo.tabs.HomeFragment;

public class MainFragment extends Fragment {

    SharedPref sharedPref;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        sharedPref = new SharedPref(getActivity());

        if (sharedPref.getInt("login")== 1) {
            Fragment homeFragment = new HomeFragment();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, homeFragment, "home")
                    .addToBackStack(null)
                    .commit();
        } else {
            Fragment loginFragment = new LoginFragment();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, loginFragment, "main")
                    .addToBackStack(null)
                    .commit();
        }

        return view;
    }
}
