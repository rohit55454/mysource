package com.jlcindia.spring;

public class Fee {
	double totalFee, feePaid, feeBal;

	public Fee(double totalFee, double feePaid, double feeBal) {
		super();
		this.totalFee = totalFee;
		this.feePaid = feePaid;
		this.feeBal = feeBal;
	}

	public double getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(double totalFee) {
		this.totalFee = totalFee;
	}

	public double getFeePaid() {
		return feePaid;
	}

	public void setFeePaid(double feePaid) {
		this.feePaid = feePaid;
	}

	public double getFeeBal() {
		return feeBal;
	}

	public void setFeeBal(double feeBal) {
		this.feeBal = feeBal;
	}

	
}
