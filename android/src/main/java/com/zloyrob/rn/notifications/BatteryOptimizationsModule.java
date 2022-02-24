package com.zloyrob.rn.notifications;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import android.provider.Settings;
import android.util.Log;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class BatteryOptimizationsModule extends ReactContextBaseJavaModule {
    private static final int REQUEST_CODE = 1;
    private final ReactApplicationContext reactContext;
    private final String packageName;

    public BatteryOptimizationsModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
        this.packageName = reactContext.getPackageName();
    }

    @Override
    public String getName() {
        return "BatteryOptimizations";
    }

    @SuppressLint("AnnotateVersionCheck")
    private boolean isBatteryOptimizationSupported() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
    }

    @ReactMethod
    public void isSupported(final Promise promise) {
        promise.resolve(isBatteryOptimizationSupported());
    }

    private boolean isIgnoringBatteryOptimizations() {
        if (isBatteryOptimizationSupported()) {
            PowerManager pm = (PowerManager) this.reactContext.getSystemService(Context.POWER_SERVICE);
            boolean isIgnoringBatteryOptimizations = false;
            if (pm != null) {
                isIgnoringBatteryOptimizations = pm.isIgnoringBatteryOptimizations(this.packageName);
            }
            Log.d("BatteryOptimizations", "PowerManager.isIgnoringBatteryOptimizations() returned: " + isIgnoringBatteryOptimizations);
            return isIgnoringBatteryOptimizations;
        } else {
            return true;
        }
    }

    @ReactMethod 
    public void isIgnoringBatteryOptimizations(final Promise promise) {
        promise.resolve(isIgnoringBatteryOptimizations());
    }

    @SuppressLint("BatteryLife")
    @ReactMethod
    public void open() {
        if (!isIgnoringBatteryOptimizations()) {
            Intent intent = new Intent();
            if (isBatteryOptimizationSupported()) {
                intent.setAction(Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS);
            }
            intent.setData(Uri.parse("package:" + this.packageName));
            getReactApplicationContext().startActivityForResult(intent, REQUEST_CODE, null);
        }
    }

}
