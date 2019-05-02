package contracts;

import beans.Forum;
import lombok.experimental.UtilityClass;

/**
 * Database keys of the {@link Forum} entity.
 */
@UtilityClass
public class ForumContract {

    /** Table. */
    public static final String TABLE = "forum";

    /** Unique id. */
    public static final String ID = "id";
}
