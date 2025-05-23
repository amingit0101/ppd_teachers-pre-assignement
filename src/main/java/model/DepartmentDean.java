package model;


public class DepartmentDean {
	private int ID;
	private  Persone P=new Persone();
	private User U=new User();
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public Persone getP() {
		return P;
	}
	public void setP(Persone p) {
		P = p;
	}
	public User getU() {
		return U;
	}
	public void setU(User u) {
		U = u;
	} 
}
