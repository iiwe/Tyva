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
    private LinkedList<PoIData> my_PoIs; //объявление
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MapKitFactory.setApiKey("cf58a573-a7a6-48c2-8c69-1d3803d134cb");
        my_PoIs = new LinkedList<>(); //инициализация
        setContentView(R.layout.activity_po_i);
        my_PoIs.add(new PoIData("Центр Азии", new Point(51.72515656949432,94.44365188425749)));
        my_PoIs.add(new PoIData("Гора Ак-Хайыракан и Моренская пещера", new Point(50.360700, 95.452978)));
        my_PoIs.add(new PoIData("Aржаан Ажыг-Суг", new Point(51.764981, 92.106207)));
        my_PoIs.add(new PoIData("озеро Азас", new Point(52.394587, 96.501249)));
        my_PoIs.add(new PoIData("гора Бай-Тайга", new Point(51.245975, 89.959614)));
        my_PoIs.add(new PoIData("Бижиктиг-Хая и каменное изваяние Чингисхана", new Point(51.057274, 90.595495)));
        my_PoIs.add(new PoIData("Буддийская ниша Суме", new Point(51.607277, 92.395501)));
        my_PoIs.add(new PoIData("гора Догэ:", new Point(51.761853, 94.423260)));
        my_PoIs.add(new PoIData("Долина царей", new Point(52.071665, 93.631851)));
        my_PoIs.add(new PoIData("Долина царей", new Point(52.095953, 93.711247)));
        my_PoIs.add(new PoIData("озеро Дус-Холь", new Point(50.336154, 95.015473)));
        my_PoIs.add(new PoIData("Дургенский каньон", new Point(51.046501, 94.537952)));
        my_PoIs.add(new PoIData("река Эне-Сай(Енисей)", new Point(51.728576, 94.455307)));
        my_PoIs.add(new PoIData("озеро Кара-Холь", new Point(51.415881, 89.484937)));
        my_PoIs.add(new PoIData("озеро Каък", new Point(51.333563, 93.572949)));
        my_PoIs.add(new PoIData("гора Кежеге", new Point(50.033971, 95.457023)));
        my_PoIs.add(new PoIData("каньон Кызыл-Эл", new Point(51.372820, 93.189490)));
        my_PoIs.add(new PoIData("река Кызыл-Хем", new Point(51.618802, 95.083672)));
        my_PoIs.add(new PoIData("гора Монгун-Тайга", new Point(50.278795, 90.118663)));
        my_PoIs.add(new PoIData("писаница Мугур-Саргол", new Point(51.699368, 92.288905)));
        my_PoIs.add(new PoIData("Пор-Бажын", new Point(50.615235, 97.384962)));
        my_PoIs.add(new PoIData("Сарыг-Хая и село Кызыл-Даг", new Point(51.131828, 89.892892)));
        my_PoIs.add(new PoIData("Скифское золото", new Point(51.719081288623094, 94.42954759663938)));
        my_PoIs.add(new PoIData("озеро Сут-Холь", new Point(51.516453, 91.167058)));
        my_PoIs.add(new PoIData("гора Сыын-Чурээ", new Point(51.357530, 92.471939)));
        my_PoIs.add(new PoIData("аржаан Тарыс", new Point(50.374175, 98.196749)));
        my_PoIs.add(new PoIData("скала Теве-Хая", new Point(50.545726, 95.121543)));
        my_PoIs.add(new PoIData("Убсунурская котловина и озеро Торе-Холь", new Point(50.646991, 93.181116)));
        my_PoIs.add(new PoIData("Улуг-Хорум", new Point(50.488300, 91.235469)));
        my_PoIs.add(new PoIData("Устуу-Хурээ", new Point(51.258591, 91.654167)));
        my_PoIs.add(new PoIData("Уттуг-Хая", new Point(51.211816, 90.842841)));
        my_PoIs.add(new PoIData("Уш-Белдир", new Point(51.471077, 98.053945)));
        my_PoIs.add(new PoIData("гора Хайыракан", new Point(51.564302, 93.028220)));
        my_PoIs.add(new PoIData("озеро Хиндиктиг-Холь", new Point(50.350944, 89.830245)));
        my_PoIs.add(new PoIData("озеро Чагытай", new Point(51.016828, 94.728531)));
        my_PoIs.add(new PoIData("Чалама", new Point(51.737514, 93.504994)));
        my_PoIs.add(new PoIData("Чараш-Даш", new Point(50.635, 90.1504)));
        my_PoIs.add(new PoIData("аржаан Чойган", new Point(52.3445, 98.4517)));
        my_PoIs.add(new PoIData("аржаан Шивилиг", new Point( 50.993692, 89.917089)));

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