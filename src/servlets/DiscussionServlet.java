package servlets;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Discussion;
import beans.Message;
import dao.DiscussionDao;
import dao.GeneralDiscussionDao;
import dao.GeneralMessageDao;
import dao.MessageDao;
import exceptions.NotFoundException;

public final class DiscussionServlet extends HttpServlet {

    /** Serial number. */
	private static final long serialVersionUID = 5622938890054157165L;

	/** Servlet view. */
	private static final String VIEW = "/WEB-INF/discussion.jsp";

	/** Key to access informations on {@link Discussion} in view. */
	private static final String DISCUSSION_INFO = "discussion";

	/** Key to access linked {@link Message messages} in view. */
	private static final String MESSAGES_LIST = "messages";

	/** DAO to manipulate {@link Discussion} entities. */
	private final DiscussionDao discussionDao = new GeneralDiscussionDao();

	/** DAO to manipulate {@link Message} entities. */
	private final MessageDao messageDao = new GeneralMessageDao();

	@Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {

	    final String path = req.getPathInfo();
        final Pattern pattern = Pattern.compile("/([0-9]+)");

        if (path != null) {

            final Matcher match = pattern.matcher(path);

            if (match.matches()) {
                final Long id = Long.parseLong(match.group(1));

                try {
                    final Discussion discussion = this.discussionDao.findById(id);

                    req.setAttribute(DiscussionServlet.DISCUSSION_INFO, discussion);
                    req.setAttribute(DiscussionServlet.MESSAGES_LIST, this.messageDao.findAll(discussion));

                    this.getServletContext().getRequestDispatcher(VIEW).forward(req, res);

                } catch (final NotFoundException e) {
                    // TODO: 404 page.
                }
            }
        }
	}
}
