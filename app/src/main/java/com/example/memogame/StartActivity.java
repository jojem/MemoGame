package com.example.memogame;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StartActivity extends AppCompatActivity {
    Button mStart;
    Button mExit;

    TextView titleN;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        titleN = (TextView)findViewById(R.id.titleName);
        Typeface type = Typeface.createFromAsset(getAssets(),"my-font.ttf");
        titleN.setTypeface(type);

        mStart = (Button)findViewById(R.id.btnStart);
        mExit = (Button)findViewById(R.id.btnExit);

        mStart.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGame();
            }
        });

        mExit.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void startGame () {
        Intent i = new Intent(this, MainActivity.class);
        startActivity (i);
    }

    public void SettingsClick (View view)
    {
        Intent settings = new Intent(getApplicationContext(),Settings.class);
        startActivity(settings);
    }

    public void RecordsClick (View view)
    {
        Intent records = new Intent(this, Records.class);
        startActivity (records);
    }


    public void ExitClick (View view)
    {
        finish();
    }
}

