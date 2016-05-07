package com.jlcindia.spring;

public class DataSource {
	
	private String driverClass, url, username, password;
	private int min, max, timeout;
	
	public String getDriverClass(){
		return driverClass;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}
	
	@Override
	public String toString() {
		return driverClass+"\t"+url+"\t"+username+"\t"+password+"\t"+min+"\t"+max+"\t"+timeout ;
	}
	
}
