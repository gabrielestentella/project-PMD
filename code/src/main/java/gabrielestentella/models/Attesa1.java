package gabrielestentella.models;

import java.util.Date;

/**
 * @author Gabriele Stentella
 */
public class Attesa1 implements StatoTirocinio {
    public boolean approva(Tirocinio tirocinio) {
        tirocinio.cambiaStato((StatoTirocinio) new Attesa2());
        return true;
    }
    public boolean rifiuta(Tirocinio tirocinio) {
        (tirocinio.getTirocinante()).notifica("Il tirocinio è stato rifiutato dal Relatore");
        tirocinio = null;
        return true;
    }
    public boolean modifica(Tirocinio tirocinio, String title, Date end) {
        return false;
    }
    public boolean termina(Tirocinio tirocinio) {
        return false;
    }
}