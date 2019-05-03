package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;
import org.postgresql.jdbc.PgConnection;
import org.postgresql.jdbc.PgResultSet;

import beans.User;
import beans.UserRole;
import contracts.UserContract;

/**
 * DAO to manipulate {@link User} entities.
 */
public final class GeneralUserDao extends BaseDao implements UserDao {

    /** Request to create a {@link User}. */
    private static final String INSERT_REQUEST = "INSERT INTO " + UserContract.TABLE
            + "(" + UserContract.NAME + ", " + UserContract.PASSWORD + ", "
            + UserContract.SALT + ", " + UserContract.ROLE + ") VALUES(?, ?, ?, ?)";

    /** Request to find a {@link User} by his {@link User#getId() id}. */
    private static final String FIND_BY_ID = "SELECT * FROM " + UserContract.TABLE
            + " WHERE " + UserContract.ID + " = ?";

    /** Request to find a {@link User} by his {@link User#getName() name}. */
    private static final String FIND_BY_NAME = "SELECT * FROM " + UserContract.TABLE
            + " WHERE " + UserContract.NAME + " = ?";

    @Override
    public User findOne(final Long id) {
        User user = null;

        try {
            final PreparedStatement statement = this.getFactory().getConnection()
                    .prepareStatement(GeneralUserDao.FIND_BY_ID);

            statement.setLong(1, id);

            final PgResultSet result = (PgResultSet) statement.executeQuery();

            if (result.next()) {
                user = this.map(result);
            }
        } catch (final SQLException e) {}

        return user;
    }


    @Override
    public User findByName(final String name) {
        User user = null;

        try {
            final PreparedStatement statement = this.getFactory().getConnection()
                    .prepareStatement(GeneralUserDao.FIND_BY_NAME);

            statement.setString(1, name);

            final PgResultSet result = (PgResultSet) statement.executeQuery();

            if (result.next()) {
                user = this.map(result);
            }
        } catch (final SQLException e) {}

        return user;
    }

    @Override
    public boolean create(final String name, String password, final UserRole role) {
        boolean success = false;

        try {
            if (this.findByName(name) == null) {
                // Connect to database.
                final PgConnection connection = this.getFactory().getConnection();

                // Prepared request.
                final PreparedStatement statement = connection.prepareStatement(GeneralUserDao.INSERT_REQUEST);

                statement.setString(1, name);

                final String salt = BCrypt.gensalt();
                password = BCrypt.hashpw(password, salt);

                statement.setString(2, password);
                statement.setString(3, salt);
                statement.setLong(4, role.getId());

                statement.executeQuery();

                success = true;
            }
        } catch (final SQLException e) {}

        return success;
    }

    @Override
    public User connect(final String name, final String password) {

        final User user = this.findByName(name);

        if (user != null) {
            final String userPassword = user.getPassword();
            final String salt = user.getSalt();

            final String testedPassword = BCrypt.hashpw(password, salt);

            if (!testedPassword.equals(userPassword)) {
                return null;
            }
        }

        return user;
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
        user.setSalt(resultSet.getString(UserContract.SALT));

        final int role = resultSet.getInt(UserContract.ROLE);

        for (final UserRole value : UserRole.values()) {
            if (value.getId() == role) {
                user.setRole(value);

                break;
            }
        }

        return user;
    }
}
