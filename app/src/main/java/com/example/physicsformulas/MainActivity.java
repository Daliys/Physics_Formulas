package com.example.physicsformulas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

   //public Task1Part1 task1Part1;
   // public  Task1Part2 task1Part2;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    public static FormulaLogic formulaLogic;

    public static String PACKAGE_NAME;
    public static boolean isInitialize = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PACKAGE_NAME = getPackageName();

        //task1Part1 = new Task1Part1();
        //task1Part2 = new Task1Part2();
        fragmentManager = getSupportFragmentManager();
        formulaLogic = new FormulaLogic(this);
        isInitialize = true;

        SwitchFragment(1);

    }

    public void SwitchFragment(int index){
        fragmentTransaction = fragmentManager.beginTransaction();

        if (index == 1 ) {
            fragmentTransaction.replace(R.id.fragment_containerMain, new Task1Part1());
            //fragmentTransaction.remove(fragmentManager.findFragmentById(R.id.fragment_containerMain));
           // fragmentTransaction.add(R.id.fragment_containerMain,task1Part1);

        }
        else if (index == 2) {
            fragmentTransaction.replace(R.id.fragment_containerMain, new Task1Part2());
            //fragmentTransaction.remove(fragmentManager.findFragmentById(R.id.fragment_containerMain));
            //fragmentTransaction.add(R.id.fragment_containerMain,task1Part2);

        }



        fragmentTransaction.commit();
    }



    boolean isSwitch = true;
    public void ButtonChangeFragmentListener(View view) {
        formulaLogic.Start();
/*
        fragmentTransaction = fragmentManager.beginTransaction();

       // if (isSwitch) {
        //    fragmentTransaction.replace(R.id.fragment_containerMain, task1Part1);
      //  } else {
            fragmentTransaction.replace(R.id.fragment_containerMain,  task1Part2);
     //   }
      //  isSwitch = !isSwitch;
        fragmentTransaction.commit();
*/
    }

/*
    public void But(View v){
        GenereteExample();
    }

    public void ButAnswer(View v){
        switch (v.getId()) {
            case R.id.button1:
                if (randFormula[0].equals(rightAnswerFormula)) textViewAnswer.setText("Right");
                else textViewAnswer.setText("Wrong");
                break;
            case R.id.button2:
                if (randFormula[1].equals(rightAnswerFormula)) textViewAnswer.setText("Right");
                else textViewAnswer.setText("Wrong");
                break;
            case R.id.button3:
                if (randFormula[2].equals(rightAnswerFormula)) textViewAnswer.setText("Right");
                else textViewAnswer.setText("Wrong");
                break;
            case R.id.button4:
                if (randFormula[3].equals(rightAnswerFormula)) textViewAnswer.setText("Right");
                else textViewAnswer.setText("Wrong");
                break;

        }
    }

    Formula rightAnswerFormula;
    Formula[] randFormula;

    void GenerateExample(){

       randFormula = new Formula[formulas.size()];
       randFormula = formulas.toArray(randFormula);


        Random random = new Random();

        for (int i = 0; i < random.nextInt(100); i++){
            int first = random.nextInt(randFormula.length);
            int second = random.nextInt(randFormula.length);
            Formula temp = randFormula[first];
            randFormula[first] = randFormula[second];
            randFormula[second] = temp;
        }


        rightAnswerFormula = randFormula[random.nextInt(4)];

        if(random.nextBoolean()){
            textViewExample.setVisibility(View.INVISIBLE);
            imageViewExample.setImageResource(getResources().getIdentifier("formula_"+ rightAnswerFormula.id,"drawable", getPackageName()));
            imageViewExample.setVisibility(View.VISIBLE);

            but1.setBackgroundResource(R.color.colorButton);
            but2.setBackgroundResource(R.color.colorButton);
            but3.setBackgroundResource(R.color.colorButton);
            but4.setBackgroundResource(R.color.colorButton);


            but1.setText(randFormula[0].name);
            but2.setText(randFormula[1].name);
            but3.setText(randFormula[2].name);
            but4.setText(randFormula[3].name);

        }else{
            textViewExample.setVisibility(View.VISIBLE);
            textViewExample.setText(rightAnswerFormula.name);
            imageViewExample.setVisibility(View.INVISIBLE);

            but1.setText("");
            but2.setText("");
            but3.setText("");
            but4.setText("");

            but1.setBackgroundResource(getResources().getIdentifier("formula_"+randFormula[0].id,"drawable", getPackageName()));
            but2.setBackgroundResource(getResources().getIdentifier("formula_"+randFormula[1].id,"drawable", getPackageName()));
            but3.setBackgroundResource(getResources().getIdentifier("formula_"+randFormula[2].id,"drawable", getPackageName()));
            but4.setBackgroundResource(getResources().getIdentifier("formula_"+randFormula[3].id,"drawable", getPackageName()));


        }
    }*/

}


