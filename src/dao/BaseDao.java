package dao;

import connectors.Database;
import lombok.AccessLevel;
import lombok.Getter;

/**
 * Base DAO.
 */
public class BaseDao {

    /** Connector to access database. */
    @Getter(value = AccessLevel.PROTECTED)
    private final Database connector;

    /** Protected constructor. */
    protected BaseDao() {
        this.connector = Database.instance();
    }
}
