package com.example.physicsformulas;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


public class Task1Part2 extends Fragment {


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_task1_part2, null);
        Button button1 = (Button) v.findViewById(R.id.button_answer1_part2);
        Button button2 = (Button) v.findViewById(R.id.button_answer2_part2);
        Button button3 = (Button) v.findViewById(R.id.button_answer3_part2);
        Button button4 = (Button) v.findViewById(R.id.button_answer4_part2);

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
        Button b1 = view.findViewById(R.id.button_answer1_part2);
        b1.setText(MainActivity.formulaLogic.questionFormulas.get(0).name);
        Button b2 = view.findViewById(R.id.button_answer2_part2);
        b2.setText(MainActivity.formulaLogic.questionFormulas.get(1).name);
        Button b3 = view.findViewById(R.id.button_answer3_part2);
        b3.setText(MainActivity.formulaLogic.questionFormulas.get(2).name);
        Button b4 = view.findViewById(R.id.button_answer4_part2);
        b4.setText(MainActivity.formulaLogic.questionFormulas.get(3).name);
        ImageView imageView = view.findViewById(R.id.imageView_question_part2);
        imageView.setImageResource(getResources().getIdentifier("formula_" + MainActivity.formulaLogic.rightAnswerFormula.id, "drawable", MainActivity.PACKAGE_NAME));

    }

    private View.OnClickListener btnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.button_answer1_part2:
                    MainActivity.formulaLogic.SendAnswerButton(0);
                    break;
                case R.id.button_answer2_part2:
                    MainActivity.formulaLogic.SendAnswerButton(1);
                    break;
                case R.id.button_answer3_part2:
                    MainActivity.formulaLogic.SendAnswerButton(2);
                    break;
                case R.id.button_answer4_part2:
                    MainActivity.formulaLogic.SendAnswerButton(3);
                    break;
            }
        }
    };

}
