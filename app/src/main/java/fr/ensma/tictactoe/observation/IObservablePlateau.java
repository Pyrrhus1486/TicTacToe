package fr.ensma.tictactoe.observation;

public interface IObservablePlateau {

    public void notifierPlateau();
    public void ajouterObs(IObservateurPlateau arg_obs);
}
