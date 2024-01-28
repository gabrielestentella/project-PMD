package gabrielestentella.dataAccessLogic;

import gabrielestentella.models.Docente;
import gabrielestentella.models.StatoTirocinio;
import gabrielestentella.models.Studente;
import gabrielestentella.models.Tirocinio;

import java.util.*;

/**
 * @author Gabriele Stentella
 */
public class TirocinioDAOImpl implements TirocinioDAO {

    public TirocinioDAOImpl() {}

    @Override
    public List<Tirocinio> getTirociniDocente(Docente prof) {
        return null;
    }

    @Override
    public Tirocinio getTirociniobyStudente(Studente stud) {
        return null;
    }

    @Override
    public Tirocinio getTirociniobyStato(StatoTirocinio stato) {
        return null;
    }

    @Override
    public boolean inserisciTirocinio(Tirocinio tiroc) {
        return false;
    }

    @Override
    public boolean cancellaTirocinio(Tirocinio tiroc) {
        return false;
    }

    @Override
    public boolean modificaTirocinio(Tirocinio tiroc) {
        return false;
    }
}