package gabrielestentella.dataAccessLogic;

import gabrielestentella.models.*;
import org.slf4j.Logger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Set;

public class UtenteDAOImpl implements UtenteDAO {
    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(UtenteDAOImpl.class);

    /**
     * Default constructor
     */
    public UtenteDAOImpl() {}

    public String login(String email, String password) throws SQLException {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(4);
        Connection ds = null;
        String response = null;
        try {
            ds = DataSource.getConn();
            String query = "SELECT * FROM Utente WHERE email = ?";
            PreparedStatement stmt = ds.prepareStatement(query);
            stmt.setString(1, email);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                if (encoder.matches(password, res.getString("password"))) {
                    response = res.getString("tipo");
                } else {
                    // password errata
                    LOGGER.info("Utente con email " + email + " ha inserito una password errata");
                    response = "errpsw";
                }
            } else {
                // utente non registrato
                LOGGER.info("Utente non registrato con email " + email + " ha tentato di accedere");
                response = "errmail";
            }
        } catch (SQLException e) {
            LOGGER.error("Errore durante l'accesso al database: " + e.getStackTrace().toString());
        } finally {
            try {
                if (ds != null) {
                    ds.close();
                }
            } catch (SQLException e) {
                LOGGER.error("Errore durante la chiusura della connessione al database: " + e.getStackTrace().toString());
            }
        }
        return response;
    }

    public UtenteUniversita getUtente(String email) throws SQLException {
        Connection ds = null;
        UtenteUniversita response = null;
        try {
            ds = DataSource.getConn();
            String query = "SELECT * FROM Utente WHERE email = ?";
            PreparedStatement stmt = ds.prepareStatement(query);
            stmt.setString(1, email);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                if (res.getString("tipo").equals("studente")) {
                    query.replace("Utente", "Studente");
                    res = stmt.executeQuery();
                    if (res.next())
                        response = new Studente(res.getString("nome"), res.getString("cognome"), res.getString("email"), res.getString("matricola"), res.getInt("CFUacquisiti"), null, res.getString("CdL"));
                } else if (res.getString("tipo").equals("docente") || res.getString("tipo").equals("commissione")) {
                    query.replace("Utente", "Docente");
                    res = stmt.executeQuery();
                    if (res.next())
                        response = new Docente(res.getString("nome"), res.getString("cognome"), res.getString("email"), res.getString("matricola"), res.getString("ruolo"));
                }
            }
        } catch (SQLException e) {
            LOGGER.error("Errore durante l'accesso al database: " + e.getStackTrace().toString());
        }
        return response;
    }
}
