package com.liji.as.pictureselect;


import android.app.Application;
import android.content.Context;

/**
 * 作者：liji on 2015/12/10 10:04
 * 邮箱：lijiwork@sina.com
 */
public class MApplication extends Application {
    private static Context CONTEXT;
    

    @Override
    public void onCreate() {
        
        super.onCreate();
        CONTEXT = getApplicationContext();

    }

    

    
    public static Context getContext() {
        return CONTEXT;
    }
    
}
