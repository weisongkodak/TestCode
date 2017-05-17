package com.example.song.songapplication.Activity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.song.songapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.song.songapplication.Utils.PermissionUitls.mContext;

public class ObjectAnimalActivity extends AppCompatActivity {


    @BindView(R.id.btn_objectAnimator_start)
    Button btnObjectAnimatorStart;
    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.lily_objectAnimator1)
    LinearLayout lilyObjectAnimator1;
    @BindView(R.id.btn1Clone)
    Button btn1Clone;
    @BindView(R.id.btn2)
    Button btn2;
    @BindView(R.id.lily_objectAnimator2)
    LinearLayout lilyObjectAnimator2;
    @BindView(R.id.btn2Clone)
    Button btn2Clone;
    @BindView(R.id.text)
    TextView text;
    @BindView(R.id.relty_objectAnimator)
    RelativeLayout reltyObjectAnimator;
    @BindView(R.id.ok)
    Button ok;
    @BindView(R.id.activity_okhttp)
    RelativeLayout activityOkhttp;
    @BindView(R.id.temp)
    Button temp;
    @BindView(R.id.btn3)
    Button btn3;
    @BindView(R.id.lily_objectAnimator3)
    LinearLayout lilyObjectAnimator3;
    @BindView(R.id.btn3Clone)
    Button btn3Clone;
    private boolean btn1show = false;
    private boolean btn2show = false;
    private boolean btn3show = false;
    private int moveSize1;
    private int moveSize2;
    private int moveSize3;
    private RelativeLayout.LayoutParams layoutParamsNew1, layoutParamsNew2, layoutParamsNew3;
    private Handler mHandler = new Handler();
    private static int animatorTime = 500;
    private  PopupWindow mPopupWindow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_animal);
        ButterKnife.bind(this);
        mContext = this;

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                RelativeLayout.LayoutParams lilyObjectAnimator1_layoutParams = (RelativeLayout.LayoutParams) lilyObjectAnimator1.getLayoutParams();
                RelativeLayout.LayoutParams lilyObjectAnimator2_layoutParams = (RelativeLayout.LayoutParams) lilyObjectAnimator2.getLayoutParams();
                RelativeLayout.LayoutParams lilyObjectAnimator3_layoutParams = (RelativeLayout.LayoutParams) lilyObjectAnimator3.getLayoutParams();

                moveSize1 = lilyObjectAnimator1.getHeight();
                moveSize2 = lilyObjectAnimator2.getHeight();
                moveSize3 = lilyObjectAnimator3.getHeight();
                layoutParamsNew1 = new RelativeLayout.LayoutParams(lilyObjectAnimator1_layoutParams.width, lilyObjectAnimator1_layoutParams.height);
                layoutParamsNew1.bottomMargin = lilyObjectAnimator1_layoutParams.bottomMargin;
                layoutParamsNew2 = new RelativeLayout.LayoutParams(lilyObjectAnimator2_layoutParams.width, lilyObjectAnimator2_layoutParams.height);
                layoutParamsNew2.bottomMargin = lilyObjectAnimator2_layoutParams.bottomMargin;
                layoutParamsNew3 = new RelativeLayout.LayoutParams(lilyObjectAnimator3_layoutParams.width, lilyObjectAnimator3_layoutParams.height);
                layoutParamsNew3.bottomMargin = lilyObjectAnimator3_layoutParams.bottomMargin;
            }
        }, 500);
        popUp();
        setEvents();
    }

    private void setEvents() {
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn3show) {
                    AnimatorStart3(0);
                }
                if (btn2show) {
                    AnimatorStart2(0);
                }
                AnimatorStart(animatorTime);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn3show) {
                    AnimatorStart3(0);
                }
                if (btn1show) {
                    AnimatorStart(0);
                }
                AnimatorStart2(animatorTime);
               //
