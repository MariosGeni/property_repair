package com.codehub.pf.team4.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class DateProvider {
    public static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static Timestamp getStartOfDay() throws Exception{
        String today = theDay() + " 09:00:00";
        return getFinalTime(SDF, today);
    }

    public static Timestamp getEndOfDay() throws Exception{
        String today = theDay() + " 23:59:59";
        return  getFinalTime(SDF, today);
    }

    private static String theDay() {
        return new Timestamp(new Date().getTime()).toString().substring(0, 10);
    }

    private static Timestamp getFinalTime(SimpleDateFormat sdf, String today) throws Exception {
        return new Timestamp(SDF.parse(today).getTime());
    }
}
