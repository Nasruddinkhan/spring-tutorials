
/**
 * Nasruddin khan
 * EmployeeDAO.java 8 Nov, 2020
 */
package com.mypractice.dao;

import com.mypractice.bo.EmployeeBO;

/**
 * @author MY PC
 *
 */
public interface EmployeeDAO {
	/**
	 * @param bo
	 * @return
	 */
	public int save(EmployeeBO bo) throws Exception;
}
