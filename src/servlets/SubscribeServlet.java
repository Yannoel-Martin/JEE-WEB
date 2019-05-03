package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;

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
		final User user = new User();
		user.setName("John Doe");
//		List<Topic> topics = Arrays.asList(new Topic());
//		req.setAttribute("topics", topics);
		req.setAttribute("user", user);
		this.getServletContext().getRequestDispatcher(SubscribeServlet.VIEW).forward(req, res);
	}
}
