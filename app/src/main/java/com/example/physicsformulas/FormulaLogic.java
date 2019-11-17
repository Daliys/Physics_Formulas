package com.example.physicsformulas;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FormulaLogic extends MainActivity{

    private MainActivity view;
    List<Formula> formulasList;
    public int rightAnswer = 0;
    public int wrongAnswer = 0;

    public void SendAnswerButton(int id){
        TextView textViewWrongAnswer = view.findViewById(R.id.textViewWrongAnswers);
        TextView textViewRightAnswer = view.findViewById(R.id.textViewRightAnswers);

        if(questionFormulas.get(id).equals(rightAnswerFormula)) rightAnswer++;
        else wrongAnswer++;
        textViewRightAnswer.setText(Integer.toString(rightAnswer));
        textViewWrongAnswer.setText(Integer.toString(wrongAnswer));

        GenerateExample();
    }

    public void Start(){
        GenerateExample();
    }

    public FormulaLogic(MainActivity activity){
        this.view = activity;
        InitializeFormulas();
        questionFormulas = new ArrayList<>();

        GenerateQuestion();
        rightAnswerFormula = questionFormulas.get(0);
    }


    private void InitializeFormulas(){

        formulasList = new ArrayList<>();
        formulasList.add(new Formula("Скорость", "1"));
        formulasList.add(new Formula("Ускорение", "2"));
        formulasList.add(new Formula("Тангенциальное ускорение", "3"));
        formulasList.add(new Formula("Нормальное ускорение", "4"));

    }

    public List<Formula> questionFormulas;
    public Formula rightAnswerFormula;



    private void GenerateExample() {
        Random random = new Random();
        GenerateQuestion();
        rightAnswerFormula = questionFormulas.get(random.nextInt(questionFormulas.size()));

        if (random.nextBoolean()) {
            view.SwitchFragment(11);
        } else {
            view.SwitchFragment(12);
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
        questionFormulas.clear();
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
