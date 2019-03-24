package com.example.homeWork1;

import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



public class ItemFragment extends Fragment {

    public ItemFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public static ItemFragment newInstance(int number) {
        ItemFragment fragment = new ItemFragment();
        Bundle args = new Bundle();
        args.putInt("number", number);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_single_item, container, false);
        Bundle args = getArguments();
        if (args != null) {
            int number = args.getInt("number");
            TextView numberText = v.findViewById(R.id.text_big_number);
            numberText.setText(String.valueOf(number));
            if (number % 2 == 1) {
                numberText.setTextColor(Color.parseColor("#EB5757"));
            } else {
                numberText.setTextColor(Color.parseColor("#2F80ED"));
            }
        }
        return v;
    }
}
