package fr.ensma.tictactoe.agent_case;

import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import fr.ensma.tictactoe.observation.IObservable;
import fr.ensma.tictactoe.observation.IObservateur;
import fr.ensma.tictactoe.types_base.EEtat;


public class ModelCase implements IObservable {


    private List<IObservateur> liste_observateurs;
    private EEtat etatCase;


    public ModelCase(){
        Log.d("TicTacToe : ModelCase", "Instantiation");
        etatCase= EEtat.CLIQUABLE;
        Log.d("TicTacToe : ModelCase", "Instantiation terminée");
        liste_observateurs = new ArrayList<IObservateur>();
    }


    public void setEtatCase(EEtat etatCase) {
        this.etatCase = etatCase;
        notifier();
        Log.d("TicTacToe : ModelCase", "setEtatCase()" + etatCase.toString());
    }

    public EEtat getEtatCase() {
        return etatCase;
    }

    @Override
    public void notifier() {
        Log.d("TicTacToe : ModelCase", "notifier()");
        for(IObservateur observateur : liste_observateurs){
            observateur.actualiser();

        }
    }

    @Override
    public void ajouterObs(IObservateur arg_obs) {

            liste_observateurs.add(arg_obs);


    }
}
