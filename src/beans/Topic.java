package beans;

import java.util.List;

import lombok.Data;

@Data
public class Topic {

    /** Unique id. */
    private Integer id;

    /** Name. */
    private String name;

    /** List of all {@link Discussion discussions}. */
    private List<Discussion> discussions;
}
