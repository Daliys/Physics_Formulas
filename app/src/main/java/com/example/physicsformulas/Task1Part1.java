package com.example.physicsformulas;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.os.Debug;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Task1Part1 extends Fragment {


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_task1_part1, container, false);

    }

    @Override
    public void onStart(){
        super.onStart();

        getActivity().findViewById(R.id.button_answer1_part1).setOnClickListener(btnClick);
        getActivity().findViewById(R.id.button_answer2_part1).setOnClickListener(btnClick);
        getActivity().findViewById(R.id.button_answer3_part1).setOnClickListener(btnClick);
        getActivity().findViewById(R.id.button_answer4_part1).setOnClickListener(btnClick);
        Log.e("MIIIIIIIII" , "ONSTART__1");


    }



    private View.OnClickListener btnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String str = "TEXT + ";
            switch (view.getId()) {
                case R.id.button_answer1_part1:
                    str += "But1 + part1";
                    break;
                case R.id.button_answer2_part1:
                    str += "But2 + part1";
                    break;
                case R.id.button_answer3_part1:
                    str += "But3 + part1";
                    break;
                case R.id.button_answer4_part1:
                    str += "But4 + part1";
                    break;
            }
            TextView textView = getActivity().findViewById(R.id.textViewTitle);
               textView.setText(str);

            Log.e("MIIIIIIIII" , "Button 1" );
        }

    };


}
