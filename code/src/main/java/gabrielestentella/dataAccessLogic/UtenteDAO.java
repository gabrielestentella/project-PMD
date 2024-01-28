package gabrielestentella.dataAccessLogic;

import gabrielestentella.models.UtenteUniversita;

import java.sql.SQLException;

/**
 * @author Gabriele Stentella
 */
public interface UtenteDAO {
    public String login(String email, String password) throws SQLException;
    public UtenteUniversita getUtente(String email) throws SQLException;
}
