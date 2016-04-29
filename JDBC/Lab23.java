package bookServ;

import java.util.*;
public class Lab23 {
	public static void main(String[] args) {
		BookService bs = new BookService();

	
		//	VERIFY USER
		boolean valid = bs.verifyUser("rohit", "sachan");
		if(valid)
			System.out.println("login success !");
		else
			System.out.println("login failed");
	
		//	ADDING THE BOOK
		Book b = new Book("java", "sri", "jlc", 250, 4);
		boolean res = bs.addBook(b);
		if(res)
			System.out.println("added successfully");
		else
			System.out.println("not added");

		//	UPDATE BOOK
		Book bk = new Book("jdbc", "dande", "sd", 250, 5);
		bk.setBid("101");
		int a = bs.updateBook(bk);
		System.out.println("Book updated :"+a);

		//	DELETE BOOK
		int c = bs.deleteBook("102");
		System.out.println("book deleted : "+c);

		//	ACCESS BOOK BY ID
		System.out.println("ACCESS BOOK BY ID");
		Book bo = bs.getBookByBid("B-01");
		System.out.println(bo);

		//	ACCESS BOOK BY NAME
		System.out.println("ACCESS BOOK BY NAME");
		List<Book> l = bs.getBooksByName("java");
		for(Book b1 : l)
			System.out.println(b1);

		//	ACCESS BOOK BY AUTHOR
		System.out.println("ACCESS BOOK BY AUTHOR");
		List<Book> l1 = bs.getBooksByAuthor("sri");
		for(Book b1 : l1)
			System.out.println(b1);

		//	ACCESS BOOK BY cost
		System.out.println("ACCESS BOOK BY COST");
		List<Book> l2 = bs.getBooksByCost(250);
		for(Book b1 : l2)
			System.out.println(b1);


		//	ACCESS ALL BOOKS
		System.out.println("ACCESS BOOK BY BOOKS");
		List<Book> l3 = bs.getAllBooks();
		for(Book b1 : l3)
			System.out.println(b1);
	}
}



