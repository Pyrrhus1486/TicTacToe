package fr.ensma.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import fr.ensma.tictactoe.agent_case.VueCase;

public class MainActivity extends AppCompatActivity {

    private VueCase case1;
    private VueCase case2;
    private VueCase case3;
    private VueCase case4;
    private VueCase case5;
    private VueCase case6;
    private VueCase case7;
    private VueCase case8;
    private VueCase case9;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        case1 = findViewById(R.id.case1);
        case1.mettreCercle();

    }
}
