package dao;

import connectors.ConnectionFactory;
import lombok.AccessLevel;
import lombok.Getter;

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
