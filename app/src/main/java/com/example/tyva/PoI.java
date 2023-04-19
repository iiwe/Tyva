package com.example.tyva;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.yandex.mapkit.Animation;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.geometry.Circle;
import com.yandex.mapkit.geometry.LinearRing;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.geometry.Polygon;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.map.CircleMapObject;
import com.yandex.mapkit.map.IconStyle;
import com.yandex.mapkit.map.MapObject;
import com.yandex.mapkit.map.MapObjectCollection;
import com.yandex.mapkit.map.MapObjectTapListener;
import com.yandex.mapkit.map.PlacemarkMapObject;
import com.yandex.mapkit.map.PolygonMapObject;
import com.yandex.mapkit.mapview.MapView;
import com.yandex.runtime.image.AnimatedImageProvider;
import com.yandex.runtime.image.ImageProvider;
import com.yandex.runtime.ui_view.ViewProvider;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class PoI extends AppCompatActivity {
    private MapView mapview;

    private final Point CAMERA_TARGET = new Point(51.71982705977847, 94.44525207784682);

    private final Point ANIMATED_PLACEMARK_CENTER = new Point(59.948, 30.318);
    private Button full_screen;
    private MapObjectCollection mapObjects;
    private Handler animationHandler;
    private ArrayList<PoIData> my_PoIs; //объявление
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MapKitFactory.setApiKey("cf58a573-a7a6-48c2-8c69-1d3803d134cb");
        my_PoIs = getIntent().getExtras().getParcelableArrayList("PoI");

        setContentView(R.layout.activity_po_i);
        mapview = (MapView)findViewById(R.id.mapview);
        mapview.getMap().move(
                new CameraPosition(CAMERA_TARGET, 17.0f, 0.0f, 0.0f));
        mapObjects = mapview.getMap().getMapObjects().addCollection();
        animationHandler = new Handler();
        createMapObjects();

        full_screen = findViewById(R.id.full_screen);
    }
    @Override
    protected void onStop() {
        mapview.onStop();
        MapKitFactory.getInstance().onStop();
        super.onStop();
    }

    @Override
    protected void onStart() {
        super.onStart();
        MapKitFactory.getInstance().onStart();
        mapview.onStart();
    }
    private void createMapObjects() {
        createTappableCircle();
        createAnimatedPlacemark();
    }

    // Strong reference to the listener.
    private MapObjectTapListener circleMapObjectTapListener = (mapObject, point) -> {
        if (mapObject instanceof CircleMapObject) {
            CircleMapObject circle = (CircleMapObject)mapObject;

            Object userData = circle.getUserData();
            System.out.println(userData);

            //что делать при нажатии на объект
            if (userData instanceof PoIData) {
                PoIData circleUserData = (PoIData) userData;

                Toast toast = Toast.makeText(
                        getApplicationContext(),
                        "" + circleUserData.getName(),
                        Toast.LENGTH_SHORT);
                toast.show();
            }
        }
        return true;
    };


    private void createTappableCircle() {

        for (PoIData p: my_PoIs) {
            CircleMapObject circle = mapObjects.addCircle(
                    new Circle(p.getCoords(), 50), Color.RED, 2, Color.RED);
            circle.setZIndex(50.0f);
            circle.setUserData(p);
            // Client code must retain strong reference to the listener.
            circle.addTapListener(circleMapObjectTapListener);
        }

    }

//    private void createPlacemarkMapObjectWithViewProvider() {
//        final TextView textView = new TextView(this);
//        final int[] colors = new int[] { Color.RED, Color.GREEN, Color.BLACK };
//        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        textView.setLayoutParams(params);
//
//        textView.setTextColor(Color.RED);
//        textView.setText("Hello, World!");
//
//        final ViewProvider viewProvider = new ViewProvider(textView);
//        final PlacemarkMapObject viewPlacemark =
//                mapObjects.addPlacemark(new Point(59.946263, 30.315181), viewProvider);
//
//        final Random random = new Random();
//        final int delayToShowInitialText = 5000;  // milliseconds
//        final int delayToShowRandomText = 500; // milliseconds;
//
//        // Show initial text `delayToShowInitialText` milliseconds and then
//        // randomly change text in textView every `delayToShowRandomText` milliseconds
//        animationHandler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                final int randomInt = random.nextInt(1000);
//                textView.setText("Some text version " + randomInt);
//                textView.setTextColor(colors[randomInt % colors.length]);
//                viewProvider.snapshot();
//                viewPlacemark.setView(viewProvider);
//                animationHandler.postDelayed(this, delayToShowRandomText);
//            }
//        }, delayToShowInitialText);
//    }

    private void createAnimatedPlacemark() {
        AnimatedImageProvider imageProvider =
                AnimatedImageProvider.fromAsset(this,"animation.png");
        PlacemarkMapObject animatedPlacemark =
                mapObjects.addPlacemark(ANIMATED_PLACEMARK_CENTER, imageProvider, new IconStyle());
        animatedPlacemark.useAnimation().play();
    }

    public void full(View view) {
        mapview.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        full_screen.setVisibility(View.INVISIBLE);
    }
}