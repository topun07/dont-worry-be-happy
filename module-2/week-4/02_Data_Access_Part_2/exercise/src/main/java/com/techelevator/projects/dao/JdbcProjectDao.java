package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.exception.DaoException;
import com.techelevator.projects.model.Project;
import org.springframework.transaction.annotation.Transactional;

public class JdbcProjectDao implements ProjectDao {

	private final String PROJECT_SELECT = "SELECT p.project_id, p.name, p.from_date, p.to_date FROM project p";

	private final JdbcTemplate jdbcTemplate;

	public JdbcProjectDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Project getProjectById(int projectId) {
		Project project = null;
		String sql = PROJECT_SELECT + " WHERE p.project_id=?";

		try {
			SqlRowSet results = jdbcTemplate.queryForRowSet(sql, projectId);
			if (results.next()) {
				project = mapRowToProject(results);
			}
		} catch (CannotGetJdbcConnectionException e) {
			throw new DaoException("Error connecting to the database while retrieving project with id " + projectId, e);
		} catch (DataIntegrityViolationException e) {
			throw new DaoException("Data integrity violation while retrieving project with id " + projectId, e);
		} catch (Exception e) {
			throw new DaoException("Unexpected error occurred while retrieving project with id " + projectId, e);
		}

		return project;
	}

	@Override
	public List<Project> getProjects() {
		List<Project> allProjects = new ArrayList<>();
		String sql = PROJECT_SELECT;

		try {
			SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
			while (results.next()) {
				Project projectResult = mapRowToProject(results);
				allProjects.add(projectResult);
			}
		} catch (CannotGetJdbcConnectionException e) {
			throw new DaoException("Error connecting to the database while retrieving projects", e);
		} catch (DataIntegrityViolationException e) {
			throw new DaoException("Data integrity violation while retrieving projects", e);
		} catch (Exception e) {
			throw new DaoException("Unexpected error occurred while retrieving projects", e);
		}

		return allProjects;
	}

	@Override
	public Project createProject(Project newProject) {
		String sql = "INSERT INTO project (name, from_date, to_date) VALUES (?, ?, ?) RETURNING project_id";

		try {
			int newId = jdbcTemplate.queryForObject(sql, Integer.class, newProject.getName(), newProject.getFromDate(), newProject.getToDate());
			newProject.setId(newId);
		} catch (CannotGetJdbcConnectionException e) {
			throw new DaoException("Error connecting to the database while creating project", e);
		} catch (DataIntegrityViolationException e) {
			throw new DaoException("Data integrity violation while creating project", e);
		} catch (Exception e) {
			throw new DaoException("Unexpected error occurred while creating project", e);
		}

		return newProject;
	}
	
	@Override
	public void linkProjectEmployee(int projectId, int employeeId) {
		String sql = "INSERT INTO project_employee (project_id, employee_id) VALUES (?, ?)";

		try {
			jdbcTemplate.update(sql, projectId, employeeId);
		} catch (CannotGetJdbcConnectionException e) {
			throw new DaoException("Error connecting to the database while linking project with id " + projectId + " to employee with id " + employeeId, e);
		} catch (DataIntegrityViolationException e) {
			throw new DaoException("Data integrity violation while linking project with id " + projectId + " to employee with id " + employeeId, e);
		} catch (Exception e) {
			throw new DaoException("Unexpected error occurred while linking project with id " + projectId + " to employee with id " + employeeId, e);
		}
	}

	@Override
	public void unlinkProjectEmployee(int projectId, int employeeId) {
		String sql = "DELETE FROM project_employee WHERE project_id = ? AND employee_id = ?";

		try {
			jdbcTemplate.update(sql, projectId, employeeId);
		} catch (CannotGetJdbcConnectionException e) {
			throw new DaoException("Error connecting to the database while unlinking project with id " + projectId + " from employee with id " + employeeId, e);
		} catch (DataIntegrityViolationException e) {
			throw new DaoException("Data integrity violation while unlinking project with id " + projectId + " from employee with id " + employeeId, e);
		} catch (Exception e) {
			throw new DaoException("Unexpected error occurred while unlinking project with id " + projectId + " from employee with id " + employeeId, e);
		}
	}

	@Override
	public Project updateProject(Project project) {
		String sql = "UPDATE project SET name = ?, from_date = ?, to_date = ? WHERE project_id = ?";

		try {
			jdbcTemplate.update(sql, project.getName(), project.getFromDate(), project.getToDate(), project.getId());
		} catch (CannotGetJdbcConnectionException e) {
			throw new DaoException("Error connecting to the database while updating project with id " + project.getId(), e);
		} catch (DataIntegrityViolationException e) {
			throw new DaoException("Data integrity violation while updating project with id " + project.getId(), e);
		} catch (Exception e) {
			throw new DaoException("Unexpected error occurred while updating project with id " + project.getId(), e);
		}

		return project;
	}
	@Override
	@Transactional
	public int deleteProjectById(int projectId) {
		String deleteProjectEmployeeSql = "DELETE FROM project_employee WHERE project_id = ?";
		String deleteProjectSql = "DELETE FROM project WHERE project_id = ?";
		int rowsAffected;

		try {
			// First, delete references from project_employee table
			jdbcTemplate.update(deleteProjectEmployeeSql, projectId);
			// Then, delete the project
			rowsAffected = jdbcTemplate.update(deleteProjectSql, projectId);
		} catch (CannotGetJdbcConnectionException e) {
			throw new DaoException("Error connecting to the database while deleting project with id " + projectId, e);
		} catch (DataIntegrityViolationException e) {
			throw new DaoException("Data integrity violation while deleting project with id " + projectId, e);
		} catch (Exception e) {
			throw new DaoException("Unexpected error occurred while deleting project with id " + projectId, e);
		}

		return rowsAffected;
	}
	
	private Project mapRowToProject(SqlRowSet results) {
		Project project = new Project();
		project.setId(results.getInt("project_id"));
		project.setName(results.getString("name"));
		if (results.getDate("from_date") != null) {
			project.setFromDate(results.getDate("from_date").toLocalDate());
		}
		if (results.getDate("to_date") != null) {
			project.setToDate(results.getDate("to_date").toLocalDate());
		}
		return project;
	}

}
