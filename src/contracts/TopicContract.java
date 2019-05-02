package contracts;

import beans.Forum;
import beans.Topic;
import lombok.experimental.UtilityClass;

/**
 * Database keys of the {@link Topic} entity.
 */
@UtilityClass
public class TopicContract {

    /** Table where are stored the {@link Topic topics}. */
    public static final String TABLE = "topic";

    /** Unique id. */
    public static final String ID = "id_topic";

    /** Name of the topic. */
    public static final String NAME = "name";

    /** {@link Forum} that owns the {@link Topic}. */
    public static final String ID_FORUM = "id_topic";
}
