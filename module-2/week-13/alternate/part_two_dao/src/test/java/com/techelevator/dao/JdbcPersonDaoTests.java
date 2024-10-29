package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JdbcPersonDaoTests extends BaseDaoTests {

    private static final Person PERSON_1 = new Person(1, "Martin", "Scorsese", LocalDate.parse("1942-11-17"), null);

    private JdbcPersonDao dao;
    private JdbcPersonDao invalidConnectionDao;

    private final List<Person> testPeople = new ArrayList<>(Arrays.asList(PERSON_1));
    private Person testPerson;

    private final int INVALID_BOOK_ID = 999;

    @Before
    public void setup() {
        dao = new JdbcPersonDao(dataSource);
        invalidConnectionDao = new JdbcPersonDao(invalidDataSource);
        testPerson = new Person(99, "Test", "Person", LocalDate.parse("1999-01-01"), null);
    }

    
    @Test
    public void getPersonById_throws_dao_exception_for_invalid_connection() {
        String methodName = "getPersonById";
        try {
            invalidConnectionDao.getPersonById(1);
            Assert.fail(didNotThrowAnyExceptionForCannotGetConnection(methodName));
        } catch (DaoException e) {
            // expected
        } catch (Exception e) {
            Assert.fail(didNotThrowDaoExceptionForCannotGetConnection(methodName));
        }
    }

    @Test
    public void createPerson_returns_new_person_with_id() {
        Person createdPerson = dao.createPerson(testPerson);
        Assert.assertNotNull("createPerson returned null", createdPerson);

        // verify value was saved to database, retrieve it and compare values
        Person retrievedPerson = dao.getPersonById(createdPerson.getPersonId());
        assertPersonsMatch("createPerson did not return the newly inserted record", createdPerson, retrievedPerson);
    }

    @Test
    public void createPerson_throws_dao_exception_for_data_integrity_violation() {
        testPerson.setBirthDate(null); // invalid birthdate

        String methodName = "createPerson";
        try {
            dao.createPerson(testPerson);
            Assert.fail(didNotThrowAnyExceptionForDataIntegrity(methodName));
        } catch (DaoException e) {
            if (e.getMessage().equalsIgnoreCase(methodName + NOT_IMPLEMENTED_LONG_SUFFIX)) {
                Assert.fail(threwNotImplementedException(methodName));
            }
        } catch (Exception e) {
            Assert.fail(didNotThrowDaoExceptionForDataIntegrity(methodName));
        }
    }

    
    @Test
    public void createPerson_throws_dao_exception_for_invalid_connection() {
        String methodName = "createPerson";
        try {
            invalidConnectionDao.createPerson(testPerson);
            Assert.fail(didNotThrowAnyExceptionForCannotGetConnection(methodName));
        } catch (DaoException e) {
            // expected
        } catch (Exception e) {
            Assert.fail(didNotThrowDaoExceptionForCannotGetConnection(methodName));
        }
    }

    @Test
    public void deletePersonById_removes_person() {
        // test that person exists in dao
        testPerson = dao.getPersonById(PERSON_1.getPersonId());
        assertPersonsMatch("failed to confirm person exists in dao BEFORE delete", PERSON_1, testPerson);
        int numDeleted = dao.deletePersonById(PERSON_1.getPersonId());
        Assert.assertEquals("deletePersonById(int id) didn't return 1, the number of persons deleted", 1, numDeleted);
        // test that person no longer exists in dao
        testPerson = dao.getPersonById(PERSON_1.getPersonId());
        Assert.assertNull("deletePersonById(int id) failed to remove the correct person", testPerson);
    }

    @Test
    public void deletePersonById_returns_zero_when_person_doesnt_exist() {
        // delete a person with an invalid id
        int numDeleted = dao.deletePersonById(INVALID_BOOK_ID);
        Assert.assertEquals("deletePersonById(int id) didn't return 0 for non-existent person", 0, numDeleted);
    }

    @Test
    public void deletePersonById_throws_dao_exception_for_invalid_connection() {
        String methodName = "deletePersonById";
        try {
            invalidConnectionDao.deletePersonById(1);
            Assert.fail(didNotThrowAnyExceptionForCannotGetConnection(methodName));
        } catch (DaoException e) {
            // expected
        } catch (Exception e) {
            Assert.fail(didNotThrowDaoExceptionForCannotGetConnection(methodName));
        }
    }

    private void assertPersonsMatch(String message, Person expected, Person actual) {
        Assert.assertEquals(message, expected.getPersonId(), actual.getPersonId());
        Assert.assertEquals(message, expected.getFirstName(), actual.getFirstName());
        Assert.assertEquals(message, expected.getLastName(), actual.getLastName());
        Assert.assertEquals(message, expected.getBirthDate(), actual.getBirthDate());
        Assert.assertEquals(message, expected.getDeathDate(), actual.getDeathDate());
    }
}
