package com.mobile.thongnguyen.checkbox;

import android.net.wifi.hotspot2.pps.Credential;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private CheckBox chocolateSyrup;
    private CheckBox sprinkles;
    private CheckBox crushedNuts;
    private CheckBox cherries;
    private CheckBox orioCookieCrumbles;
    private String message = "";
    List<CheckBox> checkBoxes = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chocolateSyrup = findViewById(R.id.chololate_syrup);
        sprinkles = findViewById(R.id.sprinkles);
        crushedNuts = findViewById(R.id.crushed_nuts);
        cherries = findViewById(R.id.cherries);
        orioCookieCrumbles = findViewById(R.id.orio_cookie_crumbles);

        checkBoxes.add(chocolateSyrup);
        checkBoxes.add(sprinkles);
        checkBoxes.add(crushedNuts);
        checkBoxes.add(cherries);
        checkBoxes.add(orioCookieCrumbles);

    }

    public void boxChecked(View view) {

    }

    public void showToast(View view) {

        for (CheckBox item : checkBoxes)
            if (item.isChecked())
                message += " " + item.getText().toString();

        if (!message.equals("")) {
            Toast.makeText(this,"Toppings: " + message, Toast.LENGTH_SHORT).show();
            message = "";
        }

    }
}
