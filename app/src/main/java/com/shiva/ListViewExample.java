package com.shiva;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewExample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_example);

        ListView listView = findViewById(R.id.listView);

        ArrayList<String> elements = new ArrayList<>();
        elements.add("Shiva");
        elements.add("Radhe");
        elements.add("Wasmi");
        elements.add("Pratik");
        elements.add("Athrava");
        elements.add("Yashvant");
        elements.add("---");
        elements.add("Shiva");
        elements.add("Radhe");
        elements.add("Wasmi");
        elements.add("Pratik");
        elements.add("Athrava");
        elements.add("Yashvant");
        elements.add("---");
        elements.add("Shiva");
        elements.add("Radhe");
        elements.add("Wasmi");
        elements.add("Pratik");
        elements.add("Athrava");
        elements.add("Yashvant");
        elements.add("---");
        elements.add("Shiva");
        elements.add("Radhe");
        elements.add("Wasmi");
        elements.add("Pratik");
        elements.add("Athrava");
        elements.add("Yashvant");
        elements.add("---");

        ArrayAdapter<String> adapter  = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, elements);
        listView.setAdapter(adapter);

    }
}