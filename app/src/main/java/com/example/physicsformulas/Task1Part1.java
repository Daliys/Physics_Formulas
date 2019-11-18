package com.example.physicsformulas;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Task1Part1 extends Fragment {


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_task1_part1, null);
        Button button1 = (Button) v.findViewById(R.id.button_answer1_part1);
        Button button2 = (Button) v.findViewById(R.id.button_answer2_part1);
        Button button3 = (Button) v.findViewById(R.id.button_answer3_part1);
        Button button4 = (Button) v.findViewById(R.id.button_answer4_part1);
        button1.setOnClickListener(btnClick);
        button2.setOnClickListener(btnClick);
        button3.setOnClickListener(btnClick);
        button4.setOnClickListener(btnClick);

        if (MainActivity.isInitialize)
            SetContent(v);

        return v;

    }

    @Override
    public void onStart() {
        super.onStart();
    }

    public void SetContent(View view) {
        TextView textView = view.findViewById(R.id.textView_question_part1);
        textView.setText(MainActivity.formulaLogic.logicTask1.rightAnswerFormula.name);
        Button button1 = view.findViewById(R.id.button_answer1_part1);
        button1.setBackgroundResource(getResources().getIdentifier("formula_" + MainActivity.formulaLogic.logicTask1.questionFormulas.get(0).id, "drawable", MainActivity.PACKAGE_NAME));
        Button button2 = view.findViewById(R.id.button_answer2_part1);
        button2.setBackgroundResource(getResources().getIdentifier("formula_" + MainActivity.formulaLogic.logicTask1.questionFormulas.get(1).id, "drawable", MainActivity.PACKAGE_NAME));
        Button button3 = view.findViewById(R.id.button_answer3_part1);
        button3.setBackgroundResource(getResources().getIdentifier("formula_" + MainActivity.formulaLogic.logicTask1.questionFormulas.get(2).id, "drawable", MainActivity.PACKAGE_NAME));
        Button button4 = view.findViewById(R.id.button_answer4_part1);
        button4.setBackgroundResource(getResources().getIdentifier("formula_" + MainActivity.formulaLogic.logicTask1.questionFormulas.get(3).id, "drawable", MainActivity.PACKAGE_NAME));
    }

    private View.OnClickListener btnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.button_answer1_part1:

                    MainActivity.formulaLogic.logicTask1.SendAnswerButton(0);
                    break;
                case R.id.button_answer2_part1:
                    MainActivity.formulaLogic.logicTask1.SendAnswerButton(1);
                    break;
                case R.id.button_answer3_part1:
                    MainActivity.formulaLogic.logicTask1.SendAnswerButton(2);
                    break;
                case R.id.button_answer4_part1:
                    MainActivity.formulaLogic.logicTask1.SendAnswerButton(3);
                    break;
            }
        }

    };


}
