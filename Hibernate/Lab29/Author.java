package com.hibernate;

import java.util.Date;
import java.util.List;
import java.util.Set;

//Entity
public class Author {
	//Id
	//GeneratedValue(strategy=GenerationType.AUTO)
	private int aid;
	private String aname;
	private String email;
	private long phone;
	private Date dob;

	//ElementCollection
	//JoinTable(name="qualis", joinColumns=//JoinColumn(name="aid"))
	private List<String> qualis;

	//ElementCollection
	//JoinTable(name="exps", joinColumns=//JoinColumn(name="aid"))
	private Set<String> exps;

	//ManyToMany
	//JoinTable(name="books_authors", joinColumns={
		//JoinColumn(name="aid")}, inverseJoinColumns={
			//JoinColumn(name="bid")})
	private Set<Book> books;

	public Author(){}
	public Author(String aname, String email, long phone, Date dob,
			List<String> qualis, Set<String> exps) {
		super();
		this.aname = aname;
		this.email = email;
		this.phone = phone;
		this.dob = dob;
		this.qualis = qualis;
		this.exps = exps;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public List<String> getQualis() {
		return qualis;
	}
	public void setQualis(List<String> qualis) {
		this.qualis = qualis;
	}
	public Set<String> getExps() {
		return exps;
	}
	public void setExps(Set<String> exps) {
		this.exps = exps;
	}
	public Set<Book> getBooks() {
		return books;
	}
	public void setBooks(Set<Book> books) {
		this.books = books;
	}


}
