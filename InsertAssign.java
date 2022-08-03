package JDBCAssignment;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import ExceptionHandleJDBC.StudentAlreadyExists;

public class InsertAssign {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb");

			PreparedStatement pstmt = conn.prepareStatement("insert into student values (?,?,?,?,?,?,?,?)");
			System.out.println("Enter data of the student");
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Roll no ------ It is Should be Unique");
			int rno = sc.nextInt();
			
			System.out.println("Enter Student Name");
			String sname = sc.next();
			
			System.out.println("Enter Date of birth in dd-mm-yyyy format");
			
			String dob = sc.next();
			Date date = Date.valueOf(dob);
			
			System.out.println("Enter Physics Marks");
			int phy = sc.nextInt();
			
			System.out.println("Enter Chemistry Marks");
			int chem = sc.nextInt();
			
			System.out.println("Enter maths Marks");
			int maths = sc.nextInt();
			
			// System.out.println("Enter Total Marks");
			int total = phy+chem+maths;
			
			//System.out.println("Enter Grade");
			System.out.println("Your total out of 300 is "+total);
			System.err.println();
			float avg = total/3;
			String grade;
			System.out.println("Your average is "+avg);
			System.out.println();
			if(avg> 90)
			{
				grade = "A+";
			}else if (avg <90 && avg >80) {
				grade ="A";
				System.out.println("Your Grade is "+grade);
			}else if (avg <80 && avg >70) {
				grade ="B";
				System.out.println("Your Grade is "+grade);
			}else if (avg <70 && avg >60) {
				grade ="C";
				System.out.println("Your Grade is "+grade);
			}else if (avg <60 && avg >50) {
				grade ="D";
				System.out.println("Your Grade is "+grade);
			}else if (avg <50 && avg >40) {
				grade ="E";
				System.out.println("Your Grade is "+grade);
			}else {
				grade ="F";
				System.out.println("Your Grade is "+grade+" And you are failed");
			}
			// String grade = sc.next();
			
			pstmt.setInt(1,rno);
			pstmt.setString(2,sname);
			pstmt.setDate(3,date);
			pstmt.setInt(4,phy);
			pstmt.setInt(5,chem);
			pstmt.setInt(6,maths);
			pstmt.setInt(7,total);
			pstmt.setString(8,grade);
			
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from student where rollno ="+rno);
			if(rs.next())
			{
				StudentAlreadyExists stAlready = new StudentAlreadyExists("Student Already Exists");
				throw stAlready;
			}else {
				pstmt.executeUpdate();
				ResultSet rs1 = stmt.executeQuery("select * from student");
				System.out.println("-----------List of all Students after Insertion---------------");
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
			}
			
			pstmt.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			}

}
