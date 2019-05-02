package connectors;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.postgresql.jdbc.PgConnection;

import com.mysql.jdbc.Connection;

/**
 * Class to access database.
 *
 * Grants the access to a {@link Connection}.
 */
public class Database {

    /** URL to MySQL database. */
    private static final String MYSQL_URL = "jdbc:postgresql://localhost:5432/forum";

    /** User which has access to the database. */
    private static final String USER = "postgres";

    /** Password of the user. */
    private static final String PASSWORD = "password";

    /** Instance of the singleton class. */
    private static Database DATABASE_INSTANCE;

    /** Connection to the database. */
    private PgConnection connection;

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
            Class.forName("org.postgresql.Driver");
        } catch ( final ClassNotFoundException e ) {
            /* Gérer les éventuelles erreurs ici. */
        }

        try {
            this.connection = (PgConnection) DriverManager.getConnection(Database.MYSQL_URL, Database.USER,
                    Database.PASSWORD);

        } catch (final SQLException e) {
            System.out.println(e.getMessage());
            // TODO: Handle errors.
        }
    }

    /**
     * {@link PgConnection} accessor.
     *
     * @return the connection.
     */
    public PgConnection getConnection() {
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
