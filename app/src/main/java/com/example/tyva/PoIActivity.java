package com.example.tyva;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PoIActivity extends AppCompatActivity {
    ImageView imageView;
    Button show_map;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poi_full);
        imageView = findViewById(R.id.foto);
        textView = findViewById(R.id.name);
        show_map = findViewById(R.id.show_map);
        Intent intent = getIntent();
        PoIData myPoi = intent.getParcelableExtra("Selected");
        System.out.println("Name = " + myPoi.getName());
        textView.setText(myPoi.getName());
        imageView.setImageResource(myPoi.getFoto());
        if((myPoi.getCoords().getLongitude() == 0.0) && (myPoi.getCoords().getLongitude() == 0.0)){

            show_map.setVisibility(View.INVISIBLE);
        }

    }
}
