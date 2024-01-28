package gabrielestentella.models;

import java.net.URI;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.mail.Session;
import javax.mail.Transport;
/**
 * @author Gabriele Stentella
 */
public abstract class UtenteUniversita {
    private String nome;

    private String cognome;

    private String email;

    private String matricola;

    public String notifica(String evento){
        return "";
    }

    public String getNome() {
        // TODO implement here
        return "";
    }

    public String getCognome() {
        // TODO implement here
        return "";
    }

    public String getEmail() {
        // TODO implement here
        return "";
    }

    public String getMatricola() {
        // TODO implement here
        return "";
    }

}