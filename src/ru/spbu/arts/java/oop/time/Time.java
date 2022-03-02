package ru.spbu.arts.java.oop.time;

public class Time {
    public int hour, min;

    Time(int hour, int min) {
        this.hour = hour;
        this.min = min;
    }

    public String show() {
        String time = "";
        if (hour < 10)
            time += "0" + hour + ":";
        else
            time += hour + ":";
        if (min < 10)
            time += "0" + min;
        else
            time += min;
        return time;
    }

    public boolean isMorning() {
        return (4 <= hour && hour <= 11);
    }

    public boolean isDay() {
        return (12 <= hour && hour <= 16);
    }

    public boolean isEvening() {
        return (17 <= hour && hour <= 21);
    }

    public boolean isNight() {
        return (22 <= hour || hour <= 3);
    }

    public String sayHello() {
        if (isMorning())
            return "Доброе утро!";
        if (isDay())
            return "Добрый день!";
        if (isEvening())
            return "Добрый вечер!";
        return "Доброй ночи!";
    }

    public String add(int min2) {
        int h = (hour + (min2 + min) / 60) % 24;
        int m = (min + min2 % 60) % 60;
        Time a = new Time(h, m);
        return a.show();
    }

}

