package gabrielestentella.models;

/**
 * @author Gabriele Stentella
 */
public class Docente extends UtenteUniversita {
    public Docente(String nome, String cognome, String email, String matricola, String ruolo) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.matricola = matricola;
        this.ruolo = ruolo;
    }

    private String nome;
    private String cognome;
    private String email;
    private String matricola;
    private String ruolo;

    public String getRuolo() {
        // TODO implement here
        return "";
    }
    public boolean setRuolo(String r) {
        // TODO implement here
        return false;
    }

}