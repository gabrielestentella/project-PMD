package gabrielestentella.models;

import java.util.Date;

/**
 * 
 */
public interface StatoTirocinio {
    public boolean approva(Tirocinio tirocinio);
    public boolean rifiuta(Tirocinio tirocinio);
    public boolean modifica(Tirocinio tirocinio,String title, Date end);
    public boolean termina(Tirocinio tirocinio);
}