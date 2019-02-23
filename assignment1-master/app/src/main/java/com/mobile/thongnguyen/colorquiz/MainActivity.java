package com.mobile.thongnguyen.colorquiz;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.*;

public class MainActivity extends AppCompatActivity {
    private int mScore = 0;
    private TextView mScoreView;
    private Button but1;
    private Button but2;
    private TextView mCorrectColour;
    public int colourKey1;
    public int colourKey2;
    public int correctColourKey;
    public int textColorKey;

    public int randomColour(int colour1, int colour2) {
        Random ran = new Random();
        int x = ran.nextInt(2);
        if (x == 0)
            return colour1;
        return colour2;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScoreView = findViewById(R.id.score_view);
        mScoreView.setText(getString(R.string.score));

        but1 = findViewById(R.id.button1);
        but2 = findViewById(R.id.button2);

        mCorrectColour = findViewById(R.id.correct_colour);


        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, ContextCompat.getColor(this, R.color.red));
        map.put(1, ContextCompat.getColor(this, R.color.blue));
        map.put(2, ContextCompat.getColor(this, R.color.green));
        map.put(3, ContextCompat.getColor(this, R.color.black));
        map.put(4, ContextCompat.getColor(this, R.color.yellow));
        map.put(5, ContextCompat.getColor(this, R.color.gray));
        map.put(6, ContextCompat.getColor(this, R.color.pink));
        map.put(7, ContextCompat.getColor(this, R.color.purple));
        map.put(8, ContextCompat.getColor(this, R.color.violet));
        map.put(9, ContextCompat.getColor(this, R.color.gold));
        map.put(10, ContextCompat.getColor(this, R.color.brown));
        map.put(11, ContextCompat.getColor(this, R.color.tan));

        List<String> list = new ArrayList<>();
        list.add("RED");
        list.add("BLUE");
        list.add("GREEN");
        list.add("BLACK");
        list.add("YELLOW");
        list.add("GRAY");
        list.add("PINK");
        list.add("PURPLE");
        list.add("VIOLET");
        list.add("GOLD");
        list.add("BROWN");
        list.add("TAN");


        Random ran = new Random();

        colourKey1 = ran.nextInt(12);
        colourKey2 = ran.nextInt(12);
        while (colourKey1 == colourKey2)
            colourKey2 = ran.nextInt(12);

        correctColourKey = randomColour(colourKey1, colourKey2);
        textColorKey = randomColour(colourKey1, colourKey2);


        but1.setBackgroundColor(map.get(colourKey1));
        but2.setBackgroundColor(map.get(colourKey2));



        mCorrectColour.setText(list.get(correctColourKey));
        mCorrectColour.setTextColor(map.get(textColorKey));



    }

    public boolean checkColour1Correct(int colourKey1, int correctColourKey) {
        if (colourKey1 == correctColourKey)
            return true;
        return false;
    }

    public void colourPick1(View view) {
        if (checkColour1Correct(colourKey1, correctColourKey) == true) {
            showToast(mScoreView, "Correct!");
            mScore++;
            mScoreView.setText("Score: " + (Integer.toString(mScore)));
        } else {
            showToast(mScoreView, "Wrong!");
            mScore--;
            mScoreView.setText("Score: " + (Integer.toString(mScore)));
        }
        reCreate();

    }

    public void colourPick2(View view) {
        if (checkColour1Correct(colourKey1, correctColourKey) == false) {
            showToast(mScoreView, "Correct!");
            mScore++;
            mScoreView.setText("Score: " + (Integer.toString(mScore)));
        } else {
            showToast(mScoreView, "Wrong!");
            mScore--;
            mScoreView.setText("Score: " + (Integer.toString(mScore)));
        }
        reCreate();

    }

    public void showToast(View view, String x) {
        Toast toast = Toast.makeText(this, x, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void reCreate() {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, ContextCompat.getColor(this, R.color.red));
        map.put(1, ContextCompat.getColor(this, R.color.blue));
        map.put(2, ContextCompat.getColor(this, R.color.green));
        map.put(3, ContextCompat.getColor(this, R.color.black));
        map.put(4, ContextCompat.getColor(this, R.color.yellow));
        map.put(5, ContextCompat.getColor(this, R.color.gray));
        map.put(6, ContextCompat.getColor(this, R.color.pink));
        map.put(7, ContextCompat.getColor(this, R.color.purple));
        map.put(8, ContextCompat.getColor(this, R.color.violet));
        map.put(9, ContextCompat.getColor(this, R.color.gold));
        map.put(10, ContextCompat.getColor(this, R.color.brown));
        map.put(11, ContextCompat.getColor(this, R.color.tan));

        List<String> list = new ArrayList<>();
        list.add("RED");
        list.add("BLUE");
        list.add("GREEN");
        list.add("BLACK");
        list.add("YELLOW");
        list.add("GRAY");
        list.add("PINK");
        list.add("PURPLE");
        list.add("VIOLET");
        list.add("GOLD");
        list.add("BROWN");
        list.add("TAN");

        Random ran = new Random();

        colourKey1 = ran.nextInt(12);
        colourKey2 = ran.nextInt(12);
        while (colourKey1 == colourKey2)
            colourKey2 = ran.nextInt(12);

        correctColourKey = randomColour(colourKey1, colourKey2);
        textColorKey = randomColour(colourKey1, colourKey2);


        but1.setBackgroundColor(map.get(colourKey1));
        but2.setBackgroundColor(map.get(colourKey2));



        mCorrectColour.setText(list.get(correctColourKey));
        mCorrectColour.setTextColor(map.get(textColorKey));
    }
}
