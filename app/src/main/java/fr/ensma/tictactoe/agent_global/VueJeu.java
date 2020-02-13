package fr.ensma.tictactoe.agent_global;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;


import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import fr.ensma.tictactoe.R;
import fr.ensma.tictactoe.agent_plateau.VuePlateau;


public class VueJeu extends ConstraintLayout {
    private View laRacine;

    private ConstraintLayout leRoot;

    private VuePlateau lePlateau;
    private Button leBouton;     // PLAY (PLAY/REPLAY  sans changement)
    private TextView leLabel;   // affiche le label du jeu : TICTACTOE
    private TextView leLabelVictoire; //va afficher le gagnant à la fin de partie;
    private ProgressBar leBar;

    //private PresentationJeu pj;

    public VueJeu(Context context) {
        super(context);
        initVue(context);
    }


    public VueJeu(Context context,  AttributeSet attrs) {
        super(context, attrs);
        initVue(context);
    }

    public VueJeu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initVue(context);
    }



    private void initVue(Context context) {

        laRacine = inflate(context, R.layout.activity_jeu, this);
        Log.d("TicTacToe : VueJeu", "Instantiation");
        leRoot =  laRacine.findViewById(R.id.rootId);

        leBouton = laRacine.findViewById(R.id.buttonPlayId);
        lePlateau = laRacine.findViewById(R.id.vuePlateauId);
        leLabel = laRacine.findViewById(R.id.textViewId);
        leBar = laRacine.findViewById(R.id.progressBarId);
        leLabelVictoire = laRacine.findViewById(R.id.textViewVictoryId);

    }




}
