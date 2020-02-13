package fr.ensma.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.util.Log;

import android.widget.LinearLayout;

import fr.ensma.tictactoe.agent_case.VueCase;
import fr.ensma.tictactoe.agent_global.ModelJeu;
import fr.ensma.tictactoe.agent_global.PresentationJeu;
import fr.ensma.tictactoe.agent_global.VueJeu;


public class MainActivity extends AppCompatActivity{


    private VueJeu leJeu;
    private LinearLayout leRoot;
    private ConstraintLayout leConstL;


    private PresentationJeu pj;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("TicTacToe : Main", "Instantiation");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        leConstL= findViewById(R.id.constrLayoutId);
        leRoot = findViewById(R.id.rootId);

        leJeu = findViewById(R.id.jeuId);
        pj = new PresentationJeu(this.getBaseContext(),leJeu);
    }



}
