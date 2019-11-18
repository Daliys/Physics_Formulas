package com.example.physicsformulas;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class Task2SingleAnswer extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_task2_single_answer, null);

        ImageView imageViewFormula = v.findViewById(R.id.imageView_fragment_task2_single_answer_formula);
        imageViewFormula.setImageResource(getResources().getIdentifier("formula_" + MainActivity.formulaLogic.logicTask2.GetQuestionFormulaByNum(MainActivity.formulaLogic.logicTask2.numCreatedSingleAnswer).id,
                "drawable", MainActivity.PACKAGE_NAME));
        TextView textViewFormula = v.findViewById(R.id.textView_fragment_task2_single_answer_formula);
        textViewFormula.setText(MainActivity.formulaLogic.logicTask2.GetQuestionFormulaByNum(MainActivity.formulaLogic.logicTask2.numCreatedSingleAnswer).name);
        TextView textViewCounter = v.findViewById(R.id.textView_fragment_task2_single_answer_counter);
        textViewCounter.setText(Integer.toString((MainActivity.formulaLogic.logicTask2.numCreatedSingleAnswer) +1));
        MainActivity.formulaLogic.logicTask2.numCreatedSingleAnswer++;
        return v;
    }

}
