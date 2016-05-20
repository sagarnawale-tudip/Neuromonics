package com.neuromonics;

/**
 * Created by root on 9/5/16.
 */
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.ToggleButton;

public class CustomizeActivity extends Activity {
    TabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize);
        TextView txtView = (TextView) findViewById(R.id.customText);
        String info = "<br>To modify audiogram values press 'Edit Audiogram'. To take the built in hearing level test press 'Hearing Test'.Press "+"<b>" + "i" + "</b>"+" for detailed instructions.";
        txtView.setText(Html.fromHtml(info));

        ImageView img = (ImageView) findViewById(R.id.infoImage);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CustomizeActivity.this,CustomizeInformationActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.bottom_up,R.anim.bottom_down);
            }
        });

        Button btn = (Button) findViewById(R.id.hearingTest);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CustomizeActivity.this,HearingTestActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.bottom_up,R.anim.bottom_down);
            }
        });

        Button button = (Button) findViewById(R.id.editAudiogram);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CustomizeActivity.this,EditAudiogramActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.bottom_up,R.anim.bottom_down);
            }
        });

        ToggleButton toggleButton = (ToggleButton) findViewById(R.id.toggleButton1);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton arg0, boolean isChecked) {

            }
        });

        final TextView value0 = (TextView) findViewById(R.id.position_11);final TextView value1 = (TextView) findViewById(R.id.position_12);
        final TextView value3 = (TextView) findViewById(R.id.position_13);final TextView value4 = (TextView) findViewById(R.id.position_14);
        final TextView value5 = (TextView) findViewById(R.id.position_15);final TextView value6 = (TextView) findViewById(R.id.position_16);
        final TextView value7 = (TextView) findViewById(R.id.position_17);final TextView value8 = (TextView) findViewById(R.id.position_18);
        final TextView value9 = (TextView) findViewById(R.id.position_19);final TextView value10 = (TextView) findViewById(R.id.position_21);
        final TextView value11 = (TextView) findViewById(R.id.position_22);final TextView value12 = (TextView) findViewById(R.id.position_23);
        final TextView value13 = (TextView) findViewById(R.id.position_24);final TextView value14 = (TextView) findViewById(R.id.position_25);
        final TextView value15 = (TextView) findViewById(R.id.position_26);final TextView value16 = (TextView) findViewById(R.id.position_27);
        final TextView value17 = (TextView) findViewById(R.id.position_28);final TextView value18 = (TextView) findViewById(R.id.position_29);
        for (int i=0; i< 18; i++) {
            SharedPreferences prefs = getSharedPreferences("your_file_name", MODE_PRIVATE);
            String tasksSet = prefs.getString("result" +i, null);
            value0.setText(tasksSet);
        }

    }

    public void myClickMethod(View view){
        super.onBackPressed();
        overridePendingTransition(R.anim.bottom_up,R.anim.bottom_down);
    }


}