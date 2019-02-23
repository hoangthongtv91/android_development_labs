package com.mobile.thongnguyen.shoppinglist;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mItemView1;
    private TextView mItemView2;
    private TextView mItemView3;
    private TextView mItemView4;
    private TextView mItemView5;
    private TextView mItemView6;
    private TextView mItemView7;
    private TextView mItemView8;
    private TextView mItemView9;
    private TextView mItemView10;
    private Button mAddItemButton;
    public int count = 0;
    public int countItem = 0;
    public static final int ITEM_REQUEST = 1;
    private TextView mStoreEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mItemView1 = findViewById(R.id.item_view1);
        mItemView2 = findViewById(R.id.item_view2);
        mItemView3 = findViewById(R.id.item_view3);
        mItemView4 = findViewById(R.id.item_view4);
        mItemView5 = findViewById(R.id.item_view5);
        mItemView6 = findViewById(R.id.item_view6);
        mItemView7 = findViewById(R.id.item_view7);
        mItemView8 = findViewById(R.id.item_view8);
        mItemView9 = findViewById(R.id.item_view9);
        mItemView10 = findViewById(R.id.item_view10);

        mAddItemButton = findViewById(R.id.add_item_button);

        if (savedInstanceState != null){
            mItemView1.setText(savedInstanceState.getString("reply_text_1"));
            mItemView2.setText(savedInstanceState.getString("reply_text_2"));
            mItemView3.setText(savedInstanceState.getString("reply_text_3"));
            mItemView4.setText(savedInstanceState.getString("reply_text_4"));
            mItemView5.setText(savedInstanceState.getString("reply_text_5"));
            mItemView6.setText(savedInstanceState.getString("reply_text_6"));
            mItemView7.setText(savedInstanceState.getString("reply_text_7"));
            mItemView8.setText(savedInstanceState.getString("reply_text_8"));
            mItemView9.setText(savedInstanceState.getString("reply_text_9"));
            mItemView10.setText(savedInstanceState.getString("reply_text_10"));
        }

        mStoreEditText = findViewById(R.id.stote_edittext);
    }


    public void launchItemActivity(View view) {
        count++;
        Intent addIntent = new Intent(this, ItemActivity.class);
        startActivityForResult(addIntent, ITEM_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ITEM_REQUEST)
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(ItemActivity.EXTRA_REPLY);
                switch (count) {
                    case 1:
                        mItemView1.setText("1. " +reply);
                        break;
                    case 2:
                        mItemView2.setText("2. " +reply);
                        break;
                    case 3:
                        mItemView3.setText("3. " +reply);
                        break;
                    case 4:
                        mItemView4.setText("4. " +reply);
                        break;
                    case 5:
                        mItemView5.setText("5. " +reply);
                        break;
                    case 6:
                        mItemView6.setText("6. " +reply);
                        break;
                    case 7:
                        mItemView7.setText("7. " +reply);
                        break;
                    case 8:
                        mItemView8.setText("8. " +reply);
                        break;
                    case 9:
                        mItemView9.setText("9. " +reply);
                        break;
                    case 10:
                        mItemView10.setText("10. " +reply);
                        break;
                }
            }
            if (resultCode == RESULT_FIRST_USER)
                count--;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("reply_text_1", mItemView1.getText().toString());
        outState.putString("reply_text_2", mItemView2.getText().toString());
        outState.putString("reply_text_3", mItemView3.getText().toString());
        outState.putString("reply_text_4", mItemView4.getText().toString());
        outState.putString("reply_text_5", mItemView5.getText().toString());
        outState.putString("reply_text_6", mItemView6.getText().toString());
        outState.putString("reply_text_7", mItemView7.getText().toString());
        outState.putString("reply_text_8", mItemView8.getText().toString());
        outState.putString("reply_text_9", mItemView9.getText().toString());
        outState.putString("reply_text_10", mItemView10.getText().toString());
    }

    public void searchStore(View view) {
        String loc = mStoreEditText.getText().toString();
        Uri uri = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);

        if (intent.resolveActivity(getPackageManager()) != null)
            startActivity(intent);
        else
            Log.d("ImplicitIntent", "Can't handle this");
    }
}

