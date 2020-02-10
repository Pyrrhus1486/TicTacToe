package fr.ensma.tictactoe.elements;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.view.OrientationEventListener;

public class OrientationThread extends Thread implements Runnable, SensorEventListener {

    private OrientationEventListener mOrientation;
        float x,y,z;
        float[] values;




    @Override
    public void run() {
        if ((x>90) || (x <-90) || (y> 90) || (y <- 90)) {

            //TODO : START New Game

        }
    }



    @Override
    public void onSensorChanged(SensorEvent event) {
        values = event.values;
         x = values[0];
         y = values[1];
         z = values[2];
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
