
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;

public class HashSetTest {
	public static void main(String[] args) {

		Book book1 = new Book("Wings of Fire","ABN011", 400,"II",890, "ABPJ Abdul Kalam");
		Book book2 = new Book("JAVA","SBIN0001",1000,"IV",300, "Abhishek lalwani");
		Book book3 = book1;
		Book book4 = new Book("She Stood By Me","WEN007", 356,"V",234, "ABPJ Abdul Kalam");
		
		System.out.println("book1 : "+book1);
		System.out.println("book2 : "+book2);
		System.out.println("book3 : "+book3);
		System.out.println("book4 : "+book4);

		System.out.println("----");
		
		System.out.println("book1 : "+book1.hashCode());
		System.out.println("book2 : "+book2.hashCode());
		System.out.println("book3 : "+book3.hashCode());
		System.out.println("book4 : "+book4.hashCode());

		
		HashSet<Book> bookShelf = new HashSet<Book>();
		
		System.out.println("Adding book1 ");
		bookShelf.add(book1);
		
		System.out.println("Adding book2 ");
		bookShelf.add(book2);

		System.out.println("Adding book3 ");
		bookShelf.add(book3);
		
		System.out.println("Adding book4 ");
		bookShelf.add(book4);
			
		
		for (Book book : bookShelf) {
			System.out.println("The Book : "+book);
		}
	}
}

  class Book implements Serializable
{
	String title;
	String bookNo;
	int prize;
	String edition;
	int noOfPages;
	String bookAuthor;
	

	
	public Book(String title, String bookNo, int prize, String edition, int noOfPages, String bookAuthor) {
		super();
		this.title = title;
		this.bookNo = bookNo;
		this.prize = prize;
		this.edition = edition;
		this.noOfPages = noOfPages;
		this.bookAuthor = bookAuthor;
	}

	

	@Override
	public String toString() {
		return "Book [title=" + title + ", bookNo=" + bookNo + ", prize=" + prize + ", edition=" + edition
				+ ", noOfPages=" + noOfPages + ", bookAuthor=" + bookAuthor + "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(bookAuthor, bookNo, edition, noOfPages, prize, title);
	}


//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Book other = (Book) obj;
//		return Objects.equals(bookAuthor, other.bookAuthor) && Objects.equals(bookNo, other.bookNo)
//				&& Objects.equals(edition, other.edition) && noOfPages == other.noOfPages && prize == other.prize
//				&& Objects.equals(title, other.title);
//	}


	
	
}