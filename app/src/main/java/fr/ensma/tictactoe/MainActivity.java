package fr.ensma.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

import fr.ensma.tictactoe.agent_case.VueCase;
import fr.ensma.tictactoe.agent_global.VueJeu;

public class MainActivity extends AppCompatActivity {

    private VueCase case1;
    private VueJeu leJeu;
    private LinearLayout leRoot;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        leRoot = findViewById(R.id.rootId);
        leJeu = findViewById(R.id.jeuId);
       // case1 = findViewById(R.id.case1);
      //  case1.mettreCercle();



    }
}
