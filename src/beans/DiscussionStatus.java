package beans;

import lombok.Getter;

/**
 * Status of a {@link Discussion}.
 */
@Getter
public enum DiscussionStatus {
    Opened(1L),
    Closed(2L);

    /** Unique id. */
    private Long id;

    /** Constructor. */
    DiscussionStatus(final Long id) {
        this.id = id;
    }
}
