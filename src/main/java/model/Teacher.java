package model;


public class Teacher {
	private int ID;
	private  Persone P=new Persone();
	private String status;
	private User U=new User(); 
	private Assignment A=new Assignment();
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Persone getP() {
		return P;
	}
	public void setP(Persone p) {
		P = p;
	}
	public Assignment getA() {
		return A;
	}
	public void setA(Assignment a) {
		A = a;
	}
	public User getU() {
		return U;
	}
	public void setU(User u) {
		U = u;
	}
}
