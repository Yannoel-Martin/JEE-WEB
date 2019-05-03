package servlets;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;
import lombok.AccessLevel;
import lombok.Getter;
import services.Authentification;

/**
 * Base servlet class.
 */
public class BaseServlet extends HttpServlet {

    /** Token attribute in the session. */
    public static final String TOKEN_ATTR = "token";

    /** Serial number. */
    private static final long serialVersionUID = -1929195511182857136L;

    /** View to display on error. */
    private static final String VIEW_404 = "/WEB-INF/404.jsp";

    /** Authentification service. */
    @Getter(value = AccessLevel.PROTECTED)
    private final Authentification authService = Authentification.getInstance();

    /**
     * Redirects to 404 page.
     *
     * @param req
     * @param res
     */
    protected void redirect404(final HttpServletRequest req, final HttpServletResponse res) {
        try {
            this.getServletContext().getRequestDispatcher(BaseServlet.VIEW_404).forward(req, res);
        } catch (ServletException | IOException e) {}
    }

    /**
     * Says if the access is authorized.
     * @param req
     * @param res
     * @param adminRestricted
     * @return
     */
    protected boolean accessIsAuthorized(final HttpServletRequest req, final HttpServletResponse res,
            final Boolean adminRestricted) {

        boolean authorized = false;

        final String token = (String) req.getSession().getAttribute(BaseServlet.TOKEN_ATTR);

        if (token != null) {
            authorized = this.authService.validAccess(token, adminRestricted);
        }

        // Redirect:
        if (!authorized) {
            this.redirect404(req, res);
        }

        return authorized;
    }

    /**
     * Gets the authentificated user.
     *
     * @param req
     * @param res
     * @return
     */
    protected User getAuthentificatedUser(final HttpServletRequest req, final HttpServletResponse res) {
        final String token = (String) req.getSession().getAttribute(BaseServlet.TOKEN_ATTR);

        return this.authService.getUserFromToken(token);
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
