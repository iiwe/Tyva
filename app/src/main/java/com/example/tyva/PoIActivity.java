package com.example.tyva;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PoIActivity extends AppCompatActivity {
    ImageView imageView;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poi_full);
        imageView = findViewById(R.id.foto);
        textView = findViewById(R.id.name);
        Intent intent = getIntent();
        PoIData myPoi = intent.getParcelableExtra("Selected");
        textView.setText(myPoi.getName());
        imageView.setImageResource(myPoi.getFoto());
    }
}
