package com.example.homeWork1;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import static android.content.res.Configuration.ORIENTATION_PORTRAIT;

public class MainActivity extends AppCompatActivity implements ListFragment.OnFragmentInteractionListener {

    ListFragment f1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getFragmentManager();
        f1 = (ListFragment) fm.findFragmentByTag("some-fragment");

        if (f1 == null) {
            f1 = new ListFragment();
            fm.beginTransaction().replace(R.id.fragment_main, f1, "some-fragment").commit();
        }
        if (getResources().getConfiguration().orientation == ORIENTATION_PORTRAIT) {
            f1.setColumns(3);
        } else {
            f1.setColumns(4);
        }
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        if (fragment instanceof ListFragment) {
            ListFragment f = (ListFragment) fragment;
            f.setonNumberSelected(this);
        }
    }


    @Override
    public void onBackPressed() {
        int count = getSupportFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            super.onBackPressed();
        } else {
            getSupportFragmentManager().popBackStack();
        }
    }

    public void onNumberSelected(int number) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
        ItemFragment f = ItemFragment.newInstance(number);
        ft.replace(R.id.fragment_main, f, "fragment");
        ft.addToBackStack("Back");
        ft.commit();
    }
}
