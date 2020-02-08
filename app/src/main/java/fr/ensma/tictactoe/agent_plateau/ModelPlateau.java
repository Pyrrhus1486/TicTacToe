package fr.ensma.tictactoe.agent_plateau;

import fr.ensma.tictactoe.agent_case.ModelCase;
import fr.ensma.tictactoe.types_base.EEtat;

public class ModelPlateau {

    private EEtat caseSuivante;
    private ModelCase[][] plateau;

    public EEtat typeMarqueur(){

        if(caseSuivante==EEtat.CROIX){
            caseSuivante=EEtat.CERCLE;
            return EEtat.CROIX;
        }

        else{
            caseSuivante=EEtat.CROIX;
            return EEtat.CERCLE;
        }

    }

}
