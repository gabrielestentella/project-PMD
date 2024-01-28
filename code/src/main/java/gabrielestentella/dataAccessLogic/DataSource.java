package gabrielestentella.dataAccessLogic;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * @author Gabriele Stentella
 */
public class DataSource {
    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource sorgente;
    private static Properties connectionProperties;

    static {
        // Create a copy of connection properties to avoid modifying the original
        connectionProperties = new Properties();
        connectionProperties.setProperty("jdbcUrl", "jdbc:mariadb://localhost/dbTirocini");
        connectionProperties.setProperty("username", "root");
        connectionProperties.setProperty("password", "");
        connectionProperties.setProperty("maximumPoolSize", "10");

        config.setJdbcUrl(connectionProperties.getProperty("jdbcUrl"));
        config.setUsername(connectionProperties.getProperty("username"));
        config.setPassword(connectionProperties.getProperty("password"));
        config.setMaximumPoolSize(Integer.parseInt(connectionProperties.getProperty("maximumPoolSize")));
        sorgente = new HikariDataSource(config);
    }

    private DataSource() {}

    public static Connection getConn() throws SQLException {
        return sorgente.getConnection();
    }
}