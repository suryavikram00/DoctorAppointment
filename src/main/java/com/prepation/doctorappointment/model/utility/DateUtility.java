/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prepation.doctorappointment.model.utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author NMSLAP570
 */
public class DateUtility {

    public static Date getCurrentDate() {
        Date today = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        //not SimpleDateFormat("dd-MM-yyyy hh:mm:ss")
        Calendar calendarDM = Calendar.getInstance();
        calendarDM.setTime(today);
        calendarDM.set(Calendar.HOUR, 0);
        calendarDM.set(Calendar.MINUTE, 0);
        calendarDM.set(Calendar.SECOND, 0);
        return calendarDM.getTime();
    }

}
