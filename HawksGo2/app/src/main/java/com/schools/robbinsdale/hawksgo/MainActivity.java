package com.schools.robbinsdale.hawksgo;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

//main: the code starts here
public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configureClosedSchools();
        configureCalendarEvents();
        openSchoology();
        getGrades();
        getLunchMenu();

    }

    private void configureClosedSchools(){

        final Button schoolClosed = findViewById(R.id.schoolClosing);
        schoolClosed.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, schoolClosings.class));
            }
        });
    }

    private void configureCalendarEvents(){

        final Button openCalendar = findViewById(R.id.calendar);
        openCalendar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Calendar.class));
            }
        });
    }

    private void openSchoology(){

        final Button schoologyButton = findViewById(R.id.schoology);
        schoologyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String url = "http://learn.rdale.org/grades/grades";
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.setPackage("com.android.chrome");
                try {
                    startActivity(i);
                } catch (Exception e) {
                    // Chrome is probably not installed
                    // Try with the default browser
                    i.setPackage(null);
                    startActivity(i);
                }

            }
        });
    }

    private void getGrades(){

        final Button schoologyButton = findViewById(R.id.infiniteCampus);
        schoologyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String url = "https://campus.rdale.org/campus/portal/main.xsl";
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.setPackage("com.android.chrome");
                try {
                    startActivity(i);
                } catch (Exception e) {
                    // Chrome is probably not installed
                    // Try with the default browser
                    i.setPackage(null);
                    startActivity(i);
                }

            }
        });
    }

    private void getLunchMenu(){

        final Button lunchMenu = findViewById(R.id.menu);
        lunchMenu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LunchMenu.class));
            }
        });
    }
}