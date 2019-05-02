package servlets;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Topic;
import beans.User;

public class ConnexionForum extends HttpServlet {
	
	/* generated ID serialisation Object */
	private static final long serialVersionUID = 1500899097398450168L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		Etudiant student = new Etudiant();
//		student.setNom("Martin");
//		student.setPrenom("Yannou");
//		student.setNumeroEtudiant(0155522);
//		student.setAdresse("42 rue de Cimmérie");
//		student.setPromotion("2017/2018");
//		student.setMajeur(true);
		User user = new User();
		user.setName("John Doe");
//		List<Topic> topics = Arrays.asList(new Topic());
//		req.setAttribute("topics", topics);
		req.setAttribute("user", user);
		this.getServletContext().getRequestDispatcher("/WEB-INF/forum.jsp").forward(req, res);
	}

}
