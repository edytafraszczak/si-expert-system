package pl.edu.uksw.si.se.edytafraszczak;

import java.util.List;

public class BazaWiedzy {
    private String opis;
    private String glownaRegula;
    private List<Fakt> fakty;
    private List<Regula> reguly;

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getGlownaRegula() {
        return glownaRegula;
    }

    public void setGlownaRegula(String glownaRegula) {
        this.glownaRegula = glownaRegula;
    }

    public List<Fakt> getFakty() {
        return fakty;
    }

    public void setFakty(List<Fakt> fakty) {
        this.fakty = fakty;
    }

    public List<Regula> getReguly() {
        return reguly;
    }

    public void setReguly(List<Regula> reguly) {
        this.reguly = reguly;
    }
}
