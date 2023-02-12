package com.example.tyva;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Dictionary extends AppCompatActivity {
    String[] russian_words = {"Здравствуйте!", "Да", "Нет", "Доброе утро!", "Добрый день!",
            "Добрый вечер!", "Да", "Нет", "Меня зовут…, а вас?","До свидания!", "До скорого!", "Я турист",
            "Я вас не понимаю", "Cпасибо!", "Большое спасибо!", "Извините", "Можно войти?", "Сколько?",
            "Что вы хотите?", "Покажите на карте", "Как называется эта улица?", "Мы хотим купить сувениры",
            "Как проехать до…?", "Этот автобус идет до…?", "Разрешите позвонить?", "Где можно купить?",
            "Нам нужен...", "Здесь есть?..", "Обедать, есть", "Где можно покушать?", "Очень вкусно!"};
    String[] tyva_words = {"Экии!", "Ийе", "Чок", "Эртенгиниӊ \n мендизи-биле!", "Хүндүскүнүӊ мендизи-биле!",
            "Кежээкиниӊ мендизи-биле!", "Мени… дээр, а силерниӊ адыӊар кым?","Байырлыг!", "Ужурашкыже!",
            "Мен турист мен", "Мен силерни билбейн тур мен", "Четтирдим!", "Уулу-биле четтирдим!",
            "Буруулуг болдум", "Кирип болур бе?", "Каш?", "Силерге чүү херек?", "Картага айтып бериңерем",
            "Бо кудумчунуң адын чүү дээр?", "Бис сувенирлер садып алыксап тур бис", ".. чедир канчап чедип алыр?",
            "Бо автобус … чедер бе?", "Телефон долгаптайн, болур бе?", "Кайыын садып ап болур?",
            "Биске херек...", "Мында ... бар бе", "Чемненир", "Кая чемненип болур?", "Дендии амданныг!"};
    int[] colors = new int[3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        colors[0] = Color.parseColor("#559966CC");
        LinearLayout linLayout = (LinearLayout) findViewById(R.id.linLayout);
        LayoutInflater ltInflater = getLayoutInflater();
        for (int i = 0; i < russian_words.length; i++){
            View item = ltInflater.inflate(R.layout.item, linLayout, false);
            TextView tvName = (TextView) item.findViewById(R.id.tvName);
            tvName.setText(russian_words[i]);
            TextView tvPosition = (TextView) item.findViewById(R.id.tvPosition);
            tvPosition.setText(tyva_words[i]);
            item.getLayoutParams().width = LinearLayout.LayoutParams.MATCH_PARENT;
            item.setBackgroundColor(colors[i % 1]);
            linLayout.addView(item);

        }
    }
}