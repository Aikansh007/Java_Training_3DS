
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashSet;


public class BookDeSerializeHashSet  {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Book> bookShelf = null;
		System.out.println("Object is null...");
		try {
			FileInputStream fin  = new FileInputStream("D:\\work_DSI\\java training\\myJavaWorkspace\\SerializeAssign.txt");
			System.out.println("File is ready..for reading.....");
			
			ObjectInputStream ois = new ObjectInputStream(fin);
			System.out.println("Object stream is ready...for reading object.");
			
			System.out.println("Trying to retrieve the object...");
			bookShelf = (HashSet<Book>) ois.readObject();
			System.out.println("Object retrieved....");
			
			System.out.println("-----------HashSet is : ------------");
			System.out.println(bookShelf);
			ois.close();
			fin.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
