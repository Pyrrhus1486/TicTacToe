package fr.ensma.tictactoe.types_base;

public abstract class ConversionEtatStatut {


    public static EStatutPartie convertir(EEtat arg) {

        if (arg==EEtat.CERCLE){
            return EStatutPartie.CERCLEGAGNE;
        }

        if (arg==EEtat.CROIX){
            return EStatutPartie.CROIXGAGNE;
        }

        else{

            return null;
        }
    }


}
