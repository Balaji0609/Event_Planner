package com.example.twonk.eve_plan;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
//import com.example.twonk.eve_plan.classes;

/**
 * Created by twonk on 11/15/2015.
 */

 class ReminderService extends IntentService {
    private static final int NOTIF_ID = 1;

    public ReminderService(){
        super("ReminderService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        long when = System.currentTimeMillis();         // notification time
        Notification notification = new Notification(R.drawable.common_google_signin_btn_icon_dark, "reminder", when);
        notification.defaults |= Notification.DEFAULT_SOUND;
        notification.flags |= notification.FLAG_AUTO_CANCEL;
        Intent notificationIntent = new Intent(this, activity3.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent , 0);


        NotificationCompat.Builder builder = new NotificationCompat.Builder(
                this);
        notification = builder.setContentIntent(contentIntent)
                .setAutoCancel(true).setContentTitle("It's about time")
                .setContentText("OPEN THE APP NOW").build();

        nm.notify(NOTIF_ID, notification);


        //notification.(getApplicationContext(), "It's about time", "You should open the app now", contentIntent);
        nm.notify(NOTIF_ID, notification);
    }

}

public class activity3 extends Activity {
    private EditText name;
    private EditText theme;
    private EditText dresscode;
    private EditText add;
    private EditText date;
    private EditText time;
    private EditText item;
    NotificationCompat.Builder notification;
    PendingIntent pIntent;
    NotificationManager manager;
    Intent resultIntent;
    TaskStackBuilder stackBuilder;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createactivity);
    }
    public class Result extends Activity{
        @Override
        public void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }

    }
    public void creeve(View view)
    {
        int flag = 0;
        name = (EditText) findViewById(R.id.eventname);
        theme = (EditText)findViewById(R.id.eventtheme);
        dresscode = (EditText)findViewById(R.id.eventdresscode);
        add = (EditText)findViewById(R.id.eventaddress);
        date = (EditText)findViewById(R.id.eventdate);
        time = (EditText)findViewById(R.id.eventtime);
        item =(EditText) findViewById(R.id.eventitem);
        DatabaseHandler db = new DatabaseHandler(this);
        String nam = name.getText().toString().trim();
        String them = theme.getText().toString().trim();
        String dress = dresscode.getText().toString().trim();
        String ad = add.getText().toString();
        String d = date.getText().toString();
        String t = time.getText().toString();
        String i = item.getText().toString();
        db.addEvent(new classes.event(nam, them, dress, ad, d, t,i));

        Cursor cr = db.getEvent(db);
        cr.moveToFirst();
        Toast.makeText(getApplicationContext(),"success",Toast.LENGTH_LONG).show();
        if(!nam.isEmpty())
        {
            do {
                if(cr.getString(0).equals(nam))
                {
                  flag=1;
                }
                //flag=1;
            }while(cr.moveToNext() && flag == 0);
            if (flag == 1)
            {
                Toast.makeText(getApplicationContext(),"event already exsists",Toast.LENGTH_LONG).show();
            }
            else
            {
             //   classes.event c;
/*
                AlarmManager alarmManager = (AlarmManager) this.getSystemService(this.ALARM_SERVICE);
                Calendar calendar =  Calendar.getInstance();
                calendar.set(Calendar.YEAR, Calendar.MONTH, Calendar.DATE,Calendar.HOUR, Calendar.MINUTE, Calendar.SECOND);
                long when = calendar.getTimeInMillis();         // notification time
                Intent intent = new Intent(this, ReminderService.class);
                PendingIntent pendingIntent = PendingIntent.getService(this, 0, intent, 0);
                alarmManager.set(AlarmManager.RTC, when, pendingIntent);
*/

                 notification = new NotificationCompat.Builder(activity3.this);
                //Title for Notification
                notification.setContentTitle("Event Updates");
                //Message in the Notification
                notification.setContentText(" You have an event today !!!!! Click to learn more");
                //Alert shown when Notification is received
                notification.setTicker("New Message Alert!");
                //Icon to be set on Notification
                notification.setSmallIcon(R.drawable.ic_launcher);
                //Creating new Stack Builder
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    stackBuilder = TaskStackBuilder.create(activity3.this);
                }
               // stackBuilder.addParentStack(Result.class);
                //Intent which is opened when notification is clicked
                resultIntent = new Intent(activity3.this, login.class);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    stackBuilder.addNextIntent(resultIntent);
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    pIntent =  stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
                }
                notification.setContentIntent(pIntent);
                manager =(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                manager.notify(0, notification.build());
                db.addEvent(new classes.event(nam, them, dress, ad, d, t,i));
                Toast.makeText(getApplicationContext(),"success ",Toast.LENGTH_LONG).show();
            }
        }
        else
        {
            Toast.makeText(getApplicationContext(),"enter a event name",Toast.LENGTH_LONG).show();
        }
        cr.moveToFirst();
    }






    public void bc(View view)
    {
        Intent i = new Intent(getApplicationContext(),activity2.class);
        startActivity(i);
        finish();
    }

}
