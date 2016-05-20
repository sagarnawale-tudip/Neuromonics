package com.neuromonics;

import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends TabActivity {
    private ViewPager mViewPager;
    TabHost tabHost;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtView = (TextView) findViewById(R.id.homeInfo);
        String info = "Welcomes to the Neuromonics application. We look forward to helping you manage the ringing in your ears(Tinnitus).<br><br>Neuromonics will play specially selected music tracks with a background noise specifically created to bend with and decrease your Tinnitus awareness.Press the info button ( "+"<b>" + "i" + "</b>"+")for detailed instruction on selecting the Profile that is best for you.";
        txtView.setText(Html.fromHtml(info));

        final ImageView img = (ImageView) findViewById(R.id.infoImage);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,InformationActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.bottom_up,R.anim.bottom_down);
            }
        });

        Button btn = (Button) findViewById(R.id.subscriptionButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,ViewSubscriptionsActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.bottom_up,R.anim.bottom_down);
            }
        });

        tabHost = getTabHost();
        TabHost.TabSpec spec;
        Intent intent;

        intent = new Intent().setClass(this, ProfileOneActivity.class);
        spec = tabHost.newTabSpec("Profile 1").setIndicator("Profile 1")
                .setContent(intent);
        tabHost.addTab(spec);

        intent = new Intent().setClass(this, ProfileOneActivity.class);
        spec = tabHost.newTabSpec("Profile 2").setIndicator("Profile 2")
                .setContent(intent);
        tabHost.addTab(spec);

        intent = new Intent().setClass(this, ProfileOneActivity.class);
        spec = tabHost.newTabSpec("Profile 3").setIndicator("Profile 3")
                .setContent(intent);
        tabHost.addTab(spec);

        intent = new Intent().setClass(this, CustomizeActivity.class);
        spec = tabHost.newTabSpec("Customize").setIndicator("Customize")
                .setContent(intent);
        tabHost.addTab(spec);

        setTabColor(tabHost);
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String arg0) {
                setTabColor(tabHost);
               if (tabHost.getCurrentTab() == 3) {
                   Intent i = new Intent(MainActivity.this, CustomizeActivity.class);
                   startActivity(i);
                   overridePendingTransition(R.anim.bottom_up,R.anim.bottom_down);
               }
            }
        });

        tabHost.getTabWidget().getChildAt(3).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                setTabColor(tabHost);
                Intent i = new Intent(MainActivity.this, CustomizeActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.bottom_up,R.anim.bottom_down);
            } });
    }

    public static void setTabColor(TabHost tabhost) {

        for (int i = 0; i < tabhost.getTabWidget().getChildCount(); i++) {
            tabhost.getTabWidget().getChildAt(i)
                    .setBackgroundResource(R.drawable.border);
            TextView tv = (TextView) tabhost.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
            tv.setTextColor(Color.parseColor("#56C0D0"));
            tv.setAllCaps(false);
        }
        tabhost.getTabWidget().setCurrentTab(0);
        tabhost.getTabWidget().getChildAt(tabhost.getCurrentTab())
                .setBackgroundResource(R.color.profileColor);
        TextView tv = (TextView) tabhost.getCurrentTabView().findViewById(android.R.id.title);
        tv.setTextColor(Color.WHITE);
        tv.setAllCaps(false);
    }

}
