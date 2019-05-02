package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.postgresql.jdbc.PgConnection;
import org.postgresql.jdbc.PgResultSet;

import beans.Forum;
import beans.Topic;
import contracts.TopicContract;
import exceptions.NotFoundException;

/**
 * DAO to access {@link Topic}.
 */
public final class GeneralTopicDao extends BaseDao implements TopicDao {

    /** Request to fetch all the {@link Topic topics}. */
    private static final String SELECT_ALL_REQUEST = "SELECT * FROM " + TopicContract.TABLE
            + " WHERE " + TopicContract.ID_FORUM + " = ?";

    /** Request to get one {@link Topic topic}. */
    private static final String FIND_ONE_REQUEST = "SELECT * FROM " + TopicContract.TABLE
            + " WHERE " + TopicContract.ID + " = ?";

    @Override
    public List<Topic> findAll(final Forum forum) {

        final List<Topic> topics = new ArrayList<>();

        try {
            // Connect to database.
            final PgConnection connection = this.getFactory().getConnection();

            // Prepare request.
            final PreparedStatement statement = connection.prepareStatement(GeneralTopicDao.SELECT_ALL_REQUEST);
            statement.setLong(1, forum.getId());

            // Retrieve results.
            final PgResultSet resultSet = (PgResultSet) statement.executeQuery();

            while(resultSet.next()) {
                topics.add(this.map(resultSet));
            }

        } catch (final SQLException e) {
            e.printStackTrace();
        }

        return topics;
    }

    @Override
    public Topic findById(final Long id) throws NotFoundException {
        final Topic topic;

        try {
            final PreparedStatement statement = this.getFactory().getConnection()
                    .prepareStatement(GeneralTopicDao.FIND_ONE_REQUEST);

            statement.setLong(1, id);

            final PgResultSet result = (PgResultSet) statement.executeQuery();

            if (!result.next()) {
                throw new NotFoundException("Topic with id " + id + " doesn't exist.");
            }

            topic = this.map(result);

        } catch (final SQLException e) {
            throw new NotFoundException("An error occurred with the SQL request.");
        }

        return topic;
    }

    /**
     * Map the {@link PgResultSet} to {@link Topic}.
     *
     * @param resultSet
     * @return a {@link Topic}
     * @throws SQLException
     */
    private Topic map(final PgResultSet resultSet) throws SQLException {
        final Topic topic = new Topic();

        topic.setId(resultSet.getLong(TopicContract.ID));
        topic.setName(resultSet.getString(TopicContract.NAME));

        return topic;
    }
}
