package beans;

import java.util.List;

import lombok.Data;

@Data
public class Forum {

    /** Unique id. */
    private Long id;

    /** List of all {@link Topic topics}. */
    private List<Topic> topics;
    
    public Forum () {
    	
    }
    
    public Forum (Long id) {
    	this.id = id;
    }
}
