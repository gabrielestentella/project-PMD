package gabrielestentella.models;

import java.util.Date;

/**
 * @author Gabriele Stentella
 */
public class Terminato {
    public boolean approva(Tirocinio tirocinio) {
        return false;
    }
    public boolean rifiuta(Tirocinio tirocinio) {
        return false;
    }
    public boolean modifica(Tirocinio tirocinio, String title, Date end) {
        return false;
    }
    public boolean termina(Tirocinio tirocinio) {
        return false;
    }
}