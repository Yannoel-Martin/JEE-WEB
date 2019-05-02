package services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GeneralUserDao;
import dao.UserDao;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Authentification {

    /** Unique instance. */
    private static Authentification instance;

    /** DAO to manipulate {@link User}. */
    private final UserDao dao = new GeneralUserDao();

    /**
     * Gets the unique instance of the authentification service.
     * @return the service.
     */
    public Authentification getInstance() {
        if (Authentification.instance == null) {
            Authentification.instance = new Authentification();
        }

        return Authentification.instance;
    }

    /**
     * Says if the user is authentificated.
     * @param req
     * @param res
     * @return TRUE or FALSE.
     */
    public boolean authentificated(final HttpServletRequest req, final HttpServletResponse res) {

        return true;
    }
}
