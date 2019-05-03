package services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;
import beans.UserRole;
import dao.GeneralUserDao;
import dao.UserDao;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Authentification {

    /** Unique instance. */
    private static Authentification instance;

    /** Secret key for hash. */
    private static final String SECRET_KEY = "secret";

    /** DAO to manipulate {@link User}. */
    private final UserDao dao = new GeneralUserDao();

    /**
     * Gets the unique instance of the authentification service.
     * @return the service.
     */
    public static Authentification getInstance() {
        if (Authentification.instance == null) {
            Authentification.instance = new Authentification();
        }

        return Authentification.instance;
    }

    /**
     * Generates a token with the user.
     * @param user
     * @return
     */
    public String generateToken(final User user) {
        final String key = "secret";

        final String payload = user.getName() + "," + user.getId();

        return Jwts.builder().setPayload(payload)
                .signWith(SignatureAlgorithm.HS256, key)
                .compact();
    }

    /**
     * Checks the validity of the token.
     *
     * @param token
     * @param adminRestricted - Check if admin
     * @return
     */
    public boolean validAccess(final String token, final Boolean adminRestricted) {

        boolean valid = false;

        final String payload = Jwts.parser().setSigningKey("secret").parse(token).getBody().toString();
        final String[] vals = payload.split(",");

        if (vals.length == 2) {
            final String name = vals[0];
            final Long id = Long.parseLong(vals[1]);

            final User user = this.dao.findOne(id);

            if (user != null && name.equals(user.getName())) {

                if (adminRestricted) {
                    if (user.getRole() == UserRole.Admin) {
                        valid = true;
                    }
                } else {
                    valid = true;
                }
            }
        }

        return valid;
    }

    /**
     * Extracts the {@link User} from the token.
     * @param token
     * @return
     */
    public User getUserFromToken(final String token) {
        User user = null;

        final String payload = Jwts.parser().setSigningKey("secret").parse(token).getBody().toString();
        final String[] vals = payload.split(",");

        if (vals.length == 2) {
            final String name = vals[0];
            final Long id = Long.parseLong(vals[1]);

            user = this.dao.findOne(id);

            if (user != null && !name.equals(user.getName())) {
                user = null;
            }
        }

        return user;
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
