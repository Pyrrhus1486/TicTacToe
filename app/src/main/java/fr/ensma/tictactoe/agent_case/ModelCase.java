package fr.ensma.tictactoe.agent_case;

import java.util.List;

import fr.ensma.tictactoe.observation.IObservable;
import fr.ensma.tictactoe.observation.IObservateur;
import fr.ensma.tictactoe.types_base.EEtat;


public class ModelCase implements IObservable {


    private List<IObservateur> liste_observateurs;
    private EEtat etatCase;

    public void setEtatCase(EEtat etatCase) {
        this.etatCase = etatCase;
        notifier();
    }

    public EEtat getEtatCase() {
        return etatCase;
    }

    @Override
    public void notifier() {
        for(IObservateur observateur : liste_observateurs){
            observateur.actualiser();

        }
    }

    @Override
    public void ajouterObs(IObservateur arg_obs) {

        liste_observateurs.add(arg_obs);
        continue;

    }
}
