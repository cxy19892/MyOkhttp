package com.cxy.myokhttp.sys;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;

import java.util.Stack;

/**
 * Created by hasee on 2017/6/16.
 */
public class AppManager {

    private static Stack<FragmentActivity> activityStack;
    private static AppManager instance;

    private AppManager() {
    }

    /**
     * 单一实例
     */
    public static AppManager getAppManager() {
        if (instance == null) {
            instance = new AppManager();
        }
        return instance;
    }

    /**
     * 添加Activity到堆栈
     */
    public void addActivity(FragmentActivity activity) {
        if (activityStack == null) {
            activityStack = new Stack<FragmentActivity>();
        }
        activityStack.add(activity);
    }


    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    public Activity currentActivity() {
        Activity activity = activityStack.lastElement();
        return activity;
    }

    /**
     * 结束当前Activity（堆栈中最后一个压入的）
     */
    public void finishActivity() {
        if (!activityStack.isEmpty()) {
            Activity activity = activityStack.lastElement();
            finishActivity(activity);
        }
    }

    /**
     * 结束当前Activity（堆栈中最后一个压入的）并返回参数
     */
    public void finishActivity(int resultCode, Intent intent) {
        if (!activityStack.isEmpty()) {
            Activity activity = activityStack.lastElement();
            finishActivity(activity, resultCode, intent);
        }
    }

    /**
     * 结束指定的Activity
     */
    public void finishActivity(Activity activity, int resultCode, Intent intent) {
        if (activity != null) {
            activity.setResult(resultCode, intent);
            activity.finish();
            activity = null;
        }
    }

    /**
     * 结束指定的Activity
     */
    public void finishActivity(Activity activity) {
        if (activity != null) {
            activity.finish();
            activity = null;
        }
    }

    public void finishOtherActivity(Activity activity) {
        for (FragmentActivity act : activityStack) {
            if (act != null) {
                if (!act.getClass().getSimpleName().equals(activity.getClass().getSimpleName())) {
                    act.finish();
                    act = null;
                }
            }
        }

        /*for (int i = 0, size = activityStack.size(); i < size; i++) {
            if (null != activityStack.get(i)) {
                activityStack.get(i).finish();
                activityStack.remove(i);
            }
        }*/
    }

    public void remove(Activity activity) {
        activityStack.remove(activity);
        activity = null;
    }

    /**
     * 结束指定类名的Activity
     */
    public void finishActivity(Class<?> cls) {
        for (Activity activity : activityStack) {
            if (activity.getClass().equals(cls)) {
                finishActivity(activity);
                break;
            }
        }
    }

    /**
     * 结束所有Activity
     */
    public void finishAllActivity() {
        for (int i = 0, size = activityStack.size(); i < size; i++) {
            if (null != activityStack.get(i)) {
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
    }

    public void finishAllActivityExceptOne(Class<?> cls) {
        if (activityStack == null)
            return;
        FragmentActivity exceptActivity = null;
        for (int i = 0, size = activityStack.size(); i < size; i++) {
            if (!activityStack.get(i).getClass().equals(cls)) {
                activityStack.get(i).finish();
            } else {
                exceptActivity = activityStack.get(i);
            }
        }
        activityStack.clear();
        if (exceptActivity != null) {
            addActivity(exceptActivity);
        }
    }

    /**
     * 获取堆栈中activity个数
     *
     * @return activity个数
     */
    public int getActivitySize() {
        if (activityStack == null)
            return 0;
        return activityStack.size();
    }

    /**
     * 退出程序
     */
    public void exitApp() {
        try {
            finishAllActivity();
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(0);
        } catch (Exception localException) {
        }
    }
}
