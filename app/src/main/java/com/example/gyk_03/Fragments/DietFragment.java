package com.example.gyk_03.Fragments;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.gyk_03.Activities.DetailActivity;
import com.example.gyk_03.Adapters.CustomDietAdapter;
import com.example.gyk_03.Models.DietModel;
import com.example.gyk_03.R;

import java.util.ArrayList;
import java.util.List;

public class DietFragment extends Fragment {
    List<DietModel> dietList = new ArrayList<>();
    ListView dietListView;

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_diet, container, false);

        dietListView = view.findViewById(R.id.dietListView);

        dietList.add(new DietModel("Sport Diet", 1200, R.drawable.food));
        dietList.add(new DietModel("Interval Diet", 2000, R.drawable.food));
        dietList.add(new DietModel("Death Diet", 700, R.drawable.food));
        dietList.add(new DietModel("Protein Diet", 1750, R.drawable.food));
        dietList.add(new DietModel("Gain Weight Diet", 3000, R.drawable.food));

        CustomDietAdapter customDietAdapter = new CustomDietAdapter(inflater, dietList);

        dietListView.setAdapter(customDietAdapter);

        dietListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "" + dietList.get(position).getDietName() + "Clicked", Toast.LENGTH_SHORT).show();

                Intent giveInfo = new Intent(getActivity(), DetailActivity.class);
                giveInfo.putExtra("name", dietList.get(position).getDietName());
                giveInfo.putExtra("calorie", dietList.get(position).getCalorie());
                giveInfo.putExtra("image", dietList.get(position).getImageId());

                startActivity(giveInfo);
            }
        });

        return view;
    }
}
