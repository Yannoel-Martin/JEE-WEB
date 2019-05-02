package beans;

import java.time.ZonedDateTime;

import lombok.Data;

@Data
public class Message {

    /** Unique id. */
    private Integer id;

    /** Content. */
    private String body;

    /** Date at which the {@link Message} has been sent. */
    private ZonedDateTime sendDate;

    /** Owner. */
    private User owner;
}
