package contracts;

import beans.Discussion;
import lombok.experimental.UtilityClass;

/**
 * Database keys of the {@link Discussion} entity.
 */
@UtilityClass
public class DiscussionContract {

    /** Unique id. */
    public static final String ID = "id_discussion";

    /** Name. */
    public static final String NAME = "name";

    /** {@link Discussion#getStatus() Status}. */
    public static final String STATUS = "status";

    /** Topic associated to. */
    public static final String ID_TOPIC = "id_topic";
}
