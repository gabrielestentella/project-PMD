package gabrielestentella.controllers;

import gabrielestentella.models.Studente;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import gabrielestentella.dataAccessLogic.UtenteDAOImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.SQLException;

public class LoginController extends Controller {

    @FXML
    private Button loginButton;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label error;

    @FXML
    void login() throws SQLException {
        String email = emailField.getText();
        String password = passwordField.getText();
        UtenteDAOImpl dbUtenti = new UtenteDAOImpl();
        String type = dbUtenti.login(email, password);
        switch (type) {
            case "errmail":
                // utente non registrato
                error.setText("Utente non registrato");
                error.setVisible(true);
                break;
            case "errpsw":
                // password errata
                error.setText("Password errata");
                error.setVisible(true);
                break;
            default:
                // login studente/docente/commissione
                Object [] p = new Object[2];
                p[0] = type;
                p[1] = dbUtenti.getUtente(email);
                navigate("Dashboard", p);
                break;
        }
    }
}

