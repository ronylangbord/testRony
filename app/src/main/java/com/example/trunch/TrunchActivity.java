package com.example.trunch;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by or on 4/3/2015.
 */
public class TrunchActivity extends Activity {


    //=========================================
    //				Constants
    //=========================================



    //=========================================
    //				Fields
    //=========================================
    ImageView mMatchScreen;
    TextView mTopText;
    Typeface robotoFont;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.its_a_trunch);

        //mMatchScreen = (ImageView) findViewById(R.id.matchScreen);
        mTopText = (TextView) findViewById(R.id.meet_your_trunchers);
        String restName = getIntent().getStringExtra("restName");
        String trunchers = getIntent().getStringExtra("trunchers");
        showTrunchDialog(trunchers,restName);

        //setting up the font for the text views
        robotoFont  = Typeface.createFromAsset(getAssets(), "Roboto-Regular.ttf");
        mTopText.setTypeface(robotoFont);

    }

    public void showTrunchDialog(String trunchers,String restaurant) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Trunch!");
        builder.setMessage("You are having lunch with: " + trunchers + "at "+ restaurant );
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
       // getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
}
