package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UserRole;

/**
 * Servlet to subscribe.
 */
public final class SubscribeServlet extends HttpServlet {

	/** Serial number. */
	private static final long serialVersionUID = 1500899097398450168L;

	/** Servlet view. */
	private static final String VIEW = "/WEB-INF/forum.jsp";

	@Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {

	    final String login = req.getParameter("login");
	    final String password = req.getParameter("password");
        final Integer role = Integer.parseInt(req.getParameter("role"));

        final UserRole userRole;

        if (role == 1) {
            userRole = UserRole.User;
        } else {
            userRole = UserRole.Admin;
        }

		this.getServletContext().getRequestDispatcher(SubscribeServlet.VIEW).forward(req, res);
	}
}
