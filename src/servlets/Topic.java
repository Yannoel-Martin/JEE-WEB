package servlets;

import java.io.IOException;
import java.time.ZonedDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Discussion;
import beans.DiscussionStatus;

public class Topic extends HttpServlet {

	private static final long serialVersionUID = 7278965144281191677L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		//TODO: get data from DB
		String discussions = req.getParameter("discussions");
		
		Long discussionId = 1L;
		String discussionName = req.getParameter("discussionName");
		DiscussionStatus discussionStatus = (DiscussionStatus.Opened);
		Discussion discussion = new Discussion(discussionId,discussionName,discussionStatus);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/topic.jsp").forward(req, res);
	}
	
}
