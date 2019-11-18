package com.example.physicsformulas;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LogicTask2 {
    public FormulaLogic formulaLogic;
    public List<Formula> questionsFormulas;

    public LogicTask2(FormulaLogic formulaLogic) {

        this.formulaLogic = formulaLogic;
        questionsFormulas = new ArrayList<>();
    }


    public void Start() {
        GenerateQuestions();
    }
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
                    questionsFormulas.add(formula);
                    isFind = true;
                }
            }
            Log.e("Formula", questionsFormulas.get(i).name);
        }
    }

}
