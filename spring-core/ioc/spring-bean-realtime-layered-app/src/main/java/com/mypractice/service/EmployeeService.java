
/**
 * Nasruddin khan
 * EmployeeService.java 8 Nov, 2020
 */
package com.mypractice.service;

import com.mypractice.dto.EmployeeDTO;

/**
 * @author MY PC
 *
 */
public interface EmployeeService {

	/**
	 * @param dto
	 * @return
	 * @throws Exception 
	 */
	int save(EmployeeDTO dto) throws Exception;

}
