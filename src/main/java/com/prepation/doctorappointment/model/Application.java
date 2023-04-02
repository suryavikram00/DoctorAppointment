/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prepation.doctorappointment.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author NMSLAP570
 */
public class Application {

    private List<Doctor> doctorList;

    private List<Patient> patientList;

    private List<Day> dayList;

    public Application(Date date) {
        Day day = new Day(date);
        if (dayList == null) {
            dayList = new LinkedList<>();
        }
        dayList.add(day);
    }

    public Day addDay(Date date) {

        Day day = new Day(date);

        if (this.dayList.contains(day)) {
            System.out.println("The date " + date + " is already added ");
            return null;
        }
        if (dayList == null) {
            dayList = new LinkedList<>();
        }
        dayList.add(day);
        return day;
    }

    public List<Doctor> addDoctor(Doctor doctor) {
        if (doctorList == null) {
            doctorList = new LinkedList<>();
        }
        doctorList.add(doctor);
        return doctorList;
    }

    public List<Doctor> getDoctorList() {
        if (doctorList == null) {
            doctorList = new LinkedList<>();
        }

        return doctorList;
    }

    public List<Patient> addPatient(Patient patient) {
        if (patientList == null) {
            patientList = new LinkedList<>();
        }
        patientList.add(patient);
        return patientList;
    }

    public List<Patient> getPatientList() {
        if (patientList == null) {
            patientList = new LinkedList<>();
        }
        return patientList;
    }

    public List<Day> getDayList() {
        return dayList;
    }

}
