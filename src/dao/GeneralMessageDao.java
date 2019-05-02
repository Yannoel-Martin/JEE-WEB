package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.postgresql.jdbc.PgConnection;
import org.postgresql.jdbc.PgResultSet;

import beans.Discussion;
import beans.Message;
import contracts.MessageContract;

/**
 * DAO to manipulate {@link Message} entities.
 */
public final class GeneralMessageDao extends BaseDao implements MessageDao {

    /** Request to fetch all the {@link Message messages}. */
    private static final String SELECT_ALL_REQUEST = "SELECT * FROM " + MessageContract.TABLE
            + " WHERE " + MessageContract.ID_DISCUSSION + " = ?";

    @Override
    public List<Message> findAll(final Discussion discussion) {

        final List<Message> messages = new ArrayList<>();

        try {
            // Connect to database.
            final PgConnection connection = this.getFactory().getConnection();

            // Prepare request.
            final PreparedStatement statement = connection.prepareStatement(GeneralMessageDao.SELECT_ALL_REQUEST);
            statement.setLong(1, discussion.getId());

            // Retrieve results.
            final PgResultSet resultSet = (PgResultSet) statement.executeQuery();

            while(resultSet.next()) {
                messages.add(this.map(resultSet));
            }

        } catch (final SQLException e) {
            e.printStackTrace();
        }

        return messages;
    }

    /**
     * Map the {@link PgResultSet} to {@link Message}.
     *
     * @param resultSet
     * @return a {@link Message}
     * @throws SQLException
     */
    private Message map(final PgResultSet resultSet) throws SQLException {
        final Message message = new Message();

        message.setId(resultSet.getLong(MessageContract.ID));
        message.setBody(resultSet.getString(MessageContract.CONTENT));

        // TODO: Map the owner.
        // TODO: Date conversion.

        return message;
    }
}
