package com.example.physicsformulas;

import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LogicTask1  {

    public List<Formula> questionFormulas;
    public Formula rightAnswerFormula;
    public int rightAnswer = 0;
    public int wrongAnswer = 0;
    private FormulaLogic formulaLogic;

    public LogicTask1(FormulaLogic formulaLogic){
        questionFormulas = new ArrayList<>();
        this.formulaLogic = formulaLogic;
    }

    public void ResetCounters(){
        rightAnswer = 0;
        wrongAnswer = 0;
        TextView textViewWrongAnswer = formulaLogic.view.findViewById(R.id.textViewWrongAnswers);
        TextView textViewRightAnswer = formulaLogic.view.findViewById(R.id.textViewRightAnswers);
        textViewRightAnswer.setText(Integer.toString(rightAnswer));
        textViewWrongAnswer.setText(Integer.toString(wrongAnswer));
    }

    public void Start(){
        GenerateExample();
        rightAnswerFormula = questionFormulas.get(0);
    }

    public void SendAnswerButton(int id){
        TextView textViewWrongAnswer = formulaLogic.view.findViewById(R.id.textViewWrongAnswers);
        TextView textViewRightAnswer = formulaLogic.view.findViewById(R.id.textViewRightAnswers);

        if(questionFormulas.get(id).equals(rightAnswerFormula)) rightAnswer++;
        else wrongAnswer++;
        textViewRightAnswer.setText(Integer.toString(rightAnswer));
        textViewWrongAnswer.setText(Integer.toString(wrongAnswer));

        GenerateExample();
    }

    protected void GenerateExample() {
        Random random = new Random();
        GenerateQuestion();
        rightAnswerFormula = questionFormulas.get(random.nextInt(questionFormulas.size()));

        if (random.nextBoolean()) {
            formulaLogic.view.SwitchFragment(11);
        } else {
            formulaLogic.view.SwitchFragment(12);
        }

    }


    private void GenerateQuestion(){
        Random random = new Random();
        List<Formula> randomList = new ArrayList<>(formulaLogic.formulasList);

        while (randomList.size() > 4){
            randomList.remove(random.nextInt(randomList.size()));
        }
        for(int i = 0; i < 25; i++){
            int t = random.nextInt(randomList.size());
            Formula temp = randomList.get(t);
            randomList.remove(t);
            randomList.add(temp);
        }
        questionFormulas.clear();
        questionFormulas.addAll(randomList);

    }
}
