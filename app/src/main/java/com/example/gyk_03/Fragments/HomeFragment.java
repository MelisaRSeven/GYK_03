package com.example.gyk_03.Fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.gyk_03.R;

public class HomeFragment extends Fragment {
    EditText weight, height;
    TextView userResult;
    Button calculateButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        weight = view.findViewById(R.id.weight);
        height = view.findViewById(R.id.height);
        userResult = view.findViewById(R.id.calculatedMass);

        calculateButton = view.findViewById(R.id.buttonCalculate);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });
        return view;
    }

    private void calculate() {
        if(weight.getText().toString().length() > 0 && height.getText().toString().length() > 0) {
            float userWeight = Float.parseFloat(weight.getText().toString());
            float userHeight = Float.parseFloat(height.getText().toString());

            if (userHeight > 0) {
                userHeight = userHeight / 100;
                userHeight = userHeight * userHeight;
                float result = userWeight / userHeight;

                String resultDescription;

                if (result < 16.5) {
                    resultDescription = "Severely Underweight";
                } else if (result < 18.5) {
                    resultDescription = "Underweight";
                } else if (result < 24.9) {
                    resultDescription = "Healthy";
                } else if (result < 29.9) {
                    resultDescription = "Overweight";
                } else {
                    resultDescription = "Obese";
                }

                userResult.setText("Your Body Mass Index (BMI) is :" + result + "\n" + resultDescription);
            }
        }else {
            final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setTitle("Error!");
            builder.setMessage("Height or Weight cannot be empty.");
            builder.setNegativeButton("Okay", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int id) {
                }
            });

            builder.show();
        }
    }
}
