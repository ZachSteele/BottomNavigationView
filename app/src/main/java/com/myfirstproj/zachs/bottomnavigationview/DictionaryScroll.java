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
        mMessageWindow.setText("ACCELERATION" + "\n the rate of change in velocity with respect to time."
                + "\nDISPLACEMENT" + "\n distance from the objects original position." + "\nDISTANCE"
                + "\nChange in position from the last location." +
                "\n \n \n \n \n \n \nIcons made by https://www.flaticon.com/authors/smashicons. from https://www.flaticon.com/" +
                "\nwww.flaticon.com is licensed by http://creativecommons.org/licenses/by/3.0/"
                + "\n \nIcons made by www.flaticon.com/authors/freepik"
                +
                "\nwww.flaticon.com is licensed by http://creativecommons.org/licenses/by/3.0/"
                + "\n \n Icons made by https://www.flaticon.com/authors/freepik"
                +
                "\nwww.flaticon.com is licensed by http://creativecommons.org/licenses/by/3.0/"
                + "\n\n Icons made by https://www.flaticon.com/authors/eucalyp"
                +
                "\nwww.flaticon.com is licensed by http://creativecommons.org/licenses/by/3.0/"
                + "\n\nLauncher icon made by Just UI at https://www.iconfinder.com licensed by http://creativecommons.org/licenses/by/3.0/");
    }
}
