package com.pd.chatapp.student;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.pd.chatapp.R;
import com.pd.chatapp.student.ui.FAQFragment;
import com.pd.chatapp.student.ui.historyFragment;
import com.pd.chatapp.student.ui.homeFragment;
import com.pd.chatapp.student.ui.moreFragment;
public class startStudent extends AppCompatActivity {

//    FloatingActionButton fabAskDoubt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        int page = getIntent().getIntExtra("Page",1);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);

        bottomNav.setOnNavigationItemSelectedListener(navListener);
        //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new homeFragment()).commit();

        Fragment selectedFragment = null;

        switch (page)
        {
            case 2:
                selectedFragment = new FAQFragment();
                break;
            case 3:
                selectedFragment = new historyFragment();
                break;
            case 4:
                selectedFragment = new moreFragment();
                break;
               /* case R.id.nav_menu:
                    selectedFragment = new moreFragment();
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    break;*/
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();




//        fabAskDoubt = findViewById(R.id.fabAskQuestion);
//        fabAskDoubt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(startStudent.this, askDoubt.class));
//                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
//            }
//        });
    }


//    @Override
//    public void onBackPressed() {
//        new AlertDialog.Builder(this)
//                .setMessage("Are you sure you want to exit?")
//                .setCancelable(false)
//                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        startStudent.super.onBackPressed();
//                    }
//                })
//                .setNegativeButton("No", null)
//                .show();
//    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener  = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId())
            {
//                case R.id.nav_home:
//                    startActivity(new Intent(startStudent.this, homeActivity.class));
//                    finish();
//                    break;
                case R.id.nav_FAQ:
                    selectedFragment = new FAQFragment();
                    break;
                case R.id.nav_history:
                    selectedFragment = new historyFragment();
                    break;
                case R.id.nav_menu:
                    selectedFragment = new moreFragment();
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    break;

            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();


            return true;
        }
    };


}



