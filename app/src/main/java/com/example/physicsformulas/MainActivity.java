package com.example.physicsformulas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;
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
    public static boolean closeThread = false;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PACKAGE_NAME = getPackageName();

        fragmentManager = getSupportFragmentManager();
        formulaLogic = new FormulaLogic(this);
        isInitialize = true;
        formulaLogic.logicTask1.Start();

        drawerLayout = findViewById(R.id.DrawelLayout);
        NavigationItemListener();

    }


    public void NavigationItemListener(){
        navigationView = findViewById(R.id.nav_view_main);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.menu_task1:
                        formulaLogic.logicTask1.ResetCounters();
                        formulaLogic.logicTask1.Start();
                        SetVisibleMenuLayouts(true);
                        break;
                    case R.id.menu_task2:
                        SwitchFragment(20);
                        formulaLogic.logicTask2.Start();
                        SetVisibleMenuLayouts(false);
                        formulaLogic.logicTask1.ResetCounters();
                        break;
                    case R.id.menu_wiki:
                        formulaLogic.numCreatedWikiFormulas = 0;
                        SwitchFragment(30);
                        SetVisibleMenuLayouts(false);
                        formulaLogic.logicTask1.ResetCounters();
                        break;
                }
                drawerLayout.closeDrawer(navigationView);

                return false;
            }
        });

    }

    public void SwitchFragment(int index) {
        closeThread = true;
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
                case 21:
                fragmentTransaction.replace(R.id.frame_containerMain, new Task2Answers());

                break;
            case 30:
                fragmentTransaction.replace(R.id.frame_containerMain, new Wiki());

                break;
        }

        fragmentTransaction.commit();
    }

    public void SetVisibleMenuLayouts(boolean isVisible){
        ConstraintLayout menu1 = findViewById(R.id.menuLayout1);
        ConstraintLayout menu2 = findViewById(R.id.menuLayout2);
        if(isVisible){
            menu1.setVisibility(View.VISIBLE);
            menu2.setVisibility(View.VISIBLE);
        }else {
            menu1.setVisibility(View.INVISIBLE);
            menu2.setVisibility(View.INVISIBLE);
        }
    }


    boolean isSwitch = true;
    public void ButtonChangeFragmentListener(View view) {
        drawerLayout.openDrawer(navigationView);
    }

}


