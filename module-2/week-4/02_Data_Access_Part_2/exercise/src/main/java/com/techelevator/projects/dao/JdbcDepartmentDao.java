package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.exception.DaoException;
import com.techelevator.projects.model.Department;
import org.springframework.transaction.annotation.Transactional;

public class JdbcDepartmentDao implements DepartmentDao {

	private final String DEPARTMENT_SELECT = "SELECT d.department_id, d.name FROM department d ";
	
	private final JdbcTemplate jdbcTemplate;

	public JdbcDepartmentDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Department getDepartmentById(int id) {
		Department department = null;
		String sql = DEPARTMENT_SELECT + " WHERE d.department_id=?";

		try {
			SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
			if (results.next()) {
				department = mapRowToDepartment(results);
			}
		} catch (CannotGetJdbcConnectionException e) {
			throw new DaoException("Error connecting to the database while retrieving department with id " + id, e);
		} catch (DataIntegrityViolationException e) {
			throw new DaoException("Data integrity violation while retrieving department with id " + id, e);
		} catch (Exception e) {
			throw new DaoException("Unexpected error occurred while retrieving department with id " + id, e);
		}

		return department;
	}

	@Override
	public List<Department> getDepartments() {
		List<Department> departments = new ArrayList<>();
		String sql = DEPARTMENT_SELECT;

		try {
			SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
			while (results.next()) {
				departments.add(mapRowToDepartment(results));
			}
		} catch (CannotGetJdbcConnectionException e) {
			throw new DaoException("Error connecting to the database while retrieving departments", e);
		} catch (DataIntegrityViolationException e) {
			throw new DaoException("Data integrity violation while retrieving departments", e);
		} catch (Exception e) {
			throw new DaoException("Unexpected error occurred while retrieving departments", e);
		}

		return departments;
	}

	@Override
	public Department createDepartment(Department department) {
		String sql = "INSERT INTO department (name) VALUES (?) RETURNING department_id";

		try {
			int newId = jdbcTemplate.queryForObject(sql, Integer.class, department.getName());
			department.setId(newId);
		} catch (CannotGetJdbcConnectionException e) {
			throw new DaoException("Error connecting to the database while creating department", e);
		} catch (DataIntegrityViolationException e) {
			throw new DaoException("Data integrity violation while creating department", e);
		} catch (Exception e) {
			throw new DaoException("Unexpected error occurred while creating department", e);
		}

		return department;
	}

	@Override
	public Department updateDepartment(Department department) {
		String sql = "UPDATE department SET name = ? WHERE department_id = ?";

		try {
			jdbcTemplate.update(sql, department.getName(), department.getId());
		} catch (CannotGetJdbcConnectionException e) {
			throw new DaoException("Error connecting to the database while updating department with id " + department.getId(), e);
		} catch (DataIntegrityViolationException e) {
			throw new DaoException("Data integrity violation while updating department with id " + department.getId(), e);
		} catch (Exception e) {
			throw new DaoException("Unexpected error occurred while updating department with id " + department.getId(), e);
		}

		return department;
	}

	@Override
	@Transactional
	public int deleteDepartmentById(int id) {
		int unassignedDepartmentId = 0; // Set this to the ID of your "unassigned" department
		String reassignEmployeesSql = "UPDATE employee SET department_id = ? WHERE department_id = ?";
		String deleteDepartmentSql = "DELETE FROM department WHERE department_id = ?";
		int rowsAffected;

		try {
			// First, reassign employees belonging to the department
			jdbcTemplate.update(reassignEmployeesSql, unassignedDepartmentId, id);
			// Then, delete the department
			rowsAffected = jdbcTemplate.update(deleteDepartmentSql, id);
		} catch (CannotGetJdbcConnectionException e) {
			throw new DaoException("Error connecting to the database while deleting department with id " + id, e);
		} catch (DataIntegrityViolationException e) {
			throw new DaoException("Data integrity violation while deleting department with id " + id, e);
		} catch (Exception e) {
			throw new DaoException("Unexpected error occurred while deleting department with id " + id, e);
		}

		return rowsAffected;
	}

	private Department mapRowToDepartment(SqlRowSet results) {
		Department department = new Department();
		department.setId(results.getInt("department_id"));
		department.setName(results.getString("name"));
		return department;
	}

}
