package pl.edu.uksw.si.se.edytafraszczak;

public class Odpowiedz {
    private Fakt fakt;
    private Regula regula;
    private String wartosc;

    public Odpowiedz() {
    }

    public Odpowiedz(Fakt fakt, String wartosc) {
        this.fakt = fakt;
        this.wartosc = wartosc;
    }

    public Odpowiedz(Regula regula, String wartosc) {
        this.regula = regula;
        this.wartosc = wartosc;
    }

    public Fakt getFakt() {
        return fakt;
    }

    public void setFakt(Fakt fakt) {
        this.fakt = fakt;
    }

    public String getWartosc() {
        return wartosc;
    }

    public void setWartosc(String wartosc) {
        this.wartosc = wartosc;
    }

    public Regula getRegula() {
        return regula;
    }

    public void setRegula(Regula regula) {
        this.regula = regula;
    }

    public String getNazwa() {
        if (fakt != null) return fakt.getNazwa();
        if (regula != null) return regula.getNazwa();
        return null;
    }

    @Override
    public int hashCode() {
        return getNazwa().hashCode();
    }
}
