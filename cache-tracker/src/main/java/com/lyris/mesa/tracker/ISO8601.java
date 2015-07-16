package com.lyris.mesa.tracker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public final class ISO8601 {
    /** Transform Calendar to ISO 8601 string. */
    public static String fromCalendar(final Calendar calendar) {
        return ISO8601.fromDate(calendar.getTime());
    }
    
    /** Transform Timestamp (1394495086) to ISO 8601 string. */
    public static String fromTimestamp(final long timestamp) {
    	return fromDate(new Date((long) timestamp * 1000));
    }
    
    /** Transform Date to ISO 8601 string. */
    public static String fromDate(final Date date) {
        String formatted = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
            .format(date);
        return formatted.substring(0, 22) + ":" + formatted.substring(22);
    }

    public static Date dateFromTimestamp(final long timestamp) {
    	return new Date((long) timestamp * 1000);
    }
    
    public static Calendar calendarFromTimestamp(final long timestamp) {
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(dateFromTimestamp(timestamp));
    	return calendar;
    }
    
    /** Get current date and time formatted as ISO 8601 string. */
    public static String now() {
        return fromCalendar(GregorianCalendar.getInstance());
    }
    
    public static String addYears(int years) {
    	Calendar calendar = GregorianCalendar.getInstance();
    	calendar.add(Calendar.YEAR, years);
    	return fromCalendar(calendar);
    }
    
    public static String addMonths(int months) {
    	Calendar calendar = GregorianCalendar.getInstance();
    	calendar.add(Calendar.MONTH, months);
    	return fromCalendar(calendar);
    }
    
    public static String addDays(int days) {
    	Calendar calendar = GregorianCalendar.getInstance();
    	calendar.add(Calendar.DATE, days);
    	return fromCalendar(calendar);
    }
    
    /** Transform ISO 8601 string to Calendar. */
    public static Calendar toCalendar(final String iso8601string)
            throws ParseException {
        Calendar calendar = GregorianCalendar.getInstance();
        String s = iso8601string.replace("Z", "+00:00");
        try {
            s = s.substring(0, 22) + s.substring(23);  // to get rid of the ":"
        } catch (IndexOutOfBoundsException e) {
            throw new ParseException("Invalid length", 0);
        }
        Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").parse(s);
        calendar.setTime(date);
        return calendar;
    }
}