package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import beans.Forum;
import beans.Topic;
import contracts.TopicContract;

/**
 * DAO to access {@link Topic}.
 */
public final class GeneralTopicDao extends BaseDao implements TopicDao {

    /** Request to fetch all the {@link Topic topics}. */
    private static final String FIND_ALL_REQUEST = "SELECT * FROM " + TopicContract.TABLE
            + "WHERE " + TopicContract.ID_FORUM + " = ?";

    @Override
    public List<Topic> findAll(final Forum forum) {

        final List<Topic> topics = new ArrayList<>();

        try {
            final PreparedStatement statement = this.generateStatement(
                    GeneralTopicDao.FIND_ALL_REQUEST, forum.getId());

            final ResultSet resultSet = (ResultSet) statement.executeQuery();

            while(resultSet.next()) {
                topics.add(this.map(resultSet));
            }

        } catch (final SQLException e) {
            e.printStackTrace();
        }

        return topics;
    }

    /**
     * Map the {@link ResultSet} to {@link Topic}.
     *
     * @param resultSet
     * @return a {@link Topic}
     * @throws SQLException
     */
    private Topic map(final ResultSet resultSet) throws SQLException {
        final Topic topic = new Topic();

        topic.setId(resultSet.getLong(TopicContract.ID));
        topic.setName(resultSet.getString(TopicContract.NAME));

        return topic;
    }
}
