package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {
	
	private ArrayList<String> patientNotes;

	
	public Physician(Integer id) {
		super(id);
		this.id = id;
	}
	
	//CompliantUser:
	@Override
	public boolean assignPIN(int newPIN) {
		int pinLength = String.valueOf(newPIN).length();
		if (pinLength < 4) {
			return false;
		}
		this.pin = newPIN;
		return true;
	}
	
	@Override
	public boolean accessAuthorized(Integer id) {
		if( id == this.getId()) {
			return true;
		} else {
			return false;			
		}
	}
	
	public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }
	
	public Integer getEmployeeID() {
		return id;
	}

	public void setEmployeeID(Integer id) {
		this.id = id;
	}

	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}
	
	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}
    

}
