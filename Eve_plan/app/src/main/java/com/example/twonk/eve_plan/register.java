package com.example.twonk.eve_plan;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by twonk on 11/16/2015.
 */
public class register extends Activity {
    private EditText inname;
    private EditText inmail;
    private EditText inpass;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
    }
    public void reg(View view)
    {
        int flag = 0;
        inname = (EditText)findViewById(R.id.name);
        inmail = (EditText)findViewById(R.id.email);
        inpass = (EditText)findViewById(R.id.password);
        DatabaseHandler db = new DatabaseHandler(this);
        String na = inname.getText().toString();
        String ma = inmail.getText().toString();
        String pa = inpass.getText().toString();
        db.addUser(new login(na, ma, pa));
        Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_LONG).show();
        Cursor cr = db.getUser(db);
        if(cr!=null) {
            cr.moveToFirst();
            do {
                if (cr.getString(2).equals(ma)) {
                    flag = 1;
                }
            } while (cr.moveToNext() && flag == 0);
            //cr.moveToFirst();
        }
        //if(cr)
        if(flag == 0) {
            db.addUser(new login(na, ma, pa));
            Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"already exsists!! login", Toast.LENGTH_LONG).show();
        }
    }
    public void bcklog(View view)
    {
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
        finish();
    }
}
