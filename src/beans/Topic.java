package beans;

import java.util.List;

import lombok.Data;

@Data
public class Topic {

    /** Unique id. */
    private Long id;

    /** Name. */
    private String name;

    /** List of all {@link Discussion discussions}. */
    private List<Discussion> discussions;
    
    public Topic () {
    	
    }
    
    public Topic (Long id, String name) {
    	this.id = id;
    	this.name = name;
    }
}
