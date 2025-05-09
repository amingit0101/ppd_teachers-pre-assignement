package model;

import java.sql.Date;
import java.util.ArrayList;


public class Department {
	int ID;
	String name;
	DepartmentDean DD=new DepartmentDean();
	ArrayList<Teacher> Teachers=new ArrayList<Teacher>();
	Date creation_date;
	ArrayList<Formation> Fs=new ArrayList<Formation>();
}
