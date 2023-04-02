/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prepation.doctorappointment.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author NMSLAP570
 */
public class Day {

    private Date date;

    private static final Integer SLOT_PERIOD_IN_HOUR = 1;

    private static final Integer APPOINTMENT_START_TIME = 9;

    private static final Integer APPOINTMENT_END_TIME = 21;

    private List<Slot> slotList;

    public Day(Date date) {
        this.date = date;
        for (int hour = APPOINTMENT_START_TIME; hour < APPOINTMENT_END_TIME; hour++) {
            Slot slot = new Slot(hour, this);
            if(slotList == null){
                slotList = new LinkedList<>();
            }
            slotList.add(slot);
        }
    }
    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.date == null ? this.date : this.date.toString());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Day other = (Day) obj;
        if (!Objects.equals(this.date == null ? this.date : this.date.toString(),
                    other.date == null ? other.date : other.date.toString())) {
            return false;
        }
        return true;
    }

    public Date getDate() {
        return date;
    }

    public List<Slot> getSlotList() {
        return slotList;
    }

    @Override
    public String toString() {
        return "Day{" + "date=" + date + '}';
    }

}
