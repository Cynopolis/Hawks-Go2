package com.schools.robbinsdale.hawksgo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button schoology = findViewById(R.id.schoology);
        schoology.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });
    }
}
