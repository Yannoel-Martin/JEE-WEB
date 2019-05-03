package servlets;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Forum;
import beans.Topic;
import dao.ForumDao;
import dao.GeneralForumDao;
import dao.GeneralTopicDao;
import dao.TopicDao;
import exceptions.NotFoundException;

public final class ForumServlet extends BaseServlet {

    /** Serial number. */
	private static final long serialVersionUID = 7440684528279758678L;

	/** View associated to the servlet. */
	private static final String VIEW = "/WEB-INF/forum.jsp";

	/** Key to access informations on the {@link Forum} */
	private static final String FORUM_INFOS = "forum";

	/** Key to access all the topics. */
	private static final String LIST_TOPICS = "topics";

	/** DAO to manipulate {@link Topic topics}. */
	private final TopicDao topicDao = new GeneralTopicDao();

	/** DAO to manipulate {@link Forum forums}. */
	private final ForumDao forumDao = new GeneralForumDao();

	@Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse res)
            throws ServletException, IOException {

	    final String path = req.getPathInfo();
	    final Pattern pattern = Pattern.compile("/([0-9]+)");

	    if (path != null) {

	        final Matcher match = pattern.matcher(path);

	        if (match.matches()) {
	            final Long id = Long.parseLong(match.group(1));

	            try {
                    final Forum forum = this.forumDao.findById(id);

                    req.setAttribute(ForumServlet.FORUM_INFOS, forum);
                    req.setAttribute(ForumServlet.LIST_TOPICS, this.topicDao.findAll(forum));

                    this.getServletContext().getRequestDispatcher(VIEW).forward(req, res);

                } catch (final NotFoundException e) {
                    this.redirect404(req, res);
                }
	        } else {
	            this.redirect404(req, res);
	        }
	    } else {
	        this.redirect404(req, res);
	    }
	}
}
