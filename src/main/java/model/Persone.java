package model;

import java.sql.Date;



public class Persone {
	public int ID;
	public String name;
	public String phone;
	public Date birthday;
	public String email;
	public Diploma diploma=new Diploma();  
}
