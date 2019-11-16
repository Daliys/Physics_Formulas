package com.example.physicsformulas;

import android.app.Activity;
import android.media.Image;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FormulaLogic extends MainActivity{

    private MainActivity view;
    List<Formula> formulasList;

    public void SendAnswerButton(int id){
        TextView textView = view.findViewById(R.id.textViewTitle);
        textView.setText("1111111111111111111111111111111111");
        //if(questionFormulas.get(id).equals(rightAnswer)) textView.setText("RIGHT");
       // else textView.setText("FALSE");
        Button b1 = view.findViewById(R.id.button_answer1_part1);
        b1.setText("PAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
      //  GenerateExample();
    }

    public void Start(){
        GenerateExample();

    }

    public FormulaLogic(MainActivity activity){
        this.view = activity;
        InitializeFormulas();
        questionFormulas = new ArrayList<>();

    }


    private void InitializeFormulas(){

        formulasList = new ArrayList<>();
        formulasList.add(new Formula("Скорость", "1"));
        formulasList.add(new Formula("Ускорение", "2"));
        formulasList.add(new Formula("Тангенциальное ускорение", "3"));
        formulasList.add(new Formula("Нормальное ускорение", "4"));

    }

    private List<Formula> questionFormulas;
    private Formula rightAnswer;

    private void GenerateExample(){
        Random random = new Random();
        GenerateQuestion();
        rightAnswer = questionFormulas.get(random.nextInt(questionFormulas.size()));


        if(random.nextBoolean()){
            view.SwitchFragment(1);

            TextView textView = view.task1Part1.getView().findViewById(R.id.textView_question_part1);
            textView.setText(rightAnswer.name);
            Button button1 = view.findViewById(R.id.button_answer1_part1);
            button1.setBackgroundResource(view.getResources().getIdentifier("formula_"+ questionFormulas.get(0).id,"drawable", view.getPackageName()));
            Button button2 = view.findViewById(R.id.button_answer2_part1);
            button2.setBackgroundResource(view.getResources().getIdentifier("formula_"+ questionFormulas.get(1).id,"drawable", view.getPackageName()));
            Button button3 = view.findViewById(R.id.button_answer3_part1);
            button3.setBackgroundResource(view.getResources().getIdentifier("formula_"+ questionFormulas.get(2).id,"drawable", view.getPackageName()));
            Button button4 = view.findViewById(R.id.button_answer4_part1);
            button4.setBackgroundResource(view.getResources().getIdentifier("formula_"+ questionFormulas.get(3).id,"drawable", view.getPackageName()));
        }else {
            view.SwitchFragment(2);

            Button b1 = view.task1Part2.getView().findViewById(R.id.button_answer1_part2);
            b1.setText(questionFormulas.get(0).name);
            Button b2 = view.findViewById(R.id.button_answer2_part2);
            b2.setText(questionFormulas.get(1).name);
            Button b3 = view.findViewById(R.id.button_answer3_part2);
            b3.setText(questionFormulas.get(2).name);
            Button b4 = view.findViewById(R.id.button_answer4_part2);
            b4.setText(questionFormulas.get(3).name);

            ImageView imageView = view.findViewById(R.id.imageView_question_part2);
            imageView.setImageResource(view.getResources().getIdentifier("formula_"+ rightAnswer.id,"drawable", view.getPackageName()));
        }

    }

    private void GenerateQuestion(){
        Random random = new Random();
        List<Formula> randomList = new ArrayList<>(formulasList);

        while (randomList.size() > 4){
            randomList.remove(random.nextInt(randomList.size()));
        }
        for(int i = 0; i < 25; i++){
            int t = random.nextInt(randomList.size());
            Formula temp = randomList.get(t);
            randomList.remove(t);
            randomList.add(temp);
        }
        questionFormulas.addAll(randomList);

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
