package gabrielestentella.models;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gabriele Stentella
 */
public class CommissioneTirocini {
    private List<Docente> membri = new ArrayList<>();;
    public CommissioneTirocini() {}

    //@ requires prof != null;
    //@ ensures membri.contains(prof);
    public boolean aggiungiMembro(Docente prof) {
        membri.add(prof);
        return true;
    }

    //@ requires prof != null;
    //@ ensures !membri.contains(prof);
    public boolean rimuoviMembro(Docente prof) {
        membri.remove(prof);
        return true;
    }

    public boolean controllaAppartenenza(Docente prof) {
        return membri.contains(prof);
    }

}