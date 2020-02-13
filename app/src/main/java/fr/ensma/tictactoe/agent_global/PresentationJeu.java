package fr.ensma.tictactoe.agent_global;

import android.content.Context;
import android.util.Log;

import fr.ensma.tictactoe.agent_plateau.Presentation_plateau;
import fr.ensma.tictactoe.observation.IObservateur;
import fr.ensma.tictactoe.types_base.EStatutPartie;

public class PresentationJeu implements IObservateur {

    private Presentation_plateau pp;
    private VueJeu vj;
    private ModelJeu mj;
    private EStatutPartie statut;


    public PresentationJeu(Context ctx, VueJeu vj) {
       // Log.d("TicTacToe : Pres_Jeu", "Instantiation");
        this.vj = vj;
        pp = new Presentation_plateau(ctx, vj.getVuePlateau());
        mj = new ModelJeu();

        pp.ajouterObs(this);
    }


    @Override
    public void actualiser() {
        Log.d("TicTacToe : Pres_Jeu", "actualiser");
        statut = pp.getStatut();
        vj.modifierLabel(statut.toString());
    }



}
