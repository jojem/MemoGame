package com.example.memogame;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class Records extends TabActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.records);

        TabHost tabHost = getTabHost();

        // Вкладка Время
        TabHost.TabSpec timetab = tabHost.newTabSpec("Time");
        // устанавливаем заголовок и иконку
        timetab.setIndicator("по времени");
        // устанавливаем окно, которая будет показываться во вкладке
        Intent timeIntent = new Intent(this, RecordTime.class);
        timetab.setContent(timeIntent);

        // Вкладка Очки
        TabHost.TabSpec pointtab = tabHost.newTabSpec("Point");
        pointtab.setIndicator("по очкам");
        Intent pointIntent = new Intent(this, RecordPoint.class);
        pointtab.setContent(pointIntent);

        // Добавляем вкладки в TabHost
        tabHost.addTab(timetab);
        tabHost.addTab(pointtab);
    }

}
