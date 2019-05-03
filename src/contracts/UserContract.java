package contracts;

import beans.User;
import lombok.experimental.UtilityClass;

/**
 * Database keys of the {@link User} entity.
 */
@UtilityClass
public class UserContract {

    /** Table name. */
    public static final String TABLE = "user_forum";

    /** Unique id. */
    public static final String ID = "id";

    /** Name of the {@link User}. */
    public static final String NAME = "name";

    /** Password of the {@link User}. */
    public static final String PASSWORD = "password";

    /** Salt linked to password. */
    public static final String SALT = "salt";

    /** Role. */
    public static final String ROLE = "role";
}
