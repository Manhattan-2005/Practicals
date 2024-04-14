package com.shiva;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Practical_20_Exercise1 extends AppCompatActivity {

    Button startWifi, stopWifi;
    WifiManager wifiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical20_exercise1);

        startWifi = findViewById(R.id.startWifi);
        stopWifi = findViewById(R.id.stopWifi);
        wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);

        // Inside onCreate or another appropriate method
        if (checkSelfPermission(Manifest.permission.CHANGE_WIFI_STATE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.CHANGE_WIFI_STATE}, 1);
        }

        startWifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!wifiManager.isWifiEnabled()) {
                    wifiManager.setWifiEnabled(true);
                }
                Toast.makeText(getApplicationContext(), "Wifi Started", Toast.LENGTH_SHORT).show();
            }
        });

        stopWifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (wifiManager.isWifiEnabled()) {
                    wifiManager.setWifiEnabled(false);
                }
                Toast.makeText(getApplicationContext(), "Wifi Stopped", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
