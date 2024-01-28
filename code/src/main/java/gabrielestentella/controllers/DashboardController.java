package gabrielestentella.controllers;

import gabrielestentella.dataAccessLogic.TirocinioDAOImpl;
import gabrielestentella.models.Studente;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class DashboardController extends Controller{
    @FXML
    private Label title;

    @FXML
    private Button nuovoTirocinio;

    public void onNavigateFrom(Controller sender, Object [] parameters) {
        TirocinioDAOImpl dbTirocini = new TirocinioDAOImpl();
        if(parameters[0].toString().equals("studente")) {
            title.setText("Dashboard studente");
            if (dbTirocini.getTirociniobyStudente((Studente) parameters[1]) != null) {
                nuovoTirocinio.setVisible(false);
            } else {
                nuovoTirocinio.setVisible(true);
            }
        } else if(parameters[0].toString().equals("docente")) {
            title.setText("Dashboard docente");
            nuovoTirocinio.setVisible(false);
        } else if(parameters[0].toString().equals("commissione")) {
            title.setText("Dashboard commissione");
            nuovoTirocinio.setVisible(false);
        }
    }

    @FXML
    void logout() {
        navigate("Login", null);
    }
}
