package com.example.physicsformulas;


import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.os.Handler;
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


    private void InitializeComponent(View v) {

        Button but = v.findViewById(R.id.button2Task2);
        Button but2 = v.findViewById(R.id.button1Task2);
        final TextView textViewTimer = v.findViewById(R.id.textView_task2_timer);
        final ProgressBar pb = v.findViewById(R.id.progressBar_task2_timer);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pb.setProgress(pb.getProgress() + 5);
            }
        });

        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pb.setProgress(pb.getProgress() - 5);

                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        long startClock = System.currentTimeMillis();
                        int i = 0;
                        while (System.currentTimeMillis() - (startClock + 16000) < 0) {
                            i = (int) (15 - (System.currentTimeMillis() - startClock) / 1000);
                            final int progress = (int) ((float) (100 - (System.currentTimeMillis() - startClock) * 100 / 15000));
                            final int intText = i < 0 ? 0 : i;

                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    pb.setProgress(progress);
                                    textViewTimer.setText(Integer.toString(intText));
                                }
                            });

                            try {
                                Thread.sleep(10);
                            } catch (Exception e) {
                            }
                        }
                    }
                });
                thread.start();
            }
        });

    }
}
