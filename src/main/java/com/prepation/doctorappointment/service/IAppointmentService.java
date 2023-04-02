/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.prepation.doctorappointment.service;

import com.prepation.doctorappointment.model.Appointment;
import com.prepation.doctorappointment.model.Doctor;
import com.prepation.doctorappointment.model.Patient;
import com.prepation.doctorappointment.model.User;
import java.util.Date;
import java.util.List;

/**
 *
 * @author NMSLAP570
 */
public interface IAppointmentService {
    
    public Doctor registerDoctor(String name);
    
    public Patient registerPatient(String name);
    
    public Appointment declareAvailability(String doctorName, Date date, Integer startHour );
    
    public List<Appointment> viewAvailableSlot(List<Doctor> doctorList);
    
    public Appointment bookAppointment(String patientName, String doctorName, Date date, Integer startHour);
    
    public void cancelAppointment(String patientName, Date date, Integer startHour);
    
    public void viewBookedAppointment(User user);
    
}
