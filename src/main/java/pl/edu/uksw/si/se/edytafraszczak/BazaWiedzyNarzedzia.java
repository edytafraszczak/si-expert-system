package pl.edu.uksw.si.se.edytafraszczak;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Comparator;
import java.util.List;

public class BazaWiedzyNarzedzia {
    public static BazaWiedzy odczytajBazeWiedzy(String filePath) throws FileNotFoundException {
        return new Gson().fromJson(new FileReader(new File(filePath)), BazaWiedzyWrapper.class).getBazaWiedzy();
    }

    public static Odpowiedz przetwurzRegule(SesjaZUzytkownikiem sesja, Regula regula) {
        if (regula == null) {
            return null;
        }
        boolean spelniona = true;
        for (Warunek warunek : regula.getWarunki()) {
            spelniona = sprWarunek(sesja, warunek);
            if (!spelniona) break;
        }
        Odpowiedz odp = new Odpowiedz(regula, spelniona + "");
        sesja.getOdpowiedzi().add(odp);
        return odp;
    }


    public static Regula znajdzRegule(BazaWiedzy bazaWiedzy, String nazwa) {
        for (Regula regula : bazaWiedzy.getReguly()) {
            if (regula.getNazwa().equalsIgnoreCase(nazwa))
                return regula;
        }
        return null;
    }

    public static Fakt znajdzFakt(BazaWiedzy bazaWiedzy, String nazwa) {
        for (Fakt fakt : bazaWiedzy.getFakty()) {
            if (fakt.getNazwa().equalsIgnoreCase(nazwa))
                return fakt;
        }
        return null;
    }

    public static Odpowiedz dajOdpowiedz(SesjaZUzytkownikiem sesja, Warunek warunek) {
        Odpowiedz odpowiedz = sesja.dajOdpowiedz(warunek.getNazwa());
        if (odpowiedz == null) {
            Fakt fakt = znajdzFakt(sesja.getBazaWiedzy(), warunek.getNazwa());
            if (fakt != null) {
                String odpowiedzStr = "";
                if (fakt.getTyp().equalsIgnoreCase("boolean")) {
                    odpowiedzStr = GuiNarzedzia.pokazDialogTrueFalse(fakt.getOpis()) + "";
                }
                odpowiedz = new Odpowiedz(fakt, odpowiedzStr);

            } else {
                odpowiedz = przetwurzRegule(sesja, znajdzRegule(sesja.getBazaWiedzy(), warunek.getNazwa()));
            }
            sesja.getOdpowiedzi().add(odpowiedz);
        }
        return odpowiedz;

    }


    public static Regula dajReguleONajwyzszymPoziomieUfnosci(SesjaZUzytkownikiem sesja) {
        List<Regula> reguly = sesja.getBazaWiedzy().getReguly();
        reguly.sort(new Comparator<Regula>() {
            @Override
            public int compare(Regula o1, Regula o2) {
                return Integer.compare(o2.getWskaznikUfnosci(), o1.getWskaznikUfnosci());
            }
        });
        for (Regula regula : reguly) {
            Odpowiedz odpowiedz = sesja.dajOdpowiedz(regula.getNazwa());
            if (odpowiedz == null) {
                return regula;
            }
        }
        return null;
    }

    private static boolean sprWarunek(SesjaZUzytkownikiem sesja, Warunek warunek) {
        Odpowiedz obecnaWartosc = dajOdpowiedz(sesja, warunek);
        switch (warunek.getOperator()) {
            case ROWNA:
                return obecnaWartosc.getWartosc().equalsIgnoreCase(warunek.getWartosc());
            case ROZNY:
                return !obecnaWartosc.getWartosc().equalsIgnoreCase(warunek.getWartosc());
        }
        return false;
    }


}
