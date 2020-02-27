package fr.ensma.tictactoe.agent_case;

import java.util.ArrayList;
import java.util.List;
import fr.ensma.tictactoe.observation.IObservablePlateau;
import fr.ensma.tictactoe.observation.IObservateur;
import fr.ensma.tictactoe.observation.IObservateurPlateau;
import fr.ensma.tictactoe.types_base.EEtat;

import android.content.Context;
import android.util.Log;


public class PresentationCase implements IObservablePlateau, IObservateur {
    private VueCase laVue;
    private ModelCase leModele;
    private List<IObservateurPlateau> liste_observateurs;
    private static final String TAG = "PresentationCase";
    public PresentationCase(Context arg_context, VueCase arg_ma_vue){
        // La présentation sera instanciée avec le contexte en argument. Le plateau, qui instanciera la présentation, recevra le contexte depuis l'agent global
      //  Log.d("TicTacToe : Pres_Case", "Instantiation");
        laVue = arg_ma_vue;
        laVue.setPres(this);
      //  Log.d("TicTacToe : Pres_Case", "Instantiation - model");
        leModele = new ModelCase();
      //  Log.d("TicTacToe : Pres_Case", "Instantiation - le modele ajouté");
        leModele.ajouterObs(this);
      //  Log.d("TicTacToe : Pres_Case", "Instantiation - observateur ajouté");
        liste_observateurs = new ArrayList<IObservateurPlateau>();
    }

    @Override
    public void notifierPlateau() {
        Log.d(TAG, "notifierPlateau()");
        //Pour la présentation plateau, qui est abonné à la présentation de chaque case.
    for(IObservateurPlateau observateur : liste_observateurs){
       observateur.actualiserPresPlateau(this);
        }
    }

    @Override
    public void ajouterObs(IObservateurPlateau arg_obs) {
        Log.d(TAG, "ajouterObs");
     liste_observateurs.add(arg_obs);
    }

    public void case_cliquee(){
        Log.d(TAG, "case_cliquee()");
        notifierPlateau();
    }

    @Override
    public void actualiser()  {
        Log.d(TAG, "actualiser()");
    EEtat tamp = leModele.getEtatCase();
        Log.d(TAG, "actualiser()" + tamp.toString());
      switch (tamp){
          case  CLIQUABLE:
            break;
          case CROIX:
         laVue.mettreCroix(); break;
          case CERCLE :
         laVue.mettreCercle(); break;
        }
    }

    public ModelCase getModele() {
       // Log.d("TicTacToe : PresentationCase", "getLeModele");
        return leModele;
    }

    public void reset(){
        leModele = new ModelCase();
         Log.d(TAG, "reset()");
        leModele.ajouterObs(this);
        liste_observateurs = new ArrayList<IObservateurPlateau>();
        Log.d(TAG, "reset() terminé");
    }
}
