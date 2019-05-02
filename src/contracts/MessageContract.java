package contracts;

import beans.Discussion;
import beans.User;
import lombok.experimental.UtilityClass;

/**
 * Database keys of the {@link Message} entity.
 */
@UtilityClass
public class MessageContract {

    /** Unique id. */
    public static final String ID = "id_message";

    /** Content of the {@link Message}. */
    public static final String CONTENT = "content";

    /** Date at which the {@link Message} has been sent. */
    public static final String SEND_AT = "sentAt";

    /** The {@link Discussion} the {@link Message} is linked to. */
    public static final String ID_DISCUSSION = "id_discussion";

    /** The {@link User} who owns the {@link Message}. */
    public static final String ID_USER = "id_user";
}
