package com.example.twonk.eve_plan;

/**
 * Created by twonk on 11/15/2015.
 */
public class login {
    int id;
    String name;
    String mailid;
    String pass;
    public login()
    {
    }
    public login(int id,String name, String mailid, String pass)
    {
        this.name = name;
        this.id = id;
        this.mailid = mailid;
        this.pass = pass;
    }
    public login(String name, String mailid,String pass)
    {
        this.name = name;
        this.mailid = mailid;
        this.pass = pass;
    }
    public login(String mailid, String pass)
    {
        this.mailid = mailid;
        this.pass = pass;
    }
    public int getId()
    {
        return this.id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public String getMailid()
    {
        return this.mailid;
    }
    public void setMailid(String mailid)
    {
        this.mailid = mailid;
    }
    public String getPass()
    {
        return this.pass;
    }
    public void setPass(String pass)
    {
        this.pass = pass;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return this.name;
    }
}
