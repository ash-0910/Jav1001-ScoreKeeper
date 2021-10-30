package com.ashishsurti.jav1001_scorekeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {

    //declared variables
    private int numPoints = 0 ;
    private int totalpointsA = 0;
    private int totalpointsB = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //set floating action button views
        FloatingActionButton teamAplus = findViewById(R.id.fbplusteama);
        FloatingActionButton teamBplus = findViewById(R.id.fbplusteamb);
        FloatingActionButton teamAminus = findViewById(R.id.fbminusteama);
        FloatingActionButton teamBminus = findViewById(R.id.fbminusteamb);

        //set the onclicklistener for each views
        teamAplus.setOnClickListener(this);
        teamBplus.setOnClickListener(this);
        teamAminus.setOnClickListener(this);
        teamBminus.setOnClickListener(this);

        //set the minus buttons as false
        teamAminus.setEnabled(false);
        teamBminus.setEnabled(false);


    }


    @Override
    public void onClick(View v) {


        //set the team score views
        TextView teamAscore = findViewById(R.id.teamascore);
        TextView teamBscore = findViewById(R.id.teambscore);
        FloatingActionButton teamAminus = findViewById(R.id.fbminusteama);
        FloatingActionButton teamBminus = findViewById(R.id.fbminusteamb);

        //using switch case to check for which buttons are clicked
        switch (v.getId()){
            //checking team A plus button
            case R.id.fbplusteama:

                //calling the radio button checking method
                rbCheck();
                //adding the points to the variable for team A
                totalpointsA += numPoints;

                if(totalpointsA > 0){
                    //setting the minus button true if the points are greater than 0
                    teamAminus.setEnabled(true);
                }
                //setting the team A score with the added points
                teamAscore.setText(String.valueOf(totalpointsA));
                break;

            //checking team B plus button
            case R.id.fbplusteamb:
                rbCheck();
                //adding the points to the variable for team B
                totalpointsB += numPoints;
                if(totalpointsB > 0){
                    //setting the minus button true if the points are greater than 0
                    teamBminus.setEnabled(true);
                }
                //setting the team A score with the added points
                teamBscore.setText(String.valueOf(totalpointsB));
                break;
            //checking team A minus button
            case R.id.fbminusteama:
                rbCheck();
                //subtracting the points to the variable for team A
                totalpointsA -= numPoints;
                if(totalpointsA<=0){
                    //setting the minus button false if the points are less than 0 and setting the total to 0
                    totalpointsA = 0;
                    teamAminus.setEnabled(false);
                }

                teamAscore.setText(String.valueOf(totalpointsA));
                break;
            //checking team B minus button
            case R.id.fbminusteamb:
                rbCheck();
                //subtracting the points to the variable for team B
                totalpointsB -= numPoints;
                if(totalpointsB<=0){
                    //setting the minus button false if the points are less than 0 and setting the total to 0
                    totalpointsB = 0;
                    teamBminus.setEnabled(false);
                }
                teamBscore.setText(String.valueOf(totalpointsB));
                break;

        }

    }

    //checking which radio button is clicked
    public void rbCheck(){
        RadioGroup pointsgroup = findViewById(R.id.pointsgroup);

        int checkedPoints = pointsgroup.getCheckedRadioButtonId();

        if(checkedPoints == R.id.rb1point){
            numPoints = 1;
        }
        else if(checkedPoints == R.id.rb2points){
            numPoints = 2;
        }
        else if(checkedPoints == R.id.rb3points){
            numPoints = 3;
        }
        else if(checkedPoints == R.id.rb6points){
            numPoints = 6;
        }
    }


}