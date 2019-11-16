package com.example.physicsformulas;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class Task1Part2 extends Fragment {


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_task1_part2,null);
        Button button1 = (Button) v.findViewById(R.id.button_answer1_part2);
        Button button2 = (Button) v.findViewById(R.id.button_answer2_part2);
        Button button3 = (Button) v.findViewById(R.id.button_answer3_part2);
        Button button4 = (Button) v.findViewById(R.id.button_answer4_part2);
        button1.setOnClickListener(btnClick);
        button2.setOnClickListener(btnClick);
        button3.setOnClickListener(btnClick);
        button4.setOnClickListener(btnClick);

        return v;

    }

    @Override
    public void onStart(){
        super.onStart();




    }

    private View.OnClickListener btnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String str = "TEXT + ";
            switch (view.getId()) {
                case R.id.button_answer1_part2:
                    MainActivity.formulaLogic.SendAnswerButton(1);
                    break;
                case R.id.button_answer2_part2:
                    MainActivity.formulaLogic.SendAnswerButton(2);
                    break;
                case R.id.button_answer3_part2:
                    MainActivity.formulaLogic.SendAnswerButton(3);
                    break;
                case R.id.button_answer4_part2:
                    MainActivity.formulaLogic.SendAnswerButton(4);
                    break;
            }
            TextView textView = getActivity().findViewById(R.id.textViewTitle);
            textView.setText(str);


        }
    };


}
