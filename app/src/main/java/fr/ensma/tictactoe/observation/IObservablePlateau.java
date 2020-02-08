package fr.ensma.tictactoe.observation;

public interface IObservablePlateau {

    public void notifier();
    public void ajouterObs(IObservateurPlateau arg_obs);
}
