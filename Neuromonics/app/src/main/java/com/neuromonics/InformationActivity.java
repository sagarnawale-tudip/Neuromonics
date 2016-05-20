package com.neuromonics;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by root on 11/5/16.
 */
public class InformationActivity extends Activity {
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information);
        TextView txtView = (TextView) findViewById(R.id.mainInformation);
        txtView.setText("\nMain Home Screen Info:\nThe Neuromonics Tinnitus management system works in several ways. First, the music on this app has been specifically chosen due to its high frequency sound energy and rhythm which has been shown to help relaxation. Secondly, the music is then shaped using an algorithm developed by Neuromonics over many years of research. This shaping enables the user to listen to the Neuromonics therapy at much lower volumes than what would be possible without the shaping. Third, a background noise called ‘neural stimulus’ is added to the music, and may sound like a faint ‘shower’ noise. This should be barely noticeable and it is designed to provide more stimulation around the tinnitus frequency to help reduce the awareness of the tinnitus. For more information on the science behind Neuromonics, go to www.neuromonics.com/neuromonics_explained.\n\nIt is important to note, that the Neuromonics stimulus is not designed to drown out your tinnitus. Best results are achieved when you adjust the volume of the stimulus to the point where the tinnitus is ‘blending’ with the music, or in other words is just noticeable through the music stimulus.\n\nOn the home screen you can choose between three profiles, Profile 1, Profile 2 and Profile 3. These profiles have been selected by Neuromonics as they represent the three most common tinnitus profiles found in tinnitus patients. The customize option allows you to fine tune a profile specifically suited to your results by adjusting the background neural stimulus and fine-tuning your hearing response or audiogram.\n\nInsert a pair of earphones into the headphone jack. Noise cancelling earphones are not recommended for use with this application. If you have any sensitivity to loud noises, you should choose headphones that don’t block out background noises. Choose Profile 1 and increase the volume to a comfortable level. Listen to Profile 1 for a few minutes. Once you have listened to Profile 1 select Profile 2 and then Profile 3 and listen to each for a few minutes. After listening to each Profile, pick the one that provides the most relaxation, and allows your tinnitus to blend with the music at the lowest volume possible.\n\nIt is normal if you cannot hear a difference between the different profiles at first. It may take some time of getting used to the music before you can tell a significant difference.\n\nFor best results, listen in a relaxing setting will minimal background noise. Listen whenever your tinnitus is bothersome, preferably 2-4 hours per day. The Daily Elapsed timer will keep track of how long you have listened in a day.");
    }

    public void myClickMethod(View view){
        super.onBackPressed();
        overridePendingTransition(R.anim.bottom_up,R.anim.bottom_down);
    }

}
