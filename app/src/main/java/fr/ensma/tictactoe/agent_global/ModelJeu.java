package fr.ensma.tictactoe.agent_global;

import fr.ensma.tictactoe.agent_plateau.ModelPlateau;
import fr.ensma.tictactoe.types_base.EStatutPartie;

public class ModelJeu {

    private ModelPlateau mPlat;

    private EStatutPartie statutPartie;


    public EStatutPartie getStatutPartie() {
        return statutPartie;
    }

    public void setStatutPartie(EStatutPartie statutPartie) {
        this.statutPartie = statutPartie;
    }

    public void changerJoueurCourant() {

    }
}
