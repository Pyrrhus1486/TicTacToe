package fr.ensma.tictactoe.agent_case;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import fr.ensma.tictactoe.R;

public class VueCase extends LinearLayout {
    private ImageView imageCercle;
    private ImageView imageCroix;
    private View laRacine;






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
        imageCercle = laRacine.findViewById(R.id.imageCercleId);
        imageCroix = laRacine.findViewById(R.id.imageCroixId);

            imageCercle.setVisibility(View.VISIBLE);
            imageCroix.setVisibility(View.INVISIBLE);
    }

    public void mettreCroix () {

        imageCroix.setVisibility(View.VISIBLE);
    }
    public void mettreCercle () {

        imageCercle.setVisibility(View.VISIBLE);
    }

    public void cliquee(){

    }

}
