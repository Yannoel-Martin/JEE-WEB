package beans;

import java.util.Date;

import lombok.Data;

@Data
public class Message {

    /** Unique id. */
    private Long id;

    /** Content. */
    private String body;

    /** Date at which the {@link Message} has been sent. */
    private Date sendDate;

    /** Owner. */
    private User owner;

    public Message() {

    }

	public Message(final Long id, final String body, final Date sendDate) {
    	this.id = id;
    	this.body = body;
    	this.sendDate = sendDate;
    }
}
