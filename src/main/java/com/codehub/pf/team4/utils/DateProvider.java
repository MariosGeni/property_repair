package com.codehub.pf.team4.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class DateProvider {
    public static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat SDF_NO_TIME = new SimpleDateFormat("yyyy-MM-dd");

    public static Timestamp getStartOfDay() throws Exception{
        String today = theDayString() + " 09:00:00";
        return getFinalTime(SDF, today);
    }

    public static Timestamp getEndOfDay() throws Exception{
        String today = theDayString() + " 23:59:59";
        return getFinalTime(SDF, today);
    }

    public static Timestamp getDate(Timestamp date) throws Exception{
        return new Timestamp(SDF_NO_TIME.parse(date.toString()).getTime());
    }

    public static Timestamp getDate(String date) throws Exception{
        return new Timestamp(SDF_NO_TIME.parse(date).getTime());
    }

    public static boolean isToday(Timestamp date) {
        return SDF_NO_TIME.format(date.getTime()).equals(theDayString());
    }

    private static String theDayString() {
        return new Timestamp(new Date().getTime()).toString().substring(0, 10);
    }

    private static Timestamp getFinalTime(SimpleDateFormat sdf, String today) throws Exception {
        return new Timestamp(SDF.parse(today).getTime());
    }
}
