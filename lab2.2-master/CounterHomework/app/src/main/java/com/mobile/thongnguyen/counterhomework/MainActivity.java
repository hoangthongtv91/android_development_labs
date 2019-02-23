package com.mobile.thongnguyen.counterhomework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mCounter;
    private Button mButton;
    private EditText mEditText;
    public int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCounter = findViewById(R.id.counter);
        mButton = findViewById(R.id.count_button);
        mEditText = findViewById(R.id.edit_text);

        mCounter.setText("0");

        if (savedInstanceState != null){
            mCounter.setText(savedInstanceState.getString("counter"));
            mEditText.setText(savedInstanceState.getString("edit_TEXT"));
        }

    }

    public void countIncrement(View view) {
        count++;
        mCounter.setText(Integer.toString(count));

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("counter", mCounter.getText().toString());
        outState.putString("edit_TEXT", mEditText.getText().toString());
    }
}
