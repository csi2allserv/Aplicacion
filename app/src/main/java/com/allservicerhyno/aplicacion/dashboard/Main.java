package com.allservicerhyno.aplicacion.dashboard;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.allservicerhyno.aplicacion.R;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class Main extends AppCompatActivity {

    ChipNavigationBar chipNavigationbar;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.main);

        chipNavigationbar = findViewById(R.id.bottom_nav_menu);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Menu_Principal()).commit();
        bottomMenu();
    }

    private void bottomMenu() {

        chipNavigationbar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                switch (i) {
                    case R.id.main:
                        fragment = new Menu_Principal();
                        break;

                    case R.id.account:
                        fragment = new Account();
                        break;

                    case R.id.notification:
                        fragment = new Notification();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
            }
        });


    }
}
