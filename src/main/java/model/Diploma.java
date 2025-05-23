package model;

public class Diploma {
	private int ID;
	private String diploma_name;
	public int getId(){
		return ID;
	}
	public String getname(){
		return diploma_name;
	}
	public void setId(int ID){
		this.ID=ID;
	}
	public void setname(String diploma_name){
		this.diploma_name=diploma_name;
	}
}
