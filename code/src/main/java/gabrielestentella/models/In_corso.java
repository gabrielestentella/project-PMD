package gabrielestentella.models;

import java.util.Date;

/**
 * @author Gabriele Stentella
 */
public class In_corso {
    public boolean approva(Tirocinio tirocinio) {
        return false;
    }
    public boolean rifiuta(Tirocinio tirocinio) {
        return false;
    }
    public boolean modifica(Tirocinio tirocinio, String title, Date end) {
        tirocinio.setTitolo(title);
        tirocinio.setFine(end);
        return true;
    }
    public boolean termina(Tirocinio tirocinio) {
        tirocinio.cambiaStato((StatoTirocinio) new Terminato());
        return true;
    }
}