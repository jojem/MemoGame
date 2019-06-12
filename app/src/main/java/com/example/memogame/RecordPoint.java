package com.example.memogame;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class RecordPoint  extends ListActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.point_tab);

        RecordAdapter ra = new RecordAdapter (this);
        ArrayList<String> arr = ra.getRecPoint();

        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr);
        setListAdapter(mAdapter);
    }
}
