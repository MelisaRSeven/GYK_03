package com.example.gyk_03.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gyk_03.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.detailImage)
    ImageView detailImage;
    @BindView(R.id.info)
    TextView info;
    @BindView(R.id.cal03)
    TextView cal03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        if(getIntent().getExtras() != null) {
            info.setText(getIntent().getExtras().getString("name"));
            cal03.setText(String.valueOf(getIntent().getExtras().getInt("calorie")));
            detailImage.setImageResource(getIntent().getIntExtra("image", 0));
        }
    }
}
