package fr.ensma.tictactoe.observation;

public interface IObservablePos {
    public void notifier(float f);
    public void ajouterObs(IObservateurPos arg_obs);
}