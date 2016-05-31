package org.zero.ui;

import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.widget.Toast;

import org.zero.R;
import org.zero.util.ActivityManager;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    private boolean blnIsClickBack = false;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //3秒内双击后退键退出程序
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (blnIsClickBack) {
                ActivityManager.getInstance().exit();
            } else {
                blnIsClickBack = true;
                Toast.makeText(MainActivity.this, "双击退出", Toast.LENGTH_SHORT).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        blnIsClickBack = false;
                    }
                }, 3000);
            }
        }
        return true;
    }
}
