package dao;

import java.util.List;

import beans.Discussion;
import beans.Message;
import beans.User;

/**
 * DAO to manipulate {@link Message} entities.
 */
public interface MessageDao {

    /**
     * Finds all the {@link Message messages} of the given {@link Discussion}.
     *
     * @param discussion
     * @return list of message
     */
    List<Message> findAll(Discussion discussion);

    /**
     * Sends the message.
     *
     * @param content
     * @param discussion
     * @param owner
     */
    void sendMessage(String content, Discussion discussion, User owner);
}
