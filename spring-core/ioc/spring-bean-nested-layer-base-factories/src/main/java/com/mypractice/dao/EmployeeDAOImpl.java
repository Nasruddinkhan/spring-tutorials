package com.mypractice.dao;

import com.mypractice.bo.EmployeeBO;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private static final String GET_EMPS_BY_DESGS = "SELECT EMPLOYEE_ID,FIRST_NAME,JOB_ID,SALARY FROM HR.EMPLOYEES WHERE JOB_ID=?";

    private DataSource ds;


    public EmployeeDAOImpl(DataSource ds) {
        this.ds = ds;
    }


    public List<EmployeeBO> searchEmpsByDesg(String desg) throws Exception {
        List<EmployeeBO> listBO = null;
        EmployeeBO bo = null;
        try (Connection con = ds.getConnection(); PreparedStatement ps = con.prepareStatement(GET_EMPS_BY_DESGS)) {
            ps.setString(1, desg);
			listBO = new ArrayList<>();
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    bo = new EmployeeBO();
                    bo.setEmpNo(rs.getInt(1));
                    bo.setEname(rs.getString(2));
                    bo.setDesg(rs.getString(3));
                    bo.setSalary(rs.getInt(4));
                    listBO.add(bo);
                }
            }
        } catch (SQLException se) {
            se.printStackTrace();
            throw se;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return listBO;
    }//method
}//class
