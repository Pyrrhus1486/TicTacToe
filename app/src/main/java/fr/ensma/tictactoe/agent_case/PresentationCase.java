package fr.ensma.tictactoe.agent_case;

import java.util.ArrayList;
import java.util.List;

import fr.ensma.tictactoe.observation.IObservable;
import fr.ensma.tictactoe.observation.IObservablePlateau;
import fr.ensma.tictactoe.observation.IObservateur;
import fr.ensma.tictactoe.observation.IObservateurPlateau;
import fr.ensma.tictactoe.types_base.EEtat;

import android.content.Context;
import android.nfc.Tag;
import android.util.Log;


public class PresentationCase implements IObservablePlateau, IObservateur {




    private VueCase laVue;



    private ModelCase leModele;


    private List<IObservateurPlateau> liste_observateurs;

    public PresentationCase(Context arg_context, VueCase arg_ma_vue){ // La présentation sera instanciée avec le contexte en argument. Le plateau, qui instanciera la présentation, recevra le contexte depuis l'agent global
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

/*    public void setLaVue(VueCase laVue) {
        this.laVue = laVue;
    }*/

    @Override
    public void notifierPlateau() {
        Log.d("TicTacToe : PresentationCase", "notifierPlateau()");
        //Pour la présentation plateau, qui est abonné à la présentation de chaque case.
    for(IObservateurPlateau observateur : liste_observateurs){
       observateur.actualiserPresPlateau(this);

        }
    }



    @Override
    public void ajouterObs(IObservateurPlateau arg_obs) {
        Log.d("TicTacToe : PresentationCase", "ajouterObs");
     liste_observateurs.add(arg_obs);

    }



    public void case_cliquee(){
        Log.d("TicTacToe : PresentationCase", "case_cliquee()");
        notifierPlateau();
    }


    @Override
    public void actualiser()  {
        Log.d("TicTacToe : PresentationCase", "actualiser()");
    EEtat tamp = leModele.getEtatCase();
        Log.d("TicTacToe : PresentationCase", "actualiser()" + tamp.toString());
      switch (tamp){
          case  CLIQUABLE:
            break; //Ajouter la gestion de l'erreur. (Avec la construction actuelle, elle ne devrait jamais arriver);

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

        leModele.ajouterObs(this);
    }
}
