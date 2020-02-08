package fr.ensma.tictactoe.agent_case;

import java.util.ArrayList;
import java.util.List;

import fr.ensma.tictactoe.observation.IObservable;
import fr.ensma.tictactoe.observation.IObservateur;
import fr.ensma.tictactoe.types_base.EEtat;

import android.content.Context;


public class PresentationCase implements IObservable, IObservateur {

    private VueCase laVue;
    private ModelCase leModele;

    private List<IObservateur> liste_observateurs;

    public PresentationCase(Context arg_context, VueCase arg_ma_vue){ // La présentation sera instanciée avec le contexte en argument. Le plateau, qui instanciera la présentation, recevra le contexte depuis l'agent global
        //La présentation se voit aussi passer sa vue en argument, car la vue de sa case est instanciée par la vuePlateau.

        laVue = arg_ma_vue;

        leModele = new ModelCase();
        leModele.ajouterObs(this);

        liste_observateurs = new ArrayList<IObservateur>();
    }

    @Override
    public void notifier() { //Pour l'agent plateau, qui est abonné à la présentation de chaque case.
    for(IObservateur observateur : liste_observateurs){
       observateur.actualiser();

        }
    }

    @Override
    public void ajouterObs(IObservateur arg_obs) {

     liste_observateurs.add(arg_obs);

    }

    public void case_cliquee(){
        notifier();
    }


    @Override
    public void actualiser() {
    EEtat tamp = leModele.getEtatCase();
      switch (tamp){
          case  CLIQUABLE:
            //TODO

          case CROIX:
         laVue.mettreCroix();

        case CERCLE :
         laVue.mettreCercle();
        }
    }
}
