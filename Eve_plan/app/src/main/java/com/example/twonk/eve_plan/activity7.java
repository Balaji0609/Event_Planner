package com.example.twonk.eve_plan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by twonk on 11/16/2015.
 */
public class activity7 extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accept);
    }
    public void done1(View view)
    {
        Intent i =new Intent(getApplicationContext(),activity6.class);
        startActivity(i);
        finish();
    }
}
