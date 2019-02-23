package com.mobile.thongnguyen.shoppinglist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ItemActivity extends AppCompatActivity {
    private Button mApplesButton;
    private Button mCheeseButton;
    private Button mRiceButton;
    private Button mChocolatesButton;
    private Button mMilkButton;
    private Button mGrapesButton;
    private Button mButterButton;
    private Button mBeefButton;
    private Button mPorkButton;
    public static final String EXTRA_REPLY = "extra_REPLY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        mApplesButton = findViewById(R.id.apples_button);
        mCheeseButton = findViewById(R.id.cheese_button);
        mRiceButton = findViewById(R.id.rice_button);
        mChocolatesButton = findViewById(R.id.chocolates_button);
        mMilkButton = findViewById(R.id.milk_button);
        mGrapesButton = findViewById(R.id.grapes_button);
        mButterButton = findViewById(R.id.butter_button);
        mBeefButton = findViewById(R.id.beef_button);
        mPorkButton = findViewById(R.id.pork_button);
    }

    public void applesPick(View view) {
        String apples = mApplesButton.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, apples);
        setResult(RESULT_OK, replyIntent);
        finish();
    }

    public void cheesePick(View view) {
        String cheese = mCheeseButton.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, cheese);
        setResult(RESULT_OK, replyIntent);
        finish();
    }

    public void ricePick(View view) {
        String rice = mRiceButton.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, rice);
        setResult(RESULT_OK, replyIntent);
        finish();
    }

    public void chocolatesPick(View view) {
        String chocolates = mChocolatesButton.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, chocolates);
        setResult(RESULT_OK, replyIntent);
        finish();
    }

    public void milkPick(View view) {
        String milk = mMilkButton.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, milk);
        setResult(RESULT_OK, replyIntent);
        finish();
    }

    public void grapesPick(View view) {
        String grapes = mGrapesButton.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, grapes);
        setResult(RESULT_OK, replyIntent);
        finish();
    }

    public void butterPick(View view) {
        String butter = mButterButton.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, butter);
        setResult(RESULT_OK, replyIntent);
        finish();
    }

    public void beefPick(View view) {
        String beef = mBeefButton.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, beef);
        setResult(RESULT_OK, replyIntent);
        finish();
    }

    public void porkPick(View view) {
        String pork = mPorkButton.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, pork);
        setResult(RESULT_OK, replyIntent);
        finish();
    }


    public void BacktoMain(View view) {
        Intent replyIntent = new Intent();
        setResult(RESULT_FIRST_USER, replyIntent);
        finish();
    }
}
