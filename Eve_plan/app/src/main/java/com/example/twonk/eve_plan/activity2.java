package com.example.twonk.eve_plan;


import java.text.DateFormat;
import android.app.Activity;
import java.text.SimpleDateFormat;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Date;

/**
 * Created by twonk on 11/15/2015.
 */
public class activity2 extends Activity {

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        Toast.makeText(getApplicationContext(),"you have no event today",Toast.LENGTH_LONG).show();
        Date sys = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.format(sys);
        DatabaseHandler db = new DatabaseHandler(this);
        Cursor c = db.getEvent(db);
        //Date in = new Date();
        while(c.moveToNext()) {
            if (c.getString(5).equals(sys)) {
                Toast.makeText(getApplicationContext(), "today you have " + c.getString(1) + "event", Toast.LENGTH_LONG).show();
            }
            c.moveToNext();
        }
    }
    public void createEvent(View view)
    {
        Intent i = new Intent(getApplicationContext(),activity3.class);
        startActivity(i);
        finish();
    }
    public void yourEvent(View view)
    {
        Intent i = new Intent(getApplicationContext(),activity4.class);
        startActivity(i);
        finish();
    }
    public void goingEvent(View view)
    {
        Intent i = new Intent(getApplicationContext(),activity5.class);
        startActivity(i);
        finish();
    }
    public void inviteEvent(View view)
    {
        Intent i = new Intent(getApplicationContext(),activity6.class);
        startActivity(i);
        finish();
    }
    public void userInvite(View view)
    {
        Intent i = new Intent(getApplicationContext(),activity8.class);
        startActivity(i);
        finish();
    }


}
