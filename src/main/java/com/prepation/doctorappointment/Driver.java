/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prepation.doctorappointment;

import com.prepation.doctorappointment.model.Application;
import com.prepation.doctorappointment.model.Doctor;
import com.prepation.doctorappointment.model.Patient;
import com.prepation.doctorappointment.model.utility.DateUtility;
import com.prepation.doctorappointment.service.AppointmentService;
import com.prepation.doctorappointment.service.IAppointmentService;
import java.util.Date;

/**
 *
 * @author NMSLAP570
 */
public class Driver {

    public static final Application applicationContext = new Application(DateUtility.getCurrentDate());

    public static void main(String args[]) {

        IAppointmentService appointmentService = new AppointmentService();

        applicationContext.addDoctor(appointmentService.registerDoctor("Curious"));
        applicationContext.addDoctor(appointmentService.registerDoctor("Dreadful"));

        applicationContext.addPatient(appointmentService.registerPatient("PatientA"));
        applicationContext.addPatient(appointmentService.registerPatient("PatientB"));

        appointmentService.declareAvailability("Curious", DateUtility.getCurrentDate(), 9);        
        appointmentService.declareAvailability("Curious", DateUtility.getCurrentDate(), 16);
        appointmentService.declareAvailability("Curious", DateUtility.getCurrentDate(), 12);
        
        appointmentService.viewAvailableSlot(applicationContext.getDoctorList());
        
        appointmentService.bookAppointment("PatientA", "Curious", DateUtility.getCurrentDate(), 12);
        
        appointmentService.viewAvailableSlot(applicationContext.getDoctorList());
        
        appointmentService.cancelAppointment("PatientA", DateUtility.getCurrentDate(), 12);
        
        appointmentService.viewAvailableSlot(applicationContext.getDoctorList());
        
        appointmentService.bookAppointment("PatientB", "Curious", DateUtility.getCurrentDate(), 12);
        
        appointmentService.viewBookedAppointment(Driver.applicationContext.getPatientList().get(Driver.applicationContext.getPatientList().indexOf(new Patient("PatientA"))));
        appointmentService.viewBookedAppointment(Driver.applicationContext.getPatientList().get(Driver.applicationContext.getPatientList().indexOf(new Patient("PatientB"))));
        
    }

}
