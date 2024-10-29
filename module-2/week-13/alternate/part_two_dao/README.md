# Module Assessment - DAO

## Introduction

This assessment verifies the competencies that you learned during the module. It's a hands-on assessment that you'll complete inside your IDE.

This part of the hands-on assessment has you write two methods for a DAO class and add exception handling to an already completed method. The DAO methods are for the `teMDb` database.

**After completing this part, you need to `add`, `commit`, and `push` the code to your repository. When you've completed both parts of the coding assessment, submit your assessment in BootcampOS.**

## Hints and suggestions

* If you haven't done so already, create the `teMDb` database. The script for the data is in the `part_one_sql` folder.
* `push` your code often. Whenever you reach a point where you feel like you've made good progress and your code builds, commit and push your changes.
* The code you submit must build properly to get scored. _Please make sure you don't have any build errors._

## Exploring the code

In the `com.techelevator.model` package is a `Person` class. This class represents a record in the `person` table of the `teMDb` database. You'll use this model for your DAO code.

In the `com.techelevator.dao` package is a `PersonDAO` interface like you've seen in DAO code earlier in this module.

The `JdbcPersonDao` class implements the `PersonDAO` interface, and this is where you'll write your code. You need to write the code for the `createPerson()` and `deletePersonById(int personId)` methods. The `getPersonById()` method is already completed, but you need to add exception handling to it. The `JdbcTemplate` is already defined in the class and instantiated in the class constructor. You're also provided a mapping method—`mapRowToPerson()`—to map a SQL row to a `Person` object.

## Running the tests

The project includes JUnit tests for you to verify your code. The tests are in `src/test/java/com.techelevator.dao/JdbcPersonDaoTests.java`.

The tests load a test version of the `teMDb` database with test data. This is similar to the tests you ran for the DAO exercises earlier in the module.

> To run all tests in _IntelliJ_, you can right-click the `java` folder beneath `test`, and select **Run 'All Tests'**.

## Code requirements

As stated before, you'll complete the `createPerson()` and `deletePersonById(int personId)` methods and add exception handling to `getPersonById(int personId)`. Complete each method and run the tests to verify your work.

The `getPersonById(int personId)` method must:
* Throw a `DaoException` when `JdbcTemplate` can't get a connection to the database

The `createPerson()` method must:
* Map each property of `newPerson` to a SQL statement to add a record to the database
* The SQL statement must return the ID of the newly added row
* Use the ID to retrieve the newly created book
* Return the newly created book
* Throw a `DaoException` when `JdbcTemplate` can't get a connection to the database
* Throw a `DaoException` when there would be a data integrity violation from the data change

The `deletePersonById(int personId)` method must:
* Delete the `movie_screenwriter` rows that reference the given `person_id`
* Set any `director_id` fields to `NULL` in the `movie` table that reference the given `person_id` 
* Set any `music_by_id` fields to `NULL` in the `movie` table that reference the given `person_id` 
* Return the number of `person` rows deleted (either 0 or 1)
* Throw a `DaoException` when `JdbcTemplate` can't get a connection to the database
* Throw a `DaoException` when there would be a data integrity violation from the data change

## Submit your work

When you've completed this part of the assessment, be sure to push your code to your repository. When you've completed both parts of the coding assessment, submit the assessment in BootcampOS.
