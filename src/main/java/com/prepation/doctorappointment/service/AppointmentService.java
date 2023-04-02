/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prepation.doctorappointment.service;

import com.prepation.doctorappointment.Driver;
import com.prepation.doctorappointment.model.Appointment;
import com.prepation.doctorappointment.model.Day;
import com.prepation.doctorappointment.model.Doctor;
import com.prepation.doctorappointment.model.Patient;
import com.prepation.doctorappointment.model.Slot;
import com.prepation.doctorappointment.model.User;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author NMSLAP570
 */
public class AppointmentService implements IAppointmentService {

    @Override
    public Doctor registerDoctor(String name) {
        System.out.println("Registering a new Doctor : " + name);
        Doctor doctor = new Doctor(name);
        return doctor;
    }

    @Override
    public Patient registerPatient(String name) {
        System.out.println("Registering a new Patient : " + name);
        Patient patient = new Patient(name);
        return patient;
    }

    @Override
    public Appointment declareAvailability(String doctorName, Date date, Integer startHour) {
        System.out.println("Trying to declare doctors availability | the doctor : " + doctorName + " | "
                + date + " | start hour : " + startHour);
        Doctor doctor = Driver.applicationContext.getDoctorList().get(Driver.applicationContext.getDoctorList().indexOf(new Doctor(doctorName)));
        Day temp = new Day(date);
        Day day = Driver.applicationContext.getDayList().get(Driver.applicationContext.getDayList().indexOf(temp));
        Slot slot = day.getSlotList().get(day.getSlotList().indexOf(new Slot(startHour, day)));

        // check if the slot is already booked by this doctor
        if (slot.getAppointmentList().contains(new Appointment(doctor, slot))) {
            System.out.println("The slot is already booked by the doctor : " + doctorName + " | "
                    + date + " | start hour : " + startHour);
            return null;
        }

        Appointment appointment = new Appointment(doctor, slot);
        slot.getAppointmentList().add(appointment);

        doctor.addOpenAppointment(appointment);

        return appointment;
    }

    @Override
    public List<Appointment> viewAvailableSlot(List<Doctor> doctorList) {
        System.out.println("View available slots for all the doctors");
        List<Appointment> allDoctorAppointmentList = new LinkedList<>();
        for (Doctor eachDoctor : doctorList) {
            allDoctorAppointmentList.addAll(eachDoctor.getOpenAppointmentList());
        }
        Comparator<Appointment> startHourAscComparator = new Comparator<Appointment>() {
            @Override
            public int compare(Appointment o1, Appointment o2) {
                if (o1.getSlot().getStartHour() < o2.getSlot().getStartHour()) {
                    return -1;
                } else if (o1.getSlot().getStartHour() > o2.getSlot().getStartHour()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };
        Collections.sort(allDoctorAppointmentList, startHourAscComparator);

        for (Appointment eachAppointment : allDoctorAppointmentList) {
            System.out.println(eachAppointment);
        }
        System.out.println("Ending View of available slots for all the doctors");
        return allDoctorAppointmentList;
    }

    @Override
    public Appointment bookAppointment(String patientName, String doctorName, Date date, Integer startHour) {
        System.out.println("Trying to book appointment for patient : " + patientName + " | doctor : " + doctorName + " | date "
                + date.toString() + " | time : " + startHour);
        Doctor doctor = Driver.applicationContext.getDoctorList().get(Driver.applicationContext.getDoctorList().indexOf(new Doctor(doctorName)));
        Patient patient = Driver.applicationContext.getPatientList().get(Driver.applicationContext.getPatientList().indexOf(new Patient(patientName)));
        // check if the doctor has been available for the slot
        if (doctor.getOpenAppointmentList().contains(new Appointment(doctor, new Slot(startHour, new Day(date))))) {
            Appointment availableDoctorAppointment = doctor.getOpenAppointmentList().get(
                    doctor.getOpenAppointmentList().indexOf(new Appointment(doctor, new Slot(startHour, new Day(date))))
            );
            availableDoctorAppointment.setPatient(patient);
            patient.addBookedAppointment(availableDoctorAppointment);

            // add it in doctors booked appointment
            doctor.addBookedAppointment(availableDoctorAppointment);

            // remove it from doctors open appointment
            doctor.getOpenAppointmentList().remove(new Appointment(doctor, new Slot(startHour, new Day(date))));

            return availableDoctorAppointment;
        } else {
            System.out.println("The mentioned doctor : " + doctorName + " is not availble for the slot on "
                    + date.toString() + " at time : " + startHour);
            return null;
        }
    }

    @Override
    public void viewBookedAppointment(User user) {
        System.out.println("view Booked appointment by user : " + user.getName());
        for (Appointment eachAppointment : user.getBookedAppointment()) {
            System.out.println(eachAppointment);
        }
        System.out.println("Ending view Booked appointment by user : " + user.getName());
    }

    @Override
    public void cancelAppointment(String patientName, Date date, Integer startHour) {
        System.out.println("trying to cancel appointment by patient : " + patientName + " | date : "
                + date + " | start hour : " + startHour);

        Patient patient = Driver.applicationContext.getPatientList().get(Driver.applicationContext.getPatientList().indexOf(new Patient(patientName)));

        Appointment appointmentToBeRemoved = null;
        for (Appointment eachAppointment : patient.getBookedAppointment()) {
            Slot slot = new Slot(startHour, new Day(date));
            if (eachAppointment.getSlot().equals(slot)) {
                eachAppointment.setPatient(null);
                appointmentToBeRemoved = eachAppointment;
            }
        }

        if (appointmentToBeRemoved != null) {
            Doctor doctor = appointmentToBeRemoved.getDoctor();
            patient.getBookedAppointment().remove(appointmentToBeRemoved);

            // remove it from booked appointment
            doctor.getBookedAppointment().remove(appointmentToBeRemoved);
            // add it in the open appointment list
            doctor.getOpenAppointmentList().add(appointmentToBeRemoved);
        }
        System.out.println("cancelled appointment by patient : " + patientName + " | date : "
                + date + " | start hour : " + startHour);
    }

}
