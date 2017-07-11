package com.example.twonk.eve_plan;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by twonk on 11/15/2015.
 */
public class activity6 extends Activity {
    private EditText name;
    private EditText theme;
    private EditText dresscode;
    private EditText add;
    private EditText date;
    private EditText time;
    int flag = 0;
    int flag1=0;
    Cursor cr;
    DatabaseHandler db;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inviteevent);
        db = new DatabaseHandler(this);
        cr = db.getEvent(db);
        cr.moveToFirst();
        //int flag = 0;
    }
    public void nx(View view)
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
                    flag = 1;
                    cr.moveToNext();
                } else {
                    name.setText(cr.getString(1));
                    theme.setText(cr.getString(2));
                    dresscode.setText(cr.getString(4));
                    add.setText(cr.getString(3));
                    date.setText(cr.getString(5));
                    time.setText(cr.getString(6));
                    cr.moveToNext();

                }
            }
        }
    }

    public void pr(View view)
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
                    flag = 1;
                    cr.moveToPrevious();
                } else {
                    name.setText(cr.getString(1));
                    theme.setText(cr.getString(2));
                    dresscode.setText(cr.getString(4));
                    add.setText(cr.getString(3));
                    date.setText(cr.getString(5));
                    time.setText(cr.getString(6));
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
    public void acpt(View view)
    {
        Intent ik = new Intent(getApplicationContext(),activity7.class);
        startActivity(ik);
        finish();
    }
    public void decline(View view)
    {
     Toast.makeText(getApplicationContext()," you have declined the invitation",Toast.LENGTH_LONG).show();
    }


}
