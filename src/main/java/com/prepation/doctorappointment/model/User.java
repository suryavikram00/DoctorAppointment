/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prepation.doctorappointment.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author NMSLAP570
 */
public class User {
    
    private String name;
    
    private List<Appointment> bookedAppointment;

    public User(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.name);
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
        final User other = (User) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    public List<Appointment> getBookedAppointment() {
        if(this.bookedAppointment == null){
            this.bookedAppointment = new LinkedList<>();
        }
        return bookedAppointment;
    }
    
    public List<Appointment> addBookedAppointment(Appointment appointment) {
        if(this.bookedAppointment == null){
            this.bookedAppointment = new LinkedList<>();
        }
        this.bookedAppointment.add(appointment);
        return bookedAppointment;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + '}';
    }
    
    
    
}
