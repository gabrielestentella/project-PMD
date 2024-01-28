package gabrielestentella.models;

import java.util.*;

/**
 * @author Gabriele Stentella
 */
public class Azienda {

    public Azienda(String nome, String sede_legale) {
        this.nome = nome;
        this.sede_legale = sede_legale;
    }

    private String nome;
    private String sede_legale;
    private List<Tirocinio> progetti = new ArrayList<>();

    public void addProgetto(Tirocinio progetto) {
        progetti.add(progetto);
    }

}