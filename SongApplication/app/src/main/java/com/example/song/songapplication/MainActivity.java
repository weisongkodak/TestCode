package com.example.song.songapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

import com.example.song.songapplication.Activity.BaseActivity;
import com.example.song.songapplication.Activity.Dagger2Activity;
import com.example.song.songapplication.Activity.ImageUploadActivity;
import com.example.song.songapplication.Activity.OkhttpActivity;
import com.example.song.songapplication.Utils.PermissionUitls;
import com.example.song.songapplication.widget.PerPermissionDialog;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.btn_main_okhttp)
    Button btnMainOkhttp;
    @BindView(R.id.btn_main_permissoin)
    Button btnMainPermissoin;
    @BindView(R.id.btn_main_SoftInput)
    Button btnMainSoftInput;
    @BindView(R.id.btn_main_ImageUpload)
    Button btnMainImageUpload;
    @BindView(R.id.btn_main_Dagger2)
    Button btnMainDagger2;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        PermissionUitls.mContext = mContext;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        setEvents();
        //PrePermissionDialogByCode(PermissionUitls.PERMISSION_FIRST_PAGE_CODE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setEvents() {
        btnMainOkhttp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, OkhttpActivity.class);
                startActivity(intent);
            }
        });

        btnMainPermissoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PrePermissionDialogByCode(PermissionUitls.PERMISSION_ALL_CODE);
            }
        });
        btnMainSoftInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSoftInput();
            }
        });


        btnMainImageUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ImageUploadActivity.class);
                startActivity(intent);
            }
        });
        btnMainDagger2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, Dagger2Activity.class);
                startActivity(intent);
            }
        });
    }

    private void PrePermissionDialogByCode(final int permissionCode) {
        boolean isAuthorized = PermissionUitls.isAuthorizedByCode(permissionCode);
        PerPermissionDialog perPermissionDialog = new PerPermissionDialog();
        perPermissionDialog.setBtnOnclickListener(new PerPermissionDialog.OnPerPermissionDialogClickListener() {

            @Override
            public void positive() {
                checkPermissionByCode(permissionCode);
            }

            @Override
            public void negative() {

            }
        });
        perPermissionDialog.setPermissionCode(permissionCode);
        if (isAuthorized) {
            //
            perPermissionDialog.setContentStr(getResources().getString(R.string.dialogContent));
        }

        perPermissionDialog.show(getSupportFragmentManager(), "perPermissionDialog");
    }

    private void checkPermissionByCode(int permissionCode) {
        PermissionUitls.PermissionListener permissionListener = new PermissionUitls.PermissionListener() {
            @Override
            public void permissionAgree() {
                //doNext();
            }

            @Override
            public void permissionReject() {

            }
        };
        PermissionUitls permissionUitls = PermissionUitls.getInstance(getSupportFragmentManager(), permissionListener);
        permissionUitls.permssionCheck(permissionCode);
    }

    private void showSoftInput() {
//        if (btnMainSoftInput == null) return;
//        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//        if (inputMethodManager != null) {
//            btnMainSoftInput.requestFocus();
//            inputMethodManager.showSoftInput(btnMainSoftInput, InputMethodManager.SHOW_FORCED);
//        }
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }

    public void hideSoftInput() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputMethodManager != null && inputMethodManager.isActive(btnMainSoftInput)) {
            inputMethodManager.hideSoftInputFromWindow(btnMainSoftInput.getWindowToken(), 0);
        }
    }


}
