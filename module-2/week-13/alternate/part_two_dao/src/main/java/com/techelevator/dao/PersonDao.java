package com.techelevator.dao;

import com.techelevator.model.Person;

public interface PersonDao {

    /**
     * Returns a specific person from the datastore.
     *
     * @param id the id of the person to retrieve
     * @return The Person object with the given id, or null if the person isn't found
     */
    Person getPersonById(int id);

    /**
     * Adds a new Person into the datastore.
     *
     * @param newPerson the Person object to add
     * @return the Person object with its new id filled in
     */
    Person createPerson(Person newPerson);

    /**
     * Removes a Person from the datastore.
     *
     * @param id the person to remove
     * @return The number of Person records removed
     */
    int deletePersonById(int id);
}
