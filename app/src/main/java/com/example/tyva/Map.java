package com.example.tyva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.yandex.mapkit.geometry.Point;

import java.util.ArrayList;
import java.util.LinkedList;

public class Map extends AppCompatActivity {


    public ArrayList<PoIData> my_PoIs; //объявление
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        my_PoIs = new ArrayList<>(); //инициализация
        my_PoIs.add(new PoIData("Центр Азии", new Point(51.72515656949432,94.44365188425749)));
        my_PoIs.add(new PoIData("Гора Ак-Хайыракан и Моренская пещера", new Point(50.360700, 95.452978)));
        my_PoIs.add(new PoIData("Aржаан Ажыг-Суг", new Point(51.764981, 92.106207)));
        my_PoIs.add(new PoIData("озеро Азас", new Point(52.394587, 96.501249)));
        my_PoIs.add(new PoIData("гора Бай-Тайга", new Point(51.245975, 89.959614)));
        my_PoIs.add(new PoIData("Бижиктиг-Хая и каменное изваяние Чингисхана", new Point(51.057274, 90.595495)));
        my_PoIs.add(new PoIData("Буддийская ниша Суме", new Point(51.607277, 92.395501)));
        my_PoIs.add(new PoIData("гора Догэ:", new Point(51.761853, 94.423260)));
        my_PoIs.add(new PoIData("Долина царей", new Point(52.071665, 93.631851)));
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
        my_PoIs.add(new PoIData("Сарыг-Хая и село Кызыл-Даг", new Point(51.131828, 89.892892)));
        my_PoIs.add(new PoIData("Пор-Бажын", new Point(50.615235, 97.384962)));
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

        my_PoIs.add(new PoIData("Шагаа", null));
        for (int i = 0; i < my_PoIs.size(); i++) {
            String s = "poi_"+ i;
            int resourceId = this.getResources().getIdentifier(s, "drawable", this.getPackageName());
            if (resourceId != 0) {
                my_PoIs.get(i).setFoto(resourceId);
            }
            else {
                my_PoIs.get(i).setFoto(R.drawable.flag_tyva_new);
            }

        }
        PoIAdapter poIAdapter = new PoIAdapter(this, my_PoIs);
        ListView listView = (ListView) findViewById(R.id.list_PoI);
        listView.setAdapter(poIAdapter);
        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                PoIData selected_PoI = my_PoIs.get(i);
                Intent intent = new Intent(getApplicationContext(), PoIActivity.class);
                intent.putExtra("Selected", selected_PoI);
                startActivity(intent);
            }
        });

    }


    public void show_map(View view) {
        Intent intent = new Intent(this, PoI.class);
        intent.putParcelableArrayListExtra("PoI", my_PoIs);
        startActivity(intent);
    }
}