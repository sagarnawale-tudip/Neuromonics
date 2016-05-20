package com.neuromonics;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by root on 11/5/16.
 */
public class EditAudiogramInformationActivity extends Activity {
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information);
        TextView txtView = (TextView) findViewById(R.id.mainInformation);
        txtView.setText("\nManually Edit Audiogram Instructions:\nIf you have access to your audiogram, please enter it in the table.Select each cell for Right and Left ears for each frequency then enter the dB (decibel) level from your audiogram.Move the thumbwheel until the proper value updates in the table. A level for each frequency must be entered");
    }

    public void myClickMethod(View view){
        super.onBackPressed();
        overridePendingTransition(R.anim.bottom_up,R.anim.bottom_down);
    }

}
