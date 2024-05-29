package com.example.android_s_task1;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.android_s_task1.Fragments.HomeFragment;
import com.example.android_s_task1.Fragments.LoginFragment;
import com.example.android_s_task1.FragmetsInerface.LoginFragmentInterface;

public class MainActivity extends AppCompatActivity implements LoginFragmentInterface {

    private PermissionManager permissionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment loginFragment = new LoginFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, loginFragment)
                .commit();

        permissionManager = new PermissionManager(this);
    }


    @Override
    public void onLoginButtonClicked(String typed_password) {

        if (!permissionManager.isDeviceCharging(this) && !permissionManager.isDevice100PercentCharged(this)) {
            Toast.makeText(this, "Device is not charging or not 100% charged", Toast.LENGTH_SHORT).show();
            return;
        }

        String wifiName = "Ben-Avi net";
        if (!permissionManager.isConnectedToSpecificWifi(this, wifiName)) {
            Toast.makeText(this, "The device is not connected to the wifi: " + wifiName, Toast.LENGTH_SHORT).show();
            return;
        }

        if (!permissionManager.isBluetoothEnabled()) {
            Toast.makeText(this, "Bluetooth is not enabled", Toast.LENGTH_SHORT).show();
            return;
        }

        String password = "123456";

        if (!typed_password.equals(password)) {
            Toast.makeText(this, "The password is incorrect", Toast.LENGTH_SHORT).show();
            return;
        }


        // change the fragment to the home fragment
        Fragment homeFragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, homeFragment)
                .commit();
    }


}