package com.example.physicsformulas;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LogicTask2 {
    public FormulaLogic formulaLogic;
    public List<Formula> questionsFormulas;
    public int numCurrentFormula;
    public int numCreatedSingleAnswer;


    public LogicTask2(FormulaLogic formulaLogic) {

        this.formulaLogic = formulaLogic;
        questionsFormulas = new ArrayList<>();
        numCurrentFormula = 0;
        numCreatedSingleAnswer = 0;
    }

    public Formula GetCurrentQuestionFormula(){return questionsFormulas.get(numCurrentFormula);}

    public Formula GetQuestionFormulaByNum(int num){
        if(num < questionsFormulas.size())return questionsFormulas.get(num);
        return null;
    }

    public void Start() {
        numCurrentFormula = 0;
        questionsFormulas.clear();
        numCreatedSingleAnswer = 0;
        GenerateQuestions();

    }
    public void Reset(){
        numCurrentFormula = 0;
        questionsFormulas.clear();
        numCreatedSingleAnswer = 0;
        formulaLogic.view.SwitchFragment(20);


    }

    public void ShowAnswer(){
        numCreatedSingleAnswer = 0;
        formulaLogic.view.SwitchFragment(21);
    }

    // здесь нужно дописать когда будет форумул > 10 что формула участвует 1 раз
    public void GenerateQuestions(){
        Random random = new Random();
        for(int i = 0; i < 10; i++){
            boolean isFind = false;
            while (!isFind){
                Formula formula = formulaLogic.formulasList.get(random.nextInt(formulaLogic.formulasList.size()));
                if(i>1) {
                  if(!questionsFormulas.get(questionsFormulas.size()-1).equals(formula) && !questionsFormulas.get(questionsFormulas.size()-2).equals(formula)){
                      questionsFormulas.add(formula);
                      isFind = true;
                  }
                }else{
                    if(i == 1) if(questionsFormulas.get(0).equals(formula))continue;
                    questionsFormulas.add(formula);
                    isFind = true;
                }
            }
        }
    }

}
