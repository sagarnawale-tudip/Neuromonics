package com.neuromonics;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by root on 11/5/16.
 */
public class HearingTestInformationActivity extends Activity {
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information);
        TextView txtView = (TextView) findViewById(R.id.mainInformation);
        txtView.setText("Hearing level test info:\nYou are now ready to start your hearing test. Please follow these steps before starting your hearing test:\n\n1. Find a quiet setting with no or minimal background noise. (example: In a bedroom with the door closed)\n\n2. Insert the earphones that you intend to listen with. If you change headphones you should retake the test because each headphone has a slightly different frequency response. These differences will be automatically taken into account during the hearing level test.\n\n3. Turn up the volume on your device to the maximum volume setting. \n\n4. Press “Start Test.”\n\n5. Tap the big red button whenever you hear a tone.\n\nGeneral information about hearing level tests:\nHearing tests are trying to determine the threshold at which you are able to hear a tone. The tones you hear will be very soft and you will likely not be able to hear any tones at all for a few seconds. The test will start out with a very soft tone and increase until you can hear it, which is when you should tap the big red button. Each ear is measured individually for each individual frequency. Once a frequency test has been completed, the test will move on to the next frequency. Once both ears and each frequency has completed, the audiogram values will automatically populate the table in the customization screen.\n\nThe absolute levels of the test are not important, only the shape is important. The absolute level is not important because you are able to adjust the volume to your preference. The relative levels are automatically used to create the best frequency response.\n\nA word on headphones. Headphones should be comfortable as we suggest listening for 2-4 hours per day. The headphones should also have a good high frequency response. Generally speaking, the more expensive the headphone, the better the high frequency response. We have seen good results with the Bose SoundTrue or SoundSport headphones. You should not use noise canceling headphones as the extra processing might interfere with the Tinnitus sound processing.");
    }

    public void myClickMethod(View view){
        super.onBackPressed();
        overridePendingTransition(R.anim.bottom_up,R.anim.bottom_down);
    }

}
