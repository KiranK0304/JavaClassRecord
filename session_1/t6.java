import java.util.Scanner;

public class t6{
	public static void main(String[] args) {

		Book book1 = new Book();
		Book book2 = new Book();

//		book1.getTitle();

		book1.setBook();
		book2.setBook();

		BookUtility.displayBook(book1);
		BookUtility.displayBook(book2);
//		BookUtility util = new BookUtility();
	}
}

class Book {

	private int bookID;
	private String title;
	private String author;

	public void setBook() {
		Scanner sc = new Scanner(System.in);

		System.out.print("enter id: ");
		bookID = sc.nextInt();
		sc.nextLine();

		System.out.print("enter title: ");
		title = sc.nextLine();

		System.out.print("enter author: ");
		author = sc.nextLine();

	}

	public int getBookID() {
		return bookID;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}
}

class BookUtility {

	public static void displayBook(Book b) {

		System.out.println("----- Book Details -----");
		System.out.println("Book ID : " + b.getBookID());
		System.out.println("Title   : " + b.getTitle());
		System.out.println("Author  : " + b.getAuthor());
		System.out.println();
	}
}