package bookServ;

public class Book {
	String bid;
	String bname;
	String author;
	String publication;
	double cost;
	int edition;
	
	public Book(){}
	public Book(String bname, String author, String publication, double cost, int edition){
		this.bname = bname;
		this.author = author;
		this.publication = publication;
		this.cost = cost;
		this.edition = edition;
	}
	
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublication() {
		return publication;
	}
	public void setPublication(String publication) {
		this.publication = publication;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public int getEdition() {
		return edition;
	}
	public void setEdition(int edition) {
		this.edition = edition;
	}
	public String toString(){
		return " "+bid+" "+bname+" "+author+" "+publication+" "+cost+" "+edition; 
	}
	
	
}
