package fr.ensma.tictactoe.agent_case;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import fr.ensma.tictactoe.R;

public class VueCase extends LinearLayout implements View.OnClickListener{
    private ImageButton leBoutonImage;
    private View laRacine;

    private PresentationCase pres;

    public VueCase(Context ctx) {

        super(ctx);

        initVue(ctx);
    }

    public VueCase(Context ctx, AttributeSet attrs) {
        super(ctx,attrs);

        initVue(ctx);
    }
    public VueCase(Context ctx, AttributeSet attrs, int defStyle) {
        super(ctx, attrs, defStyle);
        initVue(ctx);
    }




    private void initVue(Context ctx) {

        laRacine = inflate(ctx, R.layout.activity_case, this);
        leBoutonImage = laRacine.findViewById(R.id.imageBoutonId);
       // Log.d("TicTacToe : VueCase", "Instantiation");

        //pres = new PresentationCase();
        //ModelCase m = new ModelCase();


        leBoutonImage.setOnClickListener(this);
        // leBoutonImage.setBackgroundResource(R.drawable.ic_cross);
    }

    public void setPres(PresentationCase pres) {
        this.pres = pres;
    }


    public void mettreCroix () {
    leBoutonImage.setBackgroundResource(R.drawable.ic_cross);
    //TODO change joeur
    }
    public void mettreCercle () {
        leBoutonImage.setBackgroundResource(R.drawable.ic_circle);
    //TODO : change joeur
    }

    public void cliquee(){
        Log.d("TicTacToe : VueCase", "CaseCliquee");

        pres.case_cliquee();
    }


    @Override
    public void onClick(View v) {

        cliquee();
    }
}
