package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Identification extends HttpServlet {
	
	/* generated ID serialisation Object */
	private static final long serialVersionUID = 1500899097398450168L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/identification.jsp").forward(req, res);
	}
	
}
