package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.postgresql.jdbc.PgConnection;
import org.postgresql.jdbc.PgResultSet;

import beans.Discussion;
import beans.Message;
import beans.User;
import contracts.MessageContract;
import contracts.UserContract;

/**
 * DAO to manipulate {@link Message} entities.
 */
public final class GeneralMessageDao extends BaseDao implements MessageDao {

    /** Request to fetch all the {@link Message messages}. */
    private static final String SELECT_ALL_REQUEST = "SELECT * FROM " + MessageContract.TABLE
            + " INNER JOIN " + UserContract.TABLE
            + " ON " + MessageContract.TABLE + "." + MessageContract.ID_USER
            + " = " + UserContract.TABLE + "." + UserContract.ID
            + " WHERE " + MessageContract.ID_DISCUSSION + " = ?";

    /** Request to add a message. */
    private static final String INSERT_REQUEST = "INSERT INTO " + MessageContract.TABLE
            + "(" + MessageContract.CONTENT + ", " + MessageContract.SEND_AT + ", "
            + MessageContract.ID_DISCUSSION + ", " + MessageContract.ID_USER + ")"
            + " VALUES(?, ?, ?, ?)";

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

    @Override
    public void sendMessage(final String content, final Discussion discussion, final User owner) {

        final Long userId = owner.getId();
        final Long discussionId = discussion.getId();

        try {
            // Connect to database.
            final PgConnection connection = this.getFactory().getConnection();

            // Prepared request.
            final PreparedStatement statement = connection.prepareStatement(GeneralMessageDao.INSERT_REQUEST);

            statement.setString(1, content);
            statement.setDate(2, java.sql.Date.valueOf(java.time.LocalDate.now()));
            statement.setLong(3, discussionId);
            statement.setLong(4, userId);

            statement.executeQuery();

        } catch (final SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Map the {@link PgResultSet} to {@link Message}.
     *
     * @param resultSet
     * @return a {@link Message}
     * @throws SQLException
     * @throws
     */
    private Message map(final PgResultSet resultSet) throws SQLException {
        final Message message = new Message();

        message.setId(resultSet.getLong(MessageContract.ID));
        message.setBody(resultSet.getString(MessageContract.CONTENT));

        final User user = new User();
        user.setName(resultSet.getString(UserContract.NAME));

        message.setOwner(user);

        try {
         // Parse date.
            final Date date = new SimpleDateFormat("yyyy-MM-dd").parse(resultSet.getString(MessageContract.SEND_AT));
            message.setSendDate(date);
        } catch (final Exception e) {
            message.setSendDate(null);
        }

        return message;
    }
}
