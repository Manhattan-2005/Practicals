package com.shiva;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.provider.Settings;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Practical_21_Exercise1 extends AppCompatActivity {

    private TextView textView;
    private StringBuilder toastLog = new StringBuilder();

    private BroadcastReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical21_exercise1);

        textView = findViewById(R.id.textView);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toastLog = new StringBuilder();
                updateTextView();
            }
        });

        registerBroadcastReceiver();
        registerInternetReceiver();
    }

    private void registerBroadcastReceiver() {
        IntentFilter filter = new IntentFilter();

        filter.addAction(Intent.ACTION_BOOT_COMPLETED);
        filter.addAction(Intent.ACTION_BATTERY_CHANGED);
        filter.addAction(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        filter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);

        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);

        receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                // Handle the received broadcast messages
                String action = intent.getAction();
                if (action != null) {
                    handleReceivedBroadcast(context, action, intent);
                }
            }
        };

        registerReceiver(receiver, filter);
    }

    private void registerInternetReceiver() {
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");

        BroadcastReceiver internetReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                handleInternetConnectivity(context);
            }
        };

        registerReceiver(internetReceiver, filter);
    }

    private void handleReceivedBroadcast(Context context, String action, Intent intent) {
        String message = "";

        switch (action) {
            case Intent.ACTION_BOOT_COMPLETED:
                message = "Boot Completed";
                break;
            case Intent.ACTION_BATTERY_CHANGED:
                int level = intent.getIntExtra("level", -1);
                message = "Battery Level: " + level;
                break;
            case Intent.ACTION_SCREEN_ON:
                message = "Screen On";
                break;
            case Intent.ACTION_SCREEN_OFF:
                message = "Screen Off";
                break;
            case WifiManager.WIFI_STATE_CHANGED_ACTION:
                int wifiState = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, -1);
                message = "Wi-Fi State: " + getWifiStateString(wifiState);
                break;
            case Intent.ACTION_AIRPLANE_MODE_CHANGED:
                boolean airplaneModeEnabled = Settings.Global.getInt(context.getContentResolver(), Settings.Global.AIRPLANE_MODE_ON, 0) != 0;
                message = "Airplane Mode: " + (airplaneModeEnabled ? "Enabled" : "Disabled");
                break;
        }

        toastLog.append(message).append("\n");
        updateTextView();
    }

    private void handleInternetConnectivity(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();

        if (activeNetwork != null && activeNetwork.isConnectedOrConnecting()) {
            toastLog.append("Internet Connected").append("\n");
        } else {
            toastLog.append("Internet Disconnected").append("\n");
        }

        updateTextView();
    }

    private String getWifiStateString(int wifiState) {
        switch (wifiState) {
            case WifiManager.WIFI_STATE_DISABLED:
                return "Disabled";
            case WifiManager.WIFI_STATE_DISABLING:
                return "Disabling";
            case WifiManager.WIFI_STATE_ENABLED:
                return "Enabled";
            case WifiManager.WIFI_STATE_ENABLING:
                return "Enabling";
            case WifiManager.WIFI_STATE_UNKNOWN:
            default:
                return "Unknown";
        }
    }

    private void updateTextView() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                textView.setText(toastLog.toString());
            }
        });
    }

    @Override
    protected void onDestroy() {
        if (receiver != null) {
            unregisterReceiver(receiver);
        }
        super.onDestroy();
    }
}
