package com.neel.firebasenotifications.utilities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by neelmani.karn on 2/15/2016.
 */
public class DateTimeFormatClass {

    //Date and time format constants
    public static final String DATE_FORMAT = "MMM dd, yyyy";
    public static final String TIME_FORMAT = "hh:mm a";
    public static String convertDateObjectToMMDDYYYFormat(Date date) {
        return new SimpleDateFormat(DATE_FORMAT).format(date);
    }

    public static String convertDateObjectINTOTimeAmPmFormat(Date date) {
        return new SimpleDateFormat(TIME_FORMAT).format(date);
    }

    public static boolean compareDates(Date date1){
        Date date = null;
        Calendar myCalender = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

        try {
            date = sdf.parse(convertDateObjectToMMDDYYYFormat(myCalender.getTime()));
            //System.out.println(date);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (date!=null){
            if (date.equals(date1)){
                return false;
            }else if (date.before(date1)){
                return false;
            }else if (date.after(date1)){
                return true;
            }
        }else{
            return false;
        }
        return false;
    }

    /**
     @param "April 15, 2016"
     @return "MMM dd, yyyy" format

     */
    public static String convertStringObjectToMMDDYYYFormat(String date){
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        try {

            Date parsedDate = formatter.parse(date);
            // System.out.println(date);

            //System.out.println(formatter.format(parsedDate));
            return formatter.format(parsedDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     @param "MMM dd, yyyy"
     @return Date object

     */
    public static Date convertStringObjectToDate(String date){
        //String startDateString = "05/10/1988";
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);

        try {
            Date parsedDate = formatter.parse(date);
            return parsedDate;
        } catch (ParseException e) {
            e.printStackTrace();
            return new Date();
        }
    }

    public static String convertStringObjectToMMMDDYYYYFormat(String date){

        String[] s = date.split("T");
        System.out.println(s[0]);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = null;
        try {
            startDate = df.parse(s[0]);
            //Log.e("startdate",startDate.toString());

        } catch (ParseException e) {
            e.printStackTrace();

        }
        return convertDateObjectToMMDDYYYFormat(startDate);
    }


    public static String convertStringObjectToAMPMTimeFormat(String date){

        String[] s = date.split("T");
        System.out.println(s[1]);
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        Date startDate = null;
        String parsedDate;
        try {
            startDate = df.parse(s[1]);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(startDate);


        System.out.println(new SimpleDateFormat("hh:mm a").format(startDate));
        return convertDateObjectINTOTimeAmPmFormat(startDate);
    }

}