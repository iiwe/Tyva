package com.example.tyva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void About(View view) {
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }
    public void Dictionary(View view) {
        Intent intent = new Intent(this, Phrasebook.class);
        startActivity(intent);
    }
    public void PoI(View view) {
        Intent intent = new Intent(this, Map.class);
        startActivity(intent);
    }
}