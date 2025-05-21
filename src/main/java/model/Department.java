package model;

import java.sql.Date;
import java.util.ArrayList;


public class Department {
	public int ID;
	public String name;
	public DepartmentDean DD=new DepartmentDean();
	public ArrayList<Teacher> Teachers=new ArrayList<Teacher>();
	public Date creation_date;
	public ArrayList<Formation> Fs=new ArrayList<Formation>();
}
