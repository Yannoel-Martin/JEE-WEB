package connectors;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

/**
 * Class to access database.
 *
 * Grants the access to a {@link Connection}.
 */
public class Database {

    /** URL to MySQL database. */
    private static final String MYSQL_URL = "jdbc:mysql://localhost:3306/forum";

    /** User which has access to the database. */
    private static final String USER = "root";

    /** Password of the user. */
    private static final String PASSWORD = "password";

    /** Instance of the singleton class. */
    private static Database DATABASE_INSTANCE;

    /** Connection to the database. */
    private Connection connection;

    /**
     * Returns the unique instance of the Database.
     *
     * @return {@link Database}
     */
    public static Database instance() {
        if (Database.DATABASE_INSTANCE == null) {
            Database.DATABASE_INSTANCE = new Database();
        }

        return Database.DATABASE_INSTANCE;
    }

    /** Inner constructor. */
    private Database() {
        try {
            this.connection = (Connection) DriverManager.getConnection(Database.MYSQL_URL, Database.USER,
                    Database.PASSWORD);

        } catch (final SQLException e) {
            // TODO: Handle errors.
        }
    }

    /**
     * {@link Connection} accessor.
     *
     * @return the connection.
     */
    public Connection getConnection() {
        return this.connection;
    }

    /**
     * Destructor.
     *
     * @throws SQLException
     */
    @Override
    public void finalize() throws SQLException {
        this.connection.close();
    }
}
