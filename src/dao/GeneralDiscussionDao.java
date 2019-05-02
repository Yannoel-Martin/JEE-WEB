package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.postgresql.jdbc.PgConnection;
import org.postgresql.jdbc.PgResultSet;

import beans.Discussion;
import beans.DiscussionStatus;
import beans.Topic;
import contracts.DiscussionContract;
import exceptions.NotFoundException;

/**
 * DAO to manipulate {@link Discussion} entities.
 */
public final class GeneralDiscussionDao extends BaseDao implements DiscussionDao {

    /** Request to fetch all the {@link Discussion discussions}. */
    private static final String SELECT_ALL_REQUEST = "SELECT * FROM " + DiscussionContract.TABLE
            + " WHERE " + DiscussionContract.ID_TOPIC + " = ?";

    /** Request to get one {@link Discussion discussion}. */
    private static final String FIND_ONE_REQUEST = "SELECT * FROM " + DiscussionContract.TABLE
            + " WHERE " + DiscussionContract.ID + " = ?";

    @Override
    public List<Discussion> findAll(final Topic topic) {
        final List<Discussion> discussions = new ArrayList<>();

        try {
            // Connect to database.
            final PgConnection connection = this.getFactory().getConnection();

            // Prepare request.
            final PreparedStatement statement = connection.prepareStatement(GeneralDiscussionDao.SELECT_ALL_REQUEST);
            statement.setLong(1, topic.getId());

            // Retrieve results.
            final PgResultSet resultSet = (PgResultSet) statement.executeQuery();

            while(resultSet.next()) {
                discussions.add(this.map(resultSet));
            }

        } catch (final SQLException e) {
            e.printStackTrace();
        }

        return discussions;
    }

    @Override
    public Discussion findById(final Long id) throws NotFoundException {
        final Discussion discussion;

        try {
            final PreparedStatement statement = this.getFactory().getConnection()
                    .prepareStatement(GeneralDiscussionDao.FIND_ONE_REQUEST);

            statement.setLong(1, id);

            final PgResultSet result = (PgResultSet) statement.executeQuery();

            if (!result.next()) {
                throw new NotFoundException("Discussion with id " + id + " doesn't exist.");
            }

            discussion = this.map(result);

        } catch (final SQLException e) {
            throw new NotFoundException("An error occurred with the SQL request.");
        }

        return discussion;
    }

    /**
     * Map the {@link PgResultSet} to {@link Discussion}.
     *
     * @param resultSet
     * @return a {@link Discussion}
     * @throws SQLException
     */
    private Discussion map(final PgResultSet resultSet) throws SQLException {
        final Discussion discussion = new Discussion();

        discussion.setId(resultSet.getLong(DiscussionContract.ID));
        discussion.setName(resultSet.getString(DiscussionContract.NAME));

        final int status = resultSet.getInt(DiscussionContract.STATUS);
        discussion.setStatus(DiscussionStatus.values()[status]);

        return discussion;
    }
}
