package com.b10_608.DM.pojo;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Repair {

	private int rno;
	private int dno;
	private String reason;
	@JSONField(format="yyyy-MM-dd")
	private Date sdate;
	@JSONField(format="yyyy-MM-dd")
	private Date fdate;
	private double cost;
	
	public Repair() {
		super();
	}
	
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getDno() {
		return dno;
	}
	public void setDno(int dno) {
		this.dno = dno;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Date getSdate() {
		return sdate;
	}
	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}
	public Date getFdate() {
		return fdate;
	}
	public void setFdate(Date fdate) {
		this.fdate = fdate;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Repair [rno=" + rno + ", dno=" + dno + ", reason=" + reason + ", sdate=" + sdate + ", fdate=" + fdate
				+ ", cost=" + cost + "]";
	}
	
	
	
}
