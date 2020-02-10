package fr.ensma.tictactoe.elements;

import android.os.CountDownTimer;
import android.widget.ProgressBar;

import fr.ensma.tictactoe.agent_global.ModelJeu;
import fr.ensma.tictactoe.agent_plateau.ModelPlateau;

public class Timer extends CountDownTimer {
    private int i;
    private ModelJeu m;
    private ProgressBar b;
    private static int time = 5;

    public Timer (ProgressBar b, ModelJeu m) {
        super(1000000,10);
        this.b = b;
        this.m = m;
        reset();
    }


    @Override
    public void onTick(long millisUntilFinished) {
        i++;
        b.setProgress((int) i / time);
        if (i > 100*time) {
            reset();
        }
     }

    @Override
    public void onFinish() { reset ();

    }
    public void reset() {
    //TODO : "Rajouter "changer Joueur Courant"
        i=0;
    }
    public void zero() { i = 0;}
}
