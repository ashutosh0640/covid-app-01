package com.vaccinationApp.model;

public enum Slot {
	
	slot1("8 A.M - 9 A.M"),
	slot2("9 A.M - 10 A.M"),
	slot3("10 A.M - 11 A.M"),
	slot4("11 A.M - 12 P.M"),
	slot5("12 P.M - 1 P.M"),
	slot6("1 P.M - 2 P.M"),
	slot7("2 P.M - 3 P.M"),
	slot8("3 P.M - 4 P.M"),
	slot9("4 P.M - 5 P.M");
	
	private final String timeSlot;
	
	Slot(String timeSlot){
		this.timeSlot=timeSlot;
	}


	public String getTimeSlot() {
		return timeSlot;
	}
	
	
}
