package com.neuromonics;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by root on 11/5/16.
 */
public class EditAudiogramActivity extends Activity {
    private ArrayList<String> Listtasks;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_audiogram);
        final List<TextView> textViews = new ArrayList<>();

        ImageView img = (ImageView) findViewById(R.id.infoImage);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(EditAudiogramActivity.this,EditAudiogramInformationActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.bottom_up,R.anim.bottom_down);
            }
        });

        final TextView L1 = (TextView) findViewById(R.id.position_11);final TextView L2 = (TextView) findViewById(R.id.position_12);
        final TextView L3 = (TextView) findViewById(R.id.position_13);final TextView L4 = (TextView) findViewById(R.id.position_14);
        final TextView L5 = (TextView) findViewById(R.id.position_15);final TextView L6 = (TextView) findViewById(R.id.position_16);
        final TextView L7 = (TextView) findViewById(R.id.position_17);final TextView L8 = (TextView) findViewById(R.id.position_18);
        final TextView L9 = (TextView) findViewById(R.id.position_19);final TextView R1 = (TextView) findViewById(R.id.position_21);
        final TextView R2 = (TextView) findViewById(R.id.position_22);final TextView R3 = (TextView) findViewById(R.id.position_23);
        final TextView R4 = (TextView) findViewById(R.id.position_24);final TextView R5 = (TextView) findViewById(R.id.position_25);
        final TextView R6 = (TextView) findViewById(R.id.position_26);final TextView R7 = (TextView) findViewById(R.id.position_27);
        final TextView R8 = (TextView) findViewById(R.id.position_28);final TextView R9 = (TextView) findViewById(R.id.position_29);
        textViews.add(L1);textViews.add(L2);textViews.add(L3);textViews.add(L4);textViews.add(L5);textViews.add(L6);
        textViews.add(L7);textViews.add(L8);textViews.add(L9);textViews.add(R1);textViews.add(R2);textViews.add(R3);
        textViews.add(R4);textViews.add(R5);textViews.add(R6);textViews.add(R7);textViews.add(R8);textViews.add(R9);
        L1.setTextColor(Color.parseColor("#FFFFFF"));
        L1.setBackgroundResource(R.drawable.grid_background);
        numberPicker(L1);
        textClick(L1,textViews);textClick(L2,textViews);textClick(L3,textViews);textClick(L4,textViews);textClick(L5,textViews);textClick(L6,textViews);
        textClick(L7,textViews);textClick(L8,textViews);textClick(L9,textViews);textClick(R1,textViews);textClick(R2,textViews);textClick(R3,textViews);
        textClick(R4,textViews);textClick(R5,textViews);textClick(R6,textViews);textClick(R7,textViews);textClick(R8,textViews);textClick(R9,textViews);
        TextView txtView = (TextView) findViewById(R.id.editInfo);
        String info = "<br>Select each Ear and Frequency from Audiogram table.Adjust using the picker wheel.Press "+"<b>" + "i" + "</b>"+" for more instructions.";
        txtView.setText(Html.fromHtml(info));

    }

    public void numberPicker(final TextView tv){
        NumberPicker numPicker = (NumberPicker) findViewById(R.id.np);
        String[] nums = new String[21];

        for(int i=0; i<nums.length; i++) {
            nums[i] = Integer.toString(i * 5);
        }

        numPicker.setMaxValue(nums.length-1);
        numPicker.setMinValue(0);
        numPicker.setDisplayedValues(nums);
        numPicker.setWrapSelectorWheel(true);
        numPicker.setValue(Integer.parseInt(tv.getText().toString())/5);
        setDividerColor(numPicker, Color.parseColor("#d3d3d3"));
        numPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal){
                tv.setText(""+newVal*5);
            }
        });
    }

    public void myClickMethod(View view){
        super.onBackPressed();
        overridePendingTransition(R.anim.bottom_up,R.anim.bottom_down);
    }

    public void setTextChange(List<TextView> textViews){

        for (int i = 0; i< textViews.size(); i++) {
            textViews.get(i).setBackgroundResource(R.drawable.grid_border);
            textViews.get(i).setTextColor(Color.parseColor("#000000"));
        }

    }

    public void textClick (final TextView textview, final List<TextView> textViews) {
        textview.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setTextChange(textViews);
                textview.setTextColor(Color.parseColor("#FFFFFF"));
                textview.setBackgroundResource(R.drawable.grid_background);
                numberPicker(textview);
                getGridValues(textViews);
            }
        });
    }

    private void setDividerColor(NumberPicker picker, int color) {

        java.lang.reflect.Field[] pickerFields = NumberPicker.class.getDeclaredFields();
        for (java.lang.reflect.Field pf : pickerFields) {
            if (pf.getName().equals("mSelectionDivider")) {
                pf.setAccessible(true);
                try {
                    ColorDrawable colorDrawable = new ColorDrawable(color);
                    pf.set(picker, colorDrawable);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (Resources.NotFoundException e) {
                    e.printStackTrace();
                }
                catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

    public void getGridValues (List<TextView> textViews){

        Listtasks = new ArrayList<String>();
        Set<String> tasksSet = new HashSet<String>(Listtasks);

        for (int i=0; i< textViews.size(); i++){
            SharedPreferences prefs = getSharedPreferences("your_file_name", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("result"+i, textViews.get(i).getText().toString());
            editor.commit();
        }
    }

}
