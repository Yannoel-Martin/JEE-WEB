package servlets;

import java.io.IOException;
import java.time.ZonedDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Message;
import beans.User;

public class Discussion extends HttpServlet {

	private static final long serialVersionUID = 5622938890054157165L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		//TODO: get data from DB
		String messages = req.getParameter("messages");
		
		Long messageId = 1L;
		String messageContent = req.getParameter("messageContent");
		ZonedDateTime messageDate = ZonedDateTime.now();
		Message message = new Message(messageId,messageContent,messageDate);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/discussion.jsp").forward(req, res);
	}
}
