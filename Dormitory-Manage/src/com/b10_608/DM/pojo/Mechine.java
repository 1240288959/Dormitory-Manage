package com.b10_608.DM.pojo;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Mechine {

	private String mno;
	private String mname;
	@JSONField(format="yyyy-MM-dd")
	private Date sdate;
	@JSONField(format="yyyy-MM-dd")
	private Date fdate;
	private double cost;
	
	public Mechine() {
		super();
	}

	public String getMno() {
		return mno;
	}

	public void setMno(String mno) {
		this.mno = mno;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
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
		return "Mechine [mno=" + mno + ", mname=" + mname + ", sdate=" + sdate + ", fdate=" + fdate + ", cost=" + cost
				+ "]";
	}
	
	
}
