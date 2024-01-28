package gabrielestentella.models;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Gabriele Stentella
 */
public class Approvato {
    Timer timer = new Timer();
    public Approvato(Tirocinio tirocinio) {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                tirocinio.cambiaStato((StatoTirocinio) new In_corso());
            }
        };
        timer.schedule(task, tirocinio.getInizio());
    }
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