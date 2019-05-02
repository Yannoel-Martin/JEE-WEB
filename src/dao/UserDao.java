package dao;

import beans.User;
import exceptions.NotFoundException;

/**
 * DAO to manipulate {@link User} entities
 */
public interface UserDao {

    /**
     * Finds a {@link User} by his id.
     * @param id
     * @return
     */
    User findOne(Long id) throws NotFoundException;

    /**
     * Creates a user.
     * @param user
     */
    void create(User user);
}
