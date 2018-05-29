package com.example.luis.proyecto_polos;

import android.content.ComponentCallbacks;
import android.content.res.Configuration;

import com.squareup.leakcanary.LeakCanary;

public class aplicacion extends  android.app.Application{
    @Override
    public void onCreate(){
        super.onCreate();
        LeakCanary.install(this);
    }
   /* @Override
    public void onTerminate(){
        super.onTerminate();
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);
    }
    @Override
    public void onLowMemory(){
        super.onLowMemory();
    }

    @Override
    public void onTrimMemory(int level){
        super.onTrimMemory(level);
    }
    @Override
    public void registerComponentCallbacks(ComponentCallbacks callback){
        super.registerComponentCallbacks(callback);
    }*/
}
