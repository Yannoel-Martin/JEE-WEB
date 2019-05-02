package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.postgresql.jdbc.PgResultSet;

import beans.Forum;
import contracts.ForumContract;
import exceptions.NotFoundException;

/**
 * DAO to access {@link Forum} entities.
 */
public final class GeneralForumDao extends BaseDao implements ForumDao {

    /** Request to find one forum. */
    private static final String FIND_ONE_REQUEST = "SELECT * FROM " + ForumContract.TABLE
            + " WHERE " + ForumContract.ID + " = ?";

    @Override
    public Forum findById(final Long id) throws NotFoundException {

        final Forum forum = new Forum();

        try {
            final PreparedStatement statement = this.getFactory().getConnection()
                    .prepareStatement(GeneralForumDao.FIND_ONE_REQUEST);

            statement.setLong(1, id);

            final PgResultSet result = (PgResultSet) statement.executeQuery();

            if (!result.next()) {
                throw new NotFoundException("Forum with id " + id + " doesn't exist.");
            }

            // Mapping (lightweight, so no method.)
            forum.setId(id);

        } catch (final SQLException e) {
            throw new NotFoundException("An error occurred with the SQL request.");
        }

        return forum;
    }

}
