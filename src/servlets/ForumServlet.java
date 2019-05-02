package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Forum;
import beans.Topic;
import dao.GeneralTopicDao;
import dao.TopicDao;

public class ForumServlet extends HttpServlet {

	private static final long serialVersionUID = 7440684528279758678L;

	/** DAO to manipulate {@link TopicServlet topics}. */
	private final TopicDao dao = new GeneralTopicDao();

	@Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {

	    // TODO: Fetch forum.
	    final Forum forum = new Forum();

	    forum.setId(1);

	    final List<Topic> topics = this.dao.findAll(forum);

		this.getServletContext().getRequestDispatcher("/WEB-INF/forum.jsp").forward(req, res);
	}
}
