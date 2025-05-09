package model;

import java.sql.Date;
import java.util.ArrayList;



public class Formation {
	int ID;
	String name;
	Date creation_date;
	int semesters;
	ArrayList<Module> modules=new ArrayList<Module>();
}
