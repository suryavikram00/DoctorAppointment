/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prepation.doctorappointment.model;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author NMSLAP570
 */
public class Doctor extends User{
    
    private List<Appointment> openAppointmentList;

    public Doctor(String name) {
        super(name);
    }
    
    public List<Appointment> addOpenAppointment (Appointment appointment) {
        if(this.openAppointmentList == null){
            this.openAppointmentList = new LinkedList<>();
        }
        this.openAppointmentList.add(appointment);
        return this.openAppointmentList;
    } 

    public List<Appointment> getOpenAppointmentList() {
        if(this.openAppointmentList == null){
            this.openAppointmentList = new LinkedList<>();
        }
        return openAppointmentList;
    }
    
    
}
