package dao;

import java.util.List;

import beans.Forum;
import beans.Topic;

/**
 * DAO to manipulate {@link Topic} entities.
 */
public interface DiscussionDao {

    /**
     * Finds all the {@link Topic} of the given {@link Forum}.
     *
     * @param forum
     * @return list of topics
     */
    List<Topic> findAll(Forum forum);
}
