package main.java.user;

public class Date
{
    private int day;
    private int time;

    public Date(int day, int time){

        this.day = day;
        this.time = time;
    }

    public Date() {
    }

    public int getDay()
    {
        return day;
    }

    public int getTime()
    {
        return time;
    }
}
