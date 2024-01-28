package gabrielestentella.models;

import gabrielestentella.dataAccessLogic.TirocinioDAOImpl;

import java.io.File;
import java.util.Date;
import java.util.Date;

/**
 * @author Gabriele Stentella
 */
public class Tirocinio {
    // Req. non funzionale n°2: lo studente deve indicare obbligatoriamente uno e un solo relatore [...]
    //@ public invariant relatore != null;
    // Req. non funzionale n°6: se il tirocinio è esterno, deve essere indicato un tutor esterno oltre
    // al relatore accademico
    //@ public invariant tipologia == esterno ==> correlatore.length >= 1;
    private String titolo;

    private Date data_inizio;

    private Date data_fine;

    private Date data_approvazione = null;

    private StatoTirocinio stato;

    private TipoTirocinio tipologia;

    private String [] correlatore;

    private File autocertificazione;

    private Studente tirocinate;
    private Docente relatore;
    private Azienda azienda;

    public Tirocinio(String titolo, Date data_inizio, Date data_fine, TipoTirocinio tipologia,
                     String [] correlatore, File autocertificazione, Studente tirocinante, Docente relatore, Azienda azienda) {
        TirocinioDAOImpl dbTir = new TirocinioDAOImpl();

        this.titolo = titolo;
        this.data_inizio = data_inizio;
        this.data_fine = data_fine;
        this.tipologia = tipologia;
        this.correlatore = correlatore;
        this.autocertificazione = autocertificazione;
        this.stato = new Attesa1();
        this.tirocinate = tirocinante;
        this.relatore = relatore;
        this.azienda = azienda;

        azienda.addProgetto(this);
        relatore.notifica("E' stato creato un nuovo tirocinio in cui sei coinvolto come relatore");

        dbTir.inserisciTirocinio(this);

    }

    //@ requires this.stato.getClass() == Attesa1.class || this.stato.getClass() == Attesa2.class;
    //@ ensures (\old(this).stato.getClass() == Attesa1.class) ==> this.stato.getClass == Attesa2.class &&
    // (\old(this).stato.getClass()) == Attesa2.class ==> this.stato.getClass() == Approvato.class;
    public boolean approva() {
        if(stato.approva(this)){
            TirocinioDAOImpl dbTir = new TirocinioDAOImpl();
            dbTir.modificaTirocinio(this);
            return true;
        } else {
            return false;
        }
    }

    //@ requires this.stato.getClass() == Attesa1.class || this.stato.getClass() == Attesa2.class;
    //@ ensures this.stato == null;
    public boolean rifiuta() {
        if(stato.rifiuta(this)){
            TirocinioDAOImpl dbTir = new TirocinioDAOImpl();
            this.stato = null;
            dbTir.cancellaTirocinio(this);
            return true;
        } else {
            return false;
        }
    }

    //@ requires this.stato.getClass() == Approvato.class || this.stato.getClass() == In_corso.class;
    //@ ensures \old(this).stato.getClass() == Approvato.class ==> this.stato.getClass() == Approvato.class &&
    // \old(this).stato.getClass() == In_corso.class ==> this.stato.getClass() == In_corso.class;
    public boolean modifica(String title, Date end) {
        if(stato.modifica(this, title, end)){
            TirocinioDAOImpl dbTir = new TirocinioDAOImpl();
            dbTir.modificaTirocinio(this);
            return true;
        } else {
            return false;
        }
    }

    //@ requires this.stato.getClass() == In_corso.class;
    //@ ensures this.stato.getClass() == Terminato.class;
    public boolean termina() {
        if(stato.termina(this)){
            TirocinioDAOImpl dbTir = new TirocinioDAOImpl();
            dbTir.modificaTirocinio(this);
            return true;
        } else {
            return false;
        }
    }

    public String getTitolo() {
        return this.titolo;
    }

    public Date getInizio() {
        return this.data_inizio;
    }

    public Date getFine() {
        return this.data_fine;
    }

    public Date getApprovazione() {
        return this.data_approvazione;
    }

    public StatoTirocinio getStato() {
        return this.stato;
    }

    public TipoTirocinio getTipo() {
        return this.tipologia;
    }

    public void getCorrelatore(String [] corr) {
        corr[0] = this.correlatore[0];
        corr[1] = this.correlatore[1];
    }

    public Studente getTirocinante() {
        return this.tirocinate;
    }

    public Docente getRelatore() {
        return this.relatore;
    }

    public Azienda getAzienda() {
        return this.azienda;
    }

    public boolean setTitolo(String title) {
        this.titolo = title;
        return true;
    }

    public boolean setInizio(Date start) {
        this.data_inizio = start;
        return true;
    }

    public boolean setFine(Date end) {
        this.data_fine = end;
        return true;
    }

    public boolean setApprovazione(Date app) {
        this.data_approvazione = app;
        return true;
    }

    public boolean setTipologia(TipoTirocinio type) {
        this.tipologia = type;
        return true;
    }

    public boolean setCorrelatore(String [] corr) {
        this.correlatore = corr;
        return true;
    }

    public boolean setAutocertificazione(File aut) {
        this.autocertificazione = aut;
        return true;
    }
    public void cambiaStato(StatoTirocinio st) {
        this.stato = st;
    }
}