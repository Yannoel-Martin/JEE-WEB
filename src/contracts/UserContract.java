package contracts;

import beans.User;
import lombok.experimental.UtilityClass;

/**
 * Database keys of the {@link User} entity.
 */
@UtilityClass
public class UserContract {

    /** Unique id. */
    public static final String ID = "id_user";

    /** Name of the {@link User}. */
    public static final String NAME = "name";

    /** Password of the {@link User}. */
    public static final String PASSWORD = "password";

    /** Role. */
    public static final String ROLE = "role";
}
