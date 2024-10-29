package com.techelevator.projects.dao;

import com.techelevator.projects.model.Timesheet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.test.util.AssertionErrors.assertNull;

public class JdbcTimesheetDaoTests extends BaseDaoTests {

    private static final Timesheet TIMESHEET_1 = new Timesheet(1, 1, 1,
            LocalDate.parse("2021-01-01"), 1.0, true, "Timesheet 1");
    private static final Timesheet TIMESHEET_2 = new Timesheet(2, 1, 1,
            LocalDate.parse("2021-01-02"), 1.5, true, "Timesheet 2");
    private static final Timesheet TIMESHEET_3 = new Timesheet(3, 2, 1,
            LocalDate.parse("2021-01-01"), 0.25, true, "Timesheet 3");
    private static final Timesheet TIMESHEET_4 = new Timesheet(4, 2, 2,
            LocalDate.parse("2021-02-01"), 2.0, false, "Timesheet 4");

    private JdbcTimesheetDao dao;


    @Before
    public void setup() {
        dao = new JdbcTimesheetDao(dataSource);
    }

    @Test
    public void getTimesheetById_with_valid_id_returns_correct_timesheet() {
        Timesheet timesheet = dao.getTimesheetById(1);
        Assert.assertNotNull("getTimesheetById with valid id returned a null timesheet.", timesheet);
        assertTimesheetsMatch(" ", TIMESHEET_1, timesheet);

        timesheet = dao.getTimesheetById(4);
        Assert.assertNotNull("getTimesheetId with a valid id returned a null timesheet.", timesheet);
        assertTimesheetsMatch(" ", TIMESHEET_4, timesheet);
    }

    @Test
    public void getTimesheetById_with_invalid_id_returns_null_timesheet() {
        Timesheet timesheet = dao.getTimesheetById(0);
        Assert.assertNull("getTimesheetById with invalid id returned a timesheet rather than null", timesheet);
    }

    @Test
    public void getTimesheetsByEmployeeId_with_valid_employee_id_returns_list_of_timesheets_for_employee() {
        List<Timesheet> timesheets = dao.getTimesheetsByEmployeeId(1);
        assertNotNull("getTimesheetsByEmployeeId with valid employee id returned a null list of timesheets", timesheets);
        Assert.assertEquals("getTimesheetByEmployeeId with valid employeed id returned the wrong number of timesheets in the list",
                2, timesheets.size());
        assertTimesheetsMatch("getTimesheetsByEmployeeId with valid employee id returned the incorrect or incomplete timesheet.",TIMESHEET_1, timesheets.get(0));
        assertTimesheetsMatch("getTimesheetsByEmployeeId with valid employee id returned the incorrect or incomplete timesheet.",TIMESHEET_2, timesheets.get(0));

        timesheets = dao.getTimesheetsByEmployeeId(2);
        assertNotNull("getTimesheetsByEmployeedId with valid employee id returned a null list of timesheets", timesheets);
        Assert.assertEquals("getTimesheetsByEmployeeId with valid employee id returned the wrong number of " +
                "of timesheets in the list", 2, timesheets.size());
        assertTimesheetsMatch("getTimesheetsByEmployeeId with valid employee id returned the incorrect or incomplete timesheet.", TIMESHEET_3, timesheets.get(0));
        assertTimesheetsMatch("getTimesheetsByEmployeeId with valid employee id returned the incorrect or incomplete timesheet.",TIMESHEET_4, timesheets.get(0));

    }



    @Test
    public void getTimesheetsByEmployeeId_with_invalid_employee_id_returns_empty_list_of_timesheets() {
        List<Timesheet> timesheets = dao.getTimesheetsByEmployeeId(-1);
        assertTrue("Timesheets list should be empty for invalid employee ID", timesheets.isEmpty());
    }

    @Test
    public void getTimesheetsByProjectId_with_valid_project_id_returns_list_of_all_timesheets_for_project() {
        List<Timesheet> timesheets = dao.getTimesheetsByProjectId(1);
        assertEquals(3, timesheets.size());
        assertTimesheetsMatch(" ", TIMESHEET_1, timesheets.get(0));
        assertTimesheetsMatch(" ", TIMESHEET_2, timesheets.get(1));
        assertTimesheetsMatch(" ", TIMESHEET_3, timesheets.get(2));
    }

    @Test
    public void getTimesheetsByProjectId_with_invalid_project_id_returns_empty_list_of_timesheets() {
        List<Timesheet> timesheets = dao.getTimesheetsByProjectId(-1);
        assertTrue("Timesheets list should be empty for invalid project ID", timesheets.isEmpty());
    }

    @Test
    public void createTimesheet_creates_timesheet() {
        Timesheet newTimesheet = new Timesheet(0, 2, 1, LocalDate.now(), 3.5, true, "New Timesheet");
        Timesheet createdTimesheet = dao.createTimesheet(newTimesheet);
        Integer newId = createdTimesheet.getTimesheetId();

        Assert.assertNotEquals("Timesheet ID should not be 0 after creation", 0, (int) newId);

        newTimesheet.setTimesheetId(newId);
        assertTimesheetsMatch(" ", newTimesheet, createdTimesheet);
    }

    @Test
    public void updateTimesheet_updates_timesheet() {
        Timesheet timesheetToUpdate = dao.getTimesheetById(1);
        timesheetToUpdate.setHoursWorked(5.0);
        timesheetToUpdate.setDescription("Updated description");

        dao.updateTimesheet(timesheetToUpdate);
        Timesheet updatedTimesheet = dao.getTimesheetById(1);

        assertTimesheetsMatch(" ", timesheetToUpdate, updatedTimesheet);
    }

    @Test
    public void deleteTimesheetById_deletes_timesheet() {
        int rowsAffected = dao.deleteTimesheetById(1);
        Assert.assertEquals("One row should be deleted", 1, rowsAffected);

        Timesheet timesheet = dao.getTimesheetById(1);
        assertNull("Timesheet should be null after deletion", timesheet);
    }

    @Test
    public void getBillableHours_returns_correct_total() {
        double billableHours = dao.getBillableHours(1, 1);
        assertEquals("Total billable hours should be correct", 2.5, billableHours, 0.001);
    }

    private void assertTimesheetsMatch(String message, Timesheet expected, Timesheet actual) {
        assertEquals(expected.getTimesheetId(), actual.getTimesheetId());
        assertEquals(expected.getEmployeeId(), actual.getEmployeeId());
        assertEquals(expected.getProjectId(), actual.getProjectId());
        assertEquals(expected.getDateWorked(), actual.getDateWorked());
        assertEquals(expected.getHoursWorked(), actual.getHoursWorked(), 0.001);
        assertEquals(expected.isBillable(), actual.isBillable());
        assertEquals(expected.getDescription(), actual.getDescription());
    }

}
