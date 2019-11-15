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

        return inflater.inflate(R.layout.fragment_task1_part2, container, false);

    }
    static  int i = 0;

    @Override
    public void onStart(){
        super.onStart();


        getActivity().findViewById(R.id.button_answer1_part2).setOnClickListener(btnClick);
        getActivity().findViewById(R.id.button_answer2_part2).setOnClickListener(btnClick);
        getActivity().findViewById(R.id.button_answer3_part2).setOnClickListener(btnClick);
        getActivity().findViewById(R.id.button_answer4_part2).setOnClickListener(btnClick);
        Log.e("MIIIIIIIII" , "ONSTART__2");


    }

    private View.OnClickListener btnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String str = "TEXT + ";
            switch (view.getId()) {
                case R.id.button_answer1_part2:
                    str += "But1 + part2";
                    break;
                case R.id.button_answer2_part2:
                    str += "But2 + part2";
                    break;
                case R.id.button_answer3_part2:
                    str += "But3 + part2";
                    break;
                case R.id.button_answer4_part2:
                    str += "But4 + part2";
                    break;
            }
            TextView textView = getActivity().findViewById(R.id.textViewTitle);
            textView.setText(str);

            Log.e("MIIIIIIIII" , "BUTTON _ 2");

        }
    };


}
