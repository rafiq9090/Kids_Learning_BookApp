package com.teamalfa.kidslearningapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.teamalfa.kidslearningapp.adapter.Dashboardlistadapter;

public class DashboardActivity extends AppCompatActivity {

    GridView gridDeshboard;

    NavigationView navigationView;
    DrawerLayout drawerLayout;

    int[] itemImage = {R.drawable.bangla_,R.drawable.englis,R.drawable.math
            ,R.drawable.arabic,R.drawable.doa,R.drawable.national_anthim};
    String[] itemDash;
    FloatingActionButton draPaint;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        navigationView = findViewById(R.id.navigation);
        drawerLayout = findViewById(R.id.drawerlayout);

//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
//        drawerLayout.addDrawerListener(toggle);
//        toggle.syncState();
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#065A09"));
        assert actionBar != null;
        actionBar.setBackgroundDrawable(colorDrawable);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.d_company:
                        startActivity(new Intent(DashboardActivity.this,CompanayActivity.class));
                        break;
                    case R.id.d_developer:
                        startActivity(new Intent(DashboardActivity.this,DeveloperActivity.class));
                        break;
                    case R.id.d_exit:
                        finish();
                        break;
                }
//                if (drawerLayout.isDrawerOpen(GravityCompat.START)){
//                    drawerLayout.closeDrawer(GravityCompat.START);
//                }

                return true;
            }
        });


      //  getSupportActionBar().hide();

        SplashActivity.TextToSpechHelper textToSpechHelper = new SplashActivity.TextToSpechHelper(DashboardActivity.this);
        textToSpechHelper.speeak("আস্সালামুআলাইকুম স্বাগতম আমাদের বাচ্চএদর মজার ছলে শিক্ষা এপে");


        gridDeshboard = findViewById(R.id.list_item);

        itemDash = getResources().getStringArray(R.array.item_Dash);
        Dashboardlistadapter dashboardlistadapter =new Dashboardlistadapter(itemDash,itemImage,DashboardActivity.this);
        gridDeshboard.setAdapter(dashboardlistadapter);

        gridDeshboard.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        startActivity(new Intent(DashboardActivity.this,BanglaActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(DashboardActivity.this,EnglishSubjectActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(DashboardActivity.this, MathSubjectActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(DashboardActivity.this,ArabicSubjectActivity.class));
                        break;
                    case 4:
                        startActivity(new Intent(DashboardActivity.this,DoaActivity.class));
                        break;
                    case 5:
                            startActivity(new Intent(DashboardActivity.this,AllAlphabetHandWritingActivity.class));
                        break;
                }
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.Home:

                return true;
            case R.id.Company:
                startActivity(new Intent(DashboardActivity.this,CompanayActivity.class));
                break;
            case R.id.Developer:
                startActivity(new Intent(DashboardActivity.this,DeveloperActivity.class));
                 break;
            case R.id.Share:
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String shareBody = "This app amazing for kids learning purpose. You can try for your kids :- \n";
                String shareSubject = "Kids learning App.";
                String shareTitle ="Kids learning App.";
                String shareUrl ="https://play.google.com/store/apps/details?id="+getApplicationContext().getPackageName();
                intent.putExtra(Intent.EXTRA_TITLE,shareTitle);
                intent.putExtra(Intent.EXTRA_SUBJECT,shareSubject);
                intent.putExtra(Intent.EXTRA_TEXT,shareBody+shareUrl);
                startActivity(Intent.createChooser(intent,"Share using."));
                break;
            case R.id.About:
                 startActivity(new Intent(DashboardActivity.this,AboutActivity.class));
        }


        return super.onOptionsItemSelected(item);
    }

//    @Override
//    public void onBackPressed() {
//        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
//            drawerLayout.closeDrawer(GravityCompat.START);
//        }
//        else {
//            super.onBackPressed();
//
//        }
//
//    }


}