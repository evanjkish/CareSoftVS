package com.caresoft.clinicapp;

public interface HIPAACompliantUser {
	abstract boolean assignPIN(int pin);
    abstract boolean accessAuthorized(Integer confirmedAuthID);
}
