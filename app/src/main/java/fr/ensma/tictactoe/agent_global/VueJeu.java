package fr.ensma.tictactoe.agent_global;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.util.Log;
import android.view.OrientationEventListener;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;


import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import fr.ensma.tictactoe.R;
import fr.ensma.tictactoe.agent_plateau.VuePlateau;
import fr.ensma.tictactoe.elements.OrientationThread;

import static fr.ensma.tictactoe.types_base.EEtat.CROIX;


public class VueJeu extends ConstraintLayout {
    private View laRacine;

    private ConstraintLayout leRoot;

    private SourceDonnee srd;

    //private OrientationThread orient;
    float x,y,z;

    private VuePlateau lePlateau;
    private Button leBouton;     // PLAY (PLAY/REPLAY  sans changement)
    private TextView leLabel;   // affiche le label du jeu : TICTACTOE
    private TextView leLabelVictoire; //va afficher le gagnant à la fin de partie;
    private ProgressBar leBar;

    private PresentationJeu pj;

    public VueJeu(Context context) {
        super(context);

        initVue(context);
    }


    public VueJeu(Context context,  AttributeSet attrs) {
        super(context, attrs);
        initVue(context);
    }

    public VueJeu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initVue(context);
    }


    public VuePlateau getVuePlateau() {
        return lePlateau;
    }

    private void initVue(Context context) {




        laRacine = inflate(context, R.layout.activity_jeu, this);
       // Log.d("TicTacToe : VueJeu", "Instantiation");
       // leRoot =  laRacine.findViewById(R.id.rootId);

        leBouton = laRacine.findViewById(R.id.buttonPlayId);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        leLabel = laRacine.findViewById(R.id.textViewId);
        leBar = laRacine.findViewById(R.id.progressBarId);
        leLabelVictoire = laRacine.findViewById(R.id.textViewVictoryId);
        lePlateau = laRacine.findViewById(R.id.vuePlateauId);
        leBar.setMax(30);
        //orient = new OrientationThread();
        //orient.run();

        leBouton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                start();
            }
        });



        // pj = new PresentationJeu(context,this);

    }


    public void setXYZ (float x,float y,float z) {
        this.x=x;
        this.y=y;
        this.z=z;
    }

    public boolean portableTourne() {
        if ((x>45) || (x <=-45) || (y> 45) || (y <=- 45)) {
           return true;
        } else return false;
    }


    public void start () {
               if(leBar.getProgress()>0||portableTourne()) {srd.arret();
               }

                srd =  new SourceDonnee();
                srd.execute(new Integer(0));


            }


    public void modifierLabel (String arg) {
        switch (arg) {
            case "CROIXGAGNE":
                srd.arret(); break;
            case  "CERCLEGAGNE":
                srd.arret(); break;

        }


        leLabelVictoire.setText(arg);
    }


    private class SourceDonnee extends AsyncTask<Integer, Integer,Integer> {
        int i = 0;
        @Override
        protected Integer doInBackground (Integer... integers) {
            for (i = 0; i<30;i++) {
                try {
                   // Log.d("TicTacToe : VueJeu", "progress");
                    publishProgress(i);
                    Thread.currentThread().sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return 0;
                }
            }
            return 0;
        }
        protected void arret() {
            this.cancel(true);
        }

        @Override
        protected void onProgressUpdate(Integer ... values) {

            leBar.setProgress(values[0]);


        }
        @Override
        protected void onPostExecute (Integer integer)  {
            super.onPostExecute(integer);

        }

    }




}
