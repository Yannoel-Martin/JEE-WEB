package services;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.postgresql.jdbc.PgConnection;

import exceptions.ConfigurationException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Class to access database.
 *
 * Grants the access to a {@link PgConnection}.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConnectionFactory {

    /** Connection URL. */
    private static final String PROPERTY_URL = "jdbc:postgresql://localhost:5432/forum";

    /** Driver used for the database. */
    private static final String PROPERTY_DRIVER = "org.postgresql.Driver";

    /** User which has access to the database. */
    private static final String PROPERTY_USER = "postgres";

    /** User password. */
    private static final String PROPERTY_PASSWORD = "password";

    /** Instance of the singleton class. */
    private static ConnectionFactory DATABASE_INSTANCE;

    /**
     * Returns the unique instance of the Database.
     *
     * @return {@link ConnectionFactory}
     */
    public static ConnectionFactory getInstance() {
        if (ConnectionFactory.DATABASE_INSTANCE == null) {
            try {
                Class.forName(ConnectionFactory.PROPERTY_DRIVER);
            } catch ( final ClassNotFoundException e ) {
                throw new ConfigurationException("The driver cannot be found in the classpath.");
            }

            ConnectionFactory.DATABASE_INSTANCE = new ConnectionFactory();
        }

        return ConnectionFactory.DATABASE_INSTANCE;
    }

    /**
     * Connects to the database.
     *
     * @return
     * @throws SQLException
     */
    public PgConnection getConnection() throws SQLException {

        return (PgConnection) DriverManager.getConnection(
                ConnectionFactory.PROPERTY_URL,
                ConnectionFactory.PROPERTY_USER,
                ConnectionFactory.PROPERTY_PASSWORD);
    }
}
