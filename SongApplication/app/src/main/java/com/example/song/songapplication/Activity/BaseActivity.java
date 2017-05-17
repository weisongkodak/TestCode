package com.example.song.songapplication.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.song.songapplication.AppManager;
import com.example.song.songapplication.Utils.PermissionUitls;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.getInstance().addActivity(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        AppManager.getInstance().setCurrentActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getInstance().removeActivity(this);
    }

    //  add by song for permission callback
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        PermissionUitls.getInstance().onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
