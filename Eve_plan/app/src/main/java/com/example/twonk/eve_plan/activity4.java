package com.example.twonk.eve_plan;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.example.twonk.eve_plan.R;

/**
 * Created by twonk on 11/15/2015.
 */
public class activity4 extends Activity {
    private EditText name;
    private EditText theme;
    private EditText dresscode;
    private EditText add;
    private EditText date;
    private EditText time;
    private EditText item;
    int flag = 0;
    int flag1=0;
    Cursor cr;
    DatabaseHandler db;


    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yourevent);
        //int flag = 0;
        db = new DatabaseHandler(this);
        cr = db.getEvent(db);
        cr.moveToFirst();
    }
    public void next1(View view)
    {
        if(!cr.moveToNext() && flag1 ==1)
        {
            Toast.makeText(getApplicationContext(), " there are no more events", Toast.LENGTH_LONG).show();

        }
        else
        {
            name = (EditText) findViewById(R.id.eventname);
            theme = (EditText) findViewById(R.id.eventtheme);
            dresscode = (EditText) findViewById(R.id.eventdresscode);
            add = (EditText) findViewById(R.id.eventaddress);
            date = (EditText) findViewById(R.id.eventdate);
            time = (EditText) findViewById(R.id.eventtime);
            item = (EditText) findViewById(R.id.eventitem);
            if (flag1 == 0) {
                flag1 = 1;
            } else {
                if (flag == 0) {
                    cr.moveToFirst();
                    name.setText(cr.getString(1));
                    theme.setText(cr.getString(2));
                    dresscode.setText(cr.getString(4));
                    add.setText(cr.getString(3));
                    date.setText(cr.getString(5));
                    time.setText(cr.getString(6));
                    item.setText(cr.getString(7));
                    flag = 1;
                    cr.moveToNext();
                } else {
                    name.setText(cr.getString(1));
                    theme.setText(cr.getString(2));
                    dresscode.setText(cr.getString(4));
                    add.setText(cr.getString(3));
                    date.setText(cr.getString(5));
                    time.setText(cr.getString(6));
                    item.setText(cr.getString(7));
                    cr.moveToNext();

                }
            }
        }
    }

    public void prev1(View view)
    {
        if(!cr.moveToPrevious() && flag1 ==1)
        {
            Toast.makeText(getApplicationContext(), " there are no more events", Toast.LENGTH_LONG).show();
           // cr.moveToPrevious();

        }else
        {
            name = (EditText) findViewById(R.id.eventname);
            theme = (EditText) findViewById(R.id.eventtheme);
            dresscode = (EditText) findViewById(R.id.eventdresscode);
            add = (EditText) findViewById(R.id.eventaddress);
            date = (EditText) findViewById(R.id.eventdate);
            time = (EditText) findViewById(R.id.eventtime);
            item = (EditText)findViewById(R.id.eventitem);
            if (flag1 == 0) {
                flag1 = 1;
            } else {
                if (flag == 0) {
                    cr.moveToFirst();
                    name.setText(cr.getString(1));
                    theme.setText(cr.getString(2));
                    dresscode.setText(cr.getString(4));
                    add.setText(cr.getString(3));
                    date.setText(cr.getString(5));
                    time.setText(cr.getString(6));
                    //item.setText(cr.getString(7));
                    flag = 1;
                    cr.moveToPrevious();
                } else {
                    name.setText(cr.getString(1));
                    theme.setText(cr.getString(2));
                    dresscode.setText(cr.getString(4));
                    add.setText(cr.getString(3));
                    date.setText(cr.getString(5));
                    time.setText(cr.getString(6));
                    //item.setText(cr.getString(7));
                    cr.moveToPrevious();

                }
            }
        }
    }
    public void bck(View view)
    {
        //cr.close();
        Intent i = new Intent(getApplicationContext(),activity2.class);
        startActivity(i);
        finish();
    }
    public void rou(View view)
    {
        int i = 0;
        Bundle b = new Bundle();
        b.putInt("i",i);

        Intent ij = new Intent(getApplicationContext(),MapsActivity.class);
        ij.putExtras(b);
        startActivity(ij);
    }

}
