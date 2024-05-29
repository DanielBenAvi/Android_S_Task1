package com.example.android_s_task1;

import android.Manifest;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.BatteryManager;
import android.util.Log;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class PermissionManager {
    public PermissionManager(Context context) {
        // ask for location permission
        if (ContextCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }

        // ask for bluetooth permission
        if (ContextCompat.checkSelfPermission(context, android.Manifest.permission.BLUETOOTH) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.BLUETOOTH}, 1);
        }
    }

    public boolean isDeviceCharging(Context context) {
        BatteryManager batteryManager = (BatteryManager) context.getSystemService(Context.BATTERY_SERVICE);
        int batteryStatus = batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_STATUS);
        return batteryStatus == BatteryManager.BATTERY_STATUS_CHARGING;
    }

    public boolean isDevice100PercentCharged(Context context) {
        BatteryManager batteryManager = (BatteryManager) context.getSystemService(Context.BATTERY_SERVICE);
        int batteryStatus = batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);
        return batteryStatus == 100;
    }

    public boolean isConnectedToSpecificWifi(Context context, String specificSSID) {
        String currentSSID = getConnectedWifiName(context);

        // SSID returned by WifiInfo.getSSID() is enclosed in double quotes if it is an ASCII string,
        // so we need to add them to the specificSSID
        specificSSID = "\"" + specificSSID + "\"";

        // print the wifi name to the log
        Log.d("SSID", "currentSSID = "+ currentSSID);
        Log.d("SSID", "specificSSID = "+ specificSSID);

        return currentSSID.equals(specificSSID);
    }

    public String getConnectedWifiName(Context context) {

        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();

        return wifiInfo.getSSID();
    }

    public boolean isBluetoothEnabled() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        return bluetoothAdapter != null && bluetoothAdapter.isEnabled();
    }
}
