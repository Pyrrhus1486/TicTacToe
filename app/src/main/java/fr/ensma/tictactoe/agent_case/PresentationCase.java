package fr.ensma.tictactoe.agent_case;

import java.util.ArrayList;
import java.util.List;

import fr.ensma.tictactoe.observation.IObservable;
import fr.ensma.tictactoe.observation.IObservablePlateau;
import fr.ensma.tictactoe.observation.IObservateur;
import fr.ensma.tictactoe.observation.IObservateurPlateau;
import fr.ensma.tictactoe.types_base.EEtat;

import android.content.Context;


public class PresentationCase implements IObservablePlateau, IObservateur {

    private VueCase laVue;



    private ModelCase leModele;


    private List<IObservateurPlateau> liste_observateurs;

    public PresentationCase(Context arg_context, VueCase arg_ma_vue, ModelCase arg_mon_modele){ // La présentation sera instanciée avec le contexte en argument. Le plateau, qui instanciera la présentation, recevra le contexte depuis l'agent global

        laVue = arg_ma_vue;
        laVue.setPres(this);

        leModele = arg_mon_modele;
        leModele.ajouterObs(this);

        liste_observateurs = new ArrayList<IObservateurPlateau>();

    }



    @Override
    public void notifierPlateau() { //Pour la présentation plateau, qui est abonné à la présentation de chaque case.
    for(IObservateurPlateau observateur : liste_observateurs){
       observateur.actualiserPresPlateau(this);

        }
    }



    @Override
    public void ajouterObs(IObservateurPlateau arg_obs) {

     liste_observateurs.add(arg_obs);

    }



    public void case_cliquee(){
        notifierPlateau();
    }


    @Override
    public void actualiser()  {
    EEtat tamp = leModele.getEtatCase();
      switch (tamp){
          case  CLIQUABLE:
            break; //Ajouter la gestion de l'erreur. (Avec la construction actuelle, elle ne devrait jamais arriver);

          case CROIX:
         laVue.mettreCroix();

        case CERCLE :
         laVue.mettreCercle();
        }
    }

    public ModelCase getLeModele() {
        return leModele;
    }

}
