package com.example.twonk.eve_plan;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by twonk on 11/17/2015.
 */
public class activity8 extends Activity {
    private EditText us1;
    private EditText ev1;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userinvi);
    }
    public void bc(View view)
    {
        Intent i = new Intent(getApplicationContext(),activity2.class);
        startActivity(i);
        finish();
    }
    public void inv(View view)
    {
        String us;
        String ev;
        int flag =0;
        int flag1=0;
        ev1 = (EditText)findViewById(R.id.eventname);
        us1 = (EditText)findViewById(R.id.userid);
        us = us1.getText().toString();
        ev = ev1.getText().toString();

        DatabaseHandler db = new DatabaseHandler(this);
        Cursor cr = db.getEvent(db);
        Cursor cr1 = db.getUser(db);
        cr.moveToFirst();
        cr1.moveToFirst();
        do
        {
            if(cr.getString(1).equals(ev))
            {
                flag = 1;
                cr.moveToFirst();
                break;
            }
            if(cr.moveToNext())
            {
              cr.moveToNext();
            }
            else
                cr.moveToFirst();
                break;
        }while(true);

        do
        {
            if(cr1.getString(2).equals(us))
            {
                flag1=1;
                cr1.moveToFirst();
                break;
            }
            if(cr1.moveToNext()) {
                cr1.moveToNext();
            }
            else
                cr1.moveToFirst();
                break;
        }while (true);

        if(flag == 1 && flag1 ==1) {
            db.addInvi(new classes.invi(us, ev));
            Toast.makeText(getApplicationContext(), "successfully invited", Toast.LENGTH_LONG).show();
            cr.close();
            cr1.close();
        }
        else
        {
            cr.close();
            cr1.close();
            Toast.makeText(getApplicationContext(),"Please enter correct user and event name",Toast.LENGTH_LONG).show();
        }
    }

}
