package fr.ensma.tictactoe.agent_case;

import android.content.Context;
import android.media.Image;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import fr.ensma.tictactoe.R;

public class VueCase extends LinearLayout {
    private ImageButton leBoutonImage;
    private View laRacine;
    private Image ic_cercle;



    private PresentationCase pres;





    private Integer parameter;

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
        parameter = 0;
        laRacine = inflate(ctx, R.layout.activity_case, this);
        leBoutonImage = laRacine.findViewById(R.id.imageBoutonId);
        leBoutonImage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cliquee();
            }
                                         });

        // leBoutonImage.setBackgroundResource(R.drawable.ic_cross);
    }

    public void setPres(PresentationCase pres) {
        this.pres = pres;
    }

    public void mettreCroix () {
    leBoutonImage.setBackgroundResource(R.drawable.ic_cross);

    }
    public void mettreCercle () {
        leBoutonImage.setBackgroundResource(R.drawable.ic_circle);
    }

    public void cliquee(){
    pres.case_cliquee();
    }



}
