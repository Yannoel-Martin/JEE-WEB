package servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Base servlet class.
 */
public class BaseServlet extends HttpServlet {

    /**
     * Redirects to 404 page.
     *
     * @param req
     * @param res
     */
    protected void redirect404(final HttpServletRequest req, final HttpServletResponse res) {
        // TODO: Implement.
    }
}
