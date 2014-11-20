package com.ikravchenko.instancesaver;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.ikravchenko.library.SaveState;
import com.ikravchenko.library.Saver;

import java.util.ArrayList;

public class MainActivity extends Activity {

    @SaveState
    private String text = "";
    @SaveState
    SimpleObject simpleObject;
    @SaveState
    int primitive = 0;
    @SaveState
    int[] primitiveArray;
    @SaveState
    ArrayList<Parcelable> parcelablesArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        new Saver().restore(this, savedInstanceState);
        final TextView title = (TextView) findViewById(R.id.title);
        title.setText(text);
        final EditText input = (EditText) findViewById(R.id.input);
        findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = input.getText().toString();
                title.setText(text);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        new Saver().save(this, outState);
    }
}
