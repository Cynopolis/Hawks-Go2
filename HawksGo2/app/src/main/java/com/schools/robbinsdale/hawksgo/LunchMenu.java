package com.schools.robbinsdale.hawksgo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;

public class LunchMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch_menu);

        backButton();
        TextView open_status = (TextView) this.findViewById(R.id.grillLine);
        //String title = htmlParser("https://rdale.nutrislice.com/menu/cooper/main-line/2018-05-30");
        open_status.setText(getDateTime());

    }

    private void backButton(){

        final Button goBack = findViewById(R.id.backButton);
        goBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(LunchMenu.this, MainActivity.class));
            }
        });
    }

    private String htmlParser(String url){
        Document info = null;
        try {
            info = new AsyncCaller().execute(url).get();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (ExecutionException e) {
            e.printStackTrace();
        }
        Elements test = info.getElementsByClass("day");

        return info.title();
    }

    private String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
