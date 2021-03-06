package com.myfirstproj.zachs.bottomnavigationview;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView mMainNav;
    private HomeFragment homeFragment;
    private CalculatorFragment calculatorFragment;
    private KinematicsFragment kinematicsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FrameLayout mMainFrame = (FrameLayout) findViewById(R.id.main_frame);
        mMainNav = (BottomNavigationView) findViewById(R.id.main_nav);
        homeFragment = new HomeFragment();
        calculatorFragment = new CalculatorFragment();
        kinematicsFragment = new KinematicsFragment();
        setFragment(homeFragment);
        //Bottom Navigation switcher
        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        mMainNav.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(homeFragment);
                        return true;
                    case R.id.nav_calculator:
                        mMainNav.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(calculatorFragment);
                        return true;
                    case R.id.nav_kinematics:
                        mMainNav.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(kinematicsFragment);
                        return true;
                    case R.id.nav_Dictionary:
                        mMainNav.setItemBackgroundResource(R.color.colorPrimary);
                        Intent intent1 = new Intent(MainActivity.this, DictionaryScroll.class);
                        startActivity(intent1);
                        return true;
                    default:
                        return false;
                }
            }


        });
    }

    private void setFragment(android.support.v4.app.Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();
    }
}