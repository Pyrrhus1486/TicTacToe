package fr.ensma.tictactoe.agent_plateau;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridLayout;

import fr.ensma.tictactoe.R;
import fr.ensma.tictactoe.agent_case.VueCase;

public class VuePlateau extends GridLayout {

    private VueCase V11;
    private VueCase V12;
    private VueCase V13;
    private VueCase V21;
    private VueCase V22;
    private VueCase V23;
    private VueCase V31;
    private VueCase V32;
    private VueCase V33;

    private View laRacine;

    public VuePlateau(Context context) {
        super(context);
        initVue(context);
    }

    public VuePlateau(Context context, AttributeSet attrs) {
        super(context, attrs);
        initVue(context);
    }
    public VuePlateau(Context ctx, AttributeSet attrs, int defStyle) {
        super(ctx, attrs, defStyle);
        initVue(ctx);
    }

    private void initVue(Context ctx) {
        laRacine = inflate(ctx, R.layout.activity_plateau, this);
        V11 = laRacine.findViewById(R.id.case11);
        V12 = laRacine.findViewById(R.id.case12);
        V13 = laRacine.findViewById(R.id.case13);
        V21 = laRacine.findViewById(R.id.case21);
        V22 = laRacine.findViewById(R.id.case22);
        V23 = laRacine.findViewById(R.id.case23);
        V31 = laRacine.findViewById(R.id.case31);
        V32 = laRacine.findViewById(R.id.case32);
        V33 = laRacine.findViewById(R.id.case33);
    }



    public void cliquee(VueCase v) {
        v.cliquee();

    }

    public VueCase getV11() {
        return V11;
    }

    public VueCase getV12() {
        return V11;
    }

    public VueCase getV13() {
        return V13;
    }

    public VueCase getV21() {
        return V21;
    }

    public VueCase getV22() {
        return V22;
    }

    public VueCase getV23() {
        return V23;
    }

    public VueCase getV31() {
        return V31;
    }

    public VueCase getV32() {
        return V32;
    }

    public VueCase getV33() {
        return V33;
    }

}
