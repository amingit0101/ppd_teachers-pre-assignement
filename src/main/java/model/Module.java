package model;

public class Module {
	private int ID;
	private String name;
	private String code;
	private int coeficient;
	private int semester;
	private int courses_in_week;
	private int td_in_week;
	private int tp_in_week;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCourses_in_week() {
		return courses_in_week;
	}
	public void setCourses_in_week(int courses_in_week) {
		this.courses_in_week = courses_in_week;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public int getCoeficient() {
		return coeficient;
	}
	public void setCoeficient(int coeficient) {
		this.coeficient = coeficient;
	}
	public int getTd_in_week() {
		return td_in_week;
	}
	public void setTd_in_week(int td_in_week) {
		this.td_in_week = td_in_week;
	}
	public int getTp_in_week() {
		return tp_in_week;
	}
	public void setTp_in_week(int tp_in_week) {
		this.tp_in_week = tp_in_week;
	}
}
