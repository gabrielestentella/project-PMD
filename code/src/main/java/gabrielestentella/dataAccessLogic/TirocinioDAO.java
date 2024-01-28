package gabrielestentella.dataAccessLogic;

import gabrielestentella.models.Docente;
import gabrielestentella.models.StatoTirocinio;
import gabrielestentella.models.Studente;
import gabrielestentella.models.Tirocinio;

import java.util.*;

/**
 * @author Gabriele Stentella
 */
public interface TirocinioDAO {
    public List<Tirocinio> getTirociniDocente(Docente prof);
    public Tirocinio getTirociniobyStudente(Studente stud);
    public Tirocinio getTirociniobyStato(StatoTirocinio stato);
    public boolean inserisciTirocinio(Tirocinio tiroc);
    public boolean cancellaTirocinio(Tirocinio tiroc);
    public boolean modificaTirocinio(Tirocinio tiroc);
}