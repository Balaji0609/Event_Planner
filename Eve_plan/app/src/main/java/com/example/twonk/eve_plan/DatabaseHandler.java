package com.example.twonk.eve_plan;

import android.app.ActionBar;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.twonk.eve_plan.login;
import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by twonk on 11/15/2015.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VER = 1;

    private static final String DB_name = "Login_DB";

    private static final String Table_name = "user";
    private static final String Table_name1 = "event";
    private static final String Table_name2 = "userinvite";
    private static final String Table_name3 = "invitation";

    private static final String ID = "id";
    private static final String ID1 = "event_id";
    private static final String name1 = "name";
    private static final String MAILID = "mailid";
    private static final String PASSWORD = "pass";

    private static final String name = "name";
    private static final String theme="theme";
    private static final String add = "address";
    private static final String dress = "dress_code";
    private static final String date ="date";
    private static final String time ="time";
    private static final String item = "items";

    private static final String us = "User";
    private static final String ev = "Event";


    public DatabaseHandler(Context context)
    {
        super(context, DB_name, null, DATABASE_VER);
    }

    public void onCreate(SQLiteDatabase db)
    {
        String Create_Contact = "CREATE TABLE " + Table_name + "(" + ID + " INTEGER PRIMARY KEY, " +name1+" TEXT, "+ MAILID + " TEXT, " + PASSWORD + " TEXT " + ")";
        String Create_Event = "CREATE TABLE "+Table_name1 + "("+ ID1 + " INTEGER PRIMARY KEY, " + name + " TEXT,"+theme+" TEXT, "+add+" TEXT,"+dress+" TEXT, "+date+" DATE, "+time+" TIME, "+item+" Text "+")";
        String Create_Invi = "CREATE TABLE "+Table_name2+" ( "+us+" TEXT, "+ev+" TEXT "+")";
        //String insert1 = "INSERT INTO "+Table_name+" VALUES "+"("+" null, "+" null, " +" null, "+" null "+")";
        //String insert2 = "INSERT INTO "+Table_name1 +" VALUES "+"("+" null, "+" null, " +" null, "+" null, "+" null, "+" null, "+" null "+")";
        db.execSQL(Create_Contact);
        db.execSQL(Create_Event);
        db.execSQL(Create_Invi);
        //db.execSQL(insert1);
        //db.execSQL(insert2);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
        db.execSQL("DROP TABLE IF EXISTS" + Table_name);
        db.execSQL("DROP TABLE IF EXISTS" + Table_name1);
        db.execSQL("DROP TABLE IF EXISTS"+Table_name2);
        onCreate(db);
    }

    public void addUser(login log1)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(name1,log1.getName());
        values.put(MAILID, log1.getMailid());
        values.put(PASSWORD, log1.getPass());

        db.insert(Table_name, null, values);
        db.close();
    }
    public void addEvent(classes.event eve)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(name,eve.getName());
        values.put(theme,eve.getTheme());
        values.put(add,eve.getAdd());
        values.put(dress,eve.getDresscode());
        values.put(date,eve.getDate());
        values.put(time,eve.getTime());
        values.put(item,eve.getItem());
        db.insert(Table_name1,null,values);
        db.close();
    }
    public void addInvi(classes.invi in)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(us,in.getUs());
        values.put(ev,in.getEv());
        db.insert(Table_name2, null, values);
        db.close();

    }
    public Cursor getEvent(DatabaseHandler dbo)
    {
        SQLiteDatabase sq = dbo.getReadableDatabase();
        Cursor cur = sq.query(Table_name1,new String[]{ID1,name,theme,add,dress,date,time},null,null,null,null,null);
        return cur;
    }
    public Cursor getUser(DatabaseHandler dbo)
    {
        SQLiteDatabase sq = dbo.getReadableDatabase();

        Cursor cur = sq.query(Table_name, new String[]{ ID, name1, MAILID, PASSWORD}, null, null, null, null, null);

        //if(cur != null)
        //    cur.moveToFirst();

      //  login log1 = new login(Integer.parseInt(cur.getString(0)),cur.getString(1),cur.getString(2));

        return cur;
    }
    public Cursor getInvi(DatabaseHandler dbo)
    {
        SQLiteDatabase sq = dbo.getReadableDatabase();
        Cursor cur =sq.query(Table_name2,new String[]{us,ev},null,null,null,null,null);
        return cur;
    }
/*
    public List<login> getAllUser()
    {
        List<login> userList = new ArrayList<login>();

        String selectQuery = "SELECT * FROM " + Table_name;

        SQLiteDatabase db =this.getWritableDatabase();

        Cursor cur = db.rawQuery(selectQuery,null);

        if(cur.moveToFirst())
        {
            do {

                login log1 =new login();

                log1.setId(Integer.parseInt(cur.getString(0)));

                log1.setMailid(cur.getString(1));
                log1.setPass(cur.getString(2));
                userList.add(log1);

            }while (cur.moveToNext());
        }
        return userList;
    }

    public int updateUser(login log1)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(MAILID,log1.getMailid());
        values.put(PASSWORD,log1.getPass());

        return db.update(Table_name,values,ID + "=?", new String[]{String.valueOf(log1.getId())});

    }*/


    public void deleteUser(login log1)
    {
     SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Table_name, ID + "=?", new String[]{String.valueOf(log1.getId())});
        db.close();
    }
    public int getUserCount() {
        String countQuery = "SELECT * FROM " + Table_name;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cur = db.rawQuery(countQuery,null);
        cur.close();
        return cur.getCount();
    }


}
