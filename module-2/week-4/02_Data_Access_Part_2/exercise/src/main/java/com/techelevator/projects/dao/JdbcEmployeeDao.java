package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.exception.DaoException;
import com.techelevator.projects.model.Employee;
import org.springframework.transaction.annotation.Transactional;

public class JdbcEmployeeDao implements EmployeeDao {

	private final String EMPLOYEE_SELECT = "SELECT e.employee_id, e.department_id, e.first_name, e.last_name, " +
				"e.birth_date, e.hire_date FROM employee e ";

	private final JdbcTemplate jdbcTemplate;

	public JdbcEmployeeDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Employee getEmployeeById(int id) {
		Employee employee = null;
		String sql = EMPLOYEE_SELECT + " WHERE e.employee_id=?";

		try {
			SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
			if (results.next()) {
				employee = mapRowToEmployee(results);
			}
		} catch (CannotGetJdbcConnectionException e) {
			throw new DaoException("Error connecting to the database while retrieving employee with id " + id, e);
		} catch (DataIntegrityViolationException e) {
			throw new DaoException("Data integrity violation while retrieving employee with id " + id, e);
		} catch (Exception e) {
			throw new DaoException("Unexpected error occurred while retrieving employee with id " + id, e);
		}

		return employee;
	}

	@Override
	public List<Employee> getEmployees() {
		List<Employee> allEmployees = new ArrayList<>();
		String sql = EMPLOYEE_SELECT;

		try {
			SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
			while (results.next()) {
				Employee employeeResult = mapRowToEmployee(results);
				allEmployees.add(employeeResult);
			}
		} catch (CannotGetJdbcConnectionException e) {
			throw new DaoException("Error connecting to the database while retrieving employees", e);
		} catch (DataIntegrityViolationException e) {
			throw new DaoException("Data integrity violation while retrieving employees", e);
		} catch (Exception e) {
			throw new DaoException("Unexpected error occurred while retrieving employees", e);
		}

		return allEmployees;
	}

	@Override
	public List<Employee> getEmployeesByFirstNameLastName(String firstName, String lastName) {
		List<Employee> allEmployees = new ArrayList<>();
		String sql = EMPLOYEE_SELECT + " WHERE e.first_name ILIKE ? AND e.last_name ILIKE ?";

		try {
			SqlRowSet results = jdbcTemplate.queryForRowSet(sql, "%" + firstName + "%", "%" + lastName + "%");
			while (results.next()) {
				Employee employeeResult = mapRowToEmployee(results);
				allEmployees.add(employeeResult);
			}
		} catch (CannotGetJdbcConnectionException e) {
			throw new DaoException("Error connecting to the database while retrieving employees by name", e);
		} catch (DataIntegrityViolationException e) {
			throw new DaoException("Data integrity violation while retrieving employees by name", e);
		} catch (Exception e) {
			throw new DaoException("Unexpected error occurred while retrieving employees by name", e);
		}

		return allEmployees;
	}

	@Override
	public List<Employee> getEmployeesByProjectId(int projectId) {
		List<Employee> allEmployees = new ArrayList<>();
		String sql = EMPLOYEE_SELECT + " JOIN project_employee pe ON e.employee_id = pe.employee_id " +
				"WHERE pe.project_id = ?";

		try {
			SqlRowSet results = jdbcTemplate.queryForRowSet(sql, projectId);
			while (results.next()) {
				Employee employeeResult = mapRowToEmployee(results);
				allEmployees.add(employeeResult);
			}
		} catch (CannotGetJdbcConnectionException e) {
			throw new DaoException("Error connecting to the database while retrieving employees by project id " + projectId, e);
		} catch (DataIntegrityViolationException e) {
			throw new DaoException("Data integrity violation while retrieving employees by project id " + projectId, e);
		} catch (Exception e) {
			throw new DaoException("Unexpected error occurred while retrieving employees by project id " + projectId, e);
		}

		return allEmployees;
	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		List<Employee> allEmployees = new ArrayList<>();
		String sql = EMPLOYEE_SELECT + " WHERE e.employee_id NOT IN (SELECT DISTINCT employee_id FROM project_employee)";

		try {
			SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
			while (results.next()) {
				Employee employeeResult = mapRowToEmployee(results);
				allEmployees.add(employeeResult);
			}
		} catch (CannotGetJdbcConnectionException e) {
			throw new DaoException("Error connecting to the database while retrieving employees without projects", e);
		} catch (DataIntegrityViolationException e) {
			throw new DaoException("Data integrity violation while retrieving employees without projects", e);
		} catch (Exception e) {
			throw new DaoException("Unexpected error occurred while retrieving employees without projects", e);
		}

		return allEmployees;
	}

