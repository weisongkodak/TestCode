package com.example.song.layoutbycodeapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> buttonNameList = new ArrayList<>();
    private List<Button> buttonList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        initButtonData();
        setLinearLayout();
    }

    private void setLinearLayout() {
        RelativeLayout rlayout = new RelativeLayout(this);
        RelativeLayout.LayoutParams rl_lpara1 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        //rlayout.setGravity(Gravity.BOTTOM);
        LinearLayout llayout = new LinearLayout(this);
        llayout.setOrientation(LinearLayout.HORIZONTAL); // 设置线性布局的排列方式
        LinearLayout.LayoutParams ll_lpara = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 200);
        ll_lpara.weight = 1;
        rl_lpara1.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        for (Button btnTemp : buttonList) {
            llayout.addView(btnTemp, ll_lpara); // 按指定属性添加控件
        }
        rlayout.addView(llayout, rl_lpara1);
        setContentView(rlayout);
    }

    private void initButtonData() {
        buttonNameList.add("cancel");
        buttonNameList.add("ok");
        buttonNameList.add("next");
        buttonNameList.add("save");
        for (String buttonStr : buttonNameList) {
            Button btn = new Button(this);
            btn.setText(buttonStr);
            btn.setBackgroundResource(R.drawable.shape_font_color_border);
            buttonList.add(btn);
            setOnclickListener(btn, buttonStr);
        }
    }

    private void setOnclickListener(Button btn, final String name) {
        btn.setOnClickListener(getListener(btn,name));
    }

    private View.OnClickListener getListener(final Button btn, final String name) {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (Button btnTemp : buttonList) {
                    btnTemp.setBackgroundResource(R.drawable.shape_font_color_border);
                    btnTemp.setTextColor(Color.BLACK);
                }
                btn.setBackgroundColor(Color.parseColor("#F838E21E"));
                btn.setTextColor(Color.WHITE);
                if (name.equals("cancel")) {
                    //TODO
                    Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
                } else if (name.equals("ok")) {
                    //TODO
                    Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
                } else if (name.equals("next")) {
                    //TODO
                    Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
                } else if (name.equals("save")) {
                    //TODO
                    Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
                }
            }
        };
        return listener;
    }
}
