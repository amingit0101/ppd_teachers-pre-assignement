package model;

import java.sql.Date;
import java.util.ArrayList;



public class Formation {
	public int ID;
	public String name;
	public Date creation_date;
	public int semesters;
	public ArrayList<Module> modules=new ArrayList<Module>();
}
