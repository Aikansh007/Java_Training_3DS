package JDBCAssignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import ExceptionHandleJDBC.EmployeeNotFoundException;

public class DeleteAssign {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb");
			
			Statement st = conn.createStatement();
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter the roll No to Delete");
			int rno = sc.nextInt();
			ResultSet rs = st.executeQuery("select * from student where rollno = "+rno);
			
			if(rs.next())
			{
				PreparedStatement pst = conn.prepareStatement("DELETE FROM STUDENT WHERE ROLLNO=?");
				
				pst.setInt(1, rno);
		 	    pst.executeUpdate();
		 	    
		 	    Statement stmt = conn.createStatement();
				ResultSet rs1 = stmt.executeQuery("select * from student");
				System.out.println("-----------List of all Students after Updation---------------");
				while(rs1.next())
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
				pst.close();
				rs1.close(); 
			}else {
				EmployeeNotFoundException empNotFound = new EmployeeNotFoundException("Employee Not Found");
				throw empNotFound;
			}
			
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
