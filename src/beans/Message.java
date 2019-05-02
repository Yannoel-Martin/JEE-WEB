package beans;

import java.time.ZonedDateTime;

import lombok.Data;

@Data
public class Message {

    /** Unique id. */
    private Long id;

    /** Content. */
    private String body;

    /** Date at which the {@link Message} has been sent. */
    private ZonedDateTime sendDate;

    /** Owner. */
    private User owner;
    
    public Message() {
    	
    }
    
	public Message(Long id, String body, ZonedDateTime sendDate) {
    	this.id = id;
    	this.body = body;
    	this.sendDate = sendDate;
    }
}
