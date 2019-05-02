package dao;

import beans.Forum;
import exceptions.NotFoundException;

public interface ForumDao {

    /**
     * Finds a {@link Forum} by its id.
     * @param id
     * @return a forum
     */
    Forum findById(Long id) throws NotFoundException;
}
