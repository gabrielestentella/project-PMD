package gabrielestentella.models;

import java.util.*;

/**
 * @author Gabriele Stentella
 */
public class Studente extends UtenteUniversita {

    public Studente(String nome, String cognome, String email, String matricola, int CFUacquisiti, Set<Esame> esamiCompletati, String corsoDiLaurea) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.matricola = matricola;
        this.CFUacquisiti = CFUacquisiti;
        this.esamiCompletati = esamiCompletati;
        this.corsoDiLaurea = corsoDiLaurea;
    }

    private String nome;
    private String cognome;
    private String email;
    private String matricola;
    private int CFUacquisiti;
    private Set<Esame> esamiCompletati;
    private String corsoDiLaurea;

    public boolean controllaRequisiti() {
        // TODO implement here
        return false;
    }
    public int getCFU() {
        // TODO implement here
        return 0;
    }
    public void getEsami(Set<Esame> esami) {
        // TODO implement here
    }
    public String getCdL() {
        // TODO implement here
        return "";
    }
}