
/*package fr.ensma.tictactoe.elements;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;

class SensorAccelerationTutoActivity extends Thread implements SensorEventListener {

    // Déclaration de l'attribut en tant qu'attribut de l'activité
    // Le sensor manager (gestionnaire de capteurs)
    SensorManager sensorManager;

    // L'accéléromètre
    Sensor accelerometer;*/
/***************************************************************************/
/** Manage life cycle ******************************************************/
    /***************************************************************************/

    // Appelé à la création de l'activité. */
  /*  @Override
    public void onRun (Bundle savedInstanceState) {
        Log.d("TicTacToe : OrientationThread", "Instantiation");
        super.onCreate(savedInstanceState);*/
        // Faire quelque chose
        // Gérer les capteurs :
        // Instancier le gestionnaire des capteurs, le SensorManager
        //sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        // Instancier l'accéléromètre
        //accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        // Faire d'autres trucs
   // }

  /*  @Override
    protected void onPause() {
        // unregister the sensor (désenregistrer le capteur)
        sensorManager.unregisterListener(this, accelerometer);
        super.onPause();
    }

    @Override
    protected void onResume() {
        *//* Ce qu'en dit Google dans le cas de l'accéléromètre :
         * «  Ce n'est pas nécessaire d'avoir les évènements des capteurs à un rythme trop rapide.
         * En utilisant un rythme moins rapide (SENSOR_DELAY_UI), nous obtenons un filtre
         * automatique de bas-niveau qui "extrait" la gravité  de l'accélération.
         * Un autre bénéfice étant que l'on utilise moins d'énergie et de CPU. »
         *//*
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_UI);
        super.onResume();
    }
*/
/********************************************************************/
/** SensorEventListener*************************************************/
    /********************************************************************/

  /*  @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Rien à faire la plupart du temps
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        // Récupérer les valeurs du capteur
        float x, y, z;
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            x = event.values[0];
            y = event.values[1];
            z = event.values[2];
        }
    }

}*/
