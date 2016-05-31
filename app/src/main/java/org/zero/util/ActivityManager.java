package org.zero.util;

import android.app.Activity;
import android.os.Process;

import java.util.Stack;

/**
 * activity对象管理器
 * Created by Zero on 2016/4/19.
 */
public class ActivityManager {
    private static Stack<Activity> activityStack;
    private static ActivityManager manager;

    private ActivityManager() {
    }

    /**
     * 单实例，获取ActivityManager对象
     */
    public static ActivityManager getInstance() {
        if (manager == null) {
            manager = new ActivityManager();
            activityStack = new Stack<>();
        }
        return manager;
    }

    /**
     * 增加activity到stack中
     * @param activity
     */
    public void addActivity(Activity activity) {
        activityStack.push(activity);
    }

    /**
     * 安全退出
     */
    public void exit() {
        for (int i = 0; i < activityStack.size(); i++) {
            activityStack.get(i).finish();
        }
        Process.killProcess(Process.myPid());
        System.exit(0);
    }


}
