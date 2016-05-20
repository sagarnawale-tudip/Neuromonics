package com.neuromonics;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by root on 11/5/16.
 */
public class ViewSubscriptionInformationActivity extends Activity {
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information);
        TextView txtView = (TextView) findViewById(R.id.mainInformation);
        txtView.setText("\nIf you believe you have an active subscription, please press Restore. All subscriptions are saved to iCloud so they can be restored later. You will need to do this if you deleted the application or you get a new phone.\n\nYou can activate your subscription on all of the devices on your account. iCloud is required to be set up on all devices.\n\nAll subscriptions are calculated from the next day and expire at midnight. For example, a one day subscription will expire at midnight tomorrow. If today is the 10th, the montlhy subscriptions will expire at midnight on the 11th of the month.\n\nIn our experience, the average user gets the best results after listening anywhere from 3 months to a year.");
    }

    public void myClickMethod(View view){
        super.onBackPressed();
        overridePendingTransition(R.anim.bottom_up,R.anim.bottom_down);
    }

}
