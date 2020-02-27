package fr.ensma.tictactoe.elements;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import fr.ensma.tictactoe.observation.IObservablePos;
import fr.ensma.tictactoe.observation.IObservateurPos;
import static java.lang.Math.abs;

/**
 * Implementation du accelerometre dans un thread separé.
 * Communication en boite à lettre avec l'abonnement.
 * Utilisation des méthodes onPause, onResume
 */
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
        Log.d(TAG, Thread.currentThread().getName());
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        msl = new MySensorListener();
        sensorManager.registerListener(msl, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void notifier(float i) {
            observateur.actualiser(i);
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
            if (abs(x - abs(sensorEvent.values[0]))>6) {
            notifier(x);
            x= abs(sensorEvent.values[0]);
            }
        }
    }

    public void onPause() {
        sensorManager.unregisterListener(msl);
    }
    public void onResume() {
        sensorManager.registerListener(msl, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

}


