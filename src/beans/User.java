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

    /** Rights on the app. */
    private UserRole role;
    
    public User () {
    	
    }
    
    public User(Long id, String name, String password, UserRole role) {
    	this.id = id;
    	this.name = name;
    	this.password = password;
    	this.role = role;
    }
}
