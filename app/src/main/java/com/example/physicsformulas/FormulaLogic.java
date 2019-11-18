package com.example.physicsformulas;
import android.util.Log;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
//here was extend MainActivity
public class FormulaLogic {

    protected MainActivity view;
    List<Formula> formulasList;
    public LogicTask1 logicTask1;
    public LogicTask2 logicTask2;

    public FormulaLogic(MainActivity activity){
        this.view = activity;
        InitializeFormulas();
        logicTask1 = new LogicTask1(this);
        logicTask2 = new LogicTask2(this);
    }


    private void InitializeFormulas(){

        formulasList = new ArrayList<>();
        formulasList.add(new Formula("Скорость", "1"));
        formulasList.add(new Formula("Ускорение", "2"));
        formulasList.add(new Formula("Тангенциальное ускорение", "3"));
        formulasList.add(new Formula("Нормальное ускорение", "4"));

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
