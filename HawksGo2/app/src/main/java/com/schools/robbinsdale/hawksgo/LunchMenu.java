package com.schools.robbinsdale.hawksgo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;

public class LunchMenu extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch_menu);
        //creates  aback button to the main page
        backButton();
        //creates a textview object to edit the text in the grill line
        TextView grill_line = (TextView) this.findViewById(R.id.grillLine);

        //sets the text for the grill line
        grill_line.setText(htmlParser());

    }

    private void backButton(){

        final Button goBack = findViewById(R.id.backButton);
        goBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(LunchMenu.this, MainActivity.class));
            }
        });
    }

    //when this class is complete, it should return an String array containing the lunch menu
    //right now it just returns the title of the HTML document
    private String htmlParser(){
        Document info = null;
        try {
            //gets html document from lunch site's page
            info = new AsyncCaller().execute(getURL()).get();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (ExecutionException e) {
            e.printStackTrace();
        }
        //create a date format, and new date object, and format it to return the day number
        String dayNum = new SimpleDateFormat("dd").format(new Date());

        Elements element = info.select("li[class = day]");
        //element = element.select("contains(dayNum)");
        Log.i("debug", info.text());
        return info.title();
    }

    //gets the current date and formats that into a URL to access the cooper menu, then returns that url
    private String getURL(){

        //create a date format
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

        //create a new date object
        Date date = new Date();

        //creates array date holder that holds the year , month, and day
        String dateHolder[] = dateFormat.format(date).split("/");

        //formats url with current date
        String url = String.format("https://rdale.nutrislice.com/menu/cooper/main-line/%s-%s-%s", dateHolder[0], dateHolder[1], dateHolder[2]);
        return url;
    }
}
