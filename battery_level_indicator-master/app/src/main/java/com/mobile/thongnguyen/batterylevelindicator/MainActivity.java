package com.mobile.thongnguyen.batterylevelindicator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView battery;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        battery = findViewById(R.id.imageView);
    }

    public void decreaseLevel(View view) {
        if (count > 0 && count <=6)
            count--;
        battery.setImageLevel(count);

    }

    public void increaseLevel(View view) {
        if (count >= 0 && count < 6)
            count++;
        battery.setImageLevel(count);
    }
}
