package com.example.song.songapplication.Activity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.song.songapplication.Bean.Pot;
import com.example.song.songapplication.R;
import com.example.song.songapplication.dagger2.DaggerFlowerComponent;
import com.example.song.songapplication.dagger2.DaggerMainComponent;
import com.example.song.songapplication.dagger2.DaggerPotComponent;

import javax.inject.Inject;

public class Dagger2Activity extends BaseActivity {
    //    @Inject
//    @PotForLily
//    Pot potLily;
//    @Inject
//    @PotForRose
//    Pot potRose;
    @Inject
    Pot pot;
    @Inject
    Pot pot2;

    /*@PersonForContext // 标记
    @Inject   //标明需要注入的对象
            Person person;
    @PersonForName // 标记
    @Inject   //标明需要注入的对象
            Person person2;
    @PersonForContext // 标记
    @Inject
    Lazy<Person> lazyPerson; // 注入Lazy元素

    @PersonForName // 标记
    @Inject
    Provider<Person> providerPerson; // 注入Provider
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger2);
      /*  // 构造桥梁对象
        MainComponent component = DaggerMainComponent.builder().mainModule(new MainModule(this)).build();
        //注入
        component.inject(this);
        // 打印两个对象的地址
        Log.i("dagger", "person = " + person.toString());
//        // 打印两个对象的地址
        Log.i("dagger", "person2 = " + person2.toString());
        Person person = lazyPerson.get();// 调用该方法时才会去创建Person,以后每次调用获取的是同一个对象
//        // 调用该方法时才回去创建Person1，以后每次调用都会重新加载Module中的具体方法，根据Module中的实现，可能相同，可能不相同。
        Person person1 = providerPerson.get();*/
        //DaggerMainComponent.create().inject(this);

        // Toast.makeText(Dagger2Activity.this, potLily.show() + "-------" + potRose.show(), Toast.LENGTH_SHORT).show();
        DaggerMainComponent.builder()
                .potComponent(DaggerPotComponent.builder()
                        .flowerComponent(DaggerFlowerComponent.create())
                        .build())
                .build().inject(this);

        String show = pot.show();
        Toast.makeText(Dagger2Activity.this, pot.equals(pot2) +"", Toast.LENGTH_SHORT).show();

//        DaggerFlowerComponent.create()
//                .plus(new PotModule())  // 这个方法返回PotComponent
//                .plus()                 // 这个方法返回MainActivityComponent
//                .inject(this);
//
//        String show = pot.show();
//        Toast.makeText(Dagger2Activity.this, pot.equals(pot2) +"", Toast.LENGTH_SHORT).show();
    }

}
