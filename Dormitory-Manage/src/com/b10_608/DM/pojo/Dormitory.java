package com.b10_608.DM.pojo;

public class Dormitory {
    private int dno;
    private String dname;
    private String dphone;
    private int maxpeople;
    private int nowpeople;
    
    
	public Dormitory() {
		super();
	}
	
	
	public int getDno() {
		return dno;
	}
	public void setDno(int dno) {
		this.dno = dno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDphone() {
		return dphone;
	}
	public void setDphone(String dphone) {
		this.dphone = dphone;
	}
	public int getMaxpeople() {
		return maxpeople;
	}
	public void setMaxpeople(int maxpeople) {
		this.maxpeople = maxpeople;
	}
	public int getNowpeople() {
		return nowpeople;
	}
	public void setNowpeople(int nowpeople) {
		this.nowpeople = nowpeople;
	}
	
	@Override
	public String toString() {
		return "Dormitory [dno=" + dno + ", dname=" + dname + ", dphone=" + dphone + ", maxpeople=" + maxpeople
				+ ", nowpeople=" + nowpeople + "]";
	}
    
	
}
