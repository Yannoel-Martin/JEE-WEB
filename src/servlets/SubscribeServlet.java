package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UserRole;
import dao.GeneralUserDao;
import dao.UserDao;

/**
 * Servlet to subscribe.
 */
public final class SubscribeServlet extends HttpServlet {

	/** Serial number. */
	private static final long serialVersionUID = 1500899097398450168L;

	/** Servlet view. */
	private static final String VIEW = "/WEB-INF/redirect.jsp";

	/** DAO to manipulate {@link User} entities. */
	private final UserDao dao = new GeneralUserDao();

	@Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse res)
            throws ServletException, IOException {

	    // Name of the user.
	    final String login = req.getParameter("login");

	    // His password.
	    final String password = req.getParameter("password");

	    // Attributed role.
        final Integer role = Integer.parseInt(req.getParameter("role"));

        final UserRole userRole;

        if (role == 1) {
            userRole = UserRole.User;
        } else {
            userRole = UserRole.Admin;
        }

        if (login != null && login.length() > 0 && password != null && password.length() > 0) {

            final boolean success = this.dao.create(login, password, userRole);

            // Notify the user.
        }

		this.getServletContext().getRequestDispatcher(SubscribeServlet.VIEW).forward(req, res);
	}
}
