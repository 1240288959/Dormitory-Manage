package com.b10_608.DM.pojo;

public class Student {
	
	private String sno;
	private int dno;
	private String sname;
	private String sex;
	private String major;
	private String mobilephone;
	
	public Student() {
		super();
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public int getDno() {
		return dno;
	}

	public void setDno(int dno) {
		this.dno = dno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getMobilephone() {
		return mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	@Override
	public String toString() {
		return "Student [sno=" + sno + ", dno=" + dno + ", sname=" + sname + ", sex=" + sex + ", major=" + major
				+ ", mobilephone=" + mobilephone + "]";
	}
	
	
	

}