	@Override
	public Employee createEmployee(Employee employee) {
		String sql = "INSERT INTO employee (department_id, first_name, last_name, birth_date, hire_date) VALUES (?, ?, ?, ?, ?) RETURNING employee_id";

		try {
			int newId = jdbcTemplate.queryForObject(sql, Integer.class, employee.getDepartmentId(), employee.getFirstName(), employee.getLastName(), employee.getBirthDate(), employee.getHireDate());
			employee.setId(newId);
		} catch (CannotGetJdbcConnectionException e) {
			throw new DaoException("Error connecting to the database while creating employee", e);
		} catch (DataIntegrityViolationException e) {
			throw new DaoException("Data integrity violation while creating employee", e);
		} catch (Exception e) {
			throw new DaoException("Unexpected error occurred while creating employee", e);
		}

		return employee;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		String sql = "UPDATE employee SET department_id = ?, first_name = ?, last_name = ?, birth_date = ?, hire_date = ? WHERE employee_id = ?";

		try {
			int rowsAffected = jdbcTemplate.update(sql, employee.getDepartmentId(), employee.getFirstName(), employee.getLastName(), employee.getBirthDate(), employee.getHireDate(), employee.getId());

			if (rowsAffected == 0) {
				throw new DaoException("No rows affected, update failed for employee with id " + employee.getId());
			}
		} catch (CannotGetJdbcConnectionException e) {
			throw new DaoException("Error connecting to the database while updating employee with id " + employee.getId(), e);
		} catch (DataIntegrityViolationException e) {
			throw new DaoException("Data integrity violation while updating employee with id " + employee.getId(), e);
		} catch (Exception e) {
			throw new DaoException("Unexpected error occurred while updating employee with id " + employee.getId(), e);
		}

		return employee;
	}

	@Override
	@Transactional
	public int deleteEmployeeById(int id) {
		String deleteProjectEmployeeSql = "DELETE FROM project_employee WHERE employee_id = ?";
		String deleteEmployeeSql = "DELETE FROM employee WHERE employee_id = ?";
		int rowsAffected;

		try {
			// First, delete references from project_employee table
			jdbcTemplate.update(deleteProjectEmployeeSql, id);
			// Then, delete the employee
			rowsAffected = jdbcTemplate.update(deleteEmployeeSql, id);
		} catch (CannotGetJdbcConnectionException e) {
			throw new DaoException("Error connecting to the database while deleting employee with id " + id, e);
		} catch (DataIntegrityViolationException e) {
			throw new DaoException("Data integrity violation while deleting employee with id " + id, e);
		} catch (Exception e) {
			throw new DaoException("Unexpected error occurred while deleting employee with id " + id, e);
		}

		return rowsAffected;
	}

	@Override
	@Transactional
	public int deleteEmployeesByDepartmentId(int departmentId) {
		String deleteProjectEmployeeSql = "DELETE FROM project_employee WHERE employee_id IN (SELECT employee_id FROM employee WHERE department_id = ?)";
		String deleteEmployeeSql = "DELETE FROM employee WHERE department_id = ?";
		int rowsAffected;

		try {
			// First, delete references from project_employee table
			jdbcTemplate.update(deleteProjectEmployeeSql, departmentId);
			// Then, delete employees
			rowsAffected = jdbcTemplate.update(deleteEmployeeSql, departmentId);
		} catch (CannotGetJdbcConnectionException e) {
			throw new DaoException("Error connecting to the database while deleting employees in department with id " + departmentId, e);
		} catch (DataIntegrityViolationException e) {
			throw new DaoException("Data integrity violation while deleting employees in department with id " + departmentId, e);
		} catch (Exception e) {
			throw new DaoException("Unexpected error occurred while deleting employees in department with id " + departmentId, e);
		}

		return rowsAffected;
	}

	private Employee mapRowToEmployee(SqlRowSet result) {
		Employee employee = new Employee();
		employee.setId(result.getInt("employee_id"));
		employee.setDepartmentId(result.getInt("department_id"));
		employee.setFirstName(result.getString("first_name"));
		employee.setLastName(result.getString("last_name"));
		employee.setBirthDate(result.getDate("birth_date").toLocalDate());
		employee.setHireDate(result.getDate("hire_date").toLocalDate());
		return employee;
	}
}
