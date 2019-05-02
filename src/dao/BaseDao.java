package dao;

import lombok.AccessLevel;
import lombok.Getter;
import services.ConnectionFactory;

/**
 * Base DAO.
 */
public class BaseDao {

    /** Connector to access database. */
    @Getter(value = AccessLevel.PROTECTED)
    private final ConnectionFactory factory;

    /** Protected constructor. */
    protected BaseDao() {
        this.factory = ConnectionFactory.getInstance();
    }
}
