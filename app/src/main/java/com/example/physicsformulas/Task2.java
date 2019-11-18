package com.example.physicsformulas;


import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;


public class Task2 extends Fragment {

    Handler handler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_task2, null);
        InitializeComponent(v);
        handler = new Handler();
        return v;
    }

    Thread thread;

    private void InitializeComponent(View v) {

        final Button buttonReset = v.findViewById(R.id.button2Task2);
        final Button buttonStart = v.findViewById(R.id.button1Task2);
        final TextView textViewExample = v.findViewById(R.id.textView_task2_example);
        final TextView textViewCounter = v.findViewById(R.id.textView_task2_counter);
        final TextView textViewTimer = v.findViewById(R.id.textView_task2_timer);

        final ProgressBar pb = v.findViewById(R.id.progressBar_task2_timer);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.closeThread = true;
                MainActivity.formulaLogic.logicTask2.Reset();

            }
        });
        buttonReset.setVisibility(View.INVISIBLE);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonStart.setVisibility(View.INVISIBLE);
                MainActivity.formulaLogic.logicTask2.Start();
                buttonReset.setVisibility(View.VISIBLE);
                MainActivity.closeThread = false;


                thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 10; i++) {
                            if (MainActivity.closeThread) return;

                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    textViewCounter.setText("[ " + ((MainActivity.formulaLogic.logicTask2.numCurrentFormula) + 1) + "  |  10 ]");
                                    textViewExample.setText(MainActivity.formulaLogic.logicTask2.GetCurrentQuestionFormula().name);
                                }
                            });

                            long startClock = System.currentTimeMillis();
                            int time = 0;

                            while (System.currentTimeMillis() - (startClock + 15500) < 0) {
                                if (MainActivity.closeThread) return;
                                time = (int) (15 - (System.currentTimeMillis() - startClock) / 1000);
                                final int progress = (int) ((float) (1000 - (System.currentTimeMillis() - startClock) * 1000 / 15000));
                                final int intText = time < 0 ? 0 : time;

                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        pb.setProgress(progress);
                                        textViewTimer.setText(Integer.toString(intText));
                                    }
                                });
                                try {
                                    thread.sleep(15);
                                } catch (Exception e) {
                                }
                            }
                            MainActivity.formulaLogic.logicTask2.numCurrentFormula++;
                        }
                        try {
                            thread.sleep(700);
                        } catch (Exception e) {
                        }
                        MainActivity.formulaLogic.logicTask2.ShowAnswer();
                    }
                });
                thread.start();
            }
        });

    }
}
