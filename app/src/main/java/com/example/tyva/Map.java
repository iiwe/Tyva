package com.example.tyva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.yandex.mapkit.geometry.Point;

import java.util.ArrayList;

public class Map extends AppCompatActivity {


    ArrayList<PoIData> poIData = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        poIData.add(new PoIData("Центр Азии", new Point(51.72515656949432,94.44365188425749)));
        poIData.add(new PoIData("Центр Азии", new Point(51.72515656949432,94.44365188425749)));
        poIData.add(new PoIData("Центр Азии", new Point(51.72515656949432,94.44365188425749)));
        poIData.add(new PoIData("Центр Азии", new Point(51.72515656949432,94.44365188425749)));
        poIData.add(new PoIData("Центр Азии", new Point(51.72515656949432,94.44365188425749)));
        PoIAdapter poIAdapter = new PoIAdapter(this, poIData);
        ListView listView = (ListView) findViewById(R.id.list_PoI);
        listView.setAdapter(poIAdapter);
    }


    public void show_map(View view) {
        Intent intent = new Intent(this, PoI.class);
        startActivity(intent);
    }
}