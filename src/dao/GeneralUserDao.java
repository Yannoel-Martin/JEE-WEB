package dao;

import java.sql.SQLException;

import org.postgresql.jdbc.PgResultSet;

import beans.User;
import beans.UserRole;
import contracts.UserContract;
import exceptions.NotFoundException;

/**
 * DAO to manipulate {@link User} entities.
 */
public final class GeneralUserDao extends BaseDao implements UserDao {

    @Override
    public User findOne(final Long id) throws NotFoundException {

        final User user = new User();

        // TODO: get from DB.
        user.setId(1L);
        user.setName("tester");
        user.setPassword("dfdsf");
        user.setRole(UserRole.Admin);

        return user;
    }

    @Override
    public void create(final User user) {
        // TODO Auto-generated method stub

    }


    /**
     * Map the {@link PgResultSet} to {@link User}.
     *
     * @param resultSet
     * @return a {@link User}
     * @throws SQLException
     */
    private User map(final PgResultSet resultSet) throws SQLException {
        final User user = new User();

        user.setId(resultSet.getLong(UserContract.ID));
        user.setName(resultSet.getString(UserContract.NAME));
        user.setPassword(resultSet.getString(UserContract.PASSWORD));

        final int role = resultSet.getInt(UserContract.ROLE);
        user.setRole(UserRole.values()[role]);

        return user;
    }
}
