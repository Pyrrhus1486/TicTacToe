package fr.ensma.tictactoe.observation;

public interface IObservable {

    public void notifier();
    public void ajouterObs(IObservateur arg_obs);


}
