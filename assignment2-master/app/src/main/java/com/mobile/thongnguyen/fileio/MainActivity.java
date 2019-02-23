package com.mobile.thongnguyen.fileio;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    private Spinner mSpinner;
    private TextView mTextView;
    private ImageView mImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSpinner = findViewById(R.id.movies_spinner);
        mTextView = findViewById(R.id.text_view);
        mImage = findViewById(R.id.image_view);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.movies, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(adapter);

        final List<String> list = new ArrayList<>();
        list.add("catch_me_if_you_can");
        list.add("flight_club");
        list.add("forrest_gump");
        list.add("good_will_hunting");
        list.add("pulp_fiction");
        list.add("god_father");
        list.add("the_hangover");
        list.add("the_shaw_shank_redemption");
        list.add("titanic");

        final List<String> textList = new ArrayList<>();
        textList.add("catch_me_if_you_can");
        textList.add("flight_club");
        textList.add("forrest_gump");
        textList.add("good_will_hunting");
        textList.add("pulp_fiction");
        textList.add("the_godfather");
        textList.add("the_hangover");
        textList.add("the_shawshank_redemption");
        textList.add("titanic");
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mImage.setImageResource(getResources().getIdentifier(list.get(position), "drawable", getPackageName()));
                Scanner in = new Scanner(getResources().openRawResource(getResources().getIdentifier(textList.get(position), "raw", getPackageName())));
                String result = "";
                while (in.hasNext())
                    result += in.nextLine();
                in.close();
                mTextView.setText(result);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}

//        // Setting image -> ImageView
//        ImageView imgView = new ImageView(this);
//        imgView.setImageResource(R.drawable.catch_me_if_you_can);

        // "the_godfather" -> R.raw.the_godfather
//        int id = getResources()
//                .getIdentifier("the_godfather", "raw", getPackageName());
//
//        String result = ""; // text data
//        Scanner in = new Scanner(getResources().openRawResource(id));
////        Scanner in = new Scanner(getResources().openRawResource(R.raw.the_godfather));
//        while (in.hasNext()) {
//            result += in.nextLine();
//        }
//        in.close();
//        // TextView <- result (text data)




//    private int getIdForDrawable(String drawableName){
//        return getResources().getIdentifier(drawableName, "drawable", getPackageName());
////        return the id
//    }

