package com.example.song.songapplication.Module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 10181198 on 4/18/2017.
 */
@Module   //提供依赖对象的实例
public class MainModule {
    private Context mContext;

    public MainModule(Context context) {
        mContext = context;
    }

    public MainModule() {

    }


    @Provides
    Context providesContext() {
        // 提供上下文对象
        return mContext;
    }

//    @Provides
//    @Singleton
//    @PotForLily
//    Pot providesPotForLily(@FlowerForLily Flower flower) {
//        // 提供上下文对象
//        return new Pot(flower);
//    }
//
//    @Provides
//    @Singleton
//    @PotForRose
//    Pot providesPotForRose(@FlowerForRose Flower flower) {
//        // 提供上下文对象
//        return new Pot(flower);
//    }
}
