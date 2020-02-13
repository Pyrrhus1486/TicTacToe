package fr.ensma.tictactoe.elements;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.util.Log;
import android.view.OrientationEventListener;

public class OrientationThread extends Thread implements  SensorEventListener {

   // private OrientationEventListener mOrientation;
    private float x,y,z;
    private float[] values;
    private boolean newGame;



    @Override
    public void run() {
        Log.d("TicTacToe : Orient", "excec");
        if ((x>45) || (x <=-45) || (y> 45) || (y <=- 45)) {
            newGame = true;
        } else newGame=false;
    }

    public boolean startNewGame() {
       return newGame;
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
