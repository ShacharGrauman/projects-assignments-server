package com.grauman.amdocs.dao.interfaces;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.mail.SendFailedException;

import com.grauman.amdocs.models.*;

public interface IEmployeeDataDAO extends IDAO<EmployeeData>{
	
	List<EmployeeData> findAll(int page,int limit) throws SQLException;
	List<EmployeeData> findAllEmployees(int page,int limit) throws SQLException;
	EmployeeData searchEmployeeProfile(int id) throws SQLException;
    List<EmployeeData> filterByName(String name,int page,int limit) throws SQLException;;
    List<EmployeeData> filter(int number,String name,String roleName,String siteName,String departmentName,
			String countryName,int page,int limit)throws SQLException;
    public Integer countfilter(int number,String name,String roleName,String siteName,String departmentName,
			String countryName)throws SQLException;
    EmployeeData unlockEmployee(int id) throws SQLException;
    EmployeeData lockEmployee(int id) throws SQLException ;
    List<Role> getEmployeeRoles(int id)throws SQLException;
    List<WorkSite> findAllSites() throws SQLException;
    List<Role> findAllRoles() throws SQLException;
    List<Department> findAllDepartments() throws SQLException;
    List<Employee> findAllManagers() throws SQLException;
    List<Country> findAllCountries() throws SQLException;
    Integer countEmployees() throws SQLException;
    Integer countRoles() throws SQLException;
    Integer countDepartments() throws SQLException;
    Integer countWorkSites() throws SQLException;
    void resetPassword(String toEmail, int number) throws SQLException, EmployeeException;
    void sendGeneralEmail(String toEmail, String firstName, String subject, String text) throws SendFailedException;

	
	
	Map<EmployeeData, List<EmployeeData>> findEmployeesHierarchy() throws SQLException;


	 
	 

    List<Permission> getEmployeePermissions(Integer id) throws SQLException;
}
