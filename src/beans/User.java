package beans;

import lombok.Data;

@Data
public class User {

    /** Unique id. */
    private Integer id;

    /** Name. */
    private String name;

    /** Password for authentification. */
    private String password;

    /** Rights on the app. */
    private UserRole role;
}
