package com.myfirstproj.zachs.bottomnavigationview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DictionaryScroll extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //create the scrolling activity and textboxes
        setContentView(R.layout.activity_dictionary_scroll);
        TextView mTitleWindow = findViewById(R.id.titleWindow);
        TextView mMessageWindow = findViewById(R.id.messageWindow);
        //information that goes into the scrolling dictionary
        mMessageWindow.setText(R.string.large_actual_text);
    }
}
