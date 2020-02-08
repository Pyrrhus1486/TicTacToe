package fr.ensma.tictactoe.agent_plateau;

import java.util.ArrayList;
import java.util.List;

import fr.ensma.tictactoe.agent_case.PresentationCase;
import android.content.Context;


public class Presentation_plateau {


    private List<PresentationCase> listePresentations;

    private VuePlateau vuePlateau;
    private ModelPlateau modelPlateau;


    public Presentation_plateau(Context arg_context) {

        vuePlateau = new VuePlateau(arg_context);

        modelPlateau = new ModelPlateau();

        listePresentations= new ArrayList<PresentationCase>();
        instancierPresentations(arg_context);


    }

    public void instancierPresentations(Context arg_context){

        listePresentations.add(new PresentationCase( arg_context, vuePlateau.getV11()));
        listePresentations.add(new PresentationCase( arg_context, vuePlateau.getV12()));
        listePresentations.add(new PresentationCase( arg_context, vuePlateau.getV13()));
        listePresentations.add(new PresentationCase( arg_context, vuePlateau.getV21()));
        listePresentations.add(new PresentationCase( arg_context, vuePlateau.getV22()));
        listePresentations.add(new PresentationCase( arg_context, vuePlateau.getV23()));
        listePresentations.add(new PresentationCase( arg_context, vuePlateau.getV31()));
        listePresentations.add(new PresentationCase( arg_context, vuePlateau.getV32()));
        listePresentations.add(new PresentationCase( arg_context, vuePlateau.getV33()));

    }
}
