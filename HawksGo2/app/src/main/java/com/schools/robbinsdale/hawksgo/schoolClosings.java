package com.schools.robbinsdale.hawksgo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

public class schoolClosings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_closings);

        backButton();
        TextView open_status = (TextView) this.findViewById(R.id.openStatus);

       // WebScraper scraper = new WebScraper();
        String title = "No title found";
        /*try {
            title = scraper.scrapeSite();
        }
        catch (IOException e){
            title = e.getMessage();
        }
        open_status.setText(title);*/
    }

    private void backButton(){

        final Button schoolClosed = findViewById(R.id.backButton);
        schoolClosed.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(schoolClosings.this, MainActivity.class));
            }
        });
    }
}
