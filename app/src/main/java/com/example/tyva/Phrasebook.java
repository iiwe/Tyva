package com.example.tyva;

import android.os.Bundle;
import android.widget.ExpandableListView;
import android.view.View;

import android.widget.SimpleExpandableListAdapter;
//import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Phrasebook extends AppCompatActivity {
    private String[] Themes = new String[] { "Обращение", "Встреча, приветствие", "Знакомство", "Поздравления", "Семья", "Числа", "Цвета" };
    private String[] Appeal = new String[] { "Мать — Авай", "Отец — Ачай", "Брат — Акый", "Сестра — Угбай", "Братик/сестренка — Дуӊмай",
            "Бабушка — Крыган авай", "Дедушка — Кырган ачай", "Дядя — Даай", "" };
    private String[] Meeting = new String[] { "Здравствуйте. — Экии.", "Можно войти? — Кирип болур бе?", "Да, войдите. — Ийе, кириӊер.", "Пройдите сюда (туда). — Бээр (мынаар) эртиӊер.",
            "Садитесь. — Олуруӊар.", "Спасибо! — Четтирдим!", "По какому делу (вопросу) пришли? — Кандыг херектиг (айтырыглыг) келдиӊер?", "Откуда приехали (пришли)? — Кайыын келдиӊер?",
            "Когда приехали (пришли)? — Кажан келдиӊер?", "Только что приехал. — Ам чаа келдим.", "Вчера приехал. — Дүүн келдим.", "Как ваше здоровье? — Кадыыӊар кандыг-дыр? (Эки-ле-дир силер бе?)",
            "Спасибо всё хорошо. — Четтирдим, эки-дир.", "Что у вас нового? — Силерде солун чүү тур?", "Ничего особенного. — Онза чүве чогулу.",
            "Как ваши дела? — Ажыл-херээӊер кандыг тур?", "Хорошо. — Эки-ле чоруп тур.", "Тепло ли сегодня на улице? — Бөгүн даштын чылыг-ыр бе?",
            "Да, тепло. — Ийе, чылыг-дыр.", "Нет, холодно. — Чок, соок-тур.", "Когда снова зайдете (придете)? — Катап кажан кирер (келир) силер?",
            "Зайду (приду) завтра. — Даарта кирер (келир) мен.", "Зайду (приду) через час — Бир шак болгаш, кирер (келир) мен.",
            "Спасибо, что зашли (пришли). — Киргениӊер (келгениӊер) дээш четтирдим.", "Да свидания! (Прощайте!) — Байырлыг!" };
    private String[] Acquaintance = new String[] { "Познакомьтесь, пожалуйста ... — Таныжып көрүӊер ...", "Как вас зовут? — Адыӊар кымыл?", "Меня зовут ... — Мээӊ адым ... ",
            "Его зовут ... — Ооӊ ады ... ", "Извините, я забыл как вас зовут. — Буруулуг болдум, силерниӊ адыӊарны уткан-дыр мен.", "Как его зовут? — Ооӊ ады кым ийик?" };
    private String[] Сongratulation = new String[] { "С праздником! — Байырлал-биле!", "Поздравляю Вас с праздником — Байырала таварыштыр Силерге байыр чедирип тур мен!", "—", "—", "—", "—", "—", "—", "—",
            "Поздравляю Вас! — Силерге байыр чедирип тур мен!", "Всего Вам доброго! — Экини күзедим! ", "Будьте здоровы! — Кадык-чаагай болуӊар!",
            "Желаю Вам счастья (успеха, здоровья)! — Аас-кежикти (чедиишкини, кадыкшылды) силерге күзедим!)", "С праздником Первомая! — Май бирниӊ байырлалы-биле!", "—", "—", "—",
            "—", "—", "—", "—", "—", "—", "—", "—", "—", "—", "—", "—", "—", "—", "—", "—", "—", "—" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrasebook);
        setTitle("Locale Date");

        Map<String, String> map;
        // коллекция для групп
        ArrayList<Map<String, String>> groupDataList = new ArrayList<>();
        // заполняем коллекцию групп из массива с названиями групп

        for (String group : Themes) {
            // заполняем список атрибутов для каждой группы
            map = new HashMap<>();
            map.put("groupName", group); // время года
            groupDataList.add(map);
        }

        // список атрибутов групп для чтения
        String groupFrom[] = new String[] { "groupName" };
        // список ID view-элементов, в которые будет помещены атрибуты групп
        int groupTo[] = new int[] { android.R.id.text1 };

        // создаем общую коллекцию для коллекций элементов
        ArrayList<ArrayList<Map<String, String>>> сhildDataList = new ArrayList<>();

        // в итоге получится сhildDataList = ArrayList<сhildDataItemList>

        // создаем коллекцию элементов для первой группы
        ArrayList<Map<String, String>> сhildDataItemList = new ArrayList<>();
        // заполняем список атрибутов для каждого элемента
        for (String month : Appeal) {
            map = new HashMap<>();
            map.put("monthName", month); // название месяца
            сhildDataItemList.add(map);
        }
        // добавляем в коллекцию коллекций
        сhildDataList.add(сhildDataItemList);

        // создаем коллекцию элементов для второй группы
        сhildDataItemList = new ArrayList<>();
        for (String month : Meeting) {
            map = new HashMap<>();
            map.put("monthName", month);
            сhildDataItemList.add(map);
        }
        сhildDataList.add(сhildDataItemList);

        // создаем коллекцию элементов для третьей группы
        сhildDataItemList = new ArrayList<>();
        for (String month : Acquaintance) {
            map = new HashMap<>();
            map.put("monthName", month);
            сhildDataItemList.add(map);
        }
        сhildDataList.add(сhildDataItemList);

        // создаем коллекцию элементов для четвертой группы
        сhildDataItemList = new ArrayList<>();
        for (String month : Сongratulation) {
            map = new HashMap<>();
            map.put("monthName", month);
            сhildDataItemList.add(map);
        }
        сhildDataList.add(сhildDataItemList);

        // список атрибутов элементов для чтения
        String childFrom[] = new String[] { "monthName" };
        // список ID view-элементов, в которые будет помещены атрибуты
        // элементов
        int childTo[] = new int[] { android.R.id.text1 };

        SimpleExpandableListAdapter adapter = new SimpleExpandableListAdapter(
                this, groupDataList,
                android.R.layout.simple_expandable_list_item_1, groupFrom,
                groupTo, сhildDataList, android.R.layout.simple_list_item_1,
                childFrom, childTo);

        ExpandableListView expandableListView = (ExpandableListView) findViewById(R.id.expListView);
        expandableListView.setAdapter(adapter);
    }
}