package com.shiva;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class Practical_22_Exercise2 extends AppCompatActivity {

    private ListView sensorListView;
    private Button getListButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical22_exercise2);

        sensorListView = findViewById(R.id.result);
        getListButton = findViewById(R.id.getList);

        getListButton.setOnClickListener(v -> displaySensorList());
    }

    private void displaySensorList() {
        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);

        String[] sensorNames = new String[sensorList.size()];

        for (int i = 0; i < sensorList.size(); i++) {
            sensorNames[i] = sensorList.get(i).getName();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sensorNames);

        sensorListView.setAdapter(adapter);
    }
}
