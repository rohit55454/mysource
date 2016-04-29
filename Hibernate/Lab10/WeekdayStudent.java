package com.hibernate;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="wdstudents")

public class WeekdayStudent extends CurrentStudent{
	private String qualifaication;
	private String percentage;
	private int yop;
	
	public WeekdayStudent(){}
	
	
	
	public WeekdayStudent(String sname, String city, String status,
			double totalfee, double feebal, String timings, String branch,
			String qualifaication, String percentage, int yop) {
		super(sname, city, status, totalfee, feebal, timings, branch);
		this.qualifaication = qualifaication;
		this.percentage = percentage;
		this.yop = yop;
	}



	public String getQualifaication() {
		return qualifaication;
	}
	public void setQualifaication(String qualifaication) {
		this.qualifaication = qualifaication;
	}
	public String getPercentage() {
		return percentage;
	}
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
	public int getYop() {
		return yop;
	}
	public void setYop(int yop) {
		this.yop = yop;
	}
	
	@Override
	public String toString() {
		return super.toString()+", "+qualifaication+", "+percentage+", "+yop;
	}
	
	
}
