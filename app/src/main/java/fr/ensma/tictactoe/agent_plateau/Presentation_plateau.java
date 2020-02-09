package fr.ensma.tictactoe.agent_plateau;

import java.util.ArrayList;
import java.util.List;

import fr.ensma.tictactoe.agent_case.PresentationCase;
import fr.ensma.tictactoe.observation.IObservateurPlateau;

import android.content.Context;


public class Presentation_plateau implements IObservateurPlateau {


    private List<PresentationCase> listePresentations;

    private VuePlateau vuePlateau;
    private ModelPlateau modelPlateau;


    public Presentation_plateau(Context arg_context) {

        vuePlateau = new VuePlateau(arg_context);

        modelPlateau = new ModelPlateau();

        listePresentations= new ArrayList<PresentationCase>();

        instancierPresentations(arg_context);
        sAbonnerPresentations();


    }

    public void instancierPresentations(Context arg_context){//On instancie les présentations, en leur passant en référence les VueCases qui ont été instanciées par la vuePlateau, et les ModelCases instanciées par le modelPlateau

        listePresentations.add(new PresentationCase( arg_context, vuePlateau.getV11(), modelPlateau.getPlateau()[0][0]));
        listePresentations.add(new PresentationCase( arg_context, vuePlateau.getV12(), modelPlateau.getPlateau()[0][1]));
        listePresentations.add(new PresentationCase( arg_context, vuePlateau.getV13(), modelPlateau.getPlateau()[0][2]));
        listePresentations.add(new PresentationCase( arg_context, vuePlateau.getV21(), modelPlateau.getPlateau()[1][0]));
        listePresentations.add(new PresentationCase( arg_context, vuePlateau.getV22(), modelPlateau.getPlateau()[1][1]));
        listePresentations.add(new PresentationCase( arg_context, vuePlateau.getV23(), modelPlateau.getPlateau()[1][2]));
        listePresentations.add(new PresentationCase( arg_context, vuePlateau.getV31(), modelPlateau.getPlateau()[2][0]));
        listePresentations.add(new PresentationCase( arg_context, vuePlateau.getV32(), modelPlateau.getPlateau()[2][1]));
        listePresentations.add(new PresentationCase( arg_context, vuePlateau.getV33(), modelPlateau.getPlateau()[2][2]));

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
