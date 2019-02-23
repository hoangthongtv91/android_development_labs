package com.mobile.thongnguyen.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView scoreText1;
    private TextView scoreText2;
    public int score1;
    public int score2;
    static final String SCORE_TEAM_1 = "Team 1 score";
    static final String SCORE_TEAM_2 = "Team 2 score";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scoreText1 = findViewById(R.id.score_1);
        scoreText2 = findViewById(R.id.score_2);

        if (savedInstanceState != null){
            int score1 = savedInstanceState.getInt(SCORE_TEAM_1);
            int score2 = savedInstanceState.getInt(SCORE_TEAM_2);

            scoreText1.setText(Integer.toString(score1));
            scoreText2.setText(Integer.toString(score2));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if (nightMode == AppCompatDelegate.MODE_NIGHT_NO)
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        else
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.night_mode){
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            else
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            recreate();
        }
        return super.onOptionsItemSelected(item);
    }


    public void decreasePoint(View view) {
        if (view.getId() == R.id.decreaseTeam1){
            score1 -=1;
            scoreText1.setText(Integer.toString(score1));
        }
        else {
            score2--;
            scoreText2.setText(String.valueOf(score2));
        }
    }

    public void increasePoint(View view) {
        if (view.getId() == R.id.increaseTeam1){
            score1++;
            scoreText1.setText(Integer.toString(score1));
        }
        else{
            score2++;
            scoreText2.setText(Integer.toString(score2));
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(SCORE_TEAM_1, score1);
        outState.putInt(SCORE_TEAM_2, score2);
        super.onSaveInstanceState(outState);
    }

    
}
