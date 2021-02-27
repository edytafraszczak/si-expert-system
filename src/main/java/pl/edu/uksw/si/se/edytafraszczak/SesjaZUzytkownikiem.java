package pl.edu.uksw.si.se.edytafraszczak;

import java.util.HashSet;
import java.util.Set;

public class SesjaZUzytkownikiem {
    private BazaWiedzy bazaWiedzy;
    private Set<Odpowiedz> odpowiedzi = new HashSet<>();

    public BazaWiedzy getBazaWiedzy() {
        return bazaWiedzy;
    }

    public void setBazaWiedzy(BazaWiedzy bazaWiedzy) {
        this.bazaWiedzy = bazaWiedzy;
    }

    public Set<Odpowiedz> getOdpowiedzi() {
        return odpowiedzi;
    }

    public void setOdpowiedzi(Set<Odpowiedz> odpowiedzi) {
        this.odpowiedzi = odpowiedzi;
    }

    public Odpowiedz dajOdpowiedz(String nazwa) {
        for (Odpowiedz odpowiedz: odpowiedzi) {
            if(odpowiedz.getNazwa().equalsIgnoreCase(nazwa)) return odpowiedz;
        }
        return null;
    }

}
