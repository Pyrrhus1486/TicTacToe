package fr.ensma.tictactoe.agent_plateau;

import fr.ensma.tictactoe.agent_case.ModelCase;
import fr.ensma.tictactoe.agent_global.ModelJeu;
import fr.ensma.tictactoe.types_base.ConversionEtatStatut;
import fr.ensma.tictactoe.types_base.EEtat;
import fr.ensma.tictactoe.types_base.EStatutPartie;

public class ModelPlateau {

    private EEtat caseSuivante;
    private ModelJeu monJeu;

    public ModelCase[][] getPlateau() {
        return plateau;
    }

    private ModelCase[][] plateau;


    public ModelPlateau() {


        caseSuivante = EEtat.CROIX; // Initialement, on commence avec une croix;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                plateau[i][j] = new ModelCase();
            }
        }

    }

    public EEtat typeMarqueur() {

        if (caseSuivante == EEtat.CROIX) {
            caseSuivante = EEtat.CERCLE;
            return EEtat.CROIX;
        } else {
            caseSuivante = EEtat.CROIX;
            return EEtat.CERCLE;
        }

    }

    public void modifierCase(ModelCase arg_case) {
        EEtat tamp = typeMarqueur();

        arg_case.setEtatCase(tamp);
        TesterCoupGagnant(tamp);
    }

    public EStatutPartie TesterCoupGagnant(EEtat arg_marqueur) {

        //lignes
        for (int i = 0; i < 3; i++) {
            int compteur = 0;
            for (int j = 0; j < 3; j++) {
                if (plateau[i][j].getEtatCase() == arg_marqueur) {
                    compteur += 1;
                }

            }
            if (compteur == 3) {

                return ConversionEtatStatut.convertir(arg_marqueur);

            }
        }
        //colonnes

        for (int i = 0; i < 3; i++) {
            int compteur = 0;
            for (int j = 0; j < 3; j++) {
                if (plateau[j][i].getEtatCase() == arg_marqueur) {
                    compteur += 1;
                }
            }
            if (compteur == 3) {

                return ConversionEtatStatut.convertir(arg_marqueur);
            }
        }

        //diagonales

        if (plateau[0][0].getEtatCase() == arg_marqueur && plateau[1][1].getEtatCase() == arg_marqueur && plateau[2][2].getEtatCase() == arg_marqueur) {

            return ConversionEtatStatut.convertir(arg_marqueur);

        }

        if (plateau[0][2].getEtatCase() == arg_marqueur && plateau[1][1].getEtatCase() == arg_marqueur && plateau[2][0].getEtatCase() == arg_marqueur) {

            return ConversionEtatStatut.convertir(arg_marqueur);

        }


        //Test si le plateau est plein. S'il contient au moins une case à l'état Cliquable, il n'est pas plein donc la partie continue.

        for (int i = 0; i < 3; i++) {
            int compteur = 0;
            for (int j = 0; j < 3; j++) {
                if (plateau[i][j].getEtatCase() == EEtat.CLIQUABLE) {
                    return (EStatutPartie.ENCOURS);
                }
            }
        }


        //Finalement, personne n'a gagné et le plateau est plein : match nul.

        return EStatutPartie.MATCHNUL;



    }
}
