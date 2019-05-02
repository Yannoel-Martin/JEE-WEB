package dao;

import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

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

    /**
     * Generates a statements with the given fields.
     *
     * @param sql
     * @param objets
     * @return a {@link PreparedStatement}
     * @throws SQLException
     */
    protected PreparedStatement generateStatement(final String sql, final Object... objets) throws SQLException {

        final PreparedStatement preparedStatement = (PreparedStatement) this.connector.getConnection()
                .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        for (int i = 0; i < objets.length; i++) {
            preparedStatement.setObject(i + 1, objets[i]);
        }

        return preparedStatement;
    }
}
