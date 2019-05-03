package dao;

import java.util.List;

import beans.Discussion;
import beans.Topic;
import exceptions.NotFoundException;

/**
 * DAO to manipulate {@link Discussion} entities.
 */
public interface DiscussionDao {

    /**
     * Finds all the {@link Discussion} of the given {@link Topic}.
     *
     * @param topic
     * @return list of discussions
     */
    List<Discussion> findAll(Topic topic);

    /**
     * Finds a {@link Discussion} by its id.
     *
     * @param id
     * @return
     * @throws NotFoundException
     */
    Discussion findById(Long id) throws NotFoundException;

    /**
     * Creates a new {@link Discussion}.
     * @param name
     * @param topic
     */
    void create(String name, Topic topic);
}
