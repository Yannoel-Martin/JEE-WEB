package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Discussion;
import beans.DiscussionStatus;

public class TopicServlet extends HttpServlet {

	private static final long serialVersionUID = 7278965144281191677L;

	@Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {

		//TODO: get data from DB
		final String discussions = req.getParameter("discussions");

		final Long discussionId = 1L;
		final String discussionName = req.getParameter("discussionName");
		final DiscussionStatus discussionStatus = (DiscussionStatus.Opened);
		final Discussion discussion = new Discussion(discussionId,discussionName,discussionStatus);

		this.getServletContext().getRequestDispatcher("/WEB-INF/topic.jsp").forward(req, res);
	}

}
