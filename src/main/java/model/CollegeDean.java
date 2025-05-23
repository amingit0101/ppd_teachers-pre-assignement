package model;



public class CollegeDean {
	private int ID;
	private Persone P=new Persone();
	private  User U=new User();
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
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	} 
}
