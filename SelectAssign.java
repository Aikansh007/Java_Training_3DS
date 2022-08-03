package JDBCAssignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import ExceptionHandleJDBC.StudentNotFoundException;

public class SelectAssign {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
			
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb");
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from student");
			System.out.println("-----------List of all Students---------------");
			while(rs.next())
			{
				
				System.out.println("Roll no : "+rs.getInt(1));
				System.out.println("Student Name : "+rs.getString(2));
				System.out.println("Date of Birth : "+rs.getString(3));
				System.out.println("Physics : "+rs.getInt(4));
				System.out.println("Chemistry : "+rs.getInt(5));
				System.out.println("Maths : "+rs.getInt(6));
				System.out.println("Total : "+rs.getInt(7));
				System.out.println("Grade : "+rs.getString(8));
				System.out.println("--------------------------");
			}
			
			System.out.println("Search Student of the basis of Roll no");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the Roll No--");
			int rno = sc.nextInt();
			ResultSet rs1 = stmt.executeQuery("select * from student where rollno ="+rno);
			System.out.println("-----------List of all Students---------------");
			if(rs1.next())
			{
				
				System.out.println("Roll no : "+rs1.getInt(1));
				System.out.println("Student Name : "+rs1.getString(2));
				System.out.println("Date of Birth : "+rs1.getString(3));
				System.out.println("Physics : "+rs1.getInt(4));
				System.out.println("Chemistry : "+rs1.getInt(5));
				System.out.println("Maths : "+rs1.getInt(6));
				System.out.println("Total : "+rs1.getInt(7));
				System.out.println("Grade : "+rs1.getString(8));
				System.out.println("--------------------------");
			}
			else {
				StudentNotFoundException stNotFound = new StudentNotFoundException("Student is not present");
				throw stNotFound;
			}
			rs.close(); 
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
