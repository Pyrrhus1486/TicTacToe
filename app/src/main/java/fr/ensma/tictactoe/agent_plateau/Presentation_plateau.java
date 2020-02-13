package fr.ensma.tictactoe.agent_plateau;

import java.util.ArrayList;
import java.util.List;

import fr.ensma.tictactoe.agent_case.PresentationCase;
import fr.ensma.tictactoe.observation.IObservateurPlateau;

import android.content.Context;
import android.util.Log;


public class Presentation_plateau implements IObservateurPlateau {


    private List<PresentationCase> listePresentations;

    private VuePlateau vuePlateau;
    private ModelPlateau modelPlateau;


    public Presentation_plateau(Context arg_context, VuePlateau vp) {
        vuePlateau = vp;

        vuePlateau.setPresentationPlateau(this);

//        modelPlateau = mp;
        modelPlateau = new ModelPlateau();

        listePresentations= new ArrayList<PresentationCase>();

        instancierPresentations(arg_context);
        sAbonnerPresentations();


    }

    public void instancierPresentations(Context arg_context){//On instancie les présentations, en leur passant en référence les VueCases qui ont été instanciées par la vuePlateau, et les ModelCases instanciées par le modelPlateau
        Log.d("TicTacToe : PresPlateau", "Instantiation");
        PresentationCase pres11 = new PresentationCase( arg_context, vuePlateau.getV11(), modelPlateau.getPlateau()[0][0]);
        PresentationCase pres12 = new PresentationCase( arg_context, vuePlateau.getV12(), modelPlateau.getPlateau()[0][1]);
        PresentationCase pres13 = new PresentationCase( arg_context, vuePlateau.getV13(), modelPlateau.getPlateau()[0][2]);
        PresentationCase pres21 = new PresentationCase( arg_context, vuePlateau.getV21(), modelPlateau.getPlateau()[1][0]);
        PresentationCase pres22 = new PresentationCase( arg_context, vuePlateau.getV22(), modelPlateau.getPlateau()[1][1]);
        PresentationCase pres23 = new PresentationCase( arg_context, vuePlateau.getV23(), modelPlateau.getPlateau()[1][2]);
        PresentationCase pres31 = new PresentationCase( arg_context, vuePlateau.getV31(), modelPlateau.getPlateau()[2][0]);
        PresentationCase pres32 = new PresentationCase( arg_context, vuePlateau.getV32(), modelPlateau.getPlateau()[2][1]);
        PresentationCase pres33 = new PresentationCase( arg_context, vuePlateau.getV33(), modelPlateau.getPlateau()[2][2]);
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
    modelPlateau.modifierCase(arg_pres.getLeModele());

    }


}
