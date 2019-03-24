package com.example.homeWork1;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.List;

public class MyAdapter extends ArrayAdapter<String> {

    private List<String> data;
    private Context context;

    MyAdapter(Context context, int textViewResourceId, List<String> data) {
        super(context, textViewResourceId, data);
        this.context = context;
        this.data = data;
    }


    @Override
    public View getView(int position, View convertView, android.view.ViewGroup parent) {
        TextView tv;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            tv = (TextView)inflater.inflate(R.layout.list_item,parent,false);
        } else {
            tv = (TextView) convertView;
        }
        tv.setText(data.get(position));
        if (position % 2 == 1)
            tv.setTextColor(Color.parseColor("#2F80ED")); // TODO экспортировать цвета из res
        else
            tv.setTextColor(Color.parseColor("#EB5757")); // red

        return tv;
    }
}
