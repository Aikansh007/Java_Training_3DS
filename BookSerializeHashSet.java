
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.HashSet;

public class BookSerializeHashSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book b1 = new Book("Wings of Fire","ABN011", 400,"II",890, "ABPJ Abdul Kalam");
		Book b2 = new Book("JAVA","SBIN0001",1000,"IV",300, "Abhishek lalwani");
		Book b3 = new Book("She Stood By Me","WEN007", 356,"V",234, "Tarun Vikas");
		
		HashSet<Book> bookShelf = new HashSet<Book>();
		bookShelf.add(b1);
		bookShelf.add(b2);
		bookShelf.add(b3);
		//bookShelf.add(book4);
		
		System.out.println("Objects created...");
		try {
			FileOutputStream fout  = new FileOutputStream("D:\\work_DSI\\java training\\myJavaWorkspace\\SerializeAssign.txt");
			System.out.println("File is ready");
			
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			System.out.println("Object stream is ready");
			
			System.out.println("Trying to store the object...");
			
		
			oos.writeObject(bookShelf);
		
			System.out.println("Object stored....");
			
			oos.close();
			fout.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}