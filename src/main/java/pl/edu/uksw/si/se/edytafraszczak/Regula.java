package pl.edu.uksw.si.se.edytafraszczak;

import java.util.List;

public class Regula {
    private String nazwa;
    private String cel;
    private int wskaznikUfnosci;
    private List<Warunek> warunki;

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public int getWskaznikUfnosci() {
        return wskaznikUfnosci;
    }

    public void setWskaznikUfnosci(int wskaznikUfnosci) {
        this.wskaznikUfnosci = wskaznikUfnosci;
    }

    public List<Warunek> getWarunki() {
        return warunki;
    }

    public void setWarunki(List<Warunek> warunki) {
        this.warunki = warunki;
    }
}
