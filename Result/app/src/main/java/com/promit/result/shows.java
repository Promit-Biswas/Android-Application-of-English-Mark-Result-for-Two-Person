package com.promit.result;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class shows extends AppCompatActivity {

    private ListView listView;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shows);
        this.setTitle("Results");
        listView = (ListView) findViewById(R.id.listview2);
        databaseHelper = new DatabaseHelper(this);
        loaddata();
    }

    public void loaddata() {
        ArrayList<String> ListData = new ArrayList<>();
        Cursor cursor = databaseHelper.showAllData();
        if (cursor.getCount() == 0) {
            Toast.makeText(shows.this, "No Data is Found.", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                ListData.add("Date: " + cursor.getString(1) + "\nProma\nRight: " + cursor.getString(2) + "\nWrong: " + cursor.getString(3) + "\n\nPromit\nRight: " + cursor.getString(4) + "\nWrong: " + cursor.getString(5));
            }
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.item, R.id.textView2, ListData);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> AdapterView, View view, int i, long l) {
                String selectedValue = AdapterView.getItemAtPosition(i).toString();
                Toast.makeText(getApplicationContext(), "" + selectedValue, Toast.LENGTH_SHORT).show();
            }
        });
    }
}