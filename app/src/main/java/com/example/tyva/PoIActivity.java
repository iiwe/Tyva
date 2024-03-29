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
    TextView name, description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poi_full);
        imageView = findViewById(R.id.foto);
        name = findViewById(R.id.name);
        description = findViewById(R.id.description);
        show_map = findViewById(R.id.show_map);
        Intent intent = getIntent();
        PoIData myPoi = intent.getParcelableExtra("Selected");
        System.out.println("Name = " + myPoi.getName());
        name.setText(myPoi.getName());
        imageView.setImageResource(myPoi.getFoto());
        if (myPoi.getDescription() != null){
            description.setText(myPoi.getDescription());
        }
        else {
            description.setText("Не задано!");
        }
        if((myPoi.getCoords().getLongitude() == 0.0) && (myPoi.getCoords().getLongitude() == 0.0)){

            show_map.setVisibility(View.INVISIBLE);
        }

    }
}
