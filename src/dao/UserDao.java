package dao;

import beans.User;
import beans.UserRole;

/**
 * DAO to manipulate {@link User} entities
 */
public interface UserDao {

    /**
     * Finds a {@link User} by his id.
     * @param id
     * @return a {@link User}.
     */
    User findOne(Long id);

    /**
     * Finds a {@link User} by his name.
     * @param name
     * @return a {@link User}.
     */
    User findByName(String name);

    /**
     * Creates a {@link User}
     * @param name
     * @param password
     * @param role
     * @return TRUE or FALSE if created.
     */
    boolean create(String name, String password, UserRole role);

    /**
     * Tries to connect as the user.
     * @param name
     * @param password
     * @return {@link Useê} or NULL.
     */
    User connect(String name, String password);
}
