
/**
 * Nasruddin khan
 * EmployeeDAOImpl.java 8 Nov, 2020
 */
package com.mypractice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import com.mypractice.bo.EmployeeBO;

/**
 * @author MY PC
 *
 */
public class EmployeeDAOImpl implements EmployeeDAO {
	private DataSource ds;

	public void setDs(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public int save(EmployeeBO bo) throws Exception {
		// TODO Auto-generated method stub
		int row = 0;
		String sql = "insert into emp ( emp_id, name, salary) values(?, ?, ?)";
		try (Connection con = ds.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, bo.getEmpID());
			ps.setString(2, bo.getName());
			ps.setDouble(3, bo.getSalary());
			row = ps.executeUpdate();
		}
		return row;
	}

}
