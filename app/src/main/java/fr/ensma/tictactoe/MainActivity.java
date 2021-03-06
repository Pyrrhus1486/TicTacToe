package fr.ensma.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.HandlerThread;
import android.util.Log;

import android.widget.LinearLayout;

import fr.ensma.tictactoe.agent_case.VueCase;
import fr.ensma.tictactoe.agent_global.ModelJeu;
import fr.ensma.tictactoe.agent_global.PresentationJeu;
import fr.ensma.tictactoe.agent_global.VueJeu;
import fr.ensma.tictactoe.elements.SensorThread;


public class MainActivity extends AppCompatActivity{

    private VueJeu leJeu;
    private LinearLayout leRoot;
    private ConstraintLayout leConstL;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("TicTacToe : Main", "Instantiation");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        leConstL= findViewById(R.id.constrLayoutId);
        leRoot = findViewById(R.id.rootId);
        leJeu = findViewById(R.id.jeuId);
    }

}




