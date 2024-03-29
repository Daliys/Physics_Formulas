package com.example.physicsformulas;
import java.util.ArrayList;
import java.util.List;

//here was extend MainActivity
public class FormulaLogic {

    protected MainActivity view;
    List<Formula> formulasList;
    public LogicTask1 logicTask1;
    public LogicTask2 logicTask2;

    public int numCreatedWikiFormulas;

    public FormulaLogic(MainActivity activity){
        this.view = activity;
        InitializeFormulas();
        logicTask1 = new LogicTask1(this);
        logicTask2 = new LogicTask2(this);
        numCreatedWikiFormulas =0;
    }


    private void InitializeFormulas(){

        formulasList = new ArrayList<>();
        formulasList.add(new Formula("Скорость", "1"));
        formulasList.add(new Formula("Ускорение", "2"));
        formulasList.add(new Formula("Тангенциальное ускорение", "3"));
        formulasList.add(new Formula("Нормальное ускорение", "4"));
        formulasList.add(new Formula("Количество движения", "5"));
        formulasList.add(new Formula("Закон изменения кол-ва движения", "6"));
        formulasList.add(new Formula("Мера воздействия", "7"));
        formulasList.add(new Formula("Уравнение динамики", "8"));
        formulasList.add(new Formula("Энергия движения", "9"));
        formulasList.add(new Formula("Механическая работа", "10"));


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
