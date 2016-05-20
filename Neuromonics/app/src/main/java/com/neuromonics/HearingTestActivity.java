package com.neuromonics;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by root on 18/5/16.
 */
public class HearingTestActivity extends Activity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hearing_test);

        TextView txtView = (TextView) findViewById(R.id.homeInfo);
        String info = "To fine-tune the sound processing, follow these steps to perform a hearing level test.<br>Turn the volume up to the maximum level and find a quiet place and put on your headphones.<br>Press \"Start Test\" then Tap the big red button whenever you are sure you hear a tone.<br>Once the test is finished, this screen will automatically clear and the resulting audiogram values will populate the fields in the customization screen. Press "+"<b>" + "i" + "</b>"+" for more instructions.";
        txtView.setText(Html.fromHtml(info));

        ImageView img = (ImageView) findViewById(R.id.infoImage);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HearingTestActivity.this,HearingTestInformationActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.bottom_up,R.anim.bottom_down);
            }
        });

        Button btn = (Button) findViewById(R.id.startTest);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView startText = (TextView) findViewById(R.id.startTestId);
                startText.setText("Testing in progress...");
            }
        });
    }
    public void myClickMethod(View view){
        super.onBackPressed();
        overridePendingTransition(R.anim.bottom_up,R.anim.bottom_down);
    }
}
