package com.example.song.plugin;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;

import com.ryg.dynamicload.DLBasePluginActivity;
import com.ryg.dynamicload.internal.DLIntent;

import java.io.File;

public class MainActivity extends DLBasePluginActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String pluginFolder = getInnerSDCardPath() + "/DynamicLoadHost";
        File file = new File(pluginFolder);
        file.mkdir();
        Log.i("aasdf",pluginFolder);
        findViewById(R.id.btn_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DLIntent intent = new DLIntent(getPackageName(), Main2Activity.class);
                // 传递Parcelable类型的数据

                //startPluginActivityForResult(intent, 0);
                startActivityForResult(intent,0);
            }
        });
    }

    /**
     * 获取内置SD卡路径
     * @return
     */
    public String getInnerSDCardPath() {
        return Environment.getExternalStorageDirectory().getPath();
    }
}
