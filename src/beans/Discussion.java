package beans;

import java.util.List;

import lombok.Data;

@Data
public class Discussion {

    /** Unique id. */
    private Integer id;

    /** Name. */
    private String name;

    /** Opened or closed. */
    private DiscussionStatus status;

    /** Messages sent in the {@link Discussion}. */
    private List<Message> messages;
}
