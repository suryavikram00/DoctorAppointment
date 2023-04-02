/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prepation.doctorappointment.model;

import java.util.Objects;

/**
 *
 * @author NMSLAP570
 */
public class Appointment {
    
    private Patient patient;
    
    private Doctor doctor;
    
    private Slot slot;
    
    

    public Appointment(Doctor doctor, Slot slot) {
        this.doctor = doctor;
        this.slot = slot;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.doctor);
        hash = 67 * hash + Objects.hashCode(this.slot);
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
        final Appointment other = (Appointment) obj;
        if (!Objects.equals(this.doctor, other.doctor)) {
            return false;
        }
        if (!Objects.equals(this.slot, other.slot)) {
            return false;
        }
        return true;
    }

    public Slot getSlot() {
        return slot;
    }

    @Override
    public String toString() {
        return "Appointment{" + "patient=" + patient + ", doctor=" + doctor + ", slot=" + slot + '}';
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }
    
    
    
}
