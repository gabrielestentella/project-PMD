package gabrielestentella.controllers;

import java.io.IOException;

import gabrielestentella.App;
import gabrielestentella.dataAccessLogic.UtenteDAOImpl;
import org.slf4j.Logger;

public abstract class Controller {
    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(Controller.class);
    public void init() {}

    public void onNavigateFrom(Controller sender, Object [] parameters) {}

    public void navigate(String view, Object [] parameters) {
        try {
            App.navigate(this, view, parameters);
        } catch (IOException e) {
            LOGGER.error("Errore durante la navigazione: " + e.getStackTrace().toString());
        }
    }
}
