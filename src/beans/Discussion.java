package beans;

import java.util.List;

import lombok.Data;

@Data
public class Discussion {

    /** Unique id. */
    private Long id;

    /** Name. */
    private String name;

    /** Opened or closed. */
    private DiscussionStatus status;

    /** Messages sent in the {@link Discussion}. */
    private List<Message> messages;
    
    public Discussion () {
    	
    }
    
    public Discussion (Long id, String name, DiscussionStatus status) {
    	this.id = id;
    	this.name = name;
    	this.status = status;
    }
}
