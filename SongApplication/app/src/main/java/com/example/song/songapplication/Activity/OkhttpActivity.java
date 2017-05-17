package com.example.song.songapplication.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.song.songapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OkhttpActivity extends AppCompatActivity {
    private Context mContext;
    @BindView(R.id.btn_http_send)
    Button btnHttpSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);
        ButterKnife.bind(this);
        mContext = this;
    }
}
