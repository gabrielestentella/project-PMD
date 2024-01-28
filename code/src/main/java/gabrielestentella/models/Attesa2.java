package gabrielestentella.models;

import java.util.Date;

/**
 * @author Gabriele Stentella
 */
public class Attesa2 {
    public boolean approva(Tirocinio tirocinio) {
        (tirocinio.getTirocinante()).notifica("Il tirocinio è stato approvato");
        tirocinio.setApprovazione(new Date());
        tirocinio.cambiaStato((StatoTirocinio) new Approvato(tirocinio));
        return false;
    }
    public boolean rifiuta(Tirocinio tirocinio) {
        (tirocinio.getTirocinante()).notifica("Il tirocinio è stato rifiutato dalla Commissione tirocini");
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