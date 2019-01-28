package com.b10_608.DM.pojo;

public class Utilities {
	
	private int uno;
	private int dno;
	private int month;
	private double wcost;
	private double ecost;
	
	public Utilities() {
		super();
	}

	public int getUno() {
		return uno;
	}

	public void setUno(int uno) {
		this.uno = uno;
	}

	public int getDno() {
		return dno;
	}

	public void setDno(int dno) {
		this.dno = dno;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public double getWcost() {
		return wcost;
	}

	public void setWcost(double wcost) {
		this.wcost = wcost;
	}

	public double getEcost() {
		return ecost;
	}

	public void setEcost(double ecost) {
		this.ecost = ecost;
	}

	@Override
	public String toString() {
		return "Utilities [uno=" + uno + ", dno=" + dno + ", month=" + month + ", wcost=" + wcost + ", ecost=" + ecost
				+ "]";
	}
	
	

}
