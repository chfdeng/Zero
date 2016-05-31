package org.zero.ui;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import org.zero.util.ActivityManager;

/**
 * activit基类
 * Created by Zero on 2016/4/19.
 */
public class BaseActivity extends AppCompatActivity{
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        //对象加入到管理器中便于统一管理
        ActivityManager.getInstance().addActivity(this);


        //try
    }
}
