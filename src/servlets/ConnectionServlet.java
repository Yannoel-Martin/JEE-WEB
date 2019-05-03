package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;
import dao.GeneralUserDao;
import dao.UserDao;

public class ConnectionServlet extends BaseServlet {

	/* generated ID serialisation Object */
	private static final long serialVersionUID = 1500899097398450168L;

	/** Servlet view. */
	private static final String VIEW = "/WEB-INF/forum.jsp";

	/** DAO to manipulate {@link User} entities. */
	private final UserDao dao = new GeneralUserDao();

	@Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {

	    // Name of the user.
        final String login = req.getParameter("login");

        // His password.
        final String password = req.getParameter("password");

        final User user = this.dao.connect(login, password);

        if (user != null) {
            final String token = this.getAuthService().generateToken(user);
            req.getSession().setAttribute(BaseServlet.TOKEN_ATTR, token);
        }

		this.getServletContext().getRequestDispatcher(ConnectionServlet.VIEW).forward(req, res);
	}

}
