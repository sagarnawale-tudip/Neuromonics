package com.neuromonics;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by root on 11/5/16.
 */
public class ViewSubscriptionsActivity extends Activity {
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_subscriptions);
        ImageView img = (ImageView) findViewById(R.id.infoImage);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ViewSubscriptionsActivity.this,ViewSubscriptionInformationActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.bottom_up,R.anim.bottom_down);
            }
        });
    }

    public void myClickMethod(View view){
        finish();
        overridePendingTransition(R.anim.bottom_up,R.anim.bottom_down);
    }
}
