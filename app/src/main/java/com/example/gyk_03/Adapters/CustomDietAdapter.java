package com.example.gyk_03.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.gyk_03.Models.DietModel;
import com.example.gyk_03.R;
import java.util.ArrayList;
import java.util.List;

public class CustomDietAdapter extends BaseAdapter {
    private LayoutInflater context;
    private List<DietModel> dietList = new ArrayList<>();

    public CustomDietAdapter(LayoutInflater context, List<DietModel> dietList) {
        this.context = context;
        this.dietList = dietList;
    }

    @Override
    public int getCount() {
        return dietList.size();
    }

    @Override
    public Object getItem(int position) {
        return dietList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = context.inflate(R.layout.diet_list_design,parent,false);

        TextView dietName = view.findViewById(R.id.dietName);
        dietName.setText(dietList.get(position).getDietName());

        TextView calories = view.findViewById(R.id.cal00);
        calories.setText(String.valueOf(dietList.get(position).getCalorie()));

        ImageView imageDiet = view.findViewById(R.id.foodImage);
        imageDiet.setImageResource(dietList.get(position).getImageId());

        return view;
    }
}
