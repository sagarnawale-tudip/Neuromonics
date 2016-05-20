package com.neuromonics;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by root on 11/5/16.
 */
public class CustomizeInformationActivity extends Activity {
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information);
        TextView txtView = (TextView) findViewById(R.id.mainInformation);
        txtView.setText("\nInstructions for Customize Screen:\nThe customize screen allows fine tuning of the frequency response of the profile and adjustments to the background neural stimulus. Background neural stimulus is added to the music to increase the sound energy around the tinnitus pitch and provide a stimulus to the brain to overcome the ringing in the ears. It should be barely noticeable and is an important part of blending with the tinnitus.\n\nAdjusting neural stimulus: By default the background neural stimulus is ON with a level of 0. Level 0 has been determined to be the normal level for most users. If your tinnitus is not easily blending with the music you can increase the background neural stimulus by clicking on +2, +8 etc. Click on the -2, -8 etc. to decrease the volume. Click on the toggle button to turn the background neural stimulus completely off. The level of the background neural stimulus is a personal preference, but remember the goal of the Neuromonics program is to adjust the therapy signal so that the tinnitus is just audible through the music. Sometimes it is difficult to hear the background neural stimulus. If this is the case, try going to the beginning of tracks 3 or 4 as the music starts out at a very low level and it is easier to hear the background neural stimulus.\n\nAdjusting the frequency response. The frequency response is adjusted based on an individual’s hearing profile, or in other words their audiogram. Most people that have high frequency tinnitus have some level of hearing loss, especially in the high frequencies. Neuromonics takes advantage of this connection by using the person’s hearing profile which is a much more stable measure than trying to match each person’s exact tinnitus pitch.\n\nThere are 2 ways to adjust the audiogram, which will automatically adjust the frequency response. If you have access to your personal audiogram, select “Edit Audiogram” and enter the values. If you do not have personal audiogram results, select “Hearing Test” to take a built in hearing level test. This test is similar to an audiogram test taken in a sound booth. The main difference is the absolute hearing level will likely be different, but the difference between frequencies, or the shape of the audiogram should be the same. Since you are able to adjust the volume level to your preference, only the shape of the audiogram is important. Please refer to further instructions on the “Hearing Test” and “Edit Audiogram” screens.");
    }

    public void myClickMethod(View view){
        super.onBackPressed();
        overridePendingTransition(R.anim.bottom_up,R.anim.bottom_down);
    }

}
