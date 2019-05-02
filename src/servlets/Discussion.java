package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Discussion extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String messages = req.getParameter("messages");
		this.getServletContext().getRequestDispatcher("/WEB-INF/discussion.jsp").forward(req, res);
	}
}
