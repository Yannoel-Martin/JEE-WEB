package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Forum;
import beans.Topic;
import beans.User;
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

	   if (this.accessIsAuthorized(req, res, false)) {
	       final Long id = this.getPathId(req);

	       if (id == null) {
	           this.redirect404(req, res);
	       } else {
	           try {
	               this.loadView(req, res, this.forumDao.findById(id));

	           } catch (final NotFoundException e) {
	               this.redirect404(req, res);
	           }
	       }
	   }
	}

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse res)
            throws ServletException, IOException {

        if (this.accessIsAuthorized(req, res, false)) {

            final Long id = this.getPathId(req);

            if (id != null) {
                try {
                    final String topicName = req.getParameter("topicName");
                    final Forum forum = this.forumDao.findById(id);

                    // Send the message.
                    this.topicDao.create(topicName, forum);

                    this.loadView(req, res, forum);
                } catch (final NotFoundException e) {

                }
            }
        }
    }

	/**
	 * Loads the view.
	 *
	 * @param req
	 * @param res
	 * @param forum
	 */
	private void loadView(final HttpServletRequest req, final HttpServletResponse res, final Forum forum) {
        final User user = this.getAuthentificatedUser(req, res);
		req.setAttribute("user", user);
	    req.setAttribute(ForumServlet.FORUM_INFOS, forum);
        req.setAttribute(ForumServlet.LIST_TOPICS, this.topicDao.findAll(forum));

        try {
            this.getServletContext().getRequestDispatcher(VIEW).forward(req, res);
        } catch (ServletException | IOException e) {

        }
	}
}
