package com.example.twonk.eve_plan;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuItem;
import android.util.Log;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.twonk.eve_plan.R;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText inputEmail;
    private EditText inputPassword;
    Context ctx=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        /**
         * CRUD Operations
         * */
        // Inserting Contacts
       /* Log.d("Insert: ", "Inserting ..");
        db.addUser(new login("Ravi", "9100000000"));
        db.addUser(new login("Srinivas", "9199999999"));
        db.addUser(new login("Tommy", "9522222222"));
        db.addUser(new Co("Karthik", "9533333333"));

        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<Contact> contacts = db.getAllUser();

        for (Contact cn : contacts) {
            String log = "Id: "+cn.getID()+" ,Name: " + () + " ,Phone: " + cn.getPhoneNumber();
            // Writing Contacts to log
            Log.d("Name: ", log);
    }*/
    }

    public void loggedIn(View view){
        //private Button btnLogin;
        //private Button btnLinkToRegister;
        int flag =0;
        Log.d("inside :","inside the clickaction");
        inputEmail = (EditText) findViewById(R.id.email);
        inputPassword = (EditText) findViewById(R.id.password);
       // btnLogin = (Button) findViewById(R.id.btnLogin);
        //btnLinkToRegister = (Button) findViewById(R.id.btnLinkToRegisterScreen);
        DatabaseHandler db = new DatabaseHandler(this);
        //db.onCreate();
        String email = inputEmail.getText().toString().trim();
        String password = inputPassword.getText().toString().trim();
        /*if (!email.isEmpty() && !password.isEmpty()) {
            db.addUser(new login(email, password));
            Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(getApplicationContext(), "please enter the credentials! ", Toast.LENGTH_LONG).show();
        }*/
        //db.addUser(new login(email, password));
        Cursor cr = db.getUser(db);
        cr.moveToFirst();
        if(!email.isEmpty()) {
            do {
                if (cr.getString(2).equals(email)) {
                    flag = 1;
                }
            } while (cr.moveToNext() && flag == 0);
            cr.moveToFirst();
            if (flag == 1) {
                Intent i = new Intent(getApplicationContext(),activity2.class);
                startActivity(i);
                finish();
                //Toast.makeText(getApplicationContext(), "already exsists ! login", Toast.LENGTH_LONG).show();
            } else {
                if (!email.isEmpty() && !password.isEmpty()) {
                    Intent i = new Intent(getApplicationContext(),register.class);
                    startActivity(i);
                    finish();

                } else {
                    Toast.makeText(getApplicationContext(), "please enter the credentials! ", Toast.LENGTH_LONG).show();
                }
            }
        }
    }
    public void loggedInDet(View view)
    {
        Intent i = new Intent(getApplicationContext(),register.class);
        startActivity(i);
        finish();
    }
    /*public void loggedInDet(View view){
        int flag =0;
        inputEmail=(EditText)findViewById(R.id.email);
        String em=inputEmail.getText().toString();
        DatabaseHandler db = new DatabaseHandler(ctx);
        Cursor cr = db.getUser(db);
        cr.moveToFirst();
        do{
            if(cr.getString(1).equals(em))
            {
                flag =1;
            }
        }while (cr.moveToNext()&& flag == 0);
        if(flag ==1)
        {
            Toast.makeText(getApplicationContext(), "already exsists", Toast.LENGTH_LONG).show();
        }
    }*/
    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}
