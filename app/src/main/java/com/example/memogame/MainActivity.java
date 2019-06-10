package com.example.memogame;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Chronometer;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private GridView mGrid;
    private GridAdapter mAdapter;

    private TextView mStepScreen;
    private Chronometer mTimeScreen;

    private  Integer StepCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGrid = (GridView)findViewById(R.id.field);
        mGrid.setNumColumns(6);
        mGrid.setEnabled(true);

        mAdapter = new GridAdapter(this, 6,6);
        mGrid.setAdapter(mAdapter);

        mTimeScreen = (Chronometer)findViewById(R.id.timeview);
        mStepScreen = (TextView)findViewById(R.id.stepview);

        Typeface type = Typeface.createFromAsset(getAssets(),"my-font.ttf");
        mTimeScreen.setTypeface(type);
        mStepScreen.setTypeface(type);

        StepCount = 0;
        mStepScreen.setText(StepCount.toString());

        mTimeScreen.start();

        mGrid.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id){
                mAdapter.checkOpenCells();
                mAdapter.openCell(position);

                StepCount++;
                mStepScreen.setText(StepCount.toString());

                if (mAdapter.checkGameOver()){

                    mTimeScreen.stop();
                    String time = mTimeScreen.getText().toString();
                    String TextToast = "You win! /nMade moves: " +
                            StepCount.toString() + "/nTime: " + time;
                    Toast.makeText(getApplicationContext(),
                            TextToast,
                            Toast.LENGTH_LONG).show();

                }
            }
        });
    }
}
