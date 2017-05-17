package com.example.song.songapplication.dagger2;

import com.example.song.songapplication.Activity.Dagger2Activity;
import com.example.song.songapplication.dagger2.qualifier.ActivityScope;

import dagger.Component;

/**
 * Created by 10181198 on 4/18/2017.
 */
/*
@Subcomponent  // 作为桥梁，沟通调用者和依赖对象库
public interface MainComponent {

    //定义注入的方法
    void inject(Dagger2Activity activity);

}*/
@ActivityScope
@Component(dependencies = PotComponent.class)
public interface MainComponent {
    void inject(Dagger2Activity activity);
}