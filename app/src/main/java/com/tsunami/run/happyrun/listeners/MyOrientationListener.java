package com.tsunami.run.happyrun.listeners;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/**
 * Created by 2010330579 on 2016/1/7.
 */
public class MyOrientationListener implements SensorEventListener {
    private SensorManager mSensorManager;
    private Context mContext;
    private Sensor mSensor;

    private float lastX;
    public MyOrientationListener(Context context) {
        this.mContext = context;
    }

    public void start() {
        mSensorManager = (SensorManager) mContext
                .getSystemService(Context.SENSOR_SERVICE);
        if(mSensorManager != null) {
            // 获得方向传感器
            mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        }

        if(mSensor != null) {
            mSensorManager.registerListener(this,mSensor,
                    SensorManager.SENSOR_DELAY_UI);
        }
    }

    public void stop() {
        mSensorManager.unregisterListener(this);
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }


    @SuppressWarnings({"deprecation"})
    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() == Sensor.TYPE_ORIENTATION) {
            float x = event.values[SensorManager.DATA_X];

            if(Math.abs(x - lastX) > 1.0) {
                if(mOnOrientationListener != null) {
                    mOnOrientationListener.onOrientationChanged(x);
                }
            }

            lastX = x;
        }
    }

    private OnOrientationListener mOnOrientationListener;
    public void setOnOrientationListener(
            OnOrientationListener mOnOrientationListener){
        this.mOnOrientationListener = mOnOrientationListener;

    }

//    public void setmSensorManager(SensorManager mSensorManager) {
//        this.mSensorManager = mSensorManager;
//    }
    public interface OnOrientationListener {
        void onOrientationChanged(float x);
    }
}
