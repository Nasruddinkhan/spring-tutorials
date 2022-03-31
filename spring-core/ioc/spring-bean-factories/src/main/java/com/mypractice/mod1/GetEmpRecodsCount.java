package com.mypractice.mod1;


import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class GetEmpRecodsCount {

	public static void main(String[] args) {
		InputStream is=null;
		Properties props=null;
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			//Locate Properties file
			is=new FileInputStream("src/main/java/com/nt/commons/jdbc.properties");
			//Load entries java.util.Properties class obj
			props=new Properties();
			props.load(is);
			//register jdbc driver
			Class.forName(props.getProperty("jdbc.driver"));
			//establish the connection
			con=DriverManager.getConnection(props.getProperty("jdbc.url"),
					                                                           props.getProperty("jdbc.username"),
					                                                           props.getProperty("jdbc.password"));
			//create Statement obj
			st=con.createStatement();
			//execute the Query
			rs=st.executeQuery("SELECT COUNT(*) FROM EMP");
			if(rs.next()) {
				System.out.println("records count::"+rs.getInt(1));
			}
			
			
		}//try
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//close jdbc objs
			try {
			if(rs!=null)
				rs.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			
			try {
				if(st!=null)
					st.close();
				}
				catch(SQLException se) {
					se.printStackTrace();
				}
			
			try {
				if(con!=null)
					con.close();
				}
				catch(SQLException se) {
					se.printStackTrace();
				}
			
		}//finally
	}//method
}//class
