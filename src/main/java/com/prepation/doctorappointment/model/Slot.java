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
public class Slot {

    private Integer startHour;

    private Integer endHour;

    private String meridiem;

    private Day day;

    private List<Appointment> appointmentList;

    public Slot(Integer startHour, Day day) {
        this.startHour = startHour;
        this.day = day;
        this.endHour = startHour + 1;
        this.meridiem = this.startHour < 12 ? "AM" : "PM";
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.startHour);
        hash = 37 * hash + Objects.hashCode(this.day);
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
        final Slot other = (Slot) obj;
        if (!Objects.equals(this.startHour, other.startHour)) {
            return false;
        }
        if (!Objects.equals(this.day, other.day)) {
            return false;
        }
        return true;
    }

    public List<Appointment> getAppointmentList() {
        if (this.appointmentList == null) {
            this.appointmentList = new LinkedList<>();
        }
        return appointmentList;
    }
    
    public List<Appointment> addAppointment(Appointment appointment) {
        if (this.appointmentList == null) {
            this.appointmentList = new LinkedList<>();
        }
        appointmentList.add(appointment);
        return appointmentList;
    }

    public Integer getStartHour() {
        return startHour;
    }

    @Override
    public String toString() {
        return "Slot{" + "startHour=" + startHour + ", endHour=" + endHour + ", meridiem=" + meridiem + ", day=" + day + '}';
    }

}
