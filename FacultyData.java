package FacultyPackage;
import java.sql.*;

import java.util.Scanner;

public class FacultyData {

	public static void main(String[] args) {
		String s1;
		System.out.println("1 option for Show table");
		System.out.println("2 option for Insert 0r Create table");
		System.out.println("3 option for Update table");
		System.out.println("4 option for Delete table");
		
		do {
			
		Connection con=null;
		
		/* code for connectivity the database with eclipse*/
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/faculty","root","root");
			
		}

		catch(Exception e) {
			System.out.println(e);
		}
		System.out.println("Enter option");
		Scanner s=new Scanner(System.in);
		int opt=s.nextInt();
		
		/* use statement to find which type of command is performed to  */
		
		switch(opt) {
		
		/* case one is for select query */
		
		case 1:
			
			try {
				Statement st=con.createStatement();
				ResultSet rst=st.executeQuery("select * from Electronics");
				while(rst.next()) {
					System.out.println(rst.getInt(1)+" "+rst.getString(2)+" "+rst.getString(3)+" "+rst.getInt(4));
				}
			}
			catch(Exception e) {
				System.out.println(e);
			}
			
			break;
			
		/* case 2 for insert query */	
		
		case 2:
			
			try {
				System.out.println("Enter ID");
				int ID=s.nextInt();
				System.out.println("Enter Name");
				String Name=s.next();
				System.out.println("Enter city");
				String City=s.next();
				System.out.println("Enter Marks");
				String Marks=s.next();
				PreparedStatement st=con.prepareStatement("insert into Electronics values(?,?,?,?)");
				st.setInt(1,ID);
				st.setString(2,Name);
				st.setString(3,City);
				st.setString(4,Marks);

				int rst=st.executeUpdate();
				if(rst>0) {
					System.out.println("query inserted successfuly");
				}
			}
			catch(Exception e) {
				System.out.println(e);
			}
			
			break;
			
		/* case 3 for update query */	
		
		case 3:
			
			try {
				System.out.println("Enter ID where u want to update query");
				int ID=s.nextInt();
				System.out.println("Enter Name u want to update");
				String Name=s.next();
				System.out.println("Enter city u want to update");
				String City=s.next();
				System.out.println("Enter Marks u want to update");
				String Marks=s.next();
				
				PreparedStatement st=con.prepareStatement("update Electronics set Name=?,City=?,Marks=? where ID="+ID);
				st.setString(1,Name);
				st.setString(2,City);
				st.setString(3,Marks);
			
				
				int rst=st.executeUpdate();
				if(rst>0) {
					System.out.println("query updated successfuly");
				}
			}
			catch(Exception e) {
				System.out.println(e);
			}
			
			break;
			
		/* case 4 for delete query */	
		
		case 4:
			
			try {
				System.out.println("enter id u want to delete");
				int ID=s.nextInt();
				Statement st=con.createStatement();
				
				int rst=st.executeUpdate("delete from Electronics where ID="+ID);
				if(rst>0) {
					System.out.println("query deleted successfuly");
				}
			}
			catch(Exception e) {
				System.out.println(e);
			}
			
			break;
			
			default:
				System.out.println("Invalid option");
		}
		System.out.println("Do u want to continue ?");
		s1=s.next();
	}
		while(s1.equalsIgnoreCase("yes"));

	}
	
}