//                mPopupWindow.setAnimationStyle(R.style.anim_menu_bottombar);
//                int[] location = new int[2];
//                btn2.getLocationOnScreen(location);
//                mPopupWindow.showAtLocation(v, Gravity.NO_GRAVITY, location[0], location[1]-mPopupWindow.getHeight() - btn2.getHeight()*2);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn1show) {
                    AnimatorStart(100);
                }
                if (btn2show) {
                    AnimatorStart2(100);
                }
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        AnimatorStart3(animatorTime);

                    }
                }, 110);
            }
        });
    }

    private void AnimatorStart(int time) {
        float curTranslationY = lilyObjectAnimator1.getTranslationY();
        final int H = lilyObjectAnimator1.getHeight();
        int to;
        if (btn1show) {
            to = moveSize1;
            btn1show = false;
        } else {
            to = -moveSize1;
            btn1show = true;
        }
        ObjectAnimator anim = ObjectAnimator//
                .ofFloat(temp, "translationY", curTranslationY, to)//
                .setDuration(time);//
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //int val = (Integer) animation.getAnimatedValue();
                float val = (Float) animation.getAnimatedValue();
                int vals = (int) val;
                RelativeLayout.LayoutParams lilyObjectAnimator1_layoutParams = (RelativeLayout.LayoutParams) lilyObjectAnimator1.getLayoutParams();
                lilyObjectAnimator1_layoutParams.height = H - vals;
                lilyObjectAnimator1.setLayoutParams(lilyObjectAnimator1_layoutParams);

                RelativeLayout.LayoutParams btn1Clone_layoutParams = (RelativeLayout.LayoutParams) btn1Clone.getLayoutParams();
                btn1Clone_layoutParams.topMargin = Math.abs(vals);
                if (!btn1show) {
                    btn1Clone_layoutParams.topMargin = moveSize1 - Math.abs(vals);
                }
            }
        });
        anim.start();
    }

    private void AnimatorStart2(int time) {
        float curTranslationY = lilyObjectAnimator2.getTranslationY();
        final int H = lilyObjectAnimator2.getHeight();
        int to;
        if (btn2show) {
            to = moveSize2;
            btn2show = false;
        } else {
            to = -moveSize2;
            btn2show = true;
        }
        ObjectAnimator anim = ObjectAnimator//
                .ofFloat(temp, "translationY", curTranslationY, to)//
                .setDuration(time);//
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //int val = (Integer) animation.getAnimatedValue();
                float val = (Float) animation.getAnimatedValue();
                int vals = (int) val;
                RelativeLayout.LayoutParams lilyObjectAnimator2_layoutParams = (RelativeLayout.LayoutParams) lilyObjectAnimator2.getLayoutParams();
                lilyObjectAnimator2_layoutParams.height = H - vals;
                lilyObjectAnimator2.setLayoutParams(lilyObjectAnimator2_layoutParams);

                RelativeLayout.LayoutParams btn2Clone_layoutParams = (RelativeLayout.LayoutParams) btn2Clone.getLayoutParams();
                btn2Clone_layoutParams.topMargin = Math.abs(vals);
                RelativeLayout.LayoutParams lilyObjectAnimator1_layoutParams = (RelativeLayout.LayoutParams) lilyObjectAnimator1.getLayoutParams();
                lilyObjectAnimator1_layoutParams.topMargin = Math.abs(vals);
                if (!btn2show) {
                    btn2Clone_layoutParams.topMargin = moveSize2 - Math.abs(vals);
                    lilyObjectAnimator1_layoutParams.topMargin = moveSize2 - Math.abs(vals);
                }
            }
        });
        anim.start();
    }


    private void AnimatorStart3(int time) {
        float curTranslationY = lilyObjectAnimator3.getTranslationY();
        final int H = lilyObjectAnimator3.getHeight();
        int to;
        if (btn3show) {
            to = moveSize3;
            btn3show = false;
        } else {
            to = -moveSize3;
            btn3show = true;
        }

        ObjectAnimator anim = ObjectAnimator//
                .ofFloat(temp, "translationY", curTranslationY, to)//
                .setDuration(time);//
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //int val = (Integer) animation.getAnimatedValue();
                float val = (Float) animation.getAnimatedValue();
                int vals = (int) val;
                RelativeLayout.LayoutParams lilyObjectAnimator3_layoutParams = (RelativeLayout.LayoutParams) lilyObjectAnimator3.getLayoutParams();
                lilyObjectAnimator3_layoutParams.height = H - vals;
                lilyObjectAnimator3.setLayoutParams(lilyObjectAnimator3_layoutParams);
                RelativeLayout.LayoutParams btn3Clone_layoutParams = (RelativeLayout.LayoutParams) btn3Clone.getLayoutParams();
                btn3Clone_layoutParams.topMargin = Math.abs(vals);
                RelativeLayout.LayoutParams lilyObjectAnimator1_layoutParams = (RelativeLayout.LayoutParams) lilyObjectAnimator1.getLayoutParams();
                lilyObjectAnimator1_layoutParams.topMargin = Math.abs(vals);

                RelativeLayout.LayoutParams lilyObjectAnimator2_layoutParams = (RelativeLayout.LayoutParams) lilyObjectAnimator2.getLayoutParams();
                lilyObjectAnimator2_layoutParams.topMargin = Math.abs(vals);
                if (!btn3show) {
                    btn3Clone_layoutParams.topMargin = moveSize3 - Math.abs(vals);
                    lilyObjectAnimator1_layoutParams.topMargin = moveSize3 - Math.abs(vals);
                    lilyObjectAnimator2_layoutParams.topMargin = moveSize3 - Math.abs(vals);
                }
            }
        });
        anim.start();
    }

    private void popUp(){
        View popupView = getLayoutInflater().inflate(R.layout.layout_popupwindow, null);


        mPopupWindow = new PopupWindow(popupView, RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT, true);
        mPopupWindow.setTouchable(true);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setBackgroundDrawable(new BitmapDrawable(getResources(), (Bitmap) null));
    }
}
