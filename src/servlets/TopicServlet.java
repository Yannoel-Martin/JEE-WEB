package servlets;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Topic;
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

	    final String path = req.getPathInfo();
        final Pattern pattern = Pattern.compile("/([0-9]+)");

        if (path != null) {

            final Matcher match = pattern.matcher(path);

            if (match.matches()) {
                final Long id = Long.parseLong(match.group(1));

                try {
                    final Topic topic = this.topicDao.findById(id);

                    req.setAttribute(TopicServlet.TOPIC_INFO, topic);
                    req.setAttribute(TopicServlet.DISCUSSIONS_LIST, this.discussionDao.findAll(topic));

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
