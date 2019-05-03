package dao;

import java.util.List;

import beans.Forum;
import beans.Topic;
import exceptions.NotFoundException;

/**
 * DAO to manipulate {@link Topic} entities.
 */
public interface TopicDao {

    /**
     * Finds all the {@link Topic} of the given {@link Forum}.
     *
     * @param forum
     * @return list of topics
     */
    List<Topic> findAll(Forum forum);

    /**
     * Finds a {@link Topic} by its name.
     *
     * @param id
     * @return
     * @throws NotFoundException
     */
    Topic findById(Long id) throws NotFoundException;

    /**
     * Creates a new {@link Topic}
     *
     * @param name
     * @param forum
     */
    void create(String name, Forum forum);
}
