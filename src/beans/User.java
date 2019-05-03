package beans;

import lombok.Data;

@Data
public class User {

    /** Unique id. */
    private Long id;

    /** Name. */
    private String name;

    /** Password for authentification. */
    private String password;

    /** Salt associated to password. */
    private String salt;

    /** Rights on the app. */
    private UserRole role;

    public User () {

    }

    public User(final Long id, final String name, final String password, final UserRole role) {
    	this.id = id;
    	this.name = name;
    	this.password = password;
    	this.role = role;
    }
}
