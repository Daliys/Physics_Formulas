package com.example.physicsformulas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    public static FormulaLogic formulaLogic;

    public static String PACKAGE_NAME;
    public static boolean isInitialize = false;
    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PACKAGE_NAME = getPackageName();

        fragmentManager = getSupportFragmentManager();
        formulaLogic = new FormulaLogic(this);
        isInitialize = true;
        formulaLogic.logicTask1.Start();

        NavigationItemListener();

    }


    public void NavigationItemListener(){
        navigationView = findViewById(R.id.nav_view_main);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.menu_task1:
                        formulaLogic.logicTask1.Start();
                        break;
                    case R.id.menu_task2:
                        SwitchFragment(20);
                        formulaLogic.logicTask2.Start();
                        break;
                    case R.id.menu_wiki:
                        break;
                }

                return false;
            }
        });

    }

    public void SwitchFragment(int index) {
        fragmentTransaction = fragmentManager.beginTransaction();
Log.e("Daliys", ""+fragmentManager.getFragments().size());

        switch (index) {

            case 11:
                fragmentTransaction.replace(R.id.frame_containerMain, new Task1Part1() );
                break;
            case 12:
                fragmentTransaction.replace(R.id.frame_containerMain, new Task1Part2());
                break;
            case 20:
                fragmentTransaction.replace(R.id.frame_containerMain, new Task2());
                break;
        }

        fragmentTransaction.commit();
    }



    boolean isSwitch = true;
    public void ButtonChangeFragmentListener(View view) {
        formulaLogic.logicTask1.Start();
/*
        fragmentTransaction = fragmentManager.beginTransaction();

       // if (isSwitch) {
        //    fragmentTransaction.replace(R.id.fragment_containerMain, task1Part1);
      //  } else {
            fragmentTransaction.replace(R.id.fragment_containerMain,  task1Part2);
     //   }
      //  isSwitch = !isSwitch;
        fragmentTransaction.commit();
*/
    }

}


