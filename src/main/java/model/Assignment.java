package model;

import java.time.LocalDate;

import java.util.ArrayList;



public class Assignment {
	private int ID;
	private LocalDate date;
	private ArrayList<ChoosenModule> choises=new ArrayList<ChoosenModule>();
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public ArrayList<ChoosenModule> getChoises() {
		return choises;
	}
	public void setChoises(ArrayList<ChoosenModule> choises) {
		this.choises = choises;
	}
}
