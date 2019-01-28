package com.b10_608.DM.pojo;

public class Staff {

	private String staffno;
	private int dno;
	private String staffname;
	private String sex;
	private String duty;
	private String mobilephone;
	private int age;
	
	public Staff() {
		super();
	}

	public String getStaffno() {
		return staffno;
	}

	public void setStaffno(String staffno) {
		this.staffno = staffno;
	}

	public int getDno() {
		return dno;
	}

	public void setDno(int dno) {
		this.dno = dno;
	}

	public String getStaffname() {
		return staffname;
	}

	public void setStaffname(String staffname) {
		this.staffname = staffname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getMobilephone() {
		return mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Staff [staffno=" + staffno + ", dno=" + dno + ", staffname=" + staffname + ", sex=" + sex + ", duty="
				+ duty + ", mobilephone=" + mobilephone + ", age=" + age + "]";
	}
	
}
