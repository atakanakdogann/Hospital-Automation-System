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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Date other = (Date) obj;
        if (day != other.day)
            return false;
        if (time != other.time)
            return false;
        return true;
    }

    

}
