package servlets;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;

/**
 * Base servlet class.
 */
public class BaseServlet extends HttpServlet {

    /** Serial number. */
    private static final long serialVersionUID = -1929195511182857136L;

    /**
     * Redirects to 404 page.
     *
     * @param req
     * @param res
     */
    protected void redirect404(final HttpServletRequest req, final HttpServletResponse res) {
        // TODO: Implement.
    }

    /**
     * Gets the authentificated user.
     *
     * @param req
     * @param res
     * @return
     */
    protected User getAuthentificatedUser(final HttpServletRequest req, final HttpServletResponse res) {
        final User user = new User();
        user.setId(1L);

        return user;
    }

    /**
     * Retrieves the id in the path.
     * @param req
     * @return
     */
    protected Long getPathId(final HttpServletRequest req) {
        final String path = req.getPathInfo();
        final Pattern pattern = Pattern.compile("/([0-9]+)");
        Long id = null;

        if (path != null) {
            final Matcher match = pattern.matcher(path);

            if (match.matches()) {
                id = Long.parseLong(match.group(1));
            }
        }

        return id;
    }
}
