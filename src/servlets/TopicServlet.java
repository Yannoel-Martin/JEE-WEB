package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TopicServlet extends HttpServlet {

	private static final long serialVersionUID = 7278965144281191677L;

	@Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {

		this.getServletContext().getRequestDispatcher("/WEB-INF/topic.jsp").forward(req, res);
	}
}
