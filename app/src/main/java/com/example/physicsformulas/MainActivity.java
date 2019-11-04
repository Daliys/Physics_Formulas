package com.example.physicsformulas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

   public List<Formula> formulas ;
    Button but1, but2, but3, but4;
    TextView textViewExample, textViewAnswer;
    ImageView imageViewExample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        but1 = findViewById(R.id.button1);
        but2 = findViewById(R.id.button2);
        but3 = findViewById(R.id.button3);
        but4 = findViewById(R.id.button4);
        textViewExample = findViewById(R.id.textViewExample);
        textViewAnswer = findViewById(R.id.textView3);
        imageViewExample = findViewById(R.id.imageViewExample);

        formulas = new ArrayList<>();
        formulas.add(new Formula("Скорость", "1"));
        formulas.add(new Formula("Ускорение", "2"));
        formulas.add(new Formula("Тангенциальное ускорение", "3"));
        formulas.add(new Formula("Нормальное ускорение", "4"));


        GenereteExample();

    }

    public void But(View v){
        GenereteExample();
    }

    public void ButAnswer(View v){
        switch (v.getId()) {
            case R.id.button1:
                if (randFormula[0].equals(rightAnswer)) textViewAnswer.setText("Right");
                else textViewAnswer.setText("Wrong");
                break;
            case R.id.button2:
                if (randFormula[1].equals(rightAnswer)) textViewAnswer.setText("Right");
                else textViewAnswer.setText("Wrong");
                break;
            case R.id.button3:
                if (randFormula[2].equals(rightAnswer)) textViewAnswer.setText("Right");
                else textViewAnswer.setText("Wrong");
                break;
            case R.id.button4:
                if (randFormula[3].equals(rightAnswer)) textViewAnswer.setText("Right");
                else textViewAnswer.setText("Wrong");
                break;

        }
    }

    Formula rightAnswer;
    Formula[] randFormula;

    void GenereteExample(){

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


        rightAnswer = randFormula[random.nextInt(4)];

        if(random.nextBoolean()){
            textViewExample.setVisibility(View.INVISIBLE);
            imageViewExample.setImageResource(getResources().getIdentifier("formula_"+ rightAnswer.id,"drawable", getPackageName()));
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
            textViewExample.setText(rightAnswer.name);
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
    }

}


class Formula{
    public String name;
    public String id;

    public Formula(String name, String id){
        this.name = name;
        this.id = id;
    }

}
