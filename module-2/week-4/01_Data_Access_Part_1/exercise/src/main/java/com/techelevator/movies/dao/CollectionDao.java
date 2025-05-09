package com.techelevator.movies.dao;

import com.techelevator.movies.model.Collection;

import java.util.List;

public interface CollectionDao {

    /**
     * Get a list of all collections from the datastore.
     * The list is never null. It is empty if there are no collections in the datastore.
     *
     * @return all collections as a list of Collection objects
     */
    List<Collection> getCollections();

    /**
     * Get a collection from the datastore that has the given id.
     * If the id is not found, return null.
     *
     * @param id the collection id to get from the datastore
     * @return a fully populated Collection object
     */
    Collection getCollectionById(int id);

    /**
     * Get a list of all the collections from the datastore that match the name. Perform a 
     * case-insensitive search. Return an empty list when no matching collections are found.
     *
     * @param name the collection name to get from the datastore
     * @param useWildCard wraps name with wild card characters if true
     * @return all matching collections as a list of Collection objects
     */
    List<Collection> getCollectionsByName(String name, boolean useWildCard);
    void save(Collection collection);
    void update(Collection collection);
    void deleteById(int id);
}
