package fr.ensma.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import fr.ensma.tictactoe.agent_case.VueCase;
import fr.ensma.tictactoe.agent_global.VueJeu;

public class MainActivity extends AppCompatActivity {

    private VueCase case1;
    private VueJeu leJeu;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        leJeu = findViewById(R.id.leJeuId);
       // case1 = findViewById(R.id.case1);
      //  case1.mettreCercle();



    }
}
