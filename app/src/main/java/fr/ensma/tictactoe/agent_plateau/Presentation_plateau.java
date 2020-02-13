package fr.ensma.tictactoe.agent_plateau;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import fr.ensma.tictactoe.agent_case.PresentationCase;
import fr.ensma.tictactoe.observation.IObservable;
import fr.ensma.tictactoe.observation.IObservateur;
import fr.ensma.tictactoe.observation.IObservateurPlateau;
import fr.ensma.tictactoe.types_base.EStatutPartie;

import android.content.Context;
import android.util.Log;


public class Presentation_plateau implements IObservateurPlateau, IObservable {


    private EStatutPartie statut;
    private List<PresentationCase> listePresentations;
    private List<IObservateur> listeObsJeu;
    private VuePlateau vuePlateau;
    private ModelPlateau modelPlateau;


    public Presentation_plateau(Context arg_context, VuePlateau vp) {
        listeObsJeu = new ArrayList<IObservateur>();
        vuePlateau = vp;

        vuePlateau.setPresentationPlateau(this);

//        modelPlateau = mp;
        modelPlateau = new ModelPlateau();

        listePresentations= new ArrayList<PresentationCase>();

        instancierPresentations(arg_context);
        sAbonnerPresentations();

    }

    public void instancierPresentations(Context arg_context){//On instancie les présentations, en leur passant en référence les VueCases qui ont été instanciées par la vuePlateau, et les ModelCases instanciées par le modelPlateau
      //  Log.d("TicTacToe : PresPlateau", "Instantiation");

        PresentationCase pres11 = new PresentationCase( arg_context, vuePlateau.getV11());
        modelPlateau.getPlateau()[0][0]=pres11.getModele();
     //   Log.d("TicTacToe : PresPlateau", "Instantiation pres11 terminé");
        PresentationCase pres12 = new PresentationCase( arg_context, vuePlateau.getV12());
        modelPlateau.getPlateau()[0][1]= pres12.getModele();

        PresentationCase pres13 = new PresentationCase( arg_context, vuePlateau.getV13());
        modelPlateau.getPlateau()[0][2]=pres13.getModele();

        PresentationCase pres21 = new PresentationCase( arg_context, vuePlateau.getV21());
        modelPlateau.getPlateau()[1][0]= pres21.getModele();

        PresentationCase pres22 = new PresentationCase( arg_context, vuePlateau.getV22());
        modelPlateau.getPlateau()[1][1]=pres22.getModele();

        PresentationCase pres23 = new PresentationCase( arg_context, vuePlateau.getV23());
        modelPlateau.getPlateau()[1][2]= pres23.getModele();

        PresentationCase pres31 = new PresentationCase( arg_context, vuePlateau.getV31());
        modelPlateau.getPlateau()[2][0]=pres31.getModele();

        PresentationCase pres32 = new PresentationCase( arg_context, vuePlateau.getV32());
        modelPlateau.getPlateau()[2][1]=pres32.getModele();

        PresentationCase pres33 = new PresentationCase( arg_context, vuePlateau.getV33());
        modelPlateau.getPlateau()[2][2]= pres33.getModele();

        listePresentations.add(pres11);
        listePresentations.add(pres12);
        listePresentations.add(pres13);
        listePresentations.add(pres21);
        listePresentations.add(pres22);
        listePresentations.add(pres23);
        listePresentations.add(pres31);
        listePresentations.add(pres32);
        listePresentations.add(pres33);
       // vuePlateau.setPresentationPlateau(this);

/*        pres11.setLaVue(vuePlateau.getV11());
        pres12.setLaVue(vuePlateau.getV12());
        pres13.setLaVue(vuePlateau.getV13());
        pres21.setLaVue(vuePlateau.getV21());
        pres22.setLaVue(vuePlateau.getV22());
        pres23.setLaVue(vuePlateau.getV23());
        pres31.setLaVue(vuePlateau.getV31());
        pres32.setLaVue(vuePlateau.getV32());
        pres33.setLaVue(vuePlateau.getV33());*/

/*
        vuePlateau.getV11().setPres(pres11);
        vuePlateau.getV11().setPres(pres12);
        vuePlateau.getV11().setPres(pres13);
        vuePlateau.getV11().setPres(pres21);
        vuePlateau.getV11().setPres(pres22);
        vuePlateau.getV11().setPres(pres23);
        vuePlateau.getV11().setPres(pres31);
        vuePlateau.getV11().setPres(pres32);
        vuePlateau.getV11().setPres(pres33);
*/



    }





    public void sAbonnerPresentations(){
        for(PresentationCase pres:listePresentations){
            pres.ajouterObs((IObservateurPlateau) this);
        }
    }

    @Override
    public void actualiserPresPlateau(PresentationCase arg_pres) {

        statut= modelPlateau.modifierCase(arg_pres.getModele());
        notifier();
        Log.d("TicTacToe :Presentation_plateau", "ACtualiser pres plateau"+ "statut  = "+ statut.toString());

    }

    public EStatutPartie getStatut() {
        return statut;
    }


    @Override
    public void notifier() {
        for( IObservateur i : listeObsJeu){
            i.actualiser();
        }
    }

    @Override
    public void ajouterObs(IObservateur arg_obs) {
        listeObsJeu.add(arg_obs);
    }

}
