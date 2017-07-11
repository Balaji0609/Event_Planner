package com.example.twonk.eve_plan;

/**
 * Created by twonk on 11/15/2015.
 */
public class classes {
    public static class event
    {
        int id;
        String name;
        String theme;
        String add;
        String dresscode;
        String date;
        String time;
        String item;
        public event()
        {

        }
        public event(int id,String name, String theme, String add, String dresscode, String date, String time,String item)
        {
            this.id=id;
            this.add=add;
            this.date=date;
            this.dresscode=dresscode;
            this.name=name;
            this.time=time;
            this.theme=theme;
            this.item = item;
        }
        public event(String name, String theme, String add, String dresscode, String date, String time, String item)
        {
       //     this.id=id;
            this.item=item;
            this.add=add;
            this.date=date;
            this.dresscode=dresscode;
            this.name=name;
            this.time=time;
            this.theme=theme;
        }

        public event(String name,String date,String time,String add)
        {
            this.name=name;
            this.date=date;
            this.time=time;
            this.add=add;
        }
        public String getName()
        {
            return this.name;
        }
        public String getDate()
        {
            return this.date;
        }
        public String getTheme()
        {
            return this.theme;
        }
        public String getAdd()
        {
            return this.add;
        }
        public String getDresscode()
        {
            return this.dresscode;
        }
        public String getTime()
        {
            return this.time;
        }
        public void setName(String name)
        {
            this.name=name;
        }
        public void setTheme(String theme)
        {
            this.theme=theme;
        }
        public void setAdd(String add)
        {
            this.add = add;
        }
        public void setDresscode(String dresscode)
        {
            this.dresscode=dresscode;
        }
        public void setDate(String date)
        {
            this.date = date;
        }
        public void setTime(String time) {
            this.time = time;
        }
        public int getId(int id)
        {
            return this.id;
        }
        public void setId(int id)
        {
            this.id=id;
        }
        public void setItem(String item)
        {
            this.item = item;
        }
        public String getItem()
        {
            return this.item;
        }
    }
    public static class invi
    {
        String us;
        String ev;
        public invi()
        {

        }
        public invi(String us,String ev)
        {
            this.ev=ev;
            this.us=us;
        }
        public void setUs(String us)
        {
            this.us=us;
        }
        public String getUs()
        {
            return this.us;
        }
        public void setEv(String ev)
        {
            this.ev=ev;
        }
        public String getEv()
        {
            return this.ev;
        }
    }

}
