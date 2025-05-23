package model;

import java.sql.Date;
import java.util.ArrayList;



public class Formation {
	private int ID;
	private String name;
	private Date creation_date;
	private int semesters;
	private ArrayList<Module> modules=new ArrayList<Module>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Module> getModules() {
		return modules;
	}
	public void setModules(ArrayList<Module> modules) {
		this.modules = modules;
	}
	public Date getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getSemesters() {
		return semesters;
	}
	public void setSemesters(int semesters) {
		this.semesters = semesters;
	}
}
