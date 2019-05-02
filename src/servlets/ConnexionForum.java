package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConnexionForum extends HttpServlet {
	
	/* generated ID serialisation Object */
	private static final long serialVersionUID = 1500899097398450168L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Etudiant student = new Etudiant();
		student.setNom("Martin");
		student.setPrenom("Yannou");
		student.setNumeroEtudiant(0155522);
		student.setAdresse("42 rue de Cimmérie");
		student.setPromotion("2017/2018");
		student.setMajeur(true);
		req.setAttribute("etudiant", student);
		this.getServletContext().getRequestDispatcher("/WEB-INF/student.jsp").forward(req, res);
	}

}
