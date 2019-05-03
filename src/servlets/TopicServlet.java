package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Topic;
import beans.User;
import dao.DiscussionDao;
import dao.GeneralDiscussionDao;
import dao.GeneralTopicDao;
import dao.TopicDao;
import exceptions.NotFoundException;

public final class TopicServlet extends BaseServlet {

    /** Serial number. */
	private static final long serialVersionUID = 7278965144281191677L;

	/** Servlet view. */
	private static final String VIEW = "/WEB-INF/topic.jsp";

	/** Key to access {@link DiscussionServlet discussions} in view. */
	private static final String DISCUSSIONS_LIST = "discussions";

	/** Key to access {@link Topic} in view. */
	private static final String TOPIC_INFO = "topic";

	/** DAO to manipulate {@link Topic} entities. */
	private final TopicDao topicDao = new GeneralTopicDao();

	/** DAO to manipulate {@link DiscussionServlet} entities. */
	private final DiscussionDao discussionDao = new GeneralDiscussionDao();

	@Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse res)
            throws ServletException, IOException {

        final Long id = this.getPathId(req);

        if (id != null) {
            try {
                this.loadView(req, res, this.topicDao.findById(id));

            } catch (final NotFoundException e) {

            }
        }
	}

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse res)
            throws ServletException, IOException {

        final Long id = this.getPathId(req);

        if (id != null) {
            try {
                final String discussionName = req.getParameter("discussionName");
                final Topic topic = this.topicDao.findById(id);

                // Send the message.
                this.discussionDao.create(discussionName, topic);

                this.loadView(req, res, topic);
            } catch (final NotFoundException e) {

            }
        }
    }

    /**
     * Loads the view.
     *
     * @param req
     * @param res
     * @param topic
     */
    private void loadView(final HttpServletRequest req, final HttpServletResponse res, final Topic topic) {
        final User user = this.getAuthentificatedUser(req, res);
		req.setAttribute("user", user);
        req.setAttribute(TopicServlet.TOPIC_INFO, topic);
        req.setAttribute(TopicServlet.DISCUSSIONS_LIST, this.discussionDao.findAll(topic));

        try {
            this.getServletContext().getRequestDispatcher(VIEW).forward(req, res);
        } catch (ServletException | IOException e) {

        }
    }
}
