package beans;

import java.util.List;

import lombok.Data;

@Data
public class Forum {

    /** Unique id. */
    private Integer id;

    /** List of all {@link Topic topics}. */
    private List<Topic> topics;
}
