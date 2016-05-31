package org.zero.util;

import android.app.Activity;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

/**
 * popupWindow工具类
 * Created by Zero on 2016/4/26.
 */
public class PopupWindowUtil {
    private static PopupWindowUtil popupWindowUtil;
    private static PopupWindow popupWindow;

    private PopupWindowUtil() {
    }

    /**
     * 获取对象
     */
    public static PopupWindowUtil getInstance() {
        if (popupWindowUtil == null) {
            popupWindowUtil = new PopupWindowUtil();
        }
        return popupWindowUtil;
    }

    /**
     * 显示
     */
    public void show(Activity activity, int popupWindowLayoutId) {
        //获取window最顶层View
        View parentView = activity.getWindow().getDecorView();
        View popupWindowLayout = activity.getLayoutInflater().inflate(popupWindowLayoutId, null);
        popupWindow = new PopupWindow(popupWindowLayout, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.showAtLocation(parentView, Gravity.CENTER, 0, 0);
    }

    /**
     * 隐藏
     */
    public void hide() {
        if (popupWindow != null && popupWindow.isShowing()) {
            popupWindow.dismiss();
            popupWindow = null;
        }
    }

    /**
     * 显示并且自动隐藏
     */
    public void showAndAutoHide(Activity activity, int popupWindowLayoutId) {
        show(activity, popupWindowLayoutId);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                hide();
            }
        }, 3000);
    }


}
