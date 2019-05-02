package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;

public class Forum extends HttpServlet {

	private static final long serialVersionUID = 7440684528279758678L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String topics = req.getParameter("topics");
		this.getServletContext().getRequestDispatcher("/WEB-INF/forum.jsp").forward(req, res);
	}
}
