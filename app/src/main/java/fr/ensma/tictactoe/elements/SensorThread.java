package fr.ensma.tictactoe.elements;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.sip.SipSession;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;

import fr.ensma.tictactoe.observation.IObservablePos;
import fr.ensma.tictactoe.observation.IObservateurPos;

import static java.lang.Math.abs;


public class SensorThread extends Thread implements IObservablePos {
    private SensorManager sensorManager;
    Sensor accelerometer;
    private static final String TAG = "SensorThread";

    private IObservateurPos observateur;
    private MySensorListener msl;
    private float x;

    public SensorThread(SensorManager sM) {
        Log.d(TAG, "Instantion de SensorThread" );
        sensorManager = sM;

    }



@Override
    public void run() {

        Log.d(TAG, Thread.currentThread().getName()); // To display thread
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        msl = new MySensorListener();
        sensorManager.registerListener(msl, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        //onResume(msl);

    }

    @Override
    public void notifier(float i) {
        if (abs(i) >= 7.0) {

            observateur.actualiser(i);
           / onPause();
        }
    }

    @Override
    public void ajouterObs(IObservateurPos arg_obs) {
        observateur = arg_obs;
    }

    private class MySensorListener implements SensorEventListener {
        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }

        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
          //  Log.d(TAG, "onSensorChanged: X :"+ sensorEvent.values[0] + " Y : "+ sensorEvent.values[1]);
           x=x+sensorEvent.values[0];
            notifier(x);

        }

    }

    public void onPause() {
        sensorManager.unregisterListener(msl);

    }

    public void onResume() {
        sensorManager.registerListener(msl, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

}


