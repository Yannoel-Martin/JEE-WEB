package beans;

import lombok.Getter;

@Getter
public enum UserRole {
    User(0L),
    Admin(1L);

    private Long id;

    /** Constructor. */
    UserRole(final Long id) {
        this.id = id;
    }
}
