package com.mypractice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.mypractice.bo.EmployeeBO;

public class EmployeeDAOImpl implements EmployeeDAO {
	private static final String  GET_EMPS_BY_DESGS="SELECT EMPLOYEE_ID,FIRST_NAME,JOB_ID,SALARY FROM HR.EMPLOYEES WHERE JOB_ID=?";
	
	private DataSource ds;
	

	public EmployeeDAOImpl(DataSource ds) {
		this.ds = ds;
	}


	public List<EmployeeBO> searchEmpsByDesg(String desg) throws Exception {
	  Connection con=null;
	  PreparedStatement ps=null;
	  ResultSet rs=null;
	  List<EmployeeBO> listBO=null;
	  EmployeeBO bo=null;
		try {
		  //get pooled jdbc con object
			con=ds.getConnection();
			//create PreparedStaetment object
			ps=con.prepareStatement(GET_EMPS_BY_DESGS);
			//set Query param values
			ps.setString(1,desg);
			//execute the SQL Query
			rs=ps.executeQuery();
			//process the ResultSEt (copy ResultSet obj records to ListBO Collection)
			listBO=new ArrayList();
			while(rs.next()) {
				//keep each recrod of RS to BO class obj
				bo=new EmployeeBO();
				bo.setEmpNo(rs.getInt(1));
				bo.setEname(rs.getString(2));
				bo.setDesg(rs.getString(3));
				bo.setSalary(rs.getInt(4));
				//add BO class obj to List Collection
				listBO.add(bo);
			}//while
	  }//try
		catch(SQLException se) {
			se.printStackTrace();
			throw se;
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
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
				if(ps!=null)
					ps.close();
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
		return listBO;
	}//method
}//class
