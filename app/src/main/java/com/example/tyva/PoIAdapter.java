package com.example.tyva;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PoIAdapter extends BaseAdapter {

    Context context;
    LayoutInflater layoutInflater;
    ArrayList<PoIData> poIDatas;

// конструктор для некоторых служебных настроек
    PoIAdapter(Context context, ArrayList<PoIData> poIDatas){
        this.context = context;
        this.poIDatas = poIDatas;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return poIDatas.size();
    }

    @Override
    public Object getItem(int i) {
        return poIDatas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        View view = convertView;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.poi_item, viewGroup, false);
        }
        PoIData poIData = poIDatas.get(i); //тот, на кого мы тыкнули
        ((TextView)view.findViewById(R.id.namePoi)).setText(poIData.getName());
        ((ImageView)view.findViewById(R.id.fotoPoi)).setImageResource(R.drawable.flag_tyva_new);
        return view;
    }
}
