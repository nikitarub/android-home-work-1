package com.example.homeWork1;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;


import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment {
    private OnFragmentInteractionListener callback;
    private GridView gridView;
    private List<String> data = new ArrayList<>();
    private int columns = 3;

    public ListFragment() {
        for (int i = 1; i < 101; ++i) {
            data.add(String.valueOf(i));
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list, container, false);
        gridView = v.findViewById(R.id.grid_numbers);
        setupAdapter();
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                callback.onNumberSelected(position + 1);

            }
        });
        gridView.setNumColumns(columns);

        Button clickButton = v.findViewById(R.id.button_add_number);
        clickButton.setText("Добавить число");
        clickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.add(String.valueOf(data.size() + 1));
                setupAdapter();
            }
        });

        return v;
    }


    void setupAdapter() {
        if (getActivity() == null || gridView == null) return;
        if (data != null) {
            MyAdapter adapter = new MyAdapter(getActivity(), R.layout.list_item, data);
            gridView.setAdapter(adapter);
        } else {
            gridView.setAdapter(null);
        }
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public void setonNumberSelected(ListFragment.OnFragmentInteractionListener activity) {
        callback = activity;
    }

    public interface OnFragmentInteractionListener {
        void onNumberSelected(int number);
    }
}
