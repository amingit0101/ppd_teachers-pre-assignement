package model;

import java.sql.Date;
import java.util.ArrayList;


public class Department {
	private int ID;
	private String name;
	private DepartmentDean DD=new DepartmentDean();
	private ArrayList<Teacher> Teachers=new ArrayList<Teacher>();
	private Date creation_date;
	private ArrayList<Formation> Fs=new ArrayList<Formation>();
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public DepartmentDean getDD() {
		return DD;
	}
	public void setDD(DepartmentDean dD) {
		DD = dD;
	}
	public ArrayList<Teacher> getTeachers() {
		return Teachers;
	}
	public void setTeachers(ArrayList<Teacher> teachers) {
		Teachers = teachers;
	}
	public Date getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}
	public ArrayList<Formation> getFs() {
		return Fs;
	}
	public void setFs(ArrayList<Formation> fs) {
		Fs = fs;
	}
}
