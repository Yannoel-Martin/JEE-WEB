package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Discussion;
import beans.Message;
import beans.User;
import dao.DiscussionDao;
import dao.GeneralDiscussionDao;
import dao.GeneralMessageDao;
import dao.MessageDao;
import exceptions.NotFoundException;

public final class DiscussionServlet extends BaseServlet {

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

        if (this.accessIsAuthorized(req, res, false)) {
            final Long id = this.getPathId(req);

            if (id != null) {
                try {
                    final Discussion discussion = this.discussionDao.findById(id);

                    this.loadView(req, res, discussion);
                } catch (final NotFoundException e) {

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
                    final String body = req.getParameter("messageBody");
                    final User user = this.getAuthentificatedUser(req, res);
                    final Discussion discussion = this.discussionDao.findById(id);

                    // Send the message.
                    this.messageDao.sendMessage(body, discussion, user);

                    this.loadView(req, res, discussion);
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
	 * @param discussion
	 */
	private void loadView(final HttpServletRequest req, final HttpServletResponse res, final Discussion discussion) {
        final User user = this.getAuthentificatedUser(req, res);
		req.setAttribute("user", user);
		req.setAttribute(DiscussionServlet.DISCUSSION_INFO, discussion);

		final List<Message> messages = this.messageDao.findAll(discussion);
        req.setAttribute(DiscussionServlet.MESSAGES_LIST, messages);

        try {
            this.getServletContext().getRequestDispatcher(DiscussionServlet.VIEW).forward(req, res);
        } catch (ServletException | IOException e) {

        }
	}
}
